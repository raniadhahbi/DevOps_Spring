package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionsRepository extends JpaRepository<Permissions,Long> {
    public List<Permissions> findAll();
    public Permissions findByidPermission(Long idPermissions);
    public void deletePermissionsByIdPermission(Long id);
}
