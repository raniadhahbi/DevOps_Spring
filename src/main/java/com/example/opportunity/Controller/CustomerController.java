package com.example.opportunity.Controller;


import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.Geography;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/all")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/inactive")
    public List<Customer> getInactives(){
        return customerService.getAllInactives();
    }

    @PutMapping("/change/{idCustomer}")
    public void changeStatus(@PathVariable(name = "idCustomer")Long idCustomer){
       customerService.changeStatus(idCustomer);
    }
    @GetMapping("/getCustomer/{idCustomer}")
    public Customer getPreSale(@PathVariable (name = "idCustomer") Long idCustomer){
        return customerService.getCustomerById(idCustomer);
    }

    @GetMapping("/getCustomerByCountry/{country}")
    public List<Customer> getCustomerByCountry(@PathVariable (name = "country") String country){
        return customerService.getCustomerByCountry(country);
    }

    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer){

       return customerService.addCustomer(customer);
    }
    @GetMapping("/disable/{id}")
    public Customer switchStatus(@PathVariable (name="id") Long id ){
        return customerService.switchStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable (name = "id") Long id){
        customerService.deleteCustomer(id);

    }
    @PutMapping("/update")
    public Customer modifyCustomer(@RequestBody Customer customer){
        return customerService.upadateCustomer(customer);
    }
    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Customer> getAllCustomers(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return customerService.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<Customer>  sortAllCustomers(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return customerService.SortAll(nbr,size, sorting, sortDirection);
    }
    @GetMapping("find/{name}")
    public List<Customer> finding(@PathVariable (name = "name") String name) {
        return customerService.filter(name);
    }

    @GetMapping("/searchCustomer/{customer}")
    public List<Customer> filterByCustomer(@PathVariable(name="customer") String customer){
        return customerService.filterByCustomer(customer);
    }

    @GetMapping("/searchSap/{sap}")
    public List<Customer> filterBySap(@PathVariable(name="sap") String sap){
        return customerService.filterBySap(sap);
    }

    @GetMapping("/searchCountry/{country}")
    public List<Customer> filterByCountry(@PathVariable(name="country") String country){
        return customerService.filterByCountry(country);
    }

    @GetMapping("/searchGroup/{group}")
    public List<Customer> filterByGroup(@PathVariable(name="group") String group){
        return customerService.filterByGroup(group);
    }

    @GetMapping("/searchDep/{dep}")
    public List<Customer> filterByDep(@PathVariable(name="dep") String dep){
        return customerService.filterByDep(dep);
    }

    @GetMapping("/searchUnit/{unit}")
    public List<Customer> filterByUnit(@PathVariable(name="unit") String unit){
        return customerService.filterByUnit(unit);
    }

    @GetMapping("/searchLine/{line}")
    public List<Customer> filterByLine(@PathVariable(name="line") String line){
        return customerService.filterByLine(line);
    }

    @GetMapping("/searchArea/{area}")
    public List<Customer> filterByArea(@PathVariable(name="area") String area){
        return customerService.filterByArea(area);
    }

}
