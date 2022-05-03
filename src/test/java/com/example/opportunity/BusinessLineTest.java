package com.example.opportunity;

import com.example.opportunity.Entity.Business_Line;
import com.example.opportunity.Entity.Departement;
import com.example.opportunity.Service.BusinessLineServiceImpl;
import com.example.opportunity.Service.DepartementServiceImpl;
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
public class BusinessLineTest {

    @Autowired
    BusinessLineServiceImpl businessLineService;

    @Test
    @Order(1)
    public void testListBusinessLines() {
        List<Business_Line> listsBusinessLine = businessLineService.getAllBusinessLine();
        boolean test = false;
        if (listsBusinessLine.size()>0){
            test= true;
        }
        Assert.assertTrue(test);
    }

    @Test
    @Order(2)
    public void testAddDepartement() throws ParseException {
        String n="BusinessLineTest";
        Business_Line c = new Business_Line(1L,n);
        Business_Line LineAdded = businessLineService.addBusinessLine(c);
        Assert.assertEquals(c.getName(), LineAdded.getName());
    }
}
