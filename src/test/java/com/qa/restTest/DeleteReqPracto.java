package com.qa.restTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteReqPracto {
	@Test
	public void deleteRequest() {
		// 1.Define Base URL
		RestAssured.baseURI = "https://reqres.in/api/users";

		// 2.HTTP Request
		RequestSpecification httpRequest = RestAssured.given();

		// 3. Execute req
		Response response = httpRequest.request(Method.DELETE, "616");

		// 4. Response validation
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 204);

		// 5.Status line
		String responseline = response.getStatusLine();
		System.out.println(responseline);
		Assert.assertEquals(responseline, "HTTP/1.1 204 No Content");

		// 6.Body validation
		String Responsebody=response.getBody().asString();
		System.out.println(Responsebody);
		
		//7.Headers
		Headers header=response.headers();
		System.out.println(header);
		

	}

}
