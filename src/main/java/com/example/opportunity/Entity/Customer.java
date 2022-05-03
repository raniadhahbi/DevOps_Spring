package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idCustomer ;

    private boolean status=true;

    private String customerName;

    private String sapPartner;

    private String customerGroup;

    private String country;


    @ManyToOne(fetch=FetchType.LAZY)
    private Geography geographies;

    @ManyToMany(fetch=FetchType.LAZY )
    @JoinTable(name = "Customer_Area",joinColumns = @JoinColumn(name="idCustomer"),inverseJoinColumns=@JoinColumn(name="idArea"))
    private List<Area> areaList;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "Customer_BusinessLine",joinColumns = @JoinColumn(name="idCustomer"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLineList;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "Customer_BusinessUnit",joinColumns = @JoinColumn(name="idCustomer"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnitList;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "Customer_Departement", joinColumns = @JoinColumn(name = "idCustomer"), inverseJoinColumns = @JoinColumn(name = "idDepartement"))
    private List<Departement> departementList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Opportunity_Customer",joinColumns = @JoinColumn(name="idCustomer"),inverseJoinColumns=@JoinColumn(name="idOpportunity"))
    private List<Opportuniy> opportunities;

    public Customer(Long id, String customer_name, String SAP_Partner, String customer_Group,String country) {
        this.idCustomer = id;
        this.customerName = customer_name;
        this.sapPartner = SAP_Partner;
        this.customerGroup = customer_Group;
        this.country=country;

    }
    public Customer(Long id, String customer_name, String customer_Group) {
        this.idCustomer = id;
        this.customerName = customer_name;
        this.customerGroup = customer_Group;


    }



    public Customer() {

    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSapPartner() {
        return sapPartner;
    }

    public void setSapPartner(String sapPartner) {
        this.sapPartner = sapPartner;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    public List<Business_Line> getBusinessLineList() {
        return businessLineList;
    }

    public void setBusinessLineList(List<Business_Line> businessLineList) {
        this.businessLineList = businessLineList;
    }

    public List<BusinessUnit> getBusinessUnitList() {
        return businessUnitList;
    }

    public void setBusinessUnitList(List<BusinessUnit> businessUnitList) {
        this.businessUnitList = businessUnitList;
    }

    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }
}








