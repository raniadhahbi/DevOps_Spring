package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Entity.Roles;
import com.example.opportunity.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Roles")
public class RoleController {

    @Autowired
    RolesService rolesService;

    @GetMapping(value = "/getRolesByUser/{idUser}")
    public List<Roles> getRoles(@PathVariable (name="idUser") Long idUser){
        return rolesService.getRoleByUser(idUser);
    }

    @GetMapping(value = "/getRolesById/{id}")
    public Roles getRoleById(@PathVariable (name="id") Long id){
        return rolesService.findById(id);
    }

    @GetMapping(value = "/All")
    public List<Roles> getAllRoles(){
        return rolesService.getRoles();
    }

    @PostMapping(value = "/add")
    public void addRole(@RequestBody  Roles role)
    {
        rolesService.addRole(role);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable (name = "id") Long id){
        rolesService.deleteRole(id);
        return "deleted !";
    }

    @PutMapping("/updatePermission")
    public Roles updateRole(@RequestBody Roles roles){
        return rolesService.updateRole(roles);

    }
    @GetMapping("/getPermission/{name}")
    public List<Permissions> getPermissions(@PathVariable(name = "name") String name){
        return rolesService.getPermissions(name);
    }

    @PutMapping("/updateName")
    public Roles updateName(@RequestBody Roles roles ){
        return rolesService.updateName(roles);
    }

}
