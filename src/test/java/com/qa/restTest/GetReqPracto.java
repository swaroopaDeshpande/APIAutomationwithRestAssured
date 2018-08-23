package com.qa.restTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetReqPracto {

	@Test
	public void getWeatherInfo() {
		// 1.Create BaseURL
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// 2.Prepare HTTP req
		RequestSpecification httpRequest = RestAssured.given();

		// 3.Execute this request(just like in manual in postman we click on
		// Send button
		Response response = httpRequest.request(Method.GET, "/Pune");

		// Validations
		// 4.GetResponse body
		String responseBody = response.getBody().asString();
		System.out.println("the response body is:" + responseBody);
		// retrieve body of response and validate it
		Assert.assertEquals(responseBody.contains("Pune"), true);
		// need response like postman
		/*
		 * { "City": "Pune", "Temperature": "21.383 Degree celsius", "Humidity":
		 * "99 Percent", "WeatherDescription": "moderate rain", "WindSpeed":
		 * "5.27 Km per hour", "WindDirectionDegree": "254.502 Degree" }
		 */
		// need to convert this response into JsonString

		// 5.Get status code and validate it
		int statusCode = response.getStatusCode();
		System.out.println("the status code is " + statusCode);

		Assert.assertEquals(200, statusCode);

		// 5.1 Get Status Line :HTTP/1.1 200 OK
		System.out.println(response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());

		// 6. Validate Headers: 1.Get all headers
		Headers header = response.getHeaders();
		System.out.println(header);

		// 6.1 To get specific header
		String ContentType = response.getHeader("Content-Type");
		System.out.println(ContentType);
		Assert.assertEquals("application/json", ContentType);

		// 7.get key-value from response body using jsonpath
		JsonPath jsonValue = response.jsonPath();
		String city = jsonValue.get("City");
		System.out.println("the value of city is " + city);
		Assert.assertEquals("Pune", city);

		String Temperature = jsonValue.get("Temperature");
		System.out.println("the value of Temperature is " + Temperature);
		Assert.assertEquals("21.383 Degree celsius", Temperature);

		String Humidity = jsonValue.get("Humidity");
		System.out.println("the value of Humidity is " + Humidity);
		Assert.assertEquals("99 Percent", Humidity);

		String WeatherDescription = jsonValue.get("WeatherDescription");
		System.out.println("the value of WeatherDescription is " + WeatherDescription);
		Assert.assertEquals("moderate rain", WeatherDescription);

		String WindSpeed = jsonValue.get("WindSpeed");
		System.out.println("the value of WindSpeed is " + WindSpeed);
		Assert.assertEquals("5.27 Km per hour", WindSpeed);

		String WindDirectionDegree = jsonValue.get("WindDirectionDegree");
		System.out.println("the value of WindSpeed is " + WindDirectionDegree);
		Assert.assertEquals("254.502 Degree", WindDirectionDegree);

	}

}
