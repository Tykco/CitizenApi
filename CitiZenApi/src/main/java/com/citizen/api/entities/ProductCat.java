package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ProductCat {

    private String productCode;
    private String productDescription;
    private String sourceCode;
    private String logo;
    private String organisation;
    private String productType;
    private Integer minimumCreditLimitAmount;
    private Integer maximumCreditLimitAmount;
    private Integer annualFeeAmount;
    private String currencyCode;
    private Double interestRate;
    private Integer latePaymentFee;
    private String importantInformations;
    private String termsAndConditions;
    private String agreementStartDate;
    private String agreementExpiryDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 
     * @param productCode
     *     The productCode
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 
     * @return
     *     The productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * 
     * @param productDescription
     *     The productDescription
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * 
     * @return
     *     The sourceCode
     */
    public String getSourceCode() {
        return sourceCode;
    }

    /**
     * 
     * @param sourceCode
     *     The sourceCode
     */
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    /**
     * 
     * @return
     *     The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 
     * @return
     *     The organisation
     */
    public String getOrganisation() {
        return organisation;
    }

    /**
     * 
     * @param organisation
     *     The organisation
     */
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    /**
     * 
     * @return
     *     The productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType
     *     The productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return
     *     The minimumCreditLimitAmount
     */
    public Integer getMinimumCreditLimitAmount() {
        return minimumCreditLimitAmount;
    }

    /**
     * 
     * @param minimumCreditLimitAmount
     *     The minimumCreditLimitAmount
     */
    public void setMinimumCreditLimitAmount(Integer minimumCreditLimitAmount) {
        this.minimumCreditLimitAmount = minimumCreditLimitAmount;
    }

    /**
     * 
     * @return
     *     The maximumCreditLimitAmount
     */
    public Integer getMaximumCreditLimitAmount() {
        return maximumCreditLimitAmount;
    }

    /**
     * 
     * @param maximumCreditLimitAmount
     *     The maximumCreditLimitAmount
     */
    public void setMaximumCreditLimitAmount(Integer maximumCreditLimitAmount) {
        this.maximumCreditLimitAmount = maximumCreditLimitAmount;
    }

    /**
     * 
     * @return
     *     The annualFeeAmount
     */
    public Integer getAnnualFeeAmount() {
        return annualFeeAmount;
    }

    /**
     * 
     * @param annualFeeAmount
     *     The annualFeeAmount
     */
    public void setAnnualFeeAmount(Integer annualFeeAmount) {
        this.annualFeeAmount = annualFeeAmount;
    }

    /**
     * 
     * @return
     *     The currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 
     * @param currencyCode
     *     The currencyCode
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 
     * @return
     *     The interestRate
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * 
     * @param interestRate
     *     The interestRate
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * 
     * @return
     *     The latePaymentFee
     */
    public Integer getLatePaymentFee() {
        return latePaymentFee;
    }

    /**
     * 
     * @param latePaymentFee
     *     The latePaymentFee
     */
    public void setLatePaymentFee(Integer latePaymentFee) {
        this.latePaymentFee = latePaymentFee;
    }

    /**
     * 
     * @return
     *     The importantInformations
     */
    public String getImportantInformations() {
        return importantInformations;
    }

    /**
     * 
     * @param importantInformations
     *     The importantInformations
     */
    public void setImportantInformations(String importantInformations) {
        this.importantInformations = importantInformations;
    }

    /**
     * 
     * @return
     *     The termsAndConditions
     */
    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    /**
     * 
     * @param termsAndConditions
     *     The termsAndConditions
     */
    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    /**
     * 
     * @return
     *     The agreementStartDate
     */
    public String getAgreementStartDate() {
        return agreementStartDate;
    }

    /**
     * 
     * @param agreementStartDate
     *     The agreementStartDate
     */
    public void setAgreementStartDate(String agreementStartDate) {
        this.agreementStartDate = agreementStartDate;
    }

    /**
     * 
     * @return
     *     The agreementExpiryDate
     */
    public String getAgreementExpiryDate() {
        return agreementExpiryDate;
    }

    /**
     * 
     * @param agreementExpiryDate
     *     The agreementExpiryDate
     */
    public void setAgreementExpiryDate(String agreementExpiryDate) {
        this.agreementExpiryDate = agreementExpiryDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
