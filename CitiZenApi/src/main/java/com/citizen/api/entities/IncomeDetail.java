
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class IncomeDetail {

    private String incomeType;
    private Double variableAmount;
    private String otherIncomeDescription;
    private Double fixedAmount;
    private String frequency;

    /**
     * 
     * @return
     *     The incomeType
     */
    public String getIncomeType() {
        return incomeType;
    }

    /**
     * 
     * @param incomeType
     *     The incomeType
     */
    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * 
     * @return
     *     The variableAmount
     */
    public Double getVariableAmount() {
        return variableAmount;
    }

    /**
     * 
     * @param variableAmount
     *     The variableAmount
     */
    public void setVariableAmount(Double variableAmount) {
        this.variableAmount = variableAmount;
    }

    /**
     * 
     * @return
     *     The otherIncomeDescription
     */
    public String getOtherIncomeDescription() {
        return otherIncomeDescription;
    }

    /**
     * 
     * @param otherIncomeDescription
     *     The otherIncomeDescription
     */
    public void setOtherIncomeDescription(String otherIncomeDescription) {
        this.otherIncomeDescription = otherIncomeDescription;
    }

    /**
     * 
     * @return
     *     The fixedAmount
     */
    public Double getFixedAmount() {
        return fixedAmount;
    }

    /**
     * 
     * @param fixedAmount
     *     The fixedAmount
     */
    public void setFixedAmount(Double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    /**
     * 
     * @return
     *     The frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * 
     * @param frequency
     *     The frequency
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

}
