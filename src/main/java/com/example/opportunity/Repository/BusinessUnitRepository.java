package com.example.opportunity.Repository;

import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Currencies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import java.util.List;

public interface BusinessUnitRepository extends JpaRepository<BusinessUnit,Long> {

    public List<BusinessUnit> findAll();
    public BusinessUnit findByidUnit(Long idUnit);
    public void deleteBusiness_UnitByIdUnit(Long id);
    @Query("SELECT p FROM BusinessUnit p WHERE p.name like %?1% ")
    public List<BusinessUnit> findByKeyword(String Keyword);

    public List<BusinessUnit> findByName(String name);


}
