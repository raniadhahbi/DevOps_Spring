package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Business_Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BusinessLineRepository extends JpaRepository<Business_Line,Long> {
    public List<Business_Line> findAll();
    public Business_Line findByidLine(Long idLine);
    public void deleteBusiness_LineByIdLine(Long id);
    public List<Business_Line> findByUnit(BusinessUnit businessUnit);
    @Query("SELECT distinct p FROM Business_Line p, BusinessUnit c where p.name  like %?1% or c.name like %?1%  ")
    public List<Business_Line> finding(String name);

    @Query("SELECT distinct p FROM Business_Line p where p.name  like %?1% ")
    public List<Business_Line> findingName(String name);

    @Query("SELECT distinct p FROM Business_Line p, BusinessUnit c where  c.name like %?1%  ")
    public List<Business_Line> findingUnit(String name);


}
