package com.example.opportunity.Service;


import com.example.opportunity.Entity.*;
import com.example.opportunity.Repository.DepartementRepository;
import com.example.opportunity.Repository.PreSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PreSalesServicesImpl {

    @Autowired
    PreSalesRepository preSalesRepository;

    @Autowired
    DepartementRepository departementRepository;
    public List<PreSalesEngineer> ListAllPreSales(){
        return preSalesRepository.findAll();
    }

    public PreSalesEngineer getProductLineById(Long idProduct){
        return preSalesRepository.findByIdPreSales(idProduct);
    }

    public PreSalesEngineer addPeSales(PreSalesEngineer preSalesEngineer){
        return preSalesRepository.save(preSalesEngineer);
    }


    public List<PreSalesEngineer> getByDepartement(Long idDep){
        Departement dep =departementRepository.getById(idDep);
        return preSalesRepository.getPreSalesEngineerByDepartementList(dep);
    }


    public void deletePresSales(Long id){
        preSalesRepository.deletePreSalesEngineerByIdPreSales(id);
    }
    public PreSalesEngineer upadatePreSales(PreSalesEngineer preSalesEngineer){
        PreSalesEngineer updatedPreSales=preSalesRepository.getById(preSalesEngineer.getIdPreSales());
        updatedPreSales.setName(preSalesEngineer.getName());
        updatedPreSales.setBusinessLines(preSalesEngineer.getBusinessLines());
        updatedPreSales.setBusiness_units(preSalesEngineer.getBusiness_units());
        updatedPreSales.setDepartementList(preSalesEngineer.getDepartementList());
        updatedPreSales.setAreaList(preSalesEngineer.getAreaList());
        return updatedPreSales;
    }
    public PreSalesEngineer switchStatus(Long id){

        PreSalesEngineer preSaleToBe =preSalesRepository.getById(id);
        preSaleToBe.setStatus(false);
        return preSaleToBe;

    }
    public List <PreSalesEngineer> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("name").descending());

        return preSalesRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <PreSalesEngineer> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return preSalesRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<PreSalesEngineer> filter(String name){

        return preSalesRepository.finding(name);
    }

    public List<PreSalesEngineer> filterByName(String name){
        return preSalesRepository.findingName(name);
    }
    public List<PreSalesEngineer> filterByDep(String dep){

        return preSalesRepository.findingDep(dep);
    }
    public List<PreSalesEngineer> filterByUnit(String unit){

        return preSalesRepository.findingUnit(unit);
    }
    public List<PreSalesEngineer> filterByLine(String line){

        return preSalesRepository.findingLine(line);
    }
    public List<PreSalesEngineer> filterByArea(String area){

        return preSalesRepository.findingArea(area);
    }
}
