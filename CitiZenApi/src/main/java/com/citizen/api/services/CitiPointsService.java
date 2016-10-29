package com.citizen.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citizen.api.entities.Citipointacc;
import com.citizen.api.entities.CitipointaccRepository;

@Service
public class CitiPointsService{

	
	@Autowired
	CitipointaccRepository citipointaccRepository;
	
	private Citipointacc citipointacc;
	
	public Citipointacc getCitipointacc(int customerId) {

		citipointacc = citipointaccRepository.findByCustomerId(customerId);
		return citipointacc;
	}

}
