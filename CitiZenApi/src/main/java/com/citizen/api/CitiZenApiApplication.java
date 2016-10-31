package com.citizen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citizen.api.citiapi.CitiAPI;

@Controller
@SpringBootApplication
public class CitiZenApiApplication {

	@RequestMapping("/")
    public String index() {
        return "index.html";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(CitiZenApiApplication.class, args);
        
     		CitiAPI api = new CitiAPI();
     		
     		//To authorize
     		api.authorize();
     		System.out.println("Token Type: " + api.getTokenType());
     		System.out.println("Access Token: " + api.getAccessToken());
     		
     		//To pay with points
     		//1st enroll credit card(lastFourDigitsCardNumber, citiCardHolderPhoneNumber, merchantCustomerReferenceId)
     		api.enrolCreditCard("7411", "2608191234", "2608191234111");
     		//2nd activate point payment (linkageConfirmationCode)
     		api.activatePointPayment("735937");
     		//3rd retrieve point balance
     		api.retrievePointBalance();
     		System.out.println("Currency Code: " + api.getCurrencyCode());
     		System.out.println("Program Conversion Rate: " + api.getProgramConversionRate());
     		System.out.println("AvailablePointBalance: " + api.getAvailablePointBalance());
     		System.out.println("Maximum Points To Reedem: " + api.getMaximumPointsToReedem());
     		System.out.println("Minimum Points To Reedem: " + api.getMinimumPointsToReedem());
     		//4th pay with points (transactionReferenceNumber, currencyCode, pointsToRedeem, transactionDescription)
     		api.payWithPoints("132323454de6234543", "SGD", 2000, "My Test Transaction");
     		
     		//To onboard
    }
    
}