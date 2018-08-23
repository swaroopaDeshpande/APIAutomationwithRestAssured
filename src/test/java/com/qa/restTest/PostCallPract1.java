package com.qa.restTest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostCallPract1 {

	/*
	 * Json PayLoad { "FirstName":"Bunny", "LastName":"Kiki",
	 * "UserName":"BK500", "Password":"test@258", "Email":"Bk001@gmail.com" }
	 */

	// http://restapi.demoqa.com/customer/register

	@Test
	public void PostRequestDemo() {
		// 1.Define URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// 2.HTTP req
		RequestSpecification httpRequest = RestAssured.given();

		// 3.create a json object with all fields
		JSONObject requestJson = new JSONObject();
		//to Genearte random input in Json  use Random generator = new Random();
		Random generator = new Random();
		generator.nextInt(100);
	  
	    
		requestJson.put("FirstName", "Bun"+generator.nextInt(100));
		requestJson.put("LastName", "Ki"+generator.nextInt(100));
		requestJson.put("UserName", "B576"+generator.nextInt(100));
		requestJson.put("Password", "test@022"+generator.nextInt(100));
		requestJson.put("Email", "B121@gmail.com"+generator.nextInt(100));

		// 4.Add Header
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer c05f2b475db324a2e4be720202859ef1");

		// 5.Add Json payload to body
		httpRequest.body(requestJson.toJSONString());

		// 6.Execute request
		Response response= httpRequest.request(Method.POST, "/register");
		
		//7.Get response and validate
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		//7.1 Status code
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//7.2 Status line
		String responsestatusLine=response.getStatusLine();
		System.out.println(responsestatusLine);
		Assert.assertEquals(responsestatusLine,"HTTP/1.1 201 Created" );
		
		
		//7.3 Headers check
		Headers header=response.headers();
		System.out.println(header);
		
		//7.4 Individual Header
		String ContentType=response.header("Content-Type");
		System.out.println(ContentType);
		
		//8. Check body individually
		JsonPath jsonValue=response.jsonPath();
		String sucesscode=jsonValue.get("SuccessCode");
		System.out.println(sucesscode);
		

	}

}
