package com.citizen.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.api.citiapi.CitiAPI;
import com.citizen.api.entities.Citipointacc;
import com.citizen.api.services.CitiPointsService;

@RestController
public class PointsController {
	
	@Autowired
	CitiPointsService citiPointsServiceImpl; 

	@RequestMapping(value = "/Citipoints", method = RequestMethod.GET)
	public Citipointacc CitipointaccById (@RequestParam("id") int customerId) {
		
		Citipointacc citipoints = citiPointsServiceImpl.getCitipointacc(customerId);
		
		return citipoints;
	}
	
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String getOAuth() {
		
		CitiAPI api = new CitiAPI();
		
		return api.oAuthorize();
	}
}
