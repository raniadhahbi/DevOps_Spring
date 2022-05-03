package com.example.opportunity.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ProductLine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idProductLine;

    private String name;

    private boolean status=true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ProductLine_BusinessUnit",joinColumns = @JoinColumn(name="idProductLine"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnits;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ProductLine_BusinessLine",joinColumns = @JoinColumn(name="idProductLine"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLines;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ProductLine_Departement", joinColumns = @JoinColumn(name = "idProductLine"), inverseJoinColumns = @JoinColumn(name = "idDepartement"))
    private List<Departement> departementList;


    @OneToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    List<OpportunityProduct> opportunityProducts;


    public ProductLine(Long idProductLine, String name, List<BusinessUnit> business_units, List<Business_Line> businessLines, List<Departement> departementList) {
        this.idProductLine = idProductLine;
        this.name = name;
        this.businessUnits = business_units;
        this.businessLines = businessLines;
        this.departementList = departementList;
    }
    public  ProductLine(){}
    public ProductLine(Long idProductLine, String name) {
        this.idProductLine = idProductLine;
        this.name = name;
    }

    public Long getIdProductLine() {
        return idProductLine;
    }

    public void setIdProductLine(Long idProductLine) {
        this.idProductLine = idProductLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BusinessUnit> getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnit> business_units) {
        this.businessUnits = business_units;
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


}
