package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Opportuniy;
import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Service.PermissionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Permissions")
public class PermissionsController {

    @Autowired
    PermissionsServiceImpl permissionsService;


    @GetMapping("/All")
    public List<Permissions> getAllPermissions(){

        return permissionsService.getAllPermissions();
    }
    @GetMapping("/getPermissions/{idPermission}")
    public Permissions getAllOpportunity(@PathVariable(name="idPermission") Long idPermission){
        return permissionsService.getPermissionById(idPermission);
    }
    @PostMapping("/add")
    public void addPermission(@RequestBody Permissions permissions){

        permissionsService.addPermission(permissions);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePermission(@PathVariable (name="id") Long id){
        permissionsService.deletePermission(id);
        return "deleted !";
    }


}
