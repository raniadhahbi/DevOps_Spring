package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Opportuniy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpportunityRepository extends JpaRepository<Opportuniy,Long> {
    public List<Opportuniy> findAll();
    public Opportuniy findByidOpportunity(Long idOpportunity);

}
