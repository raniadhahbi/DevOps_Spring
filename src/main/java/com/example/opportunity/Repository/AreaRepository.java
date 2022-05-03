package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {

    List<Area> findAll();
    public Area findByIdArea(Long id);
   public void deleteAreaByIdArea(Long id);
    public List<Area> findByBusinessUnits(BusinessUnit businessUnit);


    @Query("SELECT distinct p FROM Area p WHERE p.nameArea  like %?1% ")
    public List<Area> findByKeyword(String Keyword);

    @Query("SELECT distinct p FROM Area p, BusinessUnit c where p.nameArea  like %?1% or c.name like %?1%  ")
    public List<Area> finding(String name);

    @Query("SELECT distinct p FROM Area p where p.nameArea  like %?1%  ")
    public List<Area> findingName(String name);

    @Query("SELECT distinct p FROM Area p, BusinessUnit c where c.name like %?1%  ")
    public List<Area> findingUnit(String name);

}
