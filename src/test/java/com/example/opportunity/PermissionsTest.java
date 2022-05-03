package com.example.opportunity;

import com.example.opportunity.Entity.Permissions;
import com.example.opportunity.Service.PermissionsServiceImpl;
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
public class PermissionsTest {

    @Autowired
    PermissionsServiceImpl permissionsService;


    @Test
    @Order(1)
    public void testAddDepartement() throws ParseException {
        String n = "PermissionTest";
        String l="label";
        Permissions c = new Permissions(1L, n,l);
        Permissions LineAdded = permissionsService.addPermission(c);
        Assert.assertEquals(c.getCodePermission(), LineAdded.getCodePermission());
    }

    @Test
    @Order(2)
    public void testListBusinessUnits() {
        List<Permissions> listsPermissions = permissionsService.getAllPermissions();
        boolean test = false;
        if (listsPermissions.size() > 0) {
            test = true;
        }
        Assert.assertTrue(test);
    }


}