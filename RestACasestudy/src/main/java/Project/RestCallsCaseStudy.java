package Project;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCallsCaseStudy {
	
	
	
	
	public static Response GetRequest(String URI)
	{
		// I am trying to pass my request
		RequestSpecification requestspecification = RestAssured.given();
		//either my content type can be with json/xml
		requestspecification.contentType(ContentType.JSON);
		// I am trying to fecth the URI
		Response response = requestspecification.get(URI);
		return response;
	}
	
	public static Response GetRequestHeader(String URI,String accessToken) {
		RequestSpecification requestspecification = RestAssured.given().header("Authorization","bearer "+accessToken);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(URI);
		return response;
	}

	public static Response PostRequest(String URI,String accessToken)
	{
		// I am trying to pass my request
				RequestSpecification requestspecification = RestAssured.given().header("Authorization","bearer "+accessToken);
				//either my content type can be with json/xml
				requestspecification.contentType(ContentType.JSON);
				// I am trying to fecth the URI
				Response response = requestspecification.post(URI);
				return response;
				
				
	}
	
	public static Response PostRequestauthorization(String URI,String strJSON,String accessToken)
	
	{
		// I am trying to pass my request
				RequestSpecification requestspecification = RestAssured.given().body(strJSON).header("Authorization","bearer "+accessToken);
				//either my content type can be with json/xml
				requestspecification.contentType(ContentType.JSON);
				// I am trying to fecth the URI
				Response response = requestspecification.post(URI);
				return response;
				
				
	}
	
	public static Response PostRequestBasic(String URI,String Token)
	{
		// I am trying to pass my request
				RequestSpecification requestspecification = RestAssured.given().header("Authorization","Basic "+"dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=");
				//either my content type can be with json/xml
				requestspecification.contentType(ContentType.JSON);
				// I am trying to fecth the URI
				Response response = requestspecification.post(URI);
				return response;
				
				
	}

	public static Response PutRequest(String URI,String Json)
	{
		// I am trying to pass my request
				RequestSpecification requestspecification = RestAssured.given().body(Json);
				//either my content type can be with json/xml
				requestspecification.contentType(ContentType.JSON);
				// I am trying to fecth the URI
				Response response = requestspecification.put(URI);
				return response;
	}




}
