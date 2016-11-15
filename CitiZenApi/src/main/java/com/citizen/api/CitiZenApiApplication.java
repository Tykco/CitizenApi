package com.citizen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.citizen.api.citiapi.CitiAPI;

@Controller
@SpringBootApplication
public class CitiZenApiApplication {

	@RequestMapping("/")
    public String index() {
        return "index.html";
    }
	
    public static void main(String[] args) {
        SpringApplication.run(CitiZenApiApplication.class, args);
        
//     		CitiAPI api = new CitiAPI();
//     		
////     		//To authorize
//     		//api.getAccessTokenWithCode("AAKSw8UmA3au16FLe8AchO4tT3f5puAekz0IJBA5SWMIhdzZWv17tI4Os_kiG8U0ZAhfqvb0kH0PvfOA0cAbaEeqy_gHIUWi2J2Zf95INa9_4F2JYdrVR28z2moliyA2S6_AtesPj25qi1Lu3tpEy-OqO29DHsqlY8HhYGerc9lTEFS2yBH8ZbdfYlvGnUwzmiSOgtSgArY1UVzrOgfMIOXNjOnI7KCITkoDV3jJfdNKChByYyxfPiMUP6IraNMeZlM");
//     		api.setAccessToken("AAEkYjQyYzE0N2YtMjI1Yi00OTNiLWJlYzAtMjQ4Y2JiMTFmNWMyalNlqf3VrChZZjki-dV338dj5zjhVdcAA2wwgvJOkLAAJCHz0oxRRmd_2XjyueKgWd2WGRmeaRiyyDu9uzgpfzbmmfuDxxzoduotc58OKdVPEFgzDSUaH8m7BURKFGKMsSBoen4T-V5UUd7xwiwi_rICR-WMzwl64bulcjY6Aa5jgitwq3o1AdF1GLpyccyxpEgvTlmTFoJag4cMKJaWxFvvonJrjoWemsN8P2FyQ17_IFl1JkEUjwCReFrGc6XrDd6_u2jRC1kaPm6ctOJoN2XpVcnyvKEcmPqpn_aEpZU4G1hakWlgef526hXQTF_F");
//     		api.setTokeType("Bearer");
////     		api.authorize();
////     		System.out.println("Token Type: " + api.getTokenType());
////     		System.out.println("Access Token: " + api.getAccessToken());
////     		
////     		//To pay with points
////     		//1st enroll credit card(lastFourDigitsCardNumber, citiCardHolderPhoneNumber, merchantCustomerReferenceId)
//     		System.out.println("Enrolling CreditCard....");
//     		//api.sendSMS();
//     		api.enrolCreditCard("6764", "82652930", "2608191234111");
//     		//2nd activate point payment (linkageConfirmationCode)
//     		System.out.println("Activating Point Payment....");
//     		api.activatePointPayment("735937");
//     		//3rd retrieve point balance
//     		System.out.println("Retrieving Balance");
//     		api.retrievePointBalance();
//     		System.out.println("Currency Code: " + api.getCurrencyCode());
//     		System.out.println("Program Conversion Rate: " + api.getProgramConversionRate());
//     		System.out.println("AvailablePointBalance: " + api.getAvailablePointBalance());
//     		System.out.println("Maximum Points To Reedem: " + api.getMaximumPointsToReedem());
//     		System.out.println("Minimum Points To Reedem: " + api.getMinimumPointsToReedem());
//     		//4th pay with points (transactionReferenceNumber, currencyCode, pointsToRedeem, transactionDescription)
//     		System.out.println("Paying with Points....");
//     		api.payWithPoints("132323454de6234543", "SGD", 2000, "My Test Transaction");
//     		
//     		//Cards
//     		System.out.println(api.getAllCards());
    }
    
}