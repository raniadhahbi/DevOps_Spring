package com.example.opportunity.Repository;

import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Entity.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductLineRepository extends JpaRepository<ProductLine,Long> {

    public List<ProductLine> findAll();
    public ProductLine getProductLineByidProductLine(Long idProduct);
    public List<ProductLine> findByBusinessUnits(BusinessUnit businessUnit);
    public void deleteProductLineByIdProductLine(Long id);
    @Query("SELECT distinct p FROM  ProductLine p ,Departement d, Business_Line l ,BusinessUnit u where p.name like %?1% or d.nameDep  like %?1% or l.name  like %?1% or u.name like %?1%  ")
    public List<ProductLine> finding(String name);

    @Query("SELECT distinct p FROM  ProductLine p  where p.name  like %?1% ")
    public List<ProductLine> findingName(String name);

    @Query("SELECT distinct p FROM  ProductLine p ,Departement d where d.nameDep  like %?1% ")
    public List<ProductLine> findingDep(String dep);

    @Query("SELECT distinct p FROM  ProductLine p ,BusinessUnit u where u.name like %?1% ")
    public List<ProductLine> findingUnit(String unit);

    @Query("SELECT distinct p FROM  ProductLine p , Business_Line l where  l.name  like %?1%")
    public List<ProductLine> findingLine(String line);


}
