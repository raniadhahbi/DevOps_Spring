package com.example.opportunity.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Currencies")
public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @SequenceGenerator(name="currency_generator", sequenceName = "currency_seq", allocationSize=50)
    @Column(nullable=false,updatable=false)
    private Long idCurrency;

    private String code;

    private Float conversion_rate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="UTC")
    private Date conversionDate;


    public Long getId_Currency() {
        return idCurrency;
    }

    public void setId_Currency(Long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(Float conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public Date getConversion_date() {
        return conversionDate;
    }

    public void setConversion_date(Date conversion_date) {
        this.conversionDate = conversion_date;
    }



    public Currencies(String code, Float Rate, Date conversion_date) {
        this.code = code;
        this.conversion_rate = Rate;
        this.conversionDate = conversion_date;

    }

    public Currencies() {

    }
}
