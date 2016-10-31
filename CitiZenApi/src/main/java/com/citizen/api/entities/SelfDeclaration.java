
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SelfDeclaration {

    private String anticipatedIncomeDecreaseCode;
    private Boolean loanTakenIndicator;

    /**
     * 
     * @return
     *     The anticipatedIncomeDecreaseCode
     */
    public String getAnticipatedIncomeDecreaseCode() {
        return anticipatedIncomeDecreaseCode;
    }

    /**
     * 
     * @param anticipatedIncomeDecreaseCode
     *     The anticipatedIncomeDecreaseCode
     */
    public void setAnticipatedIncomeDecreaseCode(String anticipatedIncomeDecreaseCode) {
        this.anticipatedIncomeDecreaseCode = anticipatedIncomeDecreaseCode;
    }

    /**
     * 
     * @return
     *     The loanTakenIndicator
     */
    public Boolean getLoanTakenIndicator() {
        return loanTakenIndicator;
    }

    /**
     * 
     * @param loanTakenIndicator
     *     The loanTakenIndicator
     */
    public void setLoanTakenIndicator(Boolean loanTakenIndicator) {
        this.loanTakenIndicator = loanTakenIndicator;
    }

}
