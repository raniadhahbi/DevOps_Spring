package com.example.opportunity;

import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Service.BusinessUnitServiceImpl;
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
public class BusinessUnitTest {

    @Autowired
    BusinessUnitServiceImpl businessUnitService;

    @Test
    @Order(1)
    public void testListBusinessUnits() {
        List<BusinessUnit> listsBusinessLine = businessUnitService.getAllBusinessUnit();
        boolean test = false;
        if (listsBusinessLine.size()>0){
            test= true;
        }
        Assert.assertTrue(test);
    }

    @Test
    @Order(2)
    public void testAddDepartement() throws ParseException {
        String n="BusinessUnitTest";
        BusinessUnit c = new BusinessUnit(1L,n);
        BusinessUnit LineAdded = businessUnitService.addBusinessUnit(c);
        Assert.assertEquals(c.getName(), LineAdded.getName());
    }
}
