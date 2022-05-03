package com.example.opportunity.Service;


import com.example.opportunity.Entity.*;
import com.example.opportunity.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class DepartementServiceImpl {
    @Autowired
    DepartementRepository departementRepository;

    public List<Departement> getAllDepartement(){
        return departementRepository.findAll();
    }
    public Departement getDepartementById(Long idDepartement){
        return departementRepository.findByidDepartement(idDepartement);
    }
    public Departement addDepartement(Departement departement){
        return departementRepository.save(departement);
    }
    public void deleteDeppartement(Long id){
        departementRepository.deleteDepartementByIdDepartement(id);
    }
    public List<Departement> getByIdUnit(BusinessUnit businessUnit){
        return departementRepository.findByBusinessUnit(businessUnit);
    }

    public List<Departement> getByLine(Business_Line business_line){
        return departementRepository.findByBusinessLine(business_line);
    }

    public Departement upadateDepartement(Departement departement){
        Departement updatedDepartement=departementRepository.findByidDepartement(departement.getId_Departement());
        updatedDepartement.setNameDep(departement.getNameDep());
        updatedDepartement.setBusinessLine(updatedDepartement.getBusinessLine());
        updatedDepartement.setBusinessUnit(departement.getBusinessUnit());
        return updatedDepartement;
    }
    public Departement switchStatus(Long id){
        Departement depatemmentToBe =departementRepository.getById(id);
        depatemmentToBe.setStatus(false);
        return depatemmentToBe;
    }

    public List <Departement> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("businessLine").descending());

        return departementRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <Departement> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return departementRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<Departement> filter(String name){

        return departementRepository.finding(name);
    }

    public List<Departement> filterByName(String name){
        return departementRepository.findingName(name);
    }
    public List<Departement> filterBuUnit(String unit){
        return departementRepository.findingUnit(unit);
    }
    public List<Departement> filterByLine(String line){
        return departementRepository.findingLine(line);
    }

}
