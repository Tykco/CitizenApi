
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ContactConsent {

    private Boolean okToCall;
    private Boolean okToMail;
    private Boolean okToSms;

    /**
     * 
     * @return
     *     The okToCall
     */
    public Boolean getOkToCall() {
        return okToCall;
    }

    /**
     * 
     * @param okToCall
     *     The okToCall
     */
    public void setOkToCall(Boolean okToCall) {
        this.okToCall = okToCall;
    }

    /**
     * 
     * @return
     *     The okToMail
     */
    public Boolean getOkToMail() {
        return okToMail;
    }

    /**
     * 
     * @param okToMail
     *     The okToMail
     */
    public void setOkToMail(Boolean okToMail) {
        this.okToMail = okToMail;
    }

    /**
     * 
     * @return
     *     The okToSms
     */
    public Boolean getOkToSms() {
        return okToSms;
    }

    /**
     * 
     * @param okToSms
     *     The okToSms
     */
    public void setOkToSms(Boolean okToSms) {
        this.okToSms = okToSms;
    }

}
