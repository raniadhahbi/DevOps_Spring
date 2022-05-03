package com.example.opportunity.Entity;

import javax.persistence.*;

@Entity
public class OpportunityProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    Long idAssociate;

    @ManyToOne
    @JoinColumn(name = "idOpportunity")
    Opportuniy opportuniy;

    @ManyToOne
    @JoinColumn(name = "idProductLine")
    ProductLine productLine;


    private Float localPartCurrency;

    private Float localPart;

    private Float HQPart;

    private Float totalAmount;

    public OpportunityProduct(Long idAssociate, Opportuniy opportuniy, ProductLine productLine, Float localPartCurrency, Float localPart, Float HQPart, Float totalAmount) {
        this.idAssociate = idAssociate;
        this.opportuniy = opportuniy;
        this.productLine = productLine;
        this.localPartCurrency = localPartCurrency;
        this.localPart = localPart;
        this.HQPart = HQPart;
        this.totalAmount = totalAmount;
    }

    public OpportunityProduct() {

    }

    public Long getIdAssociate() {
        return idAssociate;
    }

    public void setIdAssociate(Long idAssociate) {
        this.idAssociate = idAssociate;
    }

    public Opportuniy getOpportuniy() {
        return opportuniy;
    }

    public void setOpportuniy(Opportuniy opportuniy) {
        this.opportuniy = opportuniy;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public Float getLocalPartCurrency() {
        return localPartCurrency;
    }

    public void setLocalPartCurrency(Float localPartCurrency) {
        this.localPartCurrency = localPartCurrency;
    }

    public Float getLocalPart() {
        return localPart;
    }

    public void setLocalPart(Float localPart) {
        this.localPart = localPart;
    }

    public Float getHQPart() {
        return HQPart;
    }

    public void setHQPart(Float HQPart) {
        this.HQPart = HQPart;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
