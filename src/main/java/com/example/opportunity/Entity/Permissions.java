package com.example.opportunity.Entity;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="Permissions")
public class Permissions {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idPermission;

    private String codePermission;

    private String label;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "Roles_Permissions",joinColumns = @JoinColumn(name="idPermission"),inverseJoinColumns=@JoinColumn(name="idRole"))
    private List<Roles> rolesList;

    public Permissions(Long idPermission, String namePermission, String label) {
        this.idPermission = idPermission;
        this.codePermission = namePermission;
        this.label=label;
    }
    public Permissions(){}

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }


    public String getCodePermission() {
        return codePermission;
    }

    public void setCodePermission(String codePermission) {
        this.codePermission = codePermission;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
