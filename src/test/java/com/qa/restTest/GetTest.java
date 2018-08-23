package com.qa.restTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTest {

	// validations-with correct City name

	@Test
	public void getWeatherDetailsWithCorrectCity() {
		// 1.Define Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		System.out.println("****************************");

		// 2.Define HTTP Request:make an request so that we can send it server
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("****************************");

		// 3. make a request/execute request(manually just like click on send
		// Btn
		// in postman)
		Response response = httpRequest.request(Method.GET, "/Pune");
		System.out.println("****************************");

		// 4.get response body
		String responseBody = response.getBody().asString();
		System.out.println("REsponse body is :" + responseBody);
		// Validate the key /value of body
		Assert.assertEquals(responseBody.contains("Pune"), true);
		System.out.println("****************************");

		// 5.Get status code and validate it
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);

		System.out.println("****************************");

		// 6.validations-with correct City name
		Assert.assertEquals(statusCode, 200);

		System.out.println("****************************");

		// 7.getstatusLine
		String statusLine = response.getStatusLine();
		System.out.println("The status line is " + statusLine);

		System.out.println("****************************");

		// 8.Get headers and check
		Headers header = response.getHeaders();
		System.out.println(header);

		System.out.println("****************************");
		// 9.Get particular header(Key-Value)
		// 1.Content-Encoding
		String ContentEncode = response.getHeader("Content-Encoding");
		System.out.println("value of Content Encode is " + ContentEncode);

		System.out.println("****************************");

		// 2.Content-Length=168
		String HeaderContentLength = response.getHeader("Content-Length");
		System.out.println("HeaderContentLength is " + HeaderContentLength);

		System.out.println("****************************");
		// 10.get the value by using JSONPath
		JsonPath jsonpathvalue = response.jsonPath();
		String City = jsonpathvalue.get("City");
		System.out.println("the value of city is: " + City);

		String Temperature = jsonpathvalue.get("Temperature");
		System.out.println("the value of Temperature is: " + Temperature);

		String Humidity = jsonpathvalue.get("Humidity");
		System.out.println("the value of Humidity is: " + Humidity);

		String WeatherDescription = jsonpathvalue.get("WeatherDescription");
		System.out.println("the value of WeatherDescription is: " + WeatherDescription);

		String ciWindSpeedty = jsonpathvalue.get("WindSpeed");
		System.out.println("the value of city is: " + ciWindSpeedty);

		String WindDirectionDegree = jsonpathvalue.get("WindDirectionDegree");
		System.out.println("the value of city is: " + WindDirectionDegree);
	}

	@Test
	public void getWeatherDetailsWithInCorrectCity() {
		
		//1.define URL
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		System.out.println("****************************");

		// 2.Define HTTP Request:make an request so that we can send it server
		RequestSpecification httpRequest = RestAssured.given();
		System.out.println("****************************");

		// 3. make a request/execute request(manually just like click on send
		// Btn
		// in postman)
		Response response = httpRequest.request(Method.GET, "/test_123");
		System.out.println("****************************");

		// 4.get response body
		String responseBody = response.getBody().asString();
		System.out.println("REsponse body is :" + responseBody);
		// Validate the key /value of body
		Assert.assertEquals(responseBody.contains("internal error"), true);
		System.out.println("****************************");

		// 5.Get status code and validate it
		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);

		System.out.println("****************************");

		// 6.validations-with correct City name
		Assert.assertEquals(statusCode, 400);

		System.out.println("****************************");

		// 7.getstatusLine
		String statusLine = response.getStatusLine();
		System.out.println("The status line is " + statusLine);

		System.out.println("****************************");

		// 8.Get headers and check
		Headers header = response.getHeaders();
		System.out.println(header);

		System.out.println("****************************");
		// 9.Get particular header(Key-Value)
		// 1.Content-Encoding
		String ContentEncode = response.getHeader("Content-Encoding");
		System.out.println("value of Content Encode is " + ContentEncode);

		System.out.println("****************************");

		// 2.Content-Length=168
		String HeaderContentLength = response.getHeader("Content-Length");
		System.out.println("HeaderContentLength is " + HeaderContentLength);

		System.out.println("****************************");
//		// 10.get the value by using JSONPath
//		JsonPath jsonpathvalue = response.jsonPath();
//		String City = jsonpathvalue.get("City");
//		System.out.println("the value of city is: " + City);
//
//		String Temperature = jsonpathvalue.get("Temperature");
//		System.out.println("the value of Temperature is: " + Temperature);
//
//		String Humidity = jsonpathvalue.get("Humidity");
//		System.out.println("the value of Humidity is: " + Humidity);
//
//		String WeatherDescription = jsonpathvalue.get("WeatherDescription");
//		System.out.println("the value of WeatherDescription is: " + WeatherDescription);
//
//		String ciWindSpeedty = jsonpathvalue.get("WindSpeed");
//		System.out.println("the value of city is: " + ciWindSpeedty);
//
//		String WindDirectionDegree = jsonpathvalue.get("WindDirectionDegree");
//		System.out.println("the value of city is: " + WindDirectionDegree);
//		

	}
}
