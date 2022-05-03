package com.example.opportunity.Service;


import com.example.opportunity.Entity.Roles;
import com.example.opportunity.Entity.User;
import com.example.opportunity.Repository.RoleRepository;
import com.example.opportunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@EnableScheduling
@Transactional
@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    static int j=0;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
    }
    public User createUser (User user){
        user.setMypassword(user.getLogin());
        user.setLogin(passwordEncoder.encode(user.getLogin() ));
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return  userRepository.findUserById(id);
   }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }

    public User upadateUser(User user){
        User updatedUser=userRepository.getById(user.getId());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setMypassword(user.getLogin());
        updatedUser.setLogin(passwordEncoder.encode(user.getLogin() ));
        updatedUser.setRoles(user.getRoles());
        updatedUser.setBusinessLines(user.getBusinessLines());
        updatedUser.setBusinessUnits(user.getBusinessUnits());
        updatedUser.setDepartementList(user.getDepartementList());
        updatedUser.setAreaList(user.getAreaList());
        return updatedUser;
    }
    public User loginUser(User user){
        User updatedUser=userRepository.getById(user.getId());
        updatedUser.setLastConnectionDate(new Date());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRoles(user.getRoles());
        updatedUser.setBusinessLines(user.getBusinessLines());
        updatedUser.setBusinessUnits(user.getBusinessUnits());
        updatedUser.setDepartementList(user.getDepartementList());
        updatedUser.setAreaList(user.getAreaList());
        return updatedUser;
    }
    public User anonymize(Long id){

        User userToBe =userRepository.getById(id);
        userToBe.setStatus(false);
        userToBe.setFirstName("firsName"+j);
        userToBe.setLastName("lastName"+j);
        j++;
        return userToBe;

    }

    public void ckeckAccount(){
        List<User> users=userRepository.findAll();
        Date today=new Date();
        for (int i=0;i<users.size();i++){
            long diff = today.getTime() - users.get(i).getLastConnectionDate().getTime();
            long diffday = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);


            if(diffday>=7 && users.get(i).isStatus()==true){
             users.get(i).setStatus(false);
            users.get(i).setFirstName("firsName"+j);
            users.get(i).setLastName("lastName"+j);
            j++;}
        }
    }

    public List<User> getManager(){
        Roles role=roleRepository.findByIdRole(2L);
        return userRepository.findByRoles(role);
    }
    public List <User> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("firstName").descending());

        return userRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <User> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return userRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<User> filter(String name){

        return userRepository.finding(name);
    }
    public List<User> filterByEmail(String email){

        return userRepository.findingEmail(email);
    }
    public List<User> filterByLastName(String lastname){

        return userRepository.findingLastname(lastname);
    }
    public List<User> filterByFirstname(String firstname){

        return userRepository.findingFirstname(firstname);
    }
    public List<User> filterByLogin(String login){

        return userRepository.findingLogin(login);
    }

    public List<User> filterByDep(String dep){

        return userRepository.findingDep(dep);
    }
    public List<User> filterByUnit(String unit){

        return userRepository.findingUnit(unit);
    }
    public List<User> filterByLine(String line){

        return userRepository.findingLine(line);
    }
    public List<User> filterByArea(String area){

        return userRepository.findingArea(area);
    }
}
