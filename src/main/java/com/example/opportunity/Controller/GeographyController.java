package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Entity.Geography;
import com.example.opportunity.Service.GeographyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geography")
public class GeographyController {

    @Autowired
    GeographyServiceImpl geographyService;


    @GetMapping("/All")
    public List<Geography> getAllGeography(){
        return geographyService.getAllGeography();
    }
    @GetMapping("/getGeography/{idGeography}")
    public Geography getGeographyById(@PathVariable (name = "idGeography") Long idGeography){
        return  geographyService.getGeography(idGeography);
    }

    @PostMapping("/add")
    public Geography addGeography(@RequestBody  Geography geography){


        return geographyService.addGeography(geography);
    }

    @GetMapping("/getCountryByArea/{id}")
    public List<String> getCountry(@PathVariable (name = "id") Long id){
        return geographyService.getCountry(id);
    }


    @GetMapping("/disable/{id}")
    public Geography switchStatus(@PathVariable (name="id") Long id ){
        return geographyService.switchStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGeography(@PathVariable (name = "id") Long id)
    {
        geographyService.deleteGeography(id);
    }

    @PutMapping("/update")
    public Geography modifyArea(@RequestBody Geography geography){
        return geographyService.updateArea(geography);
    }

    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Geography> getAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return geographyService.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<Geography>  sortAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return geographyService.SortAll(nbr,size, sorting, sortDirection);
    }
    @GetMapping("find/{name}")
    public List<Geography> finding(@PathVariable (name = "name") String name){
        return geographyService.filter(name);
    }

    @GetMapping("/searchName/{name}")
    public List<Geography> filterByArea(@PathVariable(name="name") String name){
        return geographyService.filterByName(name);
    }

    @GetMapping("/searchCountry/{country}")
    public List<Geography> filterByCountry(@PathVariable(name="country") String country){
        return geographyService.filterByCountry(country);
    }

    @GetMapping("/searchContinent/{continent}")
    public List<Geography> filterByContinent(@PathVariable(name="continent") String continent){
        return geographyService.filterByContinent(continent);
    }
}
