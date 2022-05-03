package com.example.opportunity.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Departement")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idDepartement;

    private String nameDep;

    private boolean status=true;

    @ManyToMany
    @JoinTable(name = "Departement_BusinessLine",joinColumns = @JoinColumn(name="idDepartement"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLine;

    @ManyToMany
    @JoinTable(name = "Departement_BusinessUnit",joinColumns = @JoinColumn(name="idDepartement"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnit;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ProductLine_Departement", joinColumns = @JoinColumn(name = "idDepartement"), inverseJoinColumns = @JoinColumn(name = "idProductLine"))
    private List<ProductLine> ProductLineList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Customer_Departement", joinColumns = @JoinColumn(name = "idDepartement"), inverseJoinColumns = @JoinColumn(name = "idCustomer"))
    private List<Customer> customerList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Departement", joinColumns = @JoinColumn(name = "idDepartement"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<User> userList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PreSales_Departement", joinColumns = @JoinColumn(name = "idDepartement"), inverseJoinColumns = @JoinColumn(name = "idPreSales"))
    private List<PreSalesEngineer> PreSalesList;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Opportuniy> opportunities;


    public Departement(Long idDepartement, String nameDep, List<Business_Line> businessLine, List<BusinessUnit> businessUnit) {
        this.idDepartement = idDepartement;
        this.nameDep = nameDep;
        this.businessLine = businessLine;
        this.businessUnit = businessUnit;
    }
    public Departement(Long idDepartement, String nameDep) {
        this.idDepartement = idDepartement;
        this.nameDep = nameDep;

    }
    public Departement(){}

    public Long getId_Departement() {
        return idDepartement;
    }

    public void setId_Departement(Long id_Departement) {
        this.idDepartement = id_Departement;
    }

    public String getNameDep() {
        return nameDep;
    }


    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BusinessUnit> getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(List<BusinessUnit> businessUnit) {
        this.businessUnit = businessUnit;
    }

    public List<Business_Line> getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(List<Business_Line> businessLine) {
        this.businessLine = businessLine;
    }


}
