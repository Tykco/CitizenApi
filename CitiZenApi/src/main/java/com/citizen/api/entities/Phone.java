
package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phone {

    private String phoneType;
    private String phoneCountryCode;
    private String phoneNumber;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The phoneType
     */
    public String getPhoneType() {
        return phoneType;
    }

    /**
     * 
     * @param phoneType
     *     The phoneType
     */
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * 
     * @return
     *     The phoneCountryCode
     */
    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    /**
     * 
     * @param phoneCountryCode
     *     The phoneCountryCode
     */
    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    /**
     * 
     * @return
     *     The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber
     *     The phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
