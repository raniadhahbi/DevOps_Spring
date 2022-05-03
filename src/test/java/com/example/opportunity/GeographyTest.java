package com.example.opportunity;

import com.example.opportunity.Entity.Geography;
import com.example.opportunity.Service.GeographyServiceImpl;
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
public class GeographyTest {

    @Autowired
    GeographyServiceImpl geographyService;

    @Test
    @Order(2)
    public void testListGeography() {
        List<Geography> listsGeographyies = geographyService.getAllGeography();
        boolean test = false;
        if (listsGeographyies.size()>0){
            test= true;
        }
        Assert.assertTrue(test);
    }

    @Test
    @Order(1)
    public void testAddGeography() throws ParseException {
        String n="country";
        String ct="continent";
        Geography c = new Geography(1L,n,ct);
        Geography LineAdded = geographyService.addGeography(c);
        Assert.assertEquals(c.getContinent(), LineAdded.getContinent());
    }
}
