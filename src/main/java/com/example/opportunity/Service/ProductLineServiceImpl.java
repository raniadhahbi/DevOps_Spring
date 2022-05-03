package com.example.opportunity.Service;


import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Entity.PreSalesEngineer;
import com.example.opportunity.Entity.ProductLine;
import com.example.opportunity.Repository.BusinessUnitRepository;
import com.example.opportunity.Repository.ProductLineRepository;
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
public class ProductLineServiceImpl {

    @Autowired
    ProductLineRepository productLineRepository;

    @Autowired
    BusinessUnitRepository business;

    public List<ProductLine> ListAllProducts(){
        return productLineRepository.findAll();
    }

    public ProductLine getProductLineById(Long idProduct){
        return productLineRepository.getProductLineByidProductLine(idProduct);
    }

    public List<ProductLine> getProductByUnit(Long id){
        List<ProductLine> pList=new ArrayList<>();
        BusinessUnit b=business.findByidUnit(id);
        List<ProductLine> p=productLineRepository.findByBusinessUnits(b);
        for(int r=0;r<p.size();r++){
            if(p.get(r).isStatus()==true){
                pList.add(p.get(r));
            }
        }
        return pList;
    }
    public ProductLine addProductLine(ProductLine productLine){
       return productLineRepository.save(productLine);

    }
    public void deleteProductLine(Long  id){

        productLineRepository.deleteProductLineByIdProductLine(id);
    }
    public ProductLine upadateProduct(ProductLine productLine){
        ProductLine updatedProduct=productLineRepository.getProductLineByidProductLine(productLine.getIdProductLine());
        updatedProduct.setName(productLine.getName());
        updatedProduct.setBusinessLines(productLine.getBusinessLines());
        updatedProduct.setBusinessUnits(productLine.getBusinessUnits());
        updatedProduct.setDepartementList(productLine.getDepartementList());
        return updatedProduct;
    }
    public ProductLine switchStatus(Long id){

        ProductLine prodToBe =productLineRepository.getById(id);
        prodToBe.setStatus(false);
        return prodToBe;

    }

    public List <ProductLine> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, Sort.by("name").descending());

        return productLineRepository.findAll(secondPageWithFiveElements).getContent();


    }
    public List <ProductLine> SortAll(int nbr, int size,String sorting,String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size, sort);

        return productLineRepository.findAll(secondPageWithFiveElements).getContent();
    }

    public List<ProductLine> filter(String name){

        return productLineRepository.finding(name);
    }

    public List<ProductLine> filterByName(String name){
        return productLineRepository.findingName(name);
    }
    public List<ProductLine> filterByDep(String dep){

        return productLineRepository.findingDep(dep);
    }
    public List<ProductLine> filterByUnit(String unit){

        return productLineRepository.findingUnit(unit);
    }
    public List<ProductLine> filterByLine(String line){

        return productLineRepository.findingLine(line);
    }
}
