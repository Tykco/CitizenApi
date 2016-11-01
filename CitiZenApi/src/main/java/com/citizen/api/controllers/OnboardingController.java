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
import com.citizen.api.entities.OnboardingRequest;
import com.citizen.api.entities.Phone;
import com.citizen.api.entities.Product;
import com.citizen.api.entities.ProductCat;
import com.citizen.api.entities.ScreeningRequest;
import com.citizen.api.entities.SuccessfulOnboard;
import com.citizen.api.entities.SuccessfulScreening;

@RestController
public class OnboardingController {


	//Test Controller Method
	@RequestMapping(value = "/getonboarding", method = RequestMethod.GET)
	public OnboardingRequest getOnboarding() {

		String productCode = "VC830";
		String sourceCode = "WW5ARCE1";
		String organization = "888";
		String logo = "830";
		String salutation = "MR";
		String givenName = "Leon";
		String surname = "Lim";
		String emailAddress = "citizen.firstprize@citi.com";
		String phoneType = "PRIMARY_MOBILE_NUMBER";
		String phoneCountryCode = "65";
		String phoneNumber = "98778535";

		OnboardingRequest onboardingResponse = new OnboardingRequest();
		
		Product product = new Product();
		CreditCardProduct creditCardProduct = new CreditCardProduct();
		creditCardProduct.setProductCode(productCode);
		creditCardProduct.setLogo(logo);
		creditCardProduct.setOrganization(organization);
		creditCardProduct.setSourceCode(sourceCode);
		product.setCreditCardProduct(creditCardProduct);

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
		consentDetailObj1.setIsConsentGiven("true");
		ConsentDetail consentDetailObj2 = new ConsentDetail();
		consentDetailObj2.setConsentType("PARTNER_CONSENT");
		consentDetailObj2.setIsConsentGiven("true");
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
	public SuccessfulScreening onboardCreditCard(@RequestBody @Valid ProductCat productObject) {

		String productCode = productObject.getProductCode();
		String sourceCode = productObject.getSourceCode();
		String organization = productObject.getOrganisation();
		String logo = productObject.getLogo();
		String salutation = "MR";
		String givenName = "Leon";
		String surname = "Lim";
		String emailAddress = "citizen.firstprize@citi.com";
		String phoneType = "PRIMARY_MOBILE_NUMBER";
		String phoneCountryCode = "65";
		String phoneNumber = "98778535";

		OnboardingRequest onboardingRequest = new OnboardingRequest();
		SuccessfulOnboard successfulOnboardResponse = new SuccessfulOnboard();
		
		ScreeningRequest screeningRequest = new ScreeningRequest(); 
		SuccessfulScreening successfulScreening = new SuccessfulScreening(); 
		
		
		Product product = new Product();
		CreditCardProduct creditCardProduct = new CreditCardProduct();
		creditCardProduct.setProductCode(productCode);
		creditCardProduct.setLogo(logo);
		creditCardProduct.setOrganization(organization);
		creditCardProduct.setSourceCode(sourceCode);
		product.setCreditCardProduct(creditCardProduct);

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
		consentDetailObj1.setIsConsentGiven("true");
		ConsentDetail consentDetailObj2 = new ConsentDetail();
		consentDetailObj2.setConsentType("PARTNER_CONSENT");
		consentDetailObj2.setIsConsentGiven("true");
		consentDetails.add(consentDetailObj1);
		consentDetails.add(consentDetailObj2);

		applicant.setPhone(phone);
		applicant.setName(name);
		applicant.setConsentDetails(consentDetails);
		applicant.setEmail(email);

		onboardingRequest.setApplicant(applicant);
		onboardingRequest.setProduct(product);

		//Authenticate session
		CitiAPI api = new CitiAPI();
		api.authorize();
		
		//Perform onboarding application
		successfulOnboardResponse = api.postOnboarding(onboardingRequest);
		
		screeningRequest.setControlFlowId(successfulOnboardResponse.getControlFlowId());
		
		
		//Perform screening after unsecured onboarding application..
		successfulScreening = api.postScreening(screeningRequest, successfulOnboardResponse.getApplicationId());
		
		return successfulScreening;
	}
}
