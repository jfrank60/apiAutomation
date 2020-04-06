package apiSuiteTest.java;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Divisions {
	
	@Test
	void getDivisionDetailsWithValidResponse() {
				
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	RequestSpecification request = RestAssured.given();	
	
	// Add a header stating the Request body is a JSON
	request.header("Referer","https://explorer.apis.google.com");

	// Post the request and check the response
	Response response = request.get("/divisions?query=Georgia&key=AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM");
	
	
	//print response
	String responseDivisions=response.getBody().asString();
	System.out.println("Division Response Body is:"+responseDivisions);
	Assert.assertNotNull(responseDivisions);
	
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 200);
	}	
}


