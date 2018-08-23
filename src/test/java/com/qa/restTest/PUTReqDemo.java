package com.qa.restTest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTReqDemo {

	@Test
	public void PUTReq() {
		// 1.Create BaseURL
		RestAssured.baseURI = "https://reqres.in/";

		// 2.HTTP req
		RequestSpecification httpRequest = RestAssured.given();

		// 3.Create JSONObject
		JSONObject JSONValue = new JSONObject();
		// 3.1 Create random numbers in JsonPayload
		Random random = new Random();

		JSONValue.put("name", "Tupu" + random.nextInt(100));
		JSONValue.put("job", "CEO" + random.nextInt(100));

		// 4.add header
		httpRequest.header("Content-Type", "application/json");
		httpRequest.request("Authorization", "Bearer c05f2b475db324a2e4be720202859ef1");

		// 4.Add payload body to JSONObject
		httpRequest.body(JSONValue.toJSONString());

		// 5.Execute Req
		Response response = httpRequest.request(Method.PUT, "/api/users/2");

		// 6.Validate
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);

		// Validate Status Line
		String responseLine = response.getStatusLine();
		System.out.println(responseLine);
		Assert.assertEquals(responseLine, "HTTP/1.1 200 OK");

		// validate headers
		Headers header = response.headers();
		System.out.println(header);

		// validate body
		String JsonResponse = response.getBody().asString();
		System.out.println(JsonResponse);

		// validate single body--Jsonpath
		JsonPath jsonval = response.jsonPath();
		System.out.println(jsonval.get("name"));
		System.out.println(jsonval.get("job"));
		System.out.println(jsonval.get("updatedAt"));
	}

}
