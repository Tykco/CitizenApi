
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CountrySpecificGroup {

    private String unionPayCardNumber;
    private Boolean disabilityIndicator;
    private String taxFileNumber;
    private Boolean bumiputraIndicator;
    private String ethnicGroup;

    /**
     * 
     * @return
     *     The unionPayCardNumber
     */
    public String getUnionPayCardNumber() {
        return unionPayCardNumber;
    }

    /**
     * 
     * @param unionPayCardNumber
     *     The unionPayCardNumber
     */
    public void setUnionPayCardNumber(String unionPayCardNumber) {
        this.unionPayCardNumber = unionPayCardNumber;
    }

    /**
     * 
     * @return
     *     The disabilityIndicator
     */
    public Boolean getDisabilityIndicator() {
        return disabilityIndicator;
    }

    /**
     * 
     * @param disabilityIndicator
     *     The disabilityIndicator
     */
    public void setDisabilityIndicator(Boolean disabilityIndicator) {
        this.disabilityIndicator = disabilityIndicator;
    }

    /**
     * 
     * @return
     *     The taxFileNumber
     */
    public String getTaxFileNumber() {
        return taxFileNumber;
    }

    /**
     * 
     * @param taxFileNumber
     *     The taxFileNumber
     */
    public void setTaxFileNumber(String taxFileNumber) {
        this.taxFileNumber = taxFileNumber;
    }

    /**
     * 
     * @return
     *     The bumiputraIndicator
     */
    public Boolean getBumiputraIndicator() {
        return bumiputraIndicator;
    }

    /**
     * 
     * @param bumiputraIndicator
     *     The bumiputraIndicator
     */
    public void setBumiputraIndicator(Boolean bumiputraIndicator) {
        this.bumiputraIndicator = bumiputraIndicator;
    }

    /**
     * 
     * @return
     *     The ethnicGroup
     */
    public String getEthnicGroup() {
        return ethnicGroup;
    }

    /**
     * 
     * @param ethnicGroup
     *     The ethnicGroup
     */
    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

}
