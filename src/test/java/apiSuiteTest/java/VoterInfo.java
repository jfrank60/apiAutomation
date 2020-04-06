package apiSuiteTest.java;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VoterInfo {
	@Test
	void getVoterInfoWithoutAddressInvalidResponse() {
				
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	RequestSpecification request = RestAssured.given();	
	
	// Add a header stating the Request body is a JSON
	request.header("Referer","https://explorer.apis.google.com");

	// Post the request and check the response
	Response response = request.get("/voterinfo?key=AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM");
	
	//print response
	String responseVoterInfo=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseVoterInfo);
	
	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 400);
	}
	
	@Test
	void getVoterInfoWithAddressAllOptionsTrueValidResponse() {
				
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	Response response = RestAssured.given()
			.when().header("Referer","https://explorer.apis.google.com")
			.queryParam("address", "160 Adams Lake Court Lawrenceville Ga 30046")
			.queryParam("officialOnly", true)
			.queryParam("returnAllAvailableData", true)
			.queryParam("key", "AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM")
			.get("/voterinfo");
		

	//Print response and validate
	String responseVoterInfo=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseVoterInfo);
	AssertJUnit.assertTrue(responseVoterInfo.contains("160 Adams Lake Court"));

	
	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 200);
	}
	
	@Test
	void getVoterInfoWithAddressOfficalOnlyFalseValidResponse() {
				
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	Response response = RestAssured.given()
			.when().header("Referer","https://explorer.apis.google.com")
			.queryParam("address", "160 Adams Lake Court Lawrenceville Ga 30046")
			.queryParam("officialOnly", false)
			.queryParam("returnAllAvailableData", true)
			.queryParam("key", "AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM")
			.get("/voterinfo");
		

	//Print response and validate
	String responseVoterInfo=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseVoterInfo);
	AssertJUnit.assertTrue(responseVoterInfo.contains("160 Adams Lake Court"));

	
	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 200);
	}
	
	@Test
	void getVoterInfoWithAddressAllOptionsFalseValidResponse() {
				
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	Response response = RestAssured.given()
			.when().header("Referer","https://explorer.apis.google.com")
			.queryParam("address", "160 Adams Lake Court Lawrenceville Ga 30046")
			.queryParam("officialOnly", false)
			.queryParam("returnAllAvailableData", false)
			.queryParam("key", "AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM")
			.get("/voterinfo");
		

	//Print response and validate
	String responseVoterInfo=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseVoterInfo);
	AssertJUnit.assertTrue(responseVoterInfo.contains("Election unknown"));

	
	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 400);
	}
}
