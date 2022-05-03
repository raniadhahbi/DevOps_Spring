package com.example.opportunity.Service;


import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public List<Customer> getAllInactives(){
     List<Customer> newCustomers=new ArrayList<>();
     List<Customer> Customers=customerRepository.findAll();
     for(int n=0;n<Customers.size();n++){
         if(Customers.get(n).isStatus()==true){
             newCustomers.add(Customers.get(n));
         }
     }
    return newCustomers;
    }

    public List<Customer> getCustomerByCountry(String country){
        return customerRepository.findCustomerByCountry(country);
    }

    public void changeStatus(Long idCustomer){
         customerRepository.findByidCustomer(idCustomer).setStatus(false);
    }

    public Customer getCustomerById(Long idCustomer){
        return customerRepository.findByidCustomer(idCustomer);
    }

    public Customer addCustomer(Customer customer){

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){

        customerRepository.deleteCustomerByIdCustomer(id);
    }
    public Customer upadateCustomer(Customer customer){
        Customer updatedCustomer=customerRepository.getById(customer.getIdCustomer());
        updatedCustomer.setCustomerName(customer.getCustomerName());
        updatedCustomer.setBusinessLineList(customer.getBusinessLineList());
        updatedCustomer.setBusinessUnitList(customer.getBusinessUnitList());
        updatedCustomer.setDepartementList(customer.getDepartementList());
        updatedCustomer.setAreaList(customer.getAreaList());
        return updatedCustomer;
    }
    public Customer switchStatus(Long id){
        Customer customerToBe =customerRepository.getById(id);
        customerToBe.setStatus(false);
        return customerToBe;
    }
    public List <Customer> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("customerName").descending());

        return customerRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <Customer> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return customerRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<Customer> filter(String name){

        return customerRepository.finding(name);
    }

    public List<Customer> filterByCustomer(String customer){

        return customerRepository.findingCustomer(customer);
    }

    public List<Customer> filterBySap(String sap){

        return customerRepository.findingSap(sap);
    }
    public List<Customer> filterByGroup(String group){

        return customerRepository.findingGroup(group);
    }

    public List<Customer> filterByCountry(String country){

        return customerRepository.findingCountry(country);
    }

    public List<Customer> filterByDep(String dep){

        return customerRepository.findingDep(dep);
    }
    public List<Customer> filterByUnit(String unit){

        return customerRepository.findingUnit(unit);
    }
    public List<Customer> filterByLine(String line){

        return customerRepository.findingLine(line);
    }
    public List<Customer> filterByArea(String area){

        return customerRepository.findingArea(area);
    }


}
