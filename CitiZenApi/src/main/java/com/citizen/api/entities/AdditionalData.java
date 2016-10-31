
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AdditionalData {

    private Double numberOfChildren;
    private Double numberOfDependents;
    private Boolean staffIndicator;
    private CountrySpecificGroup countrySpecificGroup;

    /**
     * 
     * @return
     *     The numberOfChildren
     */
    public Double getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * 
     * @param numberOfChildren
     *     The numberOfChildren
     */
    public void setNumberOfChildren(Double numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    /**
     * 
     * @return
     *     The numberOfDependents
     */
    public Double getNumberOfDependents() {
        return numberOfDependents;
    }

    /**
     * 
     * @param numberOfDependents
     *     The numberOfDependents
     */
    public void setNumberOfDependents(Double numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    /**
     * 
     * @return
     *     The staffIndicator
     */
    public Boolean getStaffIndicator() {
        return staffIndicator;
    }

    /**
     * 
     * @param staffIndicator
     *     The staffIndicator
     */
    public void setStaffIndicator(Boolean staffIndicator) {
        this.staffIndicator = staffIndicator;
    }

    /**
     * 
     * @return
     *     The countrySpecificGroup
     */
    public CountrySpecificGroup getCountrySpecificGroup() {
        return countrySpecificGroup;
    }

    /**
     * 
     * @param countrySpecificGroup
     *     The countrySpecificGroup
     */
    public void setCountrySpecificGroup(CountrySpecificGroup countrySpecificGroup) {
        this.countrySpecificGroup = countrySpecificGroup;
    }

}
