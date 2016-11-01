package com.citizen.api.controllers;

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

	@RequestMapping(value = "/citipoints", method = RequestMethod.GET)
	public Citipointacc getCitipointaccById (@RequestParam("id") int customerId) {
		
		Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);
		
		return citipoints;
	}
	
	@RequestMapping(value = "/getcustomer", method = RequestMethod.GET)
	public Customer getCustomerName (@RequestParam("token") String accessToken) {
		
		//Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);
		
		CitiAPI api = new CitiAPI();
		api.getAccessTokenWithCode(accessToken);
		
		Customer customer = new Customer();
		customer.setName(api.getCustomerName());
		
		return customer;
	}
	
}
