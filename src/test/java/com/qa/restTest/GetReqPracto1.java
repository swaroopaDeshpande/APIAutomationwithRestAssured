package com.qa.restTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqPracto1 {

	@Test
	public void getDetails() {
		// 1.Base URI define
		RestAssured.baseURI = "https://reqres.in/";
		// 2.HTTP Request
		RequestSpecification httpRequest = RestAssured.given();
		// 3.execure requst ,send button in postnman
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");
		// 4.Validation: Headers,Response code,Body
		// 4.1 resp code

		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		// 4.2 Resp line

		String responseLine = response.getStatusLine();
		System.out.println(responseLine);
		Assert.assertEquals(responseLine, "HTTP/1.1 200 OK");

		// 4.3 Body

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

		// validate each and every entry of body use Json path
		JsonPath jsonvalue = response.jsonPath();
		int page = jsonvalue.get("total_pages");
		System.out.println(page);

		// Get Headers
		Headers header = response.getHeaders();
		System.out.println(header);

		// Get sprcific header
		String ContentType = response.getHeader("Content-Type");
		System.out.println(ContentType);

	}

}
