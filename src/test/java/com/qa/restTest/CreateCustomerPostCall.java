package com.qa.restTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCustomerPostCall {

	@Test
	public void createCustomerTest() {
		// 1.define base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		// 2.define req
		RequestSpecification httprequest = RestAssured.given();
		// 3.create JSON object with all field-->Req Json Simple api
		// creating JSON Payload- use org.json.simple.JSONObject
		org.json.simple.JSONObject requestJson = new org.json.simple.JSONObject();
		requestJson.put("FirstName", "James010");
		requestJson.put("LastName", "Bond100");
		requestJson.put("UserName", "Bond008");
		requestJson.put("Password", "Test@123");
		requestJson.put("Email", "Bond008@gmail.com");

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
		
		// 8.Get status code and validate it
				int statusCode = response.getStatusCode();
				System.out.println("status code is " + statusCode);

				System.out.println("****************************");

				// 9.validations
				Assert.assertEquals(statusCode, 201);

				System.out.println("****************************");

				// 10.getstatusLine
				String statusLine = response.getStatusLine();
				System.out.println("The status line is " + statusLine);

				System.out.println("****************************");

				// 11.Get headers and check
				Headers header = response.getHeaders();
				System.out.println(header);

				System.out.println("****************************");
				// 12.Get particular header(Key-Value)
				// 1.Content-Encoding
				String ContentEncode = response.getHeader("Content-Encoding");
				System.out.println("value of Content Encode is " + ContentEncode);

				System.out.println("****************************");

				// 2.Content-Length=168
				String HeaderContentLength = response.getHeader("Content-Length");
				System.out.println("HeaderContentLength is " + HeaderContentLength);

				System.out.println("****************************");
	}
}
