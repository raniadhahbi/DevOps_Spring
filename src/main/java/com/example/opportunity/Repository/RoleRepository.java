package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Roles,Long> {


    List<Roles> findAllByUsers(Long idUser);
    public void deleteRolesByIdRole(Long id);
    Roles findByIdRole(Long id);
    Roles findByName(String name);

}
