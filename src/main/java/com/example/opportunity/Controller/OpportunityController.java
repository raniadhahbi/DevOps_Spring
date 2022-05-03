package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Opportuniy;
import com.example.opportunity.Service.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Opportunity")
public class OpportunityController {

    @Autowired
    OpportunityServiceImpl opportunityService;

    @GetMapping("/All")
    public List<Opportuniy> getAllOpportunity(){
        return opportunityService.getAllOpportunity();
    }

    @GetMapping("/getOpportunity/{idOpportunity}")
    public Opportuniy getAllOpportunity(@PathVariable (name="idOpportunity") Long idOpportunity){
        return opportunityService.getOpportunitById(idOpportunity);
    }

    @PostMapping("/add")
    public void addOpportunity(@RequestBody Opportuniy opportuniy){
        opportunityService.addOpportunity(opportuniy);
    }
}
