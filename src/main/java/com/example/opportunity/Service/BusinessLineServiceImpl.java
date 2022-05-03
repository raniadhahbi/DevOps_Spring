package com.example.opportunity.Service;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Repository.BusinessLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class BusinessLineServiceImpl {
    @Autowired
    BusinessLineRepository businessLineRepository;

    public List<Business_Line> getAllBusinessLine(){

        return  businessLineRepository.findAll();
    }
    public List<Business_Line> findByBusinessUnit(BusinessUnit businessUnit){
        return  businessLineRepository.findByUnit(businessUnit);
    }
    public  Business_Line getBusinessLineById(Long idLine){

        return businessLineRepository.findByidLine(idLine);
    }

    public Business_Line addBusinessLine(Business_Line business_line){
        return businessLineRepository.save(business_line);
    }

    public void retrieveBusinessLine(Long id){

        businessLineRepository.deleteBusiness_LineByIdLine(id);
    }

    public Business_Line updateLine(Business_Line business_line){
        Business_Line updatedLine=businessLineRepository.findByidLine(business_line.getId_Line());
        updatedLine.setName(business_line.getName());
        updatedLine.setUnit(business_line.getUnit());
        return updatedLine;
    }
    public Business_Line switchStatus(Long id){

        Business_Line lineToBe =businessLineRepository.getById(id);
        lineToBe.setStatus(false);

        return lineToBe;

    }
    public List <Business_Line> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("unit").descending());

        return businessLineRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <Business_Line> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return businessLineRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<Business_Line> filter(String name){

        return businessLineRepository.finding(name);
    }
    public List<Business_Line> filterByName(String name){
        return businessLineRepository.findingName(name);
    }

    public List<Business_Line> filterByUnit(String name){
        return businessLineRepository.findingUnit(name);
    }
}
