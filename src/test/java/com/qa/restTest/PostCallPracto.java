package com.qa.restTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallPracto {

	@Test
	public void PostCallTest() {
		// 1.Get URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		// 2.Create HTTP Request
		RequestSpecification http_request = RestAssured.given();

		// 3.create JSON object with all field-->Req Json Simple api
		org.json.simple.JSONObject requestJson = new org.json.simple.JSONObject();

		// 4.Add data in Jason
		requestJson.put("FirstName", "Test_Auto001");
		requestJson.put("LastName", "Test_Auto002");
		requestJson.put("UserName", "Auto1");
		requestJson.put("Password", "Test@123");
		requestJson.put("Email", "Test@gmail.com");

		// 5.Add Header to response body
		http_request.header("Content-Type", "application/json");

		// 6.Add payload with req to the body of req
		http_request.body("requestJson.toJSONString()");

		// 7.Post the request and get the response:Send parameter
		Response response = http_request.post("/register");
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
