
package com.citizen.api.entities;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class FinancialInformation {

    private List<IncomeDetail> incomeDetails = new ArrayList<IncomeDetail>();

    /**
     * 
     * @return
     *     The incomeDetails
     */
    public List<IncomeDetail> getIncomeDetails() {
        return incomeDetails;
    }

    /**
     * 
     * @param incomeDetails
     *     The incomeDetails
     */
    public void setIncomeDetails(List<IncomeDetail> incomeDetails) {
        this.incomeDetails = incomeDetails;
    }

}
