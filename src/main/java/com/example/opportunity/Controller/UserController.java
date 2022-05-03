package com.example.opportunity.Controller;

import com.example.opportunity.Entity.User;
import com.example.opportunity.Service.UserServiceImpl;
import com.example.opportunity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableScheduling
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    private JwtUtil jwtUtil;
   // @Autowired
    //private AuthenticationManager authenticationManager;


    private  BCryptPasswordEncoder passwordEncoder;

    public UserController(UserServiceImpl userService,BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/all")
    public List<User> listAll(){

        return userService.getAllUser();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) throws Exception{

        String mail=user.getEmail();
        String pass=user.getLogin();
        if(mail != null && !"".equals(mail)){
            User user1 = userService.getUserByEmail(mail);
            if(user1 != null){
               // return "already exist";
                return null;
            }
        }
        user.setCreationDate(new Date());
       // user.setMypassword(pass);
        return userService.createUser(user);
       // return "Bonjour " + newUser .getFirstName()  + " ton Inscription est effectuée ! ";

    }

    @PutMapping("/loginUser")
    public String loginUser(@RequestBody User user) throws Exception{
        String token;
        String tempEmail= user.getEmail();
        String tempPass = user.getLogin();
        User user1 =userService.getUserByEmail(tempEmail);
        boolean s=user1.isStatus();


       if(passwordEncoder.matches(tempPass,user1.getLogin()) && s==true){
            user1.setLastConnectionDate(new Date());

            userService.loginUser(user1);
            token=jwtUtil.generateToken(user.getEmail());
            return token;
        }
       if (s==false){
           return "Passive";
       }
        else {
           return " ";
        }
    }
    @GetMapping("/Anonymize/{id}")
    public User anonymize(@PathVariable (name="id") Long id ){
        return userService.anonymize(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable (name = "id") Long id){
        userService.deleteUser(id);

    }
    @GetMapping("/sales")
    public List<User> getSales(){
        List<User> sales=new ArrayList<>();
        List<User> managers=userService.getManager();
        for(int z=0;z< managers.size();z++){
            if(managers.get(z).isStatus()==true){

                sales.add(managers.get(z));
            }
        }
        return sales;
    }
    @Scheduled(cron = "0 * 12 * * ?")
    public void ckeckAccount(){
       userService.ckeckAccount();
    }

    @GetMapping("/getByEmail/{email}")
    public User getUserByEmail(@PathVariable (name = "email") String email){

        return userService.getUserByEmail(email);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable (name = "id") Long id){

        return userService.getUserById(id);

    }
    @PutMapping("/update")
    public User modifyUser(@RequestBody User user){

        return userService.upadateUser(user);
    }
    @GetMapping("/Allpages/{nbr}/{size}")
    public List<User> getAllUsers(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){

        return userService.getAll(nbr,size);

    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<User>  sortAllUsers(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){

        return userService.SortAll(nbr,size, sorting, sortDirection);

    }
    @GetMapping("find/{name}")
    public List<User> finding(@PathVariable (name = "name") String name) {

        return userService.filter(name);

    }
    @GetMapping("/searchEmail/{email}")
    public List<User> filterByEmail(@PathVariable(name="email") String email){

        return userService.filterByEmail(email);
    }
    @GetMapping("/searchLastname/{lastname}")
    public List<User> filterByLastname(@PathVariable(name="lastname") String lastname){

        return userService.filterByLastName(lastname);
    }
    @GetMapping("/searchFirstname/{firstname}")
    public List<User> filterByFirstname(@PathVariable(name="firstname") String firstname){

        return userService.filterByFirstname(firstname);
    }
    @GetMapping("/searchLogin/{login}")
    public List<User> filterByLogin(@PathVariable(name="login") String login){

        return userService.filterByLogin(login);
    }

    @GetMapping("/searchDep/{dep}")
    public List<User> filterByDep(@PathVariable(name="dep") String dep){

        return userService.filterByDep(dep);
    }

    @GetMapping("/searchUnit/{unit}")
    public List<User> filterByUnit(@PathVariable(name="unit") String unit){

        return userService.filterByUnit(unit);
    }

    @GetMapping("/searchLine/{line}")
    public List<User> filterByLine(@PathVariable(name="line") String line){

        return userService.filterByLine(line);
    }

    @GetMapping("/searchArea/{area}")
    public List<User> filterByArea(@PathVariable(name="area") String area){

        return userService.filterByArea(area);
    }
}
