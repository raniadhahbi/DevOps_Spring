package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Business_Unit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BusinessUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUnit;


    private String name;


    private boolean Status=true;

    @OneToMany(mappedBy = "unit" ,fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    private List<Business_Line> Business_Lines;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ProductLine_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idProductLine"))
    private List<ProductLine> ProductLineList;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Departement_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idDepartement"))
    private List<Departement> departementList;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Area_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idArea"))
    private List<Area> areaLists;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "Customer_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idCustomer"))
    private List<Customer> customerList;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "user_businessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="id"))
    private List<User> userList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PreSales_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idPreSales"))
    private List<PreSalesEngineer> PreSalesList;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Opportuniy> opportunities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  boolean isStatus() {
        return Status;
    }

    public  void setStatus(boolean status) {
        this.Status = status;
    }


    public void setId_unit(Long id_unit) {
        this.idUnit = id_unit;
    }

    public Long getId_unit() {
        return idUnit;
    }


    public BusinessUnit(Long id_unit, String name) {
        this.idUnit = id_unit;
        this.name = name;
        this.Status=true;
    }



    public BusinessUnit() {

    }
}
