
package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Onboarding {

    private Product product;
    private AuditDetails auditDetails;
    private Applicant applicant;

    /**
     * 
     * @return
     *     The product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 
     * @param product
     *     The product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 
     * @return
     *     The auditDetails
     */
    public AuditDetails getAuditDetails() {
        return auditDetails;
    }

    /**
     * 
     * @param auditDetails
     *     The auditDetails
     */
    public void setAuditDetails(AuditDetails auditDetails) {
        this.auditDetails = auditDetails;
    }

    /**
     * 
     * @return
     *     The applicant
     */
    public Applicant getApplicant() {
        return applicant;
    }

    /**
     * 
     * @param applicant
     *     The applicant
     */
    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

}
