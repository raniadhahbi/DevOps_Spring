package com.example.opportunity.Service;


import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PermissionsServiceImpl {
    @Autowired
    PermissionsRepository permissionsRepository;

    public List<Permissions> getAllPermissions(){
        return  permissionsRepository.findAll();
    }
    public Permissions getPermissionById(Long idPermissions){
        return permissionsRepository.findByidPermission(idPermissions);
    }
    public Permissions addPermission(Permissions permissions){
        return permissionsRepository.save(permissions);
    }

    public void deletePermission(Long id){permissionsRepository.deletePermissionsByIdPermission(id);}
}
