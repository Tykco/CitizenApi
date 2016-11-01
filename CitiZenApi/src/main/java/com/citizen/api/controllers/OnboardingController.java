package com.citizen.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.api.citiapi.CitiAPI;
import com.citizen.api.entities.Applicant;
import com.citizen.api.entities.Catalogue;
import com.citizen.api.entities.ConsentDetail;
import com.citizen.api.entities.CreditCardProduct;
import com.citizen.api.entities.Email;
import com.citizen.api.entities.Name;
import com.citizen.api.entities.Onboarding;
import com.citizen.api.entities.OnboardingRequest;
import com.citizen.api.entities.Phone;
import com.citizen.api.entities.Product;
import com.citizen.api.entities.ProductCat;

@RestController
public class OnboardingController {


	//Test Controller Method
	@RequestMapping(value = "/getonboarding", method = RequestMethod.GET)
	public OnboardingRequest getOnboarding() {

		OnboardingRequest onboardingResponse = new OnboardingRequest();

		String productCode = "VC830";
		String salutation = "MR";
		String givenName = "Leon";
		String surname = "Lim";
		String emailAddress = "citizen.firstprize@citi.com";
		String phoneType = "PRIMARY_MOBILE_NUMBER";
        String phoneCountryCode = "65";
        String phoneNumber = "98778535";
		
		Product product = new Product();
		CreditCardProduct creditCardProduct = new CreditCardProduct();
		creditCardProduct.setProductCode(productCode);
		
		Applicant applicant = new Applicant();
		Name name = new Name();
		name.setSalutation(salutation);
		name.setGivenName(givenName);
		name.setSurname(surname);
		
		List<Email> email = new ArrayList<Email>();
		Email emailObj = new Email();
		emailObj.setEmailAddress(emailAddress);
		email.add(emailObj);
		
		List<Phone> phone = new ArrayList<Phone>();
		Phone phoneObj = new Phone();
		phoneObj.setPhoneType(phoneType);
		phoneObj.setPhoneCountryCode(phoneCountryCode);
		phoneObj.setPhoneNumber(phoneNumber);
		phone.add(phoneObj);
		
		List<ConsentDetail> consentDetails = new ArrayList<ConsentDetail>();
		ConsentDetail consentDetailObj1 = new ConsentDetail();
		consentDetailObj1.setConsentType("PDP_CONSENT");
		consentDetailObj1.setIsConsentGiven(true);
		ConsentDetail consentDetailObj2 = new ConsentDetail();
		consentDetailObj2.setConsentType("PARTNER_CONSENT");
		consentDetailObj2.setIsConsentGiven(true);
		consentDetails.add(consentDetailObj1);
		consentDetails.add(consentDetailObj2);
		
		applicant.setPhone(phone);
		applicant.setName(name);
		applicant.setConsentDetails(consentDetails);
		applicant.setEmail(email);
		
		onboardingResponse.setApplicant(applicant);
		onboardingResponse.setProduct(product);
		
		return onboardingResponse;
	}

	@RequestMapping(value = "/getprodcat", method = RequestMethod.GET)
	public Catalogue getProductCatalogue() {
		//public String getProductCatalogue() {

		//Perform authentication for Access Token.
		CitiAPI api = new CitiAPI();
		api.authorize();

		//String listProdCat;

		Catalogue catalogue = new Catalogue();
		Catalogue catalogueResult = new Catalogue();

		List<ProductCat> prodCatList = new ArrayList<ProductCat>();

		catalogue = api.getProductCatalogue();

		for (int i=0; i<catalogue.getProducts().size(); i++) {
			if ((catalogue.getProducts().get(i).getProductCode().equals("VC030") ||
					catalogue.getProducts().get(i).getProductCode().equals("VC050") ||
					catalogue.getProducts().get(i).getProductCode().equals("VC830") ||
					catalogue.getProducts().get(i).getProductCode().equals("MC440")) && 
					(catalogue.getProducts().get(i).getSourceCode().equals("WW5ARCE1") ||
							catalogue.getProducts().get(i).getSourceCode().equals("WW5ARCE2"))){
				if (!prodCatList.contains(catalogue.getProducts().get(i))) {
					prodCatList.add(catalogue.getProducts().get(i));
				}
			}
		}
		catalogueResult.setProducts(prodCatList);
		return catalogueResult;
	}
	
	@RequestMapping(value = "/onboardcard", method = RequestMethod.POST)
	public Onboarding onboardCreditCard(@RequestBody @Valid ProductCat productObject) {
		
		String productCode = "VC830";
		String salutation = "MR";
		String givenName = "Leon";
		String surname = "Lim";
		String emailAddress = "citizen.firstprize@citi.com";
		String phoneType = "PRIMARY_MOBILE_NUMBER";
        String phoneCountryCode = "65";
        String phoneNumber = "98778535";
		
		Onboarding onboardingRequest = new Onboarding();
		
		Product product = new Product();
		CreditCardProduct creditCardProduct = new CreditCardProduct();
		creditCardProduct.setProductCode(productCode);
		
		Applicant applicant = new Applicant();
		Name name = new Name();
		name.setSalutation(salutation);
		name.setGivenName(givenName);
		name.setSurname(surname);
		
		List<Email> email = new ArrayList<Email>();
		Email emailObj = new Email();
		emailObj.setEmailAddress(emailAddress);
		email.add(emailObj);
		
		List<Phone> phone = new ArrayList<Phone>();
		Phone phoneObj = new Phone();
		phoneObj.setPhoneType(phoneType);
		phoneObj.setPhoneCountryCode(phoneCountryCode);
		phoneObj.setPhoneNumber(phoneNumber);
		phone.add(phoneObj);
		
		List<ConsentDetail> consentDetails = new ArrayList<ConsentDetail>();
		ConsentDetail consentDetailObj1 = new ConsentDetail();
		consentDetailObj1.setConsentType("PDP_CONSENT");
		consentDetailObj1.setIsConsentGiven(true);
		ConsentDetail consentDetailObj2 = new ConsentDetail();
		consentDetailObj2.setConsentType("PARTNER_CONSENT");
		consentDetailObj2.setIsConsentGiven(true);
		consentDetails.add(consentDetailObj1);
		consentDetails.add(consentDetailObj2);
		
		applicant.setPhone(phone);
		applicant.setName(name);
		applicant.setConsentDetails(consentDetails);
		applicant.setEmail(email);
		
		onboardingRequest.setApplicant(applicant);
		onboardingRequest.setProduct(product);
		
		return onboardingRequest;
	}
}
