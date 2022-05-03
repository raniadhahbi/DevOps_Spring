package com.example.opportunity.Service;


import com.example.opportunity.Entity.*;
import com.example.opportunity.Repository.AreaRepository;
import com.example.opportunity.Repository.GeographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class GeographyServiceImpl {

    @Autowired
    GeographyRepository geographyRepository;

    @Autowired
    AreaRepository areaRepository;

    public List<Geography> getAllGeography(){

        return geographyRepository.findAll();
    }
    public Geography getGeography(Long idGeography){

        return geographyRepository.findByidGeography(idGeography);
    }
    public Geography addGeography(Geography geography){
        geography.setStatus(true);
        return geographyRepository.save(geography);
    }
    public void deleteGeography(Long id)
    {
        geographyRepository.deleteGeographyByIdGeography(id);
    }

    public List<String> getCountry(Long idArea){
        List<String> countries=new ArrayList<>();
        Area a= areaRepository.findByIdArea(idArea);
        List<Geography> geo=geographyRepository.findGeographyByAreas(a);
        for(int i=0;i<geo.size();i++){
            countries.add(geo.get(i).getCountry());
        }
        return countries;
    }

    public Geography updateArea(Geography geography){
        Geography updatedGeography=geographyRepository.findByidGeography(geography.getIdGeography());
        updatedGeography.setContinent(geography.getContinent());
        updatedGeography.setCountry(geography.getCountry());
        updatedGeography.setAreas(geography.getAreas());
        return updatedGeography;
    }

    public Geography switchStatus(Long id){

        Geography geoToBe =geographyRepository.getById(id);
        geoToBe.setStatus(false);
        return geoToBe;

    }

    public List <Geography> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("areas").descending());
        return geographyRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <Geography> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);
        return geographyRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<Geography> filter(String name){

        return geographyRepository.finding(name);
    }

    public List<Geography> filterByCountry(String country){

        return geographyRepository.findingCountry(country);
    }

    public List<Geography> filterByContinent(String continent){
        return geographyRepository.findingContinent(continent);
    }

    public List<Geography> filterByName(String name){

        return geographyRepository.findingArea(name);
    }
}
