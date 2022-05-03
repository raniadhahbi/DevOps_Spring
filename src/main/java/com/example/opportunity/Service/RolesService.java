package com.example.opportunity.Service;


import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Entity.Roles;

import java.util.List;

public interface RolesService {

    List<Roles> getRoles();


    List<Roles> getRoleByUser(Long idUser);

    //Roles findRolesByName(String name);


    Roles findById(Long id);

    Roles addRole(Roles role);

    void deleteRole(Long id);

    Roles updateRole(Roles role);

    Roles updateName(Roles  roles);

    List<Permissions> getPermissions(String name);
}
