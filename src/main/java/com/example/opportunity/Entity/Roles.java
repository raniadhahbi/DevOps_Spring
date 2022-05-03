package com.example.opportunity.Entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idRole;


    private String name;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="idRole"),inverseJoinColumns=@JoinColumn(name="id"))
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Roles_Permissions",joinColumns = @JoinColumn(name="idRole"),inverseJoinColumns=@JoinColumn(name="idPermission"))
    private List<Permissions> permissions;


    public Roles(Long id_Role, String name) {
        this.idRole = id_Role;
        this.name=name;
    }
    public Roles() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public List<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permissions> permissions) {
        this.permissions = permissions;
    }
}
