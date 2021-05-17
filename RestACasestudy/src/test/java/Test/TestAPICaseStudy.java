package Test;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Project.Assertion;
import Project.BaseTestCaseStudy;
import Project.RestCallsCaseStudy;
import Utility.Testutil;
import Utility.URLCaseStudy;
import Utility.payloadconvertorcasestudy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPICaseStudy {
	
	private String accessToken;
	static Response response;
	String adduserid=null;
	String addreward=null;
	
	@BeforeTest
	public void setup() throws IOException
	{
		accessToken = BaseTestCaseStudy.Signup();
		
	}	
	
	@Test(priority=0)
	public void login() throws IOException
	{
	
		String loginpayload = payloadconvertorcasestudy.generatepayloadstring("login.json");
		
		String endpointURI = URLCaseStudy.getEndpoint("/login");
		
		//Call the method which contains the post method from the restcall
	response = RestCallsCaseStudy.PostRequestauthorization(endpointURI,loginpayload,accessToken);
	String strresponse = Testutil.getResponsestring(response);
	JsonPath jsonres = Testutil.jsonparser(strresponse);
	Assertion.verifystatuscode(response, 200);
	}
	
	@Test(priority=1)
	public void GetUser()
	{
		String endpointURL = URLCaseStudy.getEndpoint("/user");	
		response = RestCallsCaseStudy.GetRequestHeader(endpointURL,accessToken);
		String strresponse = Testutil.getResponsestring(response);
		JsonPath jsonres = Testutil.jsonparser(strresponse);
		String successuser = jsonres.getString("data.username");
		Assertion.verifystatuscode(response, 200);
		
		
	}
	@Test(priority=2)
	public void AddUsers() throws IOException
	{
		String loginpayload = payloadconvertorcasestudy.generatepayloadstring("adduser.json");
		String endpointURL = URLCaseStudy.getEndpoint("/customers");	
		response = RestCallsCaseStudy.PostRequestauthorization(endpointURL,loginpayload,accessToken);
		String strresponse = Testutil.getResponsestring(response);
		JsonPath jsonres = Testutil.jsonparser(strresponse);
		adduserid = jsonres.getString("data.id");
		Assertion.verifystatuscode(response, 200);
	}
	

	@Test(priority=3)
	public void AddRewardPoints() throws IOException
	{
		String loginpayload = payloadconvertorcasestudy.generatepayloadstring("addrewardpoints.json");
		String endpointURL = URLCaseStudy.getEndpoint("/reward/"+ adduserid);	
		response = RestCallsCaseStudy.PostRequestauthorization(endpointURL,loginpayload,accessToken);
		String strresponse = Testutil.getResponsestring(response);
		JsonPath jsonres = Testutil.jsonparser(strresponse);
		addreward = jsonres.getString("data.id");
		Assertion.verifystatuscode(response, 200);
		
	}
	
	@Test(priority=4)
	public void Getlogout()
	{
		
		String endpointURL = URLCaseStudy.getEndpoint("/logout");	
		response = RestCallsCaseStudy.PostRequest(endpointURL,accessToken);
		String strresponse = Testutil.getResponsestring(response);
		JsonPath jsonres = Testutil.jsonparser(strresponse);
		String successuser = jsonres.getString("success");
		Assertion.verifystatuscode(response, 200);
		
		
	}

	
}
