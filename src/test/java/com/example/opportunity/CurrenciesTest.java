package com.example.opportunity;


import com.example.opportunity.Entity.Currencies;
import com.example.opportunity.Service.CurrenciesService;
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
public class CurrenciesTest {


    @Autowired
    CurrenciesService currenciesService;

    @Test
    @Order(1)
    public void testListCurrencies() {
        List<Currencies> listContrats = currenciesService.getAllCurrencies();
        boolean test = false;
        if (listContrats.size()>0){
            test= true;
        }
        Assert.assertTrue(test);
    }


    @Test
    @Order(2)
    public void testAddCurrency() throws ParseException {
        String codRef = "cod";
        float rat = (float) 65.55;
        Float ratRef = rat;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = dateFormat.parse("23/02/2022");

        Currencies c = new Currencies(codRef,ratRef,d);
        Currencies ContratAdded = currenciesService.addCurrency(c);
        Assert.assertEquals(c.getCode(), ContratAdded.getCode());
    }


}
