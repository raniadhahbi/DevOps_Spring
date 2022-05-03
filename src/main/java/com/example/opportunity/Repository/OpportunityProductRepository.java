package com.example.opportunity.Repository;

import com.example.opportunity.Entity.OpportunityProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpportunityProductRepository  extends JpaRepository<OpportunityProduct,Long> {

    public List<OpportunityProduct> findAll();

    //public void save(OpportunityProduct opportunityProduct);

}
