
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class EmploymentDetail {

    private String selfEmploymentCode;
    private String occupationCode;
    private String jobTitle;
    private String employerName;
    private String industryCode;

    /**
     * 
     * @return
     *     The selfEmploymentCode
     */
    public String getSelfEmploymentCode() {
        return selfEmploymentCode;
    }

    /**
     * 
     * @param selfEmploymentCode
     *     The selfEmploymentCode
     */
    public void setSelfEmploymentCode(String selfEmploymentCode) {
        this.selfEmploymentCode = selfEmploymentCode;
    }

    /**
     * 
     * @return
     *     The occupationCode
     */
    public String getOccupationCode() {
        return occupationCode;
    }

    /**
     * 
     * @param occupationCode
     *     The occupationCode
     */
    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    /**
     * 
     * @return
     *     The jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * 
     * @param jobTitle
     *     The jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * 
     * @return
     *     The employerName
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * 
     * @param employerName
     *     The employerName
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    /**
     * 
     * @return
     *     The industryCode
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * 
     * @param industryCode
     *     The industryCode
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

}
