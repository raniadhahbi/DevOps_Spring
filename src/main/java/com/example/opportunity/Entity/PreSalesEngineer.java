package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="PreSalesEngineer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PreSalesEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idPreSales;

    private String name;

    private boolean status=true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PreSales_BusinessUnit",joinColumns = @JoinColumn(name="idPreSales"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> business_units;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PreSales_BusinessLine",joinColumns = @JoinColumn(name="idPreSales"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLines;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PreSales_Departement", joinColumns = @JoinColumn(name = "idPreSales"), inverseJoinColumns = @JoinColumn(name = "idDepartement"))
    private List<Departement> departementList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PreSales_Area",joinColumns = @JoinColumn(name="idPreSales"),inverseJoinColumns=@JoinColumn(name="idArea"))
    private List<Area> areaList;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Opportuniy> opportunities;

    public PreSalesEngineer(Long idPreSlaes, String name, List<BusinessUnit> business_units, List<Business_Line> businessLines, List<Departement> departementList, List<Area> areaList) {
        this.idPreSales = idPreSlaes;
        this.name = name;
        this.business_units = business_units;
        this.businessLines = businessLines;
        this.departementList = departementList;
        this.areaList = areaList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public PreSalesEngineer(){}

    public Long getIdPreSales() {
        return idPreSales;
    }

    public void setIdPreSales(Long idPreSales) {
        this.idPreSales = idPreSales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusinessUnit> getBusiness_units() {
        return business_units;
    }

    public void setBusiness_units(List<BusinessUnit> business_units) {
        this.business_units = business_units;
    }

    public List<Business_Line> getBusinessLines() {
        return businessLines;
    }

    public void setBusinessLines(List<Business_Line> businessLines) {
        this.businessLines = businessLines;
    }

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
