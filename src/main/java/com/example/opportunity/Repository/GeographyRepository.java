package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.Geography;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeographyRepository extends JpaRepository<Geography,Long> {
    public List<Geography> findAll();
    public Geography findByidGeography(Long idGeography);
    public void deleteGeographyByIdGeography(Long id);

    public List<Geography> findGeographyByAreas(Area area);

    @Query("SELECT distinct p FROM Geography p, Area a where p.country  like %?1% or p.continent  like %?1% or a.nameArea like %?1%  ")
    public List<Geography> finding(String name);

    @Query("SELECT distinct p FROM Geography p where p.country  like %?1%   ")
    public List<Geography> findingCountry(String country);

    @Query("SELECT distinct p FROM Geography p where p.continent  like %?1% ")
    public List<Geography> findingContinent(String continent);

    @Query("SELECT distinct p FROM Geography p, Area a where a.nameArea like %?1%  ")
    public List<Geography> findingArea(String name);
}
