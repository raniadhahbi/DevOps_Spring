package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Geography")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Geography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idGeography;

    @ManyToOne(fetch=FetchType.LAZY)
    private Area areas;

    private String continent;

    private String country;

    private boolean status=true;

    @OneToMany(mappedBy = "geographies" ,fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    private List<Customer> customer;


    public Long getIdGeography() {
        return idGeography;
    }

    public void setIdGeography(Long idGeography) {
        this.idGeography = idGeography;
    }

    public Area getAreas() {
        return areas;
    }

    public void setAreas(Area areas) {
        this.areas = areas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Geography(Long id_Geography, String continent, String country) {
        this.idGeography = id_Geography;
        this.continent = continent;
        this.country=country;
    }
    public Geography(Long id_Geography, String continent,String country,Area areasList) {
        this.idGeography = id_Geography;
        this.continent = continent;
        this.country=country;
        this.areas=areasList;
        this.status=true;
    }

    public Geography() {
    }
}

