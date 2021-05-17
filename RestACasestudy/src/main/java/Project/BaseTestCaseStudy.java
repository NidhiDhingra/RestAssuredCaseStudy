package Project;

import Utility.URLCaseStudy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTestCaseStudy {
	static Response response;
	public static String Token;
	
	


	
	public static String  Signup()
	{
		String endpointURL = URLCaseStudy.getEndpoint("/oauth2/token/client_credentials");
		response = RestCallsCaseStudy.PostRequestBasic(endpointURL, Token);
		String stres =response .getBody().asString();
		JsonPath jsonres = new JsonPath(stres);
		String accessToken =jsonres.get("data.access_token");
		System.out.println(accessToken);
		return accessToken;
	}
	
	}
	
	
	
	

