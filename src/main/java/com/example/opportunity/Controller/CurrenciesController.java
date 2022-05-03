package com.example.opportunity.Controller;


import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Currencies;
import com.example.opportunity.Service.CurrenciesService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/Currencies")
public class CurrenciesController {
    @Autowired
    CurrenciesService currenciesService;


    @GetMapping("/All")
    public List<Currencies> getAllCurrencies(){
        return currenciesService.getAllCurrencies();
    }

    @GetMapping("/getCurrency/{idCurrency}")
    public Currencies getCurrencyById(@PathVariable (name="idCurrency") Long idCurrency){
        return currenciesService.getCurrencyByidCurrency(idCurrency);
    }

    @PostMapping("/add")
    public void createCurrency(@RequestBody Currencies currency){
        currenciesService.addCurrency(currency);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteCurrency(@PathVariable (name = "id") Long id){
        currenciesService.retrieveCurrency(id);

    }
    @GetMapping("/Allpages/{nbr}/{size}")
    public List<Currencies> getAllunits(@PathVariable(name = "nbr") int nbr, @PathVariable(name="size") int size){
        return currenciesService.getAll(nbr,size);
    }

    @PutMapping("/update")
    public Currencies ModifyCurrency(@RequestBody Currencies currencies){
        return currenciesService.updateCurrency(currencies);
    }

    @GetMapping("/searchCode/{code}")
    public List<Currencies> filterByCode(@PathVariable(name="code") String code){
        return currenciesService.filterByCode(code);
    }

    @GetMapping("/searchConversion/{date}")
    public List<Currencies> filterByCode(@PathVariable(name="date") Date date){
        return currenciesService.filterByConversion(date);
    }

    @GetMapping("/getNearestDate/{code}/{myDate}")
    public Date getNearestDate(@PathVariable (name="code") String code,@PathVariable (name = "myDate") String myDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Dated = formatter.parse(myDate);
        return currenciesService.gettheDates(code,Dated);
    }


}
