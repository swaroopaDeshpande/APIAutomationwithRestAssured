package com.qa.restTest;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherGETTest {

	@Test
	public void getWeatherDetailsWithCorrectCityNameTest() {
		// 1.Define Base URL.
		// http://restapi.demoqa.com/utilities/weather/city

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// 2.define HTTP request--make an request so that we can send it server
		RequestSpecification httpRequest = RestAssured.given();

		// 3.make/execute request
		Response response = httpRequest.request(Method.GET, "/Pune");

		// 4.Get response body--after sending req we get response
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// validate city name or validate the key or value
		Assert.assertEquals(responseBody.contains("Pune"), true);

		// 5.get response status and validate it
		int statusCode = response.getStatusCode();
		System.out.println("The status code is:  " + statusCode);

		Assert.assertEquals(statusCode, 200);
		System.out.println("status line is " + response.getStatusLine());

		// 6. get the headers
		Headers headers = response.getHeaders();
		System.out.println(headers);

		// specific header
		String ContentType = response.getHeader("Content-Type");
		System.out.println("the value of content-type is " + ContentType);

		String ContentLength = response.getHeader("Content-Length");
		System.out.println("the value of content-type is " + ContentLength);

		// get the keyvalue/node by using Json Path

		JsonPath jsonPathValue = response.jsonPath();
		String city= jsonPathValue.get("City");
		System.out.println("The value of the city"+ city);
		
		String Humidity= jsonPathValue.get("Humidity");
		System.out.println("The value of the Temperature"+ Humidity);
		
		String WeatherDescription= jsonPathValue.get("WeatherDescription");
		System.out.println("The value of the WeatherDescription"+ WeatherDescription);
		
		String WindSpeed= jsonPathValue.get("WindSpeed");
		System.out.println("The value of the WindSpeed"+ WindSpeed);
		
		String WindDirectionDegree= jsonPathValue.get("WindDirectionDegree");
		System.out.println("The value of the WindDirectionDegree"+ WindDirectionDegree);
		
		
	}
	
	@Test
	public void getWeatherDetailsWithInCorrectCityNameTest()
	{
		//define the base URL
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		//define HTTP Request
		//execute the request/Make a request
				
	}
	

}
