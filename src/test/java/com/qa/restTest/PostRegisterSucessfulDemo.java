package com.qa.restTest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRegisterSucessfulDemo {

	@Test
	public void RegisterSucessFulTest() {
		// 1.Define Base URI
		RestAssured.baseURI = "https://reqres.in/";
		// 2.HTTP Request
		RequestSpecification httpRequest = RestAssured.given();
		// 3.Json Object creation as we need to pass Json body
		JSONObject JsonValue = new JSONObject();
		// 4.Add values in the Json obj
		// Random generation of Jsonbody
		Random random = new Random();

		JsonValue.put("email", "sydney@fife1" + random.nextInt(100));
		JsonValue.put("password", "pistol1" + random.nextInt(100));
		// 4.1 Add Headers
		// 4.Add Header
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", "Bearer c05f2b475db324a2e4be720202859ef1");
		// *#* 4.2Add Json payload to body
		httpRequest.body(JsonValue.toJSONString());
		// 5.Add this Payload to request and execute req
		Response response = httpRequest.request(Method.POST, "/api/register");
		// 6.Validation
		// 6.1 Validate status code
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
	}

}
