package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Service.BusinessLineServiceImpl;
import com.example.opportunity.Service.BusinessUnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BusinessLine")
public class BusinessLineController {
    @Autowired
    BusinessLineServiceImpl businessLineService;
    @Autowired
    BusinessUnitServiceImpl businessUnitService;

    @GetMapping("/All")
    public List<Business_Line> getAllBusinessLine(){
        return businessLineService.getAllBusinessLine();
    }
    @GetMapping("/getbusinessLine/{idLine}")
    public Business_Line getBusinessLine(@PathVariable (name = "idLine") Long idLine)
    {
        return businessLineService.getBusinessLineById(idLine);
    }
    @GetMapping("/getLineByUnit/{idUnit}")
    public List<Business_Line> getByUnit(@PathVariable(name = "idUnit") Long idUnit){
        BusinessUnit businessUnit=businessUnitService.getBusinessUnitById(idUnit);

        return  businessLineService.findByBusinessUnit(businessUnit);
    }
    @PostMapping("/add")
    public void addBusinessLine(@RequestBody Business_Line business_line){
        businessLineService.addBusinessLine(business_line);
    }
    @DeleteMapping ("/delete/{id}")
    public void deleteBusinessLine(@PathVariable (name = "id") Long id){
        businessLineService.retrieveBusinessLine(id);
    }
    @PutMapping("/update")
    public Business_Line modifyArea(@RequestBody Business_Line business_line){
        return businessLineService.updateLine(business_line);
    }

    @GetMapping("/disable/{id}")
    public Business_Line switchStatus(@PathVariable (name="id") Long id ){
        return businessLineService.switchStatus(id);
    }

    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Business_Line> getAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return businessLineService.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<Business_Line>  sortAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return businessLineService.SortAll(nbr,size, sorting, sortDirection);
    }
    @GetMapping("find/{name}")
    public List<Business_Line> finding(@PathVariable (name = "name") String name){
        return businessLineService.filter(name);
    }

    @GetMapping("/searchName/{name}")
    public List<Business_Line> filterByName(@PathVariable(name="name") String name){
        return businessLineService.filterByName(name);
    }

    @GetMapping("/searchUnit/{line}")
    public List<Business_Line> filterByLine(@PathVariable(name="line") String line){
       return businessLineService.filterByUnit(line);
    }
}
