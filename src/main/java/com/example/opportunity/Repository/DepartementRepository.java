package com.example.opportunity.Repository;


import com.example.opportunity.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {

    public List<Departement> findAll();
    public Departement findByidDepartement(Long idDepartement);
    public void deleteDepartementByIdDepartement(Long id);
    public List<Departement> findByBusinessUnit(BusinessUnit businessUnit);

    public List<Departement> findByBusinessLine(Business_Line business_line);

    @Query("SELECT distinct p FROM Departement p, Business_Line l ,BusinessUnit u where p.nameDep  like %?1% or l.name  like %?1% or u.name like %?1%  ")
    public List<Departement> finding(String name);

    @Query("SELECT distinct p FROM Departement p, Business_Line l ,BusinessUnit u where p.nameDep  like %?1% ")
    public List<Departement> findingName(String name);

    @Query("SELECT distinct p FROM Departement p, BusinessUnit u where  u.name like %?1% ")
    public List<Departement> findingUnit(String name);

    @Query("SELECT distinct p FROM Departement p, Business_Line l  where l.name  like %?1%  ")
    public List<Departement> findingLine(String name);

}
