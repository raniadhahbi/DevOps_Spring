package com.example.opportunity.Service;


import com.example.opportunity.Entity.OpportunityProduct;
import com.example.opportunity.Entity.Opportuniy;
import com.example.opportunity.Repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    OpportunityProductService opportunityProductService;

    public Opportuniy getOpportunitById(Long idOpportunity){
        return opportunityRepository.findByidOpportunity(idOpportunity);
    }

    public List<Opportuniy> getAllOpportunity(){
        return opportunityRepository.findAll();
    }

    public void addOpportunity(Opportuniy opportuniy){
        opportunityRepository.save(opportuniy);
    }

}
