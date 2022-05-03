package com.example.opportunity.Controller;

import com.example.opportunity.Entity.*;
import com.example.opportunity.Service.AreaServiceImpl;
import com.example.opportunity.Service.BusinessUnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Area")
public class AreaController {

    @Autowired
    AreaServiceImpl areaService;
    @Autowired
    BusinessUnitServiceImpl businessUnitService;

    @GetMapping(value = "/All")
    public List<Area> getAreas(){
        return areaService.getAllArea();
    }

    @GetMapping("/getArea/{id}")
    public Area getAreaById(@PathVariable(name="id") Long id){
        return areaService.getAreaById(id);
    }

    @PostMapping(value = "/add")
    public void addArea(@RequestBody Area area)
    {
        areaService.addArea(area);
    }

    @DeleteMapping("/delete/{id}")
    public void retrieveArea(@PathVariable (name = "id")Long id){
         areaService.deleteArea(id);

    }
    @GetMapping("/getAreaByUnit/{idUnit}")
    public List<Area> getByUnit(@PathVariable(name = "idUnit") Long idUnit){
        BusinessUnit businessUnit=businessUnitService.getBusinessUnitById(idUnit);

        return  areaService.getByIdUnit(businessUnit);
    }
    @PutMapping("/update")
    public Area modifyArea(@RequestBody Area area){
        return areaService.updateArea(area);
    }

    @GetMapping("/disable/{id}")
    public Area switchStatus(@PathVariable (name="id") Long id ){
        return areaService.SwitchStatus(id);
    }

    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Area> getAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return areaService.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<Area>  sortAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return areaService.SortAll(nbr,size, sorting, sortDirection);
    }
   @GetMapping("find/{name}")
    public List<Area> finding(@PathVariable (name = "name") String name){
        return areaService.filter(name);
   }


    @GetMapping("/searchName/{name}")
    public List<Area> filterByName(@PathVariable(name="name") String name){
        return areaService.filterByName(name);
    }

    @GetMapping("/searchLine/{line}")
    public List<Area> filterByLine(@PathVariable(name="line") String line){
        return areaService.filterByUnit(line);
    }
}
