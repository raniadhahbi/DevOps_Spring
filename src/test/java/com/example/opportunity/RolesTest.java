package com.example.opportunity;

import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Entity.Roles;
import com.example.opportunity.Service.PermissionsServiceImpl;
import com.example.opportunity.Service.RoleServiceImpl;
import com.example.opportunity.Service.RolesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RolesTest {

    @Autowired
    RoleServiceImpl rolesService;


    @Test
    @Order(1)
    public void testAddDepartement() throws ParseException {
        String n = "RoleTest";
        Roles c = new Roles(1L, n);
        Roles LineAdded = rolesService.addRole(c);
        Assert.assertEquals(c.getName(), LineAdded.getName());
    }

    @Test
    @Order(2)
    public void testListBusinessUnits() {
        List<Roles> listsRoles = rolesService.getRoles();
        boolean test = false;
        if (listsRoles.size() > 0) {
            test = true;
        }
        Assert.assertTrue(test);
    }


}