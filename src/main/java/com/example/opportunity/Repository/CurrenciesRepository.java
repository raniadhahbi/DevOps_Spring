package com.example.opportunity.Repository;

import com.example.opportunity.Entity.Area;
import com.example.opportunity.Entity.Currencies;

import com.example.opportunity.Entity.QCurrencies;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.Date;
import java.util.List;


public interface CurrenciesRepository extends JpaRepository<Currencies,Long>, QuerydslPredicateExecutor<Currencies> ,QuerydslBinderCustomizer<QCurrencies> {

    public List<Currencies> findAll();
    public Currencies findByidCurrency(Long IdCurrency);
    public void deleteAll();
    public void deleteByIdCurrency(Long currency);
    @Override
    default void customize(QuerydslBindings bindings,QCurrencies qCurrencies){
        bindings.bind(String.class).first((StringPath path,String value)->path.containsIgnoreCase(value));
    }
  public List<Currencies> findAll(Predicate prdicate);
   // public List<Currencies> findByCodeContaining(String code);
    public List<Currencies> findByCodeContaining(Float code);


    public List<Currencies> findByCode(String code);
    public List<Currencies> findByConversionDate(Date date);


}
