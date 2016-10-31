
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ConsentDetail {

    private Boolean isConsentGiven;
    private String consentType;

    /**
     * 
     * @return
     *     The isConsentGiven
     */
    public Boolean getIsConsentGiven() {
        return isConsentGiven;
    }

    /**
     * 
     * @param isConsentGiven
     *     The isConsentGiven
     */
    public void setIsConsentGiven(Boolean isConsentGiven) {
        this.isConsentGiven = isConsentGiven;
    }

    /**
     * 
     * @return
     *     The consentType
     */
    public String getConsentType() {
        return consentType;
    }

    /**
     * 
     * @param consentType
     *     The consentType
     */
    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }

}
