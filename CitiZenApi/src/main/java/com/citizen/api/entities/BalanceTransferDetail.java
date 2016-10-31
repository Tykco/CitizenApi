
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BalanceTransferDetail {

    private Double amountToTransfer;
    private String accountName;
    private String organization;
    private String accountReferenceNumber;
    private String loanDisbursementMethod;
    private String tenure;
    private Integer billerCode;

    /**
     * 
     * @return
     *     The amountToTransfer
     */
    public Double getAmountToTransfer() {
        return amountToTransfer;
    }

    /**
     * 
     * @param amountToTransfer
     *     The amountToTransfer
     */
    public void setAmountToTransfer(Double amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }

    /**
     * 
     * @return
     *     The accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 
     * @param accountName
     *     The accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
     *     The accountReferenceNumber
     */
    public String getAccountReferenceNumber() {
        return accountReferenceNumber;
    }

    /**
     * 
     * @param accountReferenceNumber
     *     The accountReferenceNumber
     */
    public void setAccountReferenceNumber(String accountReferenceNumber) {
        this.accountReferenceNumber = accountReferenceNumber;
    }

    /**
     * 
     * @return
     *     The loanDisbursementMethod
     */
    public String getLoanDisbursementMethod() {
        return loanDisbursementMethod;
    }

    /**
     * 
     * @param loanDisbursementMethod
     *     The loanDisbursementMethod
     */
    public void setLoanDisbursementMethod(String loanDisbursementMethod) {
        this.loanDisbursementMethod = loanDisbursementMethod;
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
     *     The billerCode
     */
    public Integer getBillerCode() {
        return billerCode;
    }

    /**
     * 
     * @param billerCode
     *     The billerCode
     */
    public void setBillerCode(Integer billerCode) {
        this.billerCode = billerCode;
    }

}
