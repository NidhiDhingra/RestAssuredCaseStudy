package Project;

import org.testng.Assert;

import Utility.Testutil;
import io.restassured.response.Response;

public class Assertion {
	
	public static void verifystatuscode(Response response,int status)
	{
		Assert.assertEquals(Testutil.getstatuscode(response),status);
	}

}
