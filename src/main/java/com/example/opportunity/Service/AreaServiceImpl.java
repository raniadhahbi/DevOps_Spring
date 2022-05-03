package com.example.opportunity.Service;


import com.example.opportunity.Entity.*;
import com.example.opportunity.Repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AreaServiceImpl {
    @Autowired
    AreaRepository areaRepository;

    public List<Area> getAllArea(){
        return areaRepository.findAll();
    }

    public void addArea(Area area){
        areaRepository.save(area);
    }

    public void deleteArea(Long id){areaRepository.deleteAreaByIdArea(id);}

    public Area getAreaById(Long idArea){
        return areaRepository.findByIdArea(idArea);
    }
    public List <Area> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("businessUnits").descending());

        return areaRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List<Area> getByIdUnit(BusinessUnit businessUnit){
        return areaRepository.findByBusinessUnits(businessUnit);
    }
    public Area updateArea(Area area){
        Area updatedArea=areaRepository.findByIdArea(area.getId_Area());
        updatedArea.setNameArea(area.getNameArea());
        updatedArea.setBusiness_units(area.getBusiness_units());
        return updatedArea;
    }
    public Area SwitchStatus(Long id){

        Area AreaToBe =areaRepository.getById(id);
        AreaToBe.setStatus(false);

        return AreaToBe;

    }

    public List <Area> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return areaRepository.findAll(secondPageWithFiveElements).getContent();
    }
    public List<Area> filter(String name){
        return areaRepository.finding(name);
    }

    public List<Area> filterByName(String name){
        return areaRepository.findingName(name);
    }
    public List<Area> filterByUnit(String name){
        return areaRepository.findingUnit(name);
    }

}
