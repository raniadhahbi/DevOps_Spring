package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.PreSalesEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findAll();
    public Customer findByidCustomer(Long idCustomer);
    public void deleteCustomerByIdCustomer(Long id);

    public List<Customer> findCustomerByCountry(String country);

    @Query("SELECT distinct p FROM  Customer p ,Departement d, Business_Line l ,BusinessUnit u,Area a where   p.customerName  like %?1% " +
            "or p.sapPartner  like %?1% or p.customerGroup  like %?1%   or p.country  like %?1% or d.nameDep  like %?1% or l.name  like %?1% or u.name like %?1% " +
            " or a.nameArea like %?1%  ")
    public List<Customer> finding(String name);

    @Query("SELECT distinct p FROM  Customer p  where p.customerName  like %?1% ")
    public List<Customer> findingCustomer(String customer);

    @Query("SELECT distinct p FROM  Customer p  where  p.sapPartner  like %?1% ")
    public List<Customer> findingSap(String sap);

    @Query("SELECT distinct p FROM  Customer p where   p.customerGroup  like %?1% ")
    public List<Customer> findingGroup(String group);

    @Query("SELECT distinct p FROM  Customer p  where   p.country  like %?1% ")
    public List<Customer> findingCountry(String country);

    @Query("SELECT distinct p FROM  Customer p ,Departement d where d.nameDep  like %?1% ")
    public List<Customer> findingDep(String dep);

    @Query("SELECT distinct p FROM  Customer p ,BusinessUnit u where u.name like %?1% ")
    public List<Customer> findingUnit(String unit);

    @Query("SELECT distinct p FROM  Customer p , Business_Line l where  l.name  like %?1%")
    public List<Customer> findingLine(String line);

    @Query("SELECT distinct p FROM  Customer p ,Area a where a.nameArea like %?1%  ")
    public List<Customer> findingArea(String area);



}
