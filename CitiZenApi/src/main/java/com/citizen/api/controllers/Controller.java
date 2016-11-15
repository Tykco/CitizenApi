package com.citizen.api.controllers;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.api.citiapi.CitiAPI;
import com.citizen.api.entities.Citipointacc;
import com.citizen.api.entities.Customer;
import com.citizen.api.services.CitiPointsService;

@RestController
public class Controller {

	@Autowired
	CitiPointsService citiPointsServiceImpl; 
	CitiAPI api = new CitiAPI();


	@RequestMapping(value = "/citipoints", method = RequestMethod.GET)
	public Citipointacc getCitipointaccById (@RequestParam("id") int customerId) {

		Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);

		return citipoints;
	}

	@RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
	public Customer getCustomerName (@RequestParam("token") String code) {

		//Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);

		//CitiAPI api = new CitiAPI();
		if(code == null || code.length() <= 1){
			return null;
		}else{
			if(api.getAccessToken() == null){
				api.getAccessTokenWithCode(code);
			}

			Customer customer = new Customer();
			customer.setName(api.getCustomerName());

			return customer;
		}
	}

	@RequestMapping(value = "/getphone", method = RequestMethod.GET)
	public String getCustomerPhone (@RequestParam("token") String code) {

		//Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);

		//CitiAPI api = new CitiAPI();
		if(code == null || code.length() <= 1){
			return null;
		}else{
			if(api.getAccessToken() == null){
				api.getAccessTokenWithCode(code);
			}

			return api.getCustomerPhoneNumber();
		}
	}

	@RequestMapping(value = "/getcards", method = RequestMethod.GET)
	public ArrayList<String> getCustomerCards (@RequestParam("token") String code) {

		//Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);

		//CitiAPI api = new CitiAPI();
		if(code == null || code.length() <= 1){
			return null;
		}else{
			if(api.getAccessToken() == null){
				api.getAccessTokenWithCode(code);
			}

			return api.getAllCards();
		}
	}

	@RequestMapping(value = "/enrolcard", method = RequestMethod.GET)
	public String enrolCard (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber) {

		return api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");

	}
	
	@RequestMapping(value = "/getbalance", method = RequestMethod.GET)
	public int getCardBalance (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		api.retrievePointBalance();
		return api.getAvailablePointBalance();

	}
	
	@RequestMapping(value = "/getmaxredeem", method = RequestMethod.GET)
	public int getCardMaxRedeem (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		api.retrievePointBalance();
		return api.getMaximumPointsToReedem();
	}
	
	@RequestMapping(value = "/getminredeem", method = RequestMethod.GET)
	public int getCardMinRedeem (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		api.retrievePointBalance();
		return api.getMinimumPointsToReedem();
	}
	
	@RequestMapping(value = "/sendotp", method = RequestMethod.GET)
	public String sendOtp (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		api.sendSMS();
		return "success";
	}
	
	@RequestMapping(value = "/activatepayment", method = RequestMethod.GET)
	public String activatePointPayment (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("otp") String linkageConfirmationCode) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		return api.activatePointPayment(linkageConfirmationCode);
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public String payWithPoint (@RequestParam("cardNumber") String cardNumber, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("amount") int amount) {
		api.enrolCreditCard(cardNumber, phoneNumber, "2608191234111");
		
		return api.payWithPoints("132323454de6234543", "SGD", amount, "Citizen APP");
	}

}
