package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Service.BusinessUnitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/BusinessUnit")
public class BusinessUnitController {
    @Autowired
    BusinessUnitServiceImpl businessUnitService;

    @GetMapping("/All")
    public List<BusinessUnit> getAllBusinessUnit(){
        return businessUnitService.getAllBusinessUnit();
    }

    @GetMapping("/getBusinessUnit/{idUnit}")
    public BusinessUnit getBsinessUint(@PathVariable (name = "idUnit") Long idUnit)
    {
        return businessUnitService.getBusinessUnitById(idUnit);
    }
    @PostMapping("/add")
    public BusinessUnit addBusinessUnit(@RequestBody BusinessUnit business_unit)
    {
        return businessUnitService.addBusinessUnit(business_unit);

    }


    @GetMapping("/disable/{id}")
    public BusinessUnit switchStatus(@PathVariable (name="id") Long id ){
        return businessUnitService.switchStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBusinessUnit(@PathVariable (name = "id") Long id){
        businessUnitService.retrieveBusinessUnit(id);

    }

    @GetMapping("/filter/{keyword}")
    public List<BusinessUnit> getBusinessByKeyword(@PathVariable(name = "keyword") String keyword){

            return  businessUnitService.findByKeyword(keyword);
    }
    @GetMapping("/Allpages/{nbr}/{size}")
    public List<BusinessUnit> getAllunits(@PathVariable(name = "nbr") int nbr,@PathVariable(name="size") int size){
        return businessUnitService.getAll(nbr,size);
    }
    @PutMapping("/update")
    public BusinessUnit modifyUnit(@RequestBody BusinessUnit businessUnit){
        return businessUnitService.updateUnit(businessUnit);
    }

    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<BusinessUnit>  sortAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size, @PathVariable(name = "sorting") String sorting, @PathVariable(name="sortDirection")  String sortDirection){
        return businessUnitService.SortAll(nbr,size, sorting, sortDirection);
    }

    @GetMapping("/find/{name}")
    public List<BusinessUnit> filterByName(@PathVariable(name="name") String name){
        return businessUnitService.filterByName(name);
    }
}
