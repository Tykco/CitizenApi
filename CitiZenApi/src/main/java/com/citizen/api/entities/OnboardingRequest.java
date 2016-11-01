package com.citizen.api.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class OnboardingRequest {

private AuditDetails auditDetails;
private Product product;
private Applicant applicant;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The auditDetails
*/
public AuditDetails getAuditDetails() {
return auditDetails;
}

/**
* 
* @param auditDetails
* The auditDetails
*/
public void setAuditDetails(AuditDetails auditDetails) {
this.auditDetails = auditDetails;
}

/**
* 
* @return
* The product
*/
public Product getProduct() {
return product;
}

/**
* 
* @param product
* The product
*/
public void setProduct(Product product) {
this.product = product;
}

/**
* 
* @return
* The applicant
*/
public Applicant getApplicant() {
return applicant;
}

/**
* 
* @param applicant
* The applicant
*/
public void setApplicant(Applicant applicant) {
this.applicant = applicant;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}