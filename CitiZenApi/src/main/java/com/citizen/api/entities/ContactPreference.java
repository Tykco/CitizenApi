
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ContactPreference {

    private String preferredMailingAddress;
    private Boolean sendSmsAdviceFag;

    /**
     * 
     * @return
     *     The preferredMailingAddress
     */
    public String getPreferredMailingAddress() {
        return preferredMailingAddress;
    }

    /**
     * 
     * @param preferredMailingAddress
     *     The preferredMailingAddress
     */
    public void setPreferredMailingAddress(String preferredMailingAddress) {
        this.preferredMailingAddress = preferredMailingAddress;
    }

    /**
     * 
     * @return
     *     The sendSmsAdviceFag
     */
    public Boolean getSendSmsAdviceFag() {
        return sendSmsAdviceFag;
    }

    /**
     * 
     * @param sendSmsAdviceFag
     *     The sendSmsAdviceFag
     */
    public void setSendSmsAdviceFag(Boolean sendSmsAdviceFag) {
        this.sendSmsAdviceFag = sendSmsAdviceFag;
    }

}
