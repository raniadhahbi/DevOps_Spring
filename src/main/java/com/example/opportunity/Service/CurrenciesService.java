package com.example.opportunity.Service;


import com.example.opportunity.Entity.BusinessUnit;
import com.example.opportunity.Entity.Currencies;
import com.example.opportunity.Repository.CurrenciesRepository;
//import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class CurrenciesService {
    @Autowired
    CurrenciesRepository currenciesRepository;


    public List<Currencies> getAllCurrencies(){
        return currenciesRepository.findAll();
    }


    public Currencies getCurrencyByidCurrency(Long idCurrency){
        return currenciesRepository.findByidCurrency(idCurrency);

    }
    public  Currencies addCurrency(Currencies curency){
        return currenciesRepository.save(curency);
    }


    public void retrieveCurrency(Long idCurrency){
        currenciesRepository.deleteByIdCurrency(idCurrency);

    }
    public List <Currencies> getAll(int nbr, int size){
        Pageable secondPageWithFiveElements = PageRequest.of(nbr, size);
        return currenciesRepository.findAll(secondPageWithFiveElements).getContent();
    }
    public Currencies updateCurrency(Currencies currencies){
        Currencies currency=currenciesRepository.findByidCurrency(currencies.getId_Currency());
        currency.setCode(currencies.getCode());
        currency.setConversion_date(currencies.getConversion_date());
        currency.setConversion_rate(currencies.getConversion_rate());
        return currency;
    }

   public List<Currencies> filterByCode(String code){
        return currenciesRepository.findByCode(code);
   }

   public List<Currencies> filterByConversion(Date date){
        return currenciesRepository.findByConversionDate(date);
    }


   public Date gettheDates(String code,Date myDate){
        List<Date> d=new ArrayList<>();
        List<Currencies> c=currenciesRepository.findByCode(code);
        for(int a=0;a<c.size();a++){
            d.add(c.get(a).getConversion_date());
        }
        Date dateM=getNearestDate(d,myDate);
        return dateM;
   }
    public Date getNearestDate(List<Date> dates, Date currentDate) {
        long minDiff = -1, currentTime = currentDate.getTime();
        Date minDate = null;
        for (Date date : dates) {
            long diff = Math.abs(currentTime - date.getTime());
            if ((minDiff == -1) || (diff < minDiff)) {
                minDiff = diff;
                minDate = date;
            }
        }
        return minDate;
    }
}
