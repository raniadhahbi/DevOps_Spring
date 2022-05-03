package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Entity.ProductLine;
import com.example.opportunity.Service.ProductLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ProductLine")
public class ProductLineController {

    @Autowired
    ProductLineServiceImpl productLineService;

    @GetMapping("/all")
    public List<ProductLine> allProductLine() {
        return productLineService.ListAllProducts();
    }

    @GetMapping("/getProduct/{idProduct}")
    public ProductLine getProductLine(@PathVariable (name = "idProduct") Long idProduct){
        return productLineService.getProductLineById(idProduct);
    }

    @GetMapping("/getProductByUnit/{id}")
    public List<ProductLine> getByUnits(@PathVariable (name = "id") Long id){
        return productLineService.getProductByUnit(id);
    }

    @PostMapping("/add")
    public void createProductLine(@RequestBody ProductLine productLine){
        productLineService.addProductLine(productLine);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductLine(@PathVariable (name = "id") Long id){
        productLineService.deleteProductLine(id);
    }
    @PutMapping("/update")
    public ProductLine modifyProduct(@RequestBody ProductLine productLine){
        return productLineService.upadateProduct(productLine);
    }

    @GetMapping("/disable/{id}")
    public ProductLine switchStatus(@PathVariable (name="id") Long id ){
        return productLineService.switchStatus(id);
    }

    @GetMapping("/Allpages/{nbr}/{size}")
    public List<ProductLine> getAllProductss(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return productLineService.getAll(nbr,size);
    }
    @GetMapping("/SortAllpages/{nbr}/{size}/{sorting}/{sortDirection}")
    public List<ProductLine>  sortAllProducts(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size,@PathVariable(name = "sorting") String sorting,@PathVariable(name="sortDirection")  String sortDirection){
        return productLineService.SortAll(nbr,size, sorting, sortDirection);
    }
    @GetMapping("find/{name}")
    public List<ProductLine> finding(@PathVariable (name = "name") String name) {
        return productLineService.filter(name);
    }

    @GetMapping("/searchName/{name}")
    public List<ProductLine> filterByName(@PathVariable(name="name") String name){
        return productLineService.filterByName(name);
    }

    @GetMapping("/searchDep/{dep}")
    public List<ProductLine> filterByDep(@PathVariable(name="dep") String dep){
        return productLineService.filterByDep(dep);
    }

    @GetMapping("/searchUnit/{unit}")
    public List<ProductLine> filterByUnit(@PathVariable(name="unit") String unit){
        return productLineService.filterByUnit(unit);
    }

    @GetMapping("/searchLine/{line}")
    public List<ProductLine> filterByLine(@PathVariable(name="line") String line){
        return productLineService.filterByLine(line);
    }
}
