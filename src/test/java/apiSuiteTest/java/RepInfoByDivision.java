package apiSuiteTest.java;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RepInfoByDivision {
	@Test
	void getRepInfoByDivisionRecursiveTrue() {
				
	//Dynamic Level selection	
	List<String> givenLevel = Arrays.asList("administrativeArea1","administrativeArea2","country","international",
											"locality","regional","special","subLocality1","subLocality2");
	Random rand = new Random();
	String randomLevel = givenLevel.get(rand.nextInt(givenLevel.size()));
	System.out.println("what is this"+randomLevel);
	
	//Dynamic Role Selection
	List<String> givenRole = Arrays.asList("deputyHeadOfGovernment","executiveCouncil","governmentOfficer",
											"headOfGovernment","headOfState","highestCourtJudge","judge",
											"legislatorLowerBody","legislatorUpperBody","schoolBoard",
											"specialPurposeOfficer");
	String randomRole = givenRole.get(rand.nextInt(givenRole.size()));
	System.out.println("what is this"+randomRole);

		
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	Response response = RestAssured.given()
			.when().header("Referer","https://explorer.apis.google.com")
			.queryParam("ocdId", "ocd-division/country:us/state:ak/cd:1")
			.queryParam("recursive", true)
			.queryParam("levels", randomLevel)
			.queryParam("roles", randomRole)
			.queryParam("key", "AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM")
			.get("/representatives/ocdId");
		

	//Print response and validate
	String responseRepInfoByDivision=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseRepInfoByDivision);

	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	
	if (responseRepInfoByDivision.contains("notFound")) {
		AssertJUnit.assertEquals(statusCode, 404);
	}else {
		AssertJUnit.assertTrue(responseRepInfoByDivision.contains("divisions"));
		AssertJUnit.assertEquals(statusCode, 200);

	};

	
	
	}
	
	@Test
	void getRepInfoByDivisionRecursiveFalse() {
				
	//Dynamic Level selection	
	List<String> givenLevel = Arrays.asList("administrativeArea1","administrativeArea2","country","international",
											"locality","regional","special","subLocality1","subLocality2");
	Random rand = new Random();
	String randomLevel = givenLevel.get(rand.nextInt(givenLevel.size()));
	System.out.println("what is this"+randomLevel);
	
	//Dynamic Role Selection
	List<String> givenRole = Arrays.asList("deputyHeadOfGovernment","executiveCouncil","governmentOfficer",
											"headOfGovernment","headOfState","highestCourtJudge","judge",
											"legislatorLowerBody","legislatorUpperBody","schoolBoard",
											"specialPurposeOfficer");
	String randomRole = givenRole.get(rand.nextInt(givenRole.size()));
	System.out.println("what is this"+randomRole);

		
	RestAssured.baseURI ="https://content.googleapis.com/civicinfo/v2";
	Response response = RestAssured.given()
			.when().header("Referer","https://explorer.apis.google.com")
			.queryParam("ocdId", "ocd-division/country:us/state:ak/cd:1")
			.queryParam("recursive", false)
			.queryParam("levels", randomLevel)
			.queryParam("roles", randomRole)
			.queryParam("key", "AIzaSyAa8yy0GdcGPHdtD083HiGGx_S0vMPScDM")
			.get("/representatives/ocdId");
		

	//Print response and validate
	String responseRepInfoByDivision=response.getBody().asString();
	System.out.println("Voter Info Response Body is:"+responseRepInfoByDivision);
	
	//Print status code and validate
	int statusCode=response.getStatusCode();
	System.out.println("Status Code is"+statusCode);
	AssertJUnit.assertEquals(statusCode, 404);
	}

}
