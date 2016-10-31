
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Phone {

    private String phoneType;
    private String areaCode;
    private String extension;
    private String phoneNumber;
    private String phoneCountryCode;
    private Boolean okToCall;
    private Boolean okToSms;

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
     *     The areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 
     * @param areaCode
     *     The areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 
     * @return
     *     The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 
     * @param extension
     *     The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
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
