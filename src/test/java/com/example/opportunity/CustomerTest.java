package com.example.opportunity;

import com.example.opportunity.Entity.Customer;
import com.example.opportunity.Entity.Geography;
import com.example.opportunity.Entity.ProductLine;
import com.example.opportunity.Service.CustomerServiceImpl;
import com.example.opportunity.Service.ProductLineServiceImpl;
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
public class CustomerTest {

    @Autowired
    CustomerServiceImpl customerService;




    @Test
    @Order(1)
    public void testListBusinessUnits() {
        List<Customer> listsCustomers = customerService.getAllCustomer();
        boolean test = false;
        if (listsCustomers.size() == 0) {
            test = true;
        }
        Assert.assertTrue(test);
    }


}