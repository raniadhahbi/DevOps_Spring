package com.example.opportunity.Service;


import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Entity.Roles;
import com.example.opportunity.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RoleServiceImpl  implements RolesService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Roles>  getRoles(){
        return roleRepository.findAll();
    }

    @Override
    public List<Roles> getRoleByUser(Long idUser){
        return roleRepository.findAllByUsers(idUser);
    }

    @Override
    public Roles findById(Long id){
        return roleRepository.findByIdRole(id);
    }
    @Override
    public Roles addRole(Roles role){
        return roleRepository.save(role);
    }

    public void deleteRole(Long id){
        roleRepository.deleteRolesByIdRole(id);
    }


    public Roles addPermission(Long id, List<Permissions> permissions){
        Roles r= roleRepository.findByIdRole(id);
        r.setPermissions(permissions);
        return r;
    }
    @Override
    public Roles updateRole(Roles roles){
        Roles r= roleRepository.findByName(roles.getName());
        r.setPermissions(roles.getPermissions());
        return r;
    }
    @Override
    public List<Permissions> getPermissions(String name){
        Roles roles=roleRepository.findByName(name);
        return roles.getPermissions();
    }

    @Override
    public Roles updateName(Roles  roles){
        Roles r=roleRepository.findByIdRole(roles.getIdRole());

        r.setName(roles.getName());
        return r;
    }

}
