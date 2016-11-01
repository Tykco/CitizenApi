package com.citizen.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.api.citiapi.CitiAPI;
import com.citizen.api.entities.Catalogue;
import com.citizen.api.entities.CreditCardProduct;
import com.citizen.api.entities.Onboarding;
import com.citizen.api.entities.Product;
import com.citizen.api.entities.ProductCat;

@RestController
public class OnboardingController {


	//Test Controller Method
	@RequestMapping(value = "/getonboarding", method = RequestMethod.GET)
	public Onboarding getOnboarding() {

		Onboarding onboardingResponse = new Onboarding();

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
	public String onboardCreditCard(@RequestBody @Valid ProductCat product) {
		
		String productCode = "VC830";
		String salutation = "MR";
		String givenName = "Leon";
		String surname = "Lim";
		String emailAddress = "citizen.firstprize@citi.com";
		String phoneType = "PRIMARY_MOBILE_NUMBER";
        String phoneCountryCode = "65";
        String phoneNumber = "98778535";
		
		Onboarding onboardingRequest = new Onboarding();
		
		//onboardingRequest.setProduct(new Product().setCreditCardProduct(new CreditCardProduct().setProductCode(productCode)));
		return "ok";
	}
}
