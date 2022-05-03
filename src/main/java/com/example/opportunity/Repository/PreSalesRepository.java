package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PreSalesRepository extends JpaRepository<PreSalesEngineer,Long> {

    public List<PreSalesEngineer> findAll();
    public PreSalesEngineer findByIdPreSales(Long idPreSales);
    public void deletePreSalesEngineerByIdPreSales(Long id);

    public List<PreSalesEngineer> getPreSalesEngineerByDepartementList(Departement departement);
    @Query("SELECT distinct p FROM  PreSalesEngineer p ,Departement d, Business_Line l ,BusinessUnit u,Area a where  p.name  like %?1% or d.nameDep  like %?1% or l.name  like %?1% or u.name like %?1%  or a.nameArea like %?1%  ")
    public List<PreSalesEngineer> finding(String name);

    @Query("SELECT distinct p FROM  PreSalesEngineer p  where p.name  like %?1% ")
    public List<PreSalesEngineer> findingName(String name);

    @Query("SELECT distinct p FROM  PreSalesEngineer p ,Departement d where d.nameDep  like %?1% ")
    public List<PreSalesEngineer> findingDep(String dep);

    @Query("SELECT distinct p FROM  PreSalesEngineer p ,BusinessUnit u where u.name like %?1% ")
    public List<PreSalesEngineer> findingUnit(String unit);

    @Query("SELECT distinct p FROM  PreSalesEngineer p , Business_Line l where  l.name  like %?1%")
    public List<PreSalesEngineer> findingLine(String line);

    @Query("SELECT distinct p FROM  PreSalesEngineer p ,Area a where a.nameArea like %?1%  ")
    public List<PreSalesEngineer> findingArea(String area);

}
