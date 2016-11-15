package com.citizen.api.citiapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.citizen.api.entities.Catalogue;
import com.citizen.api.entities.OnboardingRequest;
import com.citizen.api.entities.ScreeningRequest;
import com.citizen.api.entities.SuccessfulOnboard;
import com.citizen.api.entities.SuccessfulScreening;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class CitiAPI {

	private String tokenType = null;
	private String accessToken = null;
	private String rewardLinkCode = null;
	private String customerName = null;
	private String customerPhoneNumber = null;
	private ArrayList<String> creditCards = new ArrayList<String>();
	private int availablePointBalance = 0;
	private double programConversionRate = 0;
	private String currencyCode = null;
	private int maximumPointsToReedem = 0;
	private int minimumPointsToReedem = 0;

	private final String appAuthorization = "Basic YjQyYzE0N2YtMjI1Yi00OTNiLWJlYzAtMjQ4Y2JiMTFmNWMyOk40Zkc4ckQ2b0o4aEIxZUYyblcxcUwybEI0bVUzcFY2eFMxdlYwcUo3eU01ZEswd0o1";
	private final String appClientId = "b42c147f-225b-493b-bec0-248cbb11f5c2";
	private final String appUrl = "https://citizen-app.herokuapp.com/";
	private final String ACCOUNT_SID = "AC122515232e6cf4a9be88b24bced04d0b";
	private final String AUTH_TOKEN = "0e98ad96c64f84040324b8da972a154f";

	public CitiAPI(){}

	public String getAccessToken() {
		return this.accessToken;
	}

	public String getTokenType(){
		return this.tokenType;
	}

	public int getAvailablePointBalance() {
		return availablePointBalance;
	}

	public Double getProgramConversionRate() {
		return programConversionRate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public int getMaximumPointsToReedem() {
		return maximumPointsToReedem;
	}

	public int getMinimumPointsToReedem() {
		return minimumPointsToReedem;
	}

	public void setAccessToken(String accessToken){
		this.accessToken = accessToken;
	}

	public void setTokeType(String tokenType){
		this.tokenType = tokenType;
	}

	public String authorize() {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;

		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/clientCredentials/oauth2/token/sg/gcb");
			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", appAuthorization);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");

			// Request parameters and other properties.
			List<NameValuePair> params = new ArrayList<NameValuePair>(2);
			params.add(new BasicNameValuePair("grant_type", "client_credentials"));
			params.add(new BasicNameValuePair("scope", "/api"));
			request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			JSONObject resultObject = new JSONObject(result);
			System.out.println(resultObject);
			this.tokenType = resultObject.getString("token_type");
			this.tokenType = this.tokenType.substring(0, 1).toUpperCase() + this.tokenType.substring(1); 
			this.accessToken = resultObject.getString("access_token");

			System.out.println(result);


			response.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public String revokeToken(){     
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		try {

			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/revoke");
			request.addHeader("Authorization", appAuthorization);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");
			List < NameValuePair > params = new ArrayList < NameValuePair >();
			params.add(new BasicNameValuePair("token", this.accessToken));
			params.add(new BasicNameValuePair("token_type_hint", "access_token"));
			try {

				((HttpPost) request).setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			} catch (Exception e) {

				e.printStackTrace();

			}
			System.out.println("Executing request " + request.getRequestLine());
			response = httpClient.execute(request);
			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);

			response.close();
			this.accessToken = null;
			this.tokenType = null;
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	public String enrolCreditCard(String lastFourDigitsCardNumber, String citiCardHolderPhoneNumber, String merchantCustomerReferenceId) {      
		if(this.accessToken == null){
			this.authorize();
		}

		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/v1/apac/rewards/linkage");

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("Content-Type", "application/json");
			request.addHeader("client_id", appClientId);

			Map<String, String> params = new HashMap<String, String>();
			params.put("lastFourDigitsCardNumber", lastFourDigitsCardNumber);
			params.put("citiCardHolderPhoneNumber", citiCardHolderPhoneNumber);
			params.put("merchantCustomerReferenceId", merchantCustomerReferenceId);

			StringEntity requestBody =new StringEntity(generateRequestBody(params));

			try {
				((HttpPost) request).setEntity(requestBody);
			} catch (Exception e) {
				e.printStackTrace(); 
			}



			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			JSONObject resultObject = new JSONObject(result);
			this.rewardLinkCode = resultObject.getString("rewardLinkCode");
			System.out.println(this.rewardLinkCode);
			response.close();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		} 
	}

	public void sendSMS() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    
		try {

			Message message = Message.creator(
				    new PhoneNumber("+6582652930"),  // To number
				    new PhoneNumber("+19143686935"),  // From number
				    "To proceed with Citi Point payment, please enter this 6-digit code into your browser: 735937"                    // SMS body
				).create();
            System.out.println(message.getSid());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String activatePointPayment(String linkageConfirmationCode) {      
		if(rewardLinkCode == null){
			System.out.println("ERROR: "+ "Card Not Enrolled");
			return "Card Not Enrolled";
		}

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPut request = new HttpPut("https://sandbox.apihub.citi.com/gcb/api/v1/apac/rewards/" + rewardLinkCode + "/activations"); 

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);
			request.addHeader("Content-Type", "application/json");
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);

			Map<String, String> params = new HashMap<String, String>();
			params.put("linkageConfirmationCode", linkageConfirmationCode);

			StringEntity requestBody =new StringEntity(generateRequestBody(params));

			try {
				((HttpPut) request).setEntity(requestBody);
			} catch (Exception e) {
				e.printStackTrace(); 
			}

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);

			response.close();
			if(result == null || result.length() <= 1){
				result = "success";
			}else{
				result = "failure";
			}
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	public String retrievePointBalance() {
		if(rewardLinkCode == null){
			System.out.println("ERROR: "+ "Card Not Enrolled");
			return "Card Not Enrolled";
		}

		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpGet request = new HttpGet("https://sandbox.apihub.citi.com/gcb/api/v1/apac/rewards/" + rewardLinkCode + "/pointBalance"); 

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			JSONObject resultObject = new JSONObject(result);
			System.out.println(resultObject);
			this.availablePointBalance = resultObject.getInt("availablePointBalance");
			this.currencyCode = resultObject.getString("currencyCode");
			this.programConversionRate = resultObject.getDouble("programConversionRate");
			this.maximumPointsToReedem = resultObject.getInt("maximumPointsToRedeem");
			this.minimumPointsToReedem = resultObject.getInt("minimumPointsToRedeem");

			response.close();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	public String payWithPoints(String transactionReferenceNumber, String currencyCode, int pointsToRedeem, String transactionDescription) {      
		if(rewardLinkCode == null){
			System.out.println("ERROR: "+ "Card Not Enrolled");
			return "Card Not Enrolled";
		}

		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/v1/apac/rewards/" + rewardLinkCode + "/redemption");

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("Content-Type", "application/json");
			request.addHeader("client_id", appClientId);

			Map<String, String> innerParams = new HashMap<String, String>();
			Map<String, String> params = new HashMap<String, String>();
			innerParams.put("currencyCode", currencyCode);
			innerParams.put("pointsToRedeem", pointsToRedeem+"");
			innerParams.put("transactionDescription", transactionDescription);

			params.put("redemptionOrder", generateRequestBody(innerParams));
			params.put("transactionReferenceNumber", transactionReferenceNumber);

			StringEntity requestBody =new StringEntity(generateRequestBody(params));

			try {
				((HttpPost) request).setEntity(requestBody);
			} catch (Exception e) {
				e.printStackTrace(); 
			}



			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);

			response.close();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}


	//Customer starts here
	public String getAccessTokenWithCode(String code) {
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/authCode/oauth2/token/sg/gcb");

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", appAuthorization);
			request.addHeader("Content-Type", "application/x-www-form-urlencoded");


			List < NameValuePair > params = new ArrayList < NameValuePair >();


			// form parameters
			params.add(new BasicNameValuePair("grant_type", "authorization_code"));
			// form parameters
			params.add(new BasicNameValuePair("code", code));
			// form parameters
			params.add(new BasicNameValuePair("redirect_uri", appUrl));


			try {
				((HttpPost) request).setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			} catch (Exception e) {
				e.printStackTrace(); 
			}

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			JSONObject resultObject = new JSONObject(result);
			System.out.println(resultObject);
			this.tokenType = resultObject.getString("token_type");
			this.tokenType = this.tokenType.substring(0, 1).toUpperCase() + this.tokenType.substring(1); 
			this.accessToken = resultObject.getString("access_token");

			response.close();
			return result;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	public String getCustomerName(){
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpGet request = new HttpGet("https://sandbox.apihub.citi.com/gcb/api/v1/customers/profiles/basic"); 

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			JSONObject resultObject = new JSONObject(result);
			System.out.println(resultObject);
			this.customerName = ((JSONObject)resultObject.getJSONObject("customerParticulars").getJSONArray("names").get(0)).getString("fullName");
			System.out.println(result);

			response.close();
			return this.customerName;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

	public String getCustomerPhoneNumber(){
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpGet request = new HttpGet("https://sandbox.apihub.citi.com/gcb/api/v1/customers/profiles/phoneNumbers"); 

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			JSONObject resultObject = new JSONObject(result);
			System.out.println(resultObject);
			this.customerPhoneNumber = ((JSONObject)resultObject.getJSONArray("phones").get(1)).getString("phoneNumber");
			System.out.println(result);

			response.close();
			return this.customerPhoneNumber;
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	//Customer ends here

	//Onboarding
	//Product Catalogue
	public Catalogue getProductCatalogue(){

		ObjectMapper mapper = new ObjectMapper();
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;

		Catalogue catalogue = new Catalogue();

		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();

			HttpGet request = new HttpGet("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products");

			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			catalogue = mapper.readValue(result, new TypeReference<Catalogue>(){});
			System.out.println(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return catalogue;
	}

	//TODO
	public SuccessfulOnboard postOnboarding(OnboardingRequest obRequest) {

		SuccessfulOnboard successfulOnboard = new SuccessfulOnboard();
		ObjectMapper mapper = new ObjectMapper();
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try{

			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications");

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("Content-Type", "application/json");
			request.addHeader("client_id", appClientId);

			String jsonInString = mapper.writeValueAsString(obRequest);

			StringEntity requestBody =new StringEntity(jsonInString);

			try {
				((HttpPost) request).setEntity(requestBody);
			} catch (Exception e) {
				e.printStackTrace(); 
			}

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			successfulOnboard = mapper.readValue(result, new TypeReference<SuccessfulOnboard>(){});
			response.close();
			return successfulOnboard;
		} catch (Exception e) {
		}
		return successfulOnboard;
	}

	public SuccessfulScreening postScreening(ScreeningRequest screeningRequest, String applicationId) {

		SuccessfulScreening successfulScreening = new SuccessfulScreening();

		ObjectMapper mapper = new ObjectMapper();
		CloseableHttpClient httpClient = null;

		CloseableHttpResponse response = null;


		try{

			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			//proxy configuration 
			//HttpHost proxy = new HttpHost("proxy.xxxx.com", 8080, "http");
			//RequestConfig config = RequestConfig.custom().setProxy(proxy).build();

			HttpPost request = new HttpPost("https://sandbox.apihub.citi.com/gcb/api/v1/apac/onboarding/products/unsecured/applications/" + applicationId + "/backgroundScreening");

			//proxy configuration
			//request.setConfig(config);
			// Header parameters  addition
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("Content-Type", "application/json");
			request.addHeader("client_id", appClientId);

			String jsonInString = mapper.writeValueAsString(screeningRequest);

			StringEntity requestBody =new StringEntity(jsonInString);

			try {
				((HttpPost) request).setEntity(requestBody);
			} catch (Exception e) {
				e.printStackTrace(); 
			}

			System.out.println("Executing request " + request.getRequestLine());

			response = httpClient.execute(request);

			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			successfulScreening = mapper.readValue(result, new TypeReference<SuccessfulScreening>(){});
			response.close();
			return successfulScreening;
		} catch (Exception e) {
		}
		return successfulScreening;
	}

	//Cards starts here
	public ArrayList<String> getAllCards(){     

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;

		try {
			httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
			HttpGet request = new HttpGet("https://sandbox.apihub.citi.com/gcb/api/v1/cards?cardFunction=LOCAL_CARD_ACTIVATION");
			request.addHeader("Authorization", this.tokenType + " " + this.accessToken);
			request.addHeader("uuid", generateUUID());
			request.addHeader("Accept", "application/json");
			request.addHeader("client_id", appClientId);

			System.out.println("Executing request " + request.getRequestLine());
			response = httpClient.execute(request);



			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			String result = EntityUtils.toString(response.getEntity());
			System.out.println(result);
			JSONObject resultObject = new JSONObject(result);
			JSONArray cardArrays = resultObject.getJSONArray("cardDetails");
			JSONObject resultCreditCardsObject = new JSONObject();
			JSONArray resultCreditCardsArray = new JSONArray();
			this.creditCards.clear();
			for (int i = 0; i < cardArrays.length(); i++) {
				JSONObject card = cardArrays.getJSONObject(i);
				if (card.getString("subCardType").equals("CREDIT") && card.getString("localCardActivationIndicator").equals("ACTIVE")){
					this.creditCards.add(card.getString("displayCardNumber"));
					resultCreditCardsArray.put(card.get("displayCardNumber"));
				}
			}
			resultCreditCardsArray.put("3243");
			resultCreditCardsArray.put("4353");
			this.creditCards.add("3243");
			this.creditCards.add("4353");
			resultCreditCardsObject.put("valid_credit_card_number", resultCreditCardsArray);
			System.out.println("valid_credit_card_number: " + resultCreditCardsObject);
			response.close();
			return creditCards;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//Cards ends here




	//===============Helper Functions===========================================
	private String generateUUID(){
		return UUID.randomUUID().toString();
	}

	private String generateRequestBody(Map<String, String> params){

		String result = "{";
		Iterator it = params.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();

			if((pair.getValue().toString()).substring(0, 1).equals("{")){
				result += "\"" + pair.getKey() + "\":" + pair.getValue() + ",";
			}else{
				result += "\"" + pair.getKey() + "\":" + "\"" + pair.getValue() + "\",";
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
		result = result.substring(0,result.length() - 1) + "}";

		return result;
	}

}


