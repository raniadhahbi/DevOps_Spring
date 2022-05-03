package com.example.opportunity.Service;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Repository.BusinessUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class BusinessUnitServiceImpl {
    @Autowired
    BusinessUnitRepository businessUnitRepository;

    public List<BusinessUnit> getAllBusinessUnit(){
        return businessUnitRepository.findAll();
    }
    public BusinessUnit getBusinessUnitById(Long idUnit){
        return businessUnitRepository.findByidUnit(idUnit);
    }
    public BusinessUnit addBusinessUnit(BusinessUnit business_unit){
        return businessUnitRepository.save(business_unit) ;
    }
    public void retrieveBusinessUnit(Long id){
        businessUnitRepository.deleteBusiness_UnitByIdUnit(id);
    }
    public List<BusinessUnit> findByKeyword(String keyword){


            return businessUnitRepository.findByKeyword(keyword);
    }

    public List <BusinessUnit> getAll(int nbr,int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size);

        return businessUnitRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public BusinessUnit updateUnit(BusinessUnit businessUnit){
        BusinessUnit unit=businessUnitRepository.findByidUnit(businessUnit.getId_unit());
        unit.setName(businessUnit.getName());
        return unit;
    }
    public BusinessUnit switchStatus(Long id){

        BusinessUnit unitToBe =businessUnitRepository.getById(id);
        unitToBe.setStatus(false);

        return unitToBe;

    }
    public List <BusinessUnit> SortAll(int nbr, int size, String sorting, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return businessUnitRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<BusinessUnit> filterByName(String name){
        return businessUnitRepository.findByName(name);
    }


}
