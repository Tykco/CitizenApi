
package com.citizen.api.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Applicant {

    private Name name;
    private List<Email> email = new ArrayList<Email>();
    private List<Phone> phone = new ArrayList<Phone>();
    private List<ConsentDetail> consentDetails = new ArrayList<ConsentDetail>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    public Name getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The email
     */
    public List<Email> getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(List<Email> email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The phone
     */
    public List<Phone> getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone
     *     The phone
     */
    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return
     *     The consentDetails
     */
    public List<ConsentDetail> getConsentDetails() {
        return consentDetails;
    }

    /**
     * 
     * @param consentDetails
     *     The consentDetails
     */
    public void setConsentDetails(List<ConsentDetail> consentDetails) {
        this.consentDetails = consentDetails;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
