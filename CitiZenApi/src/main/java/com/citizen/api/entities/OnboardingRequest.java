
package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class OnboardingRequest {

    private Product product;
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
