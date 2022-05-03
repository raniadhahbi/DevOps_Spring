package com.example.opportunity.Controller;


import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Service.PreSalesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/PreSalesEngineer")
public class PreSalesController {

    @Autowired
    PreSalesServicesImpl preSalesServices;

    @GetMapping("/all")
    public List<PreSalesEngineer> listAllPresSales(){
        return preSalesServices.ListAllPreSales();
    }

    @GetMapping("/getPreSales/{idPreSale}")
    public PreSalesEngineer getPreSale(@PathVariable (name = "idPreSale") Long idPreSale){
        return preSalesServices.getProductLineById(idPreSale);
    }
    @PostMapping("/add")
    public PreSalesEngineer createPreSales(@RequestBody PreSalesEngineer preSalesEngineer){
        return preSalesServices.addPeSales(preSalesEngineer);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePreSales(@PathVariable (name = "id") Long id){

        preSalesServices.deletePresSales(id);
    }

    @PutMapping("/update")
    public PreSalesEngineer modifyPreSale(@RequestBody PreSalesEngineer preSalesEngineer){
        return preSalesServices.upadatePreSales(preSalesEngineer);
    }

    @GetMapping("/getPreSaleByDep/{id}")
    public List<PreSalesEngineer> getList(@PathVariable (name = "id") Long id){
        return preSalesServices.getByDepartement(id);
    }
    @GetMapping("/disable/{id}")
    public PreSalesEngineer switchStatus(@PathVariable (name="id") Long id ){
        return preSalesServices.switchStatus(id);
    }

    @GetMapping("/Allpages/{nbr}/{size}")
    public List<PreSalesEngineer> getAllPreSales(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return preSalesServices.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<PreSalesEngineer>  sortAllPreSaless(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return preSalesServices.SortAll(nbr,size, sorting, sortDirection);
    }
    @GetMapping("find/{name}")
    public List<PreSalesEngineer> finding(@PathVariable (name = "name") String name) {
        return preSalesServices.filter(name);
    }

    @GetMapping("/searchName/{name}")
    public List<PreSalesEngineer> filterByName(@PathVariable(name="name") String name){
        return preSalesServices.filterByName(name);
    }

    @GetMapping("/searchDep/{dep}")
    public List<PreSalesEngineer> filterByDep(@PathVariable(name="dep") String dep){
        return preSalesServices.filterByDep(dep);
    }

    @GetMapping("/searchUnit/{unit}")
    public List<PreSalesEngineer> filterByUnit(@PathVariable(name="unit") String unit){
        return preSalesServices.filterByUnit(unit);
    }

    @GetMapping("/searchLine/{line}")
    public List<PreSalesEngineer> filterByLine(@PathVariable(name="line") String line){
        return preSalesServices.filterByLine(line);
    }

    @GetMapping("/searchArea/{area}")
    public List<PreSalesEngineer> filterByArea(@PathVariable(name="area") String area){
        return preSalesServices.filterByArea(area);
    }
}
