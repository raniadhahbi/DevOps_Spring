package com.example.opportunity;


import com.example.opportunity.Entity.Currencies;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Service.DepartementServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {

    @Autowired
    DepartementServiceImpl departementService;

    @Test
    @Order(1)
    public void testListDepartements() {
        List<Departement> listsDepartements = departementService.getAllDepartement();
        boolean test = false;
        if (listsDepartements.size()>0){
            test= true;
        }
        Assert.assertTrue(test);
    }

    @Test
    @Order(2)
    public void testAddDepartement() throws ParseException {
        String n="departementTest";
        Departement c = new Departement(1L,n);
        Departement ContratAdded = departementService.addDepartement(c);
        Assert.assertEquals(c.getNameDep(), ContratAdded.getNameDep());
    }
}
