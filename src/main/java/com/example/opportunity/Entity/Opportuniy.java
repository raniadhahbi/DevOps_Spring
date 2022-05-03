package com.example.opportunity.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Opportunity")
public class Opportuniy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long idOpportunity;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date lastUpdateDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date lastStageUpdateDate;

    @ManyToOne(fetch=FetchType.LAZY)
    private User salesManager;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Opportunity_BusinessUnit",joinColumns = @JoinColumn(name="idOpportunity"),inverseJoinColumns=@JoinColumn(name="idUnit"))
    private List<BusinessUnit> businessUnits;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Opportunity_BusinessLine",joinColumns = @JoinColumn(name="idOpportunity"),inverseJoinColumns=@JoinColumn(name="idLine"))
    private List<Business_Line> businessLines;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Opportunity_Departement",joinColumns = @JoinColumn(name="idOpportunity"),inverseJoinColumns=@JoinColumn(name="idDepartement"))
    private List<Departement> departements;

    private String country;

    private String reference;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Customer> customers;

    private String stage;

    private Long successRate;

    private String Description;

    private Boolean inBudget;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date revenueStartPlanned;

    private Long contractDuration;

    private Float totalOffriniValue;

    private Float fullValue;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(name = "Opportunity_PreSales",joinColumns = @JoinColumn(name="idOpportunity"),inverseJoinColumns=@JoinColumn(name="idPreSales"))
    private List<PreSalesEngineer> preSalesEngineers;

    private String reason;

    private String comment;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date rFQDatePlanned;


    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date rFQDateAchieved;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date bidReviewDatePlanned;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date bidReviewDateAchieved;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date submissionDatePlanned;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date submissionDateAchieved;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date awardDatePlanned;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date awardDateAchieved;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date signatureDatePlanned;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date signatureDateAchieved;


    @OneToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE} ,orphanRemoval = true)
    List<OpportunityProduct> opportunityProducts;

    public Opportuniy(Long idOpportunity, Date creationDate, Date lastUpdateDate, Date lastStageUpdateDate, User salesManager, List<BusinessUnit> businessUnits, List<Business_Line> businessLines, List<Departement> departements, String country, String reference, List<Customer> customers, String stage, Long successRate, String description, Boolean inBudget, Date revenueStartPlanned, Long contractDuration, Float totalOffriniValue, Float fullValue, List<PreSalesEngineer> preSalesEngineers, String reason, String comment, Date rFQDatePlanned, Date rFQDateAchieved, Date bidReviewDatePlanned, Date bidReviewDateAchieved, Date submissionDatePlanned, Date submissionDateAchieved, Date awardDatePlanned, Date awardDateAchieved, Date signatureDatePlanned, Date signatureDateAchieved,List<OpportunityProduct> opportunityProducts) {
        this.idOpportunity = idOpportunity;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastStageUpdateDate = lastStageUpdateDate;
        this.salesManager = salesManager;
        this.businessUnits = businessUnits;
        this.businessLines = businessLines;
        this.departements = departements;
        this.country = country;
        this.reference = reference;
        this.customers = customers;
        this.stage = stage;
        this.successRate = successRate;
        this.Description = description;
        this.inBudget = inBudget;
        this.revenueStartPlanned = revenueStartPlanned;
        this.contractDuration = contractDuration;
        this.totalOffriniValue = totalOffriniValue;
        this.fullValue = fullValue;
        this.preSalesEngineers = preSalesEngineers;
        this.reason = reason;
        this.comment = comment;
        this.rFQDatePlanned = rFQDatePlanned;
        this.rFQDateAchieved = rFQDateAchieved;
        this.bidReviewDatePlanned = bidReviewDatePlanned;
        this.bidReviewDateAchieved = bidReviewDateAchieved;
        this.submissionDatePlanned = submissionDatePlanned;
        this.submissionDateAchieved = submissionDateAchieved;
        this.awardDatePlanned = awardDatePlanned;
        this.awardDateAchieved = awardDateAchieved;
        this.signatureDatePlanned = signatureDatePlanned;
        this.signatureDateAchieved = signatureDateAchieved;
        this.opportunityProducts=opportunityProducts;
    }

    public Opportuniy() {

    }

    public Long getIdOpportunity() {
        return idOpportunity;
    }

    public void setIdOpportunity(Long idOpportunity) {
        this.idOpportunity = idOpportunity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getLastStageUpdateDate() {
        return lastStageUpdateDate;
    }

    public void setLastStageUpdateDate(Date lastStageUpdateDate) {
        this.lastStageUpdateDate = lastStageUpdateDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Long getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(Long successRate) {
        this.successRate = successRate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getInBudget() {
        return inBudget;
    }

    public void setInBudget(Boolean inBudget) {
        this.inBudget = inBudget;
    }

    public Date getRevenueStartPlanned() {
        return revenueStartPlanned;
    }

    public void setRevenueStartPlanned(Date revenueStartPlanned) {
        this.revenueStartPlanned = revenueStartPlanned;
    }

    public Long getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(Long contractDuration) {
        this.contractDuration = contractDuration;
    }

    public Float getTotalOffriniValue() {
        return totalOffriniValue;
    }

    public void setTotalOffriniValue(Float totalOffriniValue) {
        this.totalOffriniValue = totalOffriniValue;
    }

    public Float getFullValue() {
        return fullValue;
    }

    public void setFullValue(Float fullValue) {
        this.fullValue = fullValue;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getrFQDatePlanned() {
        return rFQDatePlanned;
    }

    public void setrFQDatePlanned(Date rFQDatePlanned) {
        this.rFQDatePlanned = rFQDatePlanned;
    }

    public Date getrFQDateAchieved() {
        return rFQDateAchieved;
    }

    public void setrFQDateAchieved(Date rFQDateAchieved) {
        this.rFQDateAchieved = rFQDateAchieved;
    }

    public Date getBidReviewDatePlanned() {
        return bidReviewDatePlanned;
    }

    public void setBidReviewDatePlanned(Date bidReviewDatePlanned) {
        this.bidReviewDatePlanned = bidReviewDatePlanned;
    }

    public Date getBidReviewDateAchieved() {
        return bidReviewDateAchieved;
    }

    public void setBidReviewDateAchieved(Date bidReviewDateAchieved) {
        this.bidReviewDateAchieved = bidReviewDateAchieved;
    }

    public Date getSubmissionDatePlanned() {
        return submissionDatePlanned;
    }

    public void setSubmissionDatePlanned(Date submissionDatePlanned) {
        this.submissionDatePlanned = submissionDatePlanned;
    }

    public Date getSubmissionDateAchieved() {
        return submissionDateAchieved;
    }

    public void setSubmissionDateAchieved(Date submissionDateAchieved) {
        this.submissionDateAchieved = submissionDateAchieved;
    }

    public Date getAwardDatePlanned() {
        return awardDatePlanned;
    }

    public void setAwardDatePlanned(Date awardDatePlanned) {
        this.awardDatePlanned = awardDatePlanned;
    }

    public Date getAwardDateAchieved() {
        return awardDateAchieved;
    }

    public void setAwardDateAchieved(Date awardDateAchieved) {
        this.awardDateAchieved = awardDateAchieved;
    }

    public Date getSignatureDatePlanned() {
        return signatureDatePlanned;
    }

    public void setSignatureDatePlanned(Date signatureDatePlanned) {
        this.signatureDatePlanned = signatureDatePlanned;
    }

    public Date getSignatureDateAchieved() {
        return signatureDateAchieved;
    }

    public void setSignatureDateAchieved(Date signatureDateAchieved) {
        this.signatureDateAchieved = signatureDateAchieved;
    }

    public User getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(User salesManager) {
        this.salesManager = salesManager;
    }
}
