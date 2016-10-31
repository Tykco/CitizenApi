
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class UnsecuredLoanProduct {

    private String sourceCode;
    private String productCode;
    private String giftCode;
    private String organization;
    private String logo;
    private Boolean requestCreditShield;
    private String billingAddress;
    private String tenure;
    private Double requestedLoanAmount;

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
     *     The giftCode
     */
    public String getGiftCode() {
        return giftCode;
    }

    /**
     * 
     * @param giftCode
     *     The giftCode
     */
    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    /**
     * 
     * @return
     *     The organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * 
     * @param organization
     *     The organization
     */
    public void setOrganization(String organization) {
        this.organization = organization;
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
     *     The requestCreditShield
     */
    public Boolean getRequestCreditShield() {
        return requestCreditShield;
    }

    /**
     * 
     * @param requestCreditShield
     *     The requestCreditShield
     */
    public void setRequestCreditShield(Boolean requestCreditShield) {
        this.requestCreditShield = requestCreditShield;
    }

    /**
     * 
     * @return
     *     The billingAddress
     */
    public String getBillingAddress() {
        return billingAddress;
    }

    /**
     * 
     * @param billingAddress
     *     The billingAddress
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * 
     * @return
     *     The tenure
     */
    public String getTenure() {
        return tenure;
    }

    /**
     * 
     * @param tenure
     *     The tenure
     */
    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    /**
     * 
     * @return
     *     The requestedLoanAmount
     */
    public Double getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    /**
     * 
     * @param requestedLoanAmount
     *     The requestedLoanAmount
     */
    public void setRequestedLoanAmount(Double requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }

}
