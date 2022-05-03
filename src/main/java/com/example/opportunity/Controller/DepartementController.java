package com.example.opportunity.Controller;

import com.example.opportunity.Entity.*;
import com.example.opportunity.Service.BusinessLineServiceImpl;
import com.example.opportunity.Service.BusinessUnitServiceImpl;
import com.example.opportunity.Service.DepartementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Departement")
public class DepartementController {
    @Autowired
    DepartementServiceImpl departementService;
    @Autowired
    BusinessUnitServiceImpl businessUnitService;

    @Autowired
    BusinessLineServiceImpl businessLineService;

    @GetMapping("/All")
    public List<Departement> getAllDepartements(){

        return departementService.getAllDepartement();
    }


    @GetMapping("/getDepartement/{idDepartement}")
    public Departement getDepartementById(@PathVariable(name ="idDepartement") Long idDepartement){

        return departementService.getDepartementById(idDepartement);
    }


    @PostMapping("/add")
    public void addDepartement(@RequestBody Departement departement){

        departementService.addDepartement(departement);
    }



    @GetMapping("/getDepartByUnit/{idUnit}")
    public List<Departement> getByUnit(@PathVariable(name = "idUnit") Long idUnit){

        BusinessUnit businessUnit=businessUnitService.getBusinessUnitById(idUnit);

        return  departementService.getByIdUnit(businessUnit);
    }

    @GetMapping("/getDepartByLine/{idLine}")
    public List<Departement> getByLine(@PathVariable(name = "idLine") Long idLine){

        Business_Line businessLine=businessLineService.getBusinessLineById(idLine);

        return  departementService.getByLine(businessLine);
    }

    @GetMapping("/disable/{id}")
    public Departement switchStatus(@PathVariable (name="id") Long id ){

        return departementService.switchStatus(id);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteDeppartement(@PathVariable (name="id") Long id){

        departementService.deleteDeppartement(id);
    }



    @PutMapping("/update")
    public Departement modifyArea(@RequestBody Departement departement){

        return departementService.upadateDepartement(departement);
    }


    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Departement> getAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){

        return departementService.getAll(nbr,size);
    }



    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<Departement>  sortAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return departementService.SortAll(nbr,size, sorting, sortDirection);
    }



    @GetMapping("find/{name}")
    public List<Departement> finding(@PathVariable (name = "name") String name) {
        return departementService.filter(name);
    }



    @GetMapping("/searchName/{name}")
    public List<Departement> filterByName(@PathVariable(name="name") String name){
        return departementService.filterByName(name);
    }



    @GetMapping("/searchUnit/{unit}")
    public List<Departement> filterByUnit(@PathVariable(name="unit") String unit){
        return departementService.filterBuUnit(unit);
    }



    @GetMapping("/searchLine/{line}")
    public List<Departement> filterByLine(@PathVariable(name="line") String line){
        return departementService.filterByLine(line);
    }
}
