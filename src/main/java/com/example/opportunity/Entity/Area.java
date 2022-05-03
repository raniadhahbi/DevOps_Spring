package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Area")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idArea;

    private String nameArea;

    private boolean status=true;

    @OneToMany(fetch= FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    private List<Geography> GeographyList;

    //@ManyToMany(fetch= FetchType.LAZY)
    //private List<Country> country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Area_BusinessUnit",joinColumns = @JoinColumn(name="idArea"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnits;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "Customer_Area",joinColumns = @JoinColumn(name="idArea"),inverseJoinColumns=@JoinColumn(name="idCustomer"))
    private List<Customer> customerList;

    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name = "User_Area",joinColumns = @JoinColumn(name="idArea"),inverseJoinColumns=@JoinColumn(name="id"))
    private List<User> userList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PreSales_Area",joinColumns = @JoinColumn(name="idArea"),inverseJoinColumns=@JoinColumn(name="idPreSales"))
    private List<PreSalesEngineer> PreSalesList;

    public Area(Long id_Area, String nameArea) {
        this.idArea = id_Area;
        this.nameArea = nameArea;

    }

    public Area(){

    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
    public Long getId_Area() {
        return idArea;
    }

    public void setId_Area(Long id_Area) {
        this.idArea = id_Area;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BusinessUnit> getBusiness_units() {
        return businessUnits;
    }

    public void setBusiness_units(List<BusinessUnit> business_units) {
        this.businessUnits = business_units;
    }
}
