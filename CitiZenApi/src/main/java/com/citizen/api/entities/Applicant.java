
package com.citizen.api.entities;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Applicant {

    private List<Address> address = new ArrayList<Address>();
    private FinancialInformation financialInformation;
    private Education education;
    private KycInformation kycInformation;
    private ContactPreference contactPreference;
    private String motherMaidenName;
    private List<EmploymentDetail> employmentDetails = new ArrayList<EmploymentDetail>();
    private List<BalanceTransferDetail> balanceTransferDetails = new ArrayList<BalanceTransferDetail>();
    private List<ConsentDetail> consentDetails = new ArrayList<ConsentDetail>();
    private SelfDeclaration selfDeclaration;
    private List<IdentificationDocumentDetail> identificationDocumentDetails = new ArrayList<IdentificationDocumentDetail>();
    private List<Phone> phone = new ArrayList<Phone>();
    private ContactConsent contactConsent;
    private Name name;
    private AdditionalData additionalData;
    private List<Email> email = new ArrayList<Email>();
    private Ocr ocr;
    private Demographics demographics;

    /**
     * 
     * @return
     *     The address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The financialInformation
     */
    public FinancialInformation getFinancialInformation() {
        return financialInformation;
    }

    /**
     * 
     * @param financialInformation
     *     The financialInformation
     */
    public void setFinancialInformation(FinancialInformation financialInformation) {
        this.financialInformation = financialInformation;
    }

    /**
     * 
     * @return
     *     The education
     */
    public Education getEducation() {
        return education;
    }

    /**
     * 
     * @param education
     *     The education
     */
    public void setEducation(Education education) {
        this.education = education;
    }

    /**
     * 
     * @return
     *     The kycInformation
     */
    public KycInformation getKycInformation() {
        return kycInformation;
    }

    /**
     * 
     * @param kycInformation
     *     The kycInformation
     */
    public void setKycInformation(KycInformation kycInformation) {
        this.kycInformation = kycInformation;
    }

    /**
     * 
     * @return
     *     The contactPreference
     */
    public ContactPreference getContactPreference() {
        return contactPreference;
    }

    /**
     * 
     * @param contactPreference
     *     The contactPreference
     */
    public void setContactPreference(ContactPreference contactPreference) {
        this.contactPreference = contactPreference;
    }

    /**
     * 
     * @return
     *     The motherMaidenName
     */
    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    /**
     * 
     * @param motherMaidenName
     *     The motherMaidenName
     */
    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    /**
     * 
     * @return
     *     The employmentDetails
     */
    public List<EmploymentDetail> getEmploymentDetails() {
        return employmentDetails;
    }

    /**
     * 
     * @param employmentDetails
     *     The employmentDetails
     */
    public void setEmploymentDetails(List<EmploymentDetail> employmentDetails) {
        this.employmentDetails = employmentDetails;
    }

    /**
     * 
     * @return
     *     The balanceTransferDetails
     */
    public List<BalanceTransferDetail> getBalanceTransferDetails() {
        return balanceTransferDetails;
    }

    /**
     * 
     * @param balanceTransferDetails
     *     The balanceTransferDetails
     */
    public void setBalanceTransferDetails(List<BalanceTransferDetail> balanceTransferDetails) {
        this.balanceTransferDetails = balanceTransferDetails;
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

    /**
     * 
     * @return
     *     The selfDeclaration
     */
    public SelfDeclaration getSelfDeclaration() {
        return selfDeclaration;
    }

    /**
     * 
     * @param selfDeclaration
     *     The selfDeclaration
     */
    public void setSelfDeclaration(SelfDeclaration selfDeclaration) {
        this.selfDeclaration = selfDeclaration;
    }

    /**
     * 
     * @return
     *     The identificationDocumentDetails
     */
    public List<IdentificationDocumentDetail> getIdentificationDocumentDetails() {
        return identificationDocumentDetails;
    }

    /**
     * 
     * @param identificationDocumentDetails
     *     The identificationDocumentDetails
     */
    public void setIdentificationDocumentDetails(List<IdentificationDocumentDetail> identificationDocumentDetails) {
        this.identificationDocumentDetails = identificationDocumentDetails;
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
     *     The contactConsent
     */
    public ContactConsent getContactConsent() {
        return contactConsent;
    }

    /**
     * 
     * @param contactConsent
     *     The contactConsent
     */
    public void setContactConsent(ContactConsent contactConsent) {
        this.contactConsent = contactConsent;
    }

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
     *     The additionalData
     */
    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    /**
     * 
     * @param additionalData
     *     The additionalData
     */
    public void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
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
     *     The ocr
     */
    public Ocr getOcr() {
        return ocr;
    }

    /**
     * 
     * @param ocr
     *     The ocr
     */
    public void setOcr(Ocr ocr) {
        this.ocr = ocr;
    }

    /**
     * 
     * @return
     *     The demographics
     */
    public Demographics getDemographics() {
        return demographics;
    }

    /**
     * 
     * @param demographics
     *     The demographics
     */
    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

}
