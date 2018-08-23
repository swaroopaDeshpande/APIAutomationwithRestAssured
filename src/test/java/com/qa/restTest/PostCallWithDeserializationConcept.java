package com.qa.restTest;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.restTest.rest.Objects.CustomerResponse;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallWithDeserializationConcept {
	
	@Test
	public void createCustomerTest() {
		// 1.define base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		// 2.define req
		RequestSpecification httprequest = RestAssured.given();
		// 3.create JSON object with all field-->Req Json Simple api
		// creating JSON Payload- use org.json.simple.JSONObject
		org.json.simple.JSONObject requestJson = new org.json.simple.JSONObject();
		Random random=new Random();
		
		requestJson.put("FirstName", "Jaes87"+random.nextInt(100));
		requestJson.put("LastName", "Bo20"+random.nextInt(100));
		requestJson.put("UserName", "Bod199"+random.nextInt(100));
		requestJson.put("Password", "Tst@4a5"+random.nextInt(100));
		requestJson.put("Email", "Bnd1a5"+random.nextInt(100)+"@gmail.com");

		// 4.Add header:Copy it from postman where you have perform manually
		// POST call
		httprequest.header("Content-Type", "application/json");

		// 5.Add payload with req to the body of req
		httprequest.body(requestJson.toJSONString());

		// 6.Post the request and get the response
		Response response = httprequest.post("/register");

		// 7.Get Response from response body
		String responseBody = response.body().asString();
		System.out.println("Response body is :" + responseBody);
		
		System.out.println("****************************");
		
		//Deserialization
		CustomerResponse customerResponse=response.as(CustomerResponse.class);
		
		System.out.println(customerResponse.SucessCode);

		System.out.println(customerResponse.Message);
		

}
}
