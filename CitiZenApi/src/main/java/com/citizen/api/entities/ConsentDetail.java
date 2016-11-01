
package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ConsentDetail {

    private String consentType;
    private String isConsentGiven;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * 
     * @return
     *     The isConsentGiven
     */
    public String getIsConsentGiven() {
        return isConsentGiven;
    }

    /**
     * 
     * @param isConsentGiven
     *     The isConsentGiven
     */
    public void setIsConsentGiven(String isConsentGiven) {
        this.isConsentGiven = isConsentGiven;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
