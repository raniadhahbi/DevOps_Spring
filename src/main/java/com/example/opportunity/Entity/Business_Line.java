package com.example.opportunity.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Business_Line")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Business_Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false,updatable=false)
    private Long idLine;


    private String name;


    private boolean Status=true;

    @ManyToOne(fetch=FetchType.LAZY )
    private BusinessUnit unit;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ProductLine_BusinessLine",joinColumns = @JoinColumn(name="idLine"),inverseJoinColumns=@JoinColumn(name="idProductLine"))
    private List<ProductLine> ProductLineList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Departement_BusinessLine",joinColumns = @JoinColumn(name="idLine"),inverseJoinColumns=@JoinColumn(name="idDepartement"))
    private List<Departement> departements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Departement_BusinessUnit",joinColumns = @JoinColumn(name="idUnit"),inverseJoinColumns=@JoinColumn(name="idDepartement"))
    private List<Departement> departementList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Customer_BusinessLine",joinColumns = @JoinColumn(name="idLine"),inverseJoinColumns=@JoinColumn(name="idCustomer"))
    private List<Customer> customerList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_BusinessLine",joinColumns = @JoinColumn(name="idLine"),inverseJoinColumns=@JoinColumn(name="id"))
    private List<User> userList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PreSales_BusinessLine",joinColumns = @JoinColumn(name="idLine"),inverseJoinColumns=@JoinColumn(name="idPreSales"))
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

    public Long getId_Line() {
        return idLine;
    }

    public void setId_Line(Long id_Line) {
        this.idLine = id_Line;
    }

    public BusinessUnit getUnit() {
        return unit;
    }

    public void setUnit(BusinessUnit unit) {
        this.unit = unit;
    }

    public Business_Line(Long id_Line, String name) {
        this.idLine = id_Line;
        this.name = name;

    }
    public Business_Line(Long id_Line, String name, BusinessUnit units) {
        this.idLine = id_Line;
        this.name = name;
        this.unit=units;

    }
    public Business_Line() {

    }
}
