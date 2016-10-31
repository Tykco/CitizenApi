
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Email {

    private String emailAddress;
    private Boolean okToEmail;
    private Boolean isPrerferredEmailAddress;

    /**
     * 
     * @return
     *     The emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * @param emailAddress
     *     The emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * 
     * @return
     *     The okToEmail
     */
    public Boolean getOkToEmail() {
        return okToEmail;
    }

    /**
     * 
     * @param okToEmail
     *     The okToEmail
     */
    public void setOkToEmail(Boolean okToEmail) {
        this.okToEmail = okToEmail;
    }

    /**
     * 
     * @return
     *     The isPrerferredEmailAddress
     */
    public Boolean getIsPrerferredEmailAddress() {
        return isPrerferredEmailAddress;
    }

    /**
     * 
     * @param isPrerferredEmailAddress
     *     The isPrerferredEmailAddress
     */
    public void setIsPrerferredEmailAddress(Boolean isPrerferredEmailAddress) {
        this.isPrerferredEmailAddress = isPrerferredEmailAddress;
    }

}
