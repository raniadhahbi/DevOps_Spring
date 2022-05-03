package com.example.opportunity.Service;

import com.example.opportunity.Entity.OpportunityProduct;
import com.example.opportunity.Entity.Opportuniy;
import com.example.opportunity.Entity.ProductLine;
import com.example.opportunity.Repository.OpportunityProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityProductService {

    @Autowired
    OpportunityProductRepository opportunityProductRepository;

    public List<OpportunityProduct> listAll(){
        return opportunityProductRepository.findAll();
    }
    public void addAssociate(OpportunityProduct opportunityProduct){
         opportunityProductRepository.save(opportunityProduct);
    }
    public void add(Opportuniy opportuniy, ProductLine productLine){
        OpportunityProduct opportunityProduct=new OpportunityProduct();
        opportunityProduct.setProductLine(productLine);
        opportunityProduct.setOpportuniy(opportuniy);
        opportunityProductRepository.save(opportunityProduct);
    }

}
