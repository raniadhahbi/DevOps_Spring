package com.example.opportunity.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id ;


    private boolean status=true;

    private String firstName;

    private String lastName;

    private String email ;

    private String login;

    private String mypassword;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date LastConnectionDate;


    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date CreationDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idRole"))
    private List<Roles> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_businessUnit",joinColumns = @JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnits;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_BusinessLine",joinColumns = @JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLines;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Departement", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "idDepartement"))
    private List<Departement> departementList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "User_Area",joinColumns = @JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="idArea"))
    private List<Area> AreaList;

    @OneToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    private List<Opportuniy> opportunities;

    public User(Long id, String first_name, String last_name, String email, String login, Date Creation_date) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.login = login;
       // this.lastConnectionDate=new Date();
        this.CreationDate=Creation_date;
        this.status=true;

    }

    public User(){}


    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getLastConnectionDate() {
        return LastConnectionDate;
    }

    public void setLastConnectionDate(Date lastConnectionDate) {
        this.LastConnectionDate = lastConnectionDate;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
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
        return AreaList;
    }

    public void setAreaList(List<Area> areaList) {
        AreaList = areaList;
    }

    public List<BusinessUnit> getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnit> businessUnits) {
        this.businessUnits = businessUnits;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }
}








