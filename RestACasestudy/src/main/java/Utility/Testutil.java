package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Testutil {
	
	public static String getResponsestring(Response response)
	{
		String stres =response .getBody().asString();
		return  stres;
	}
	public static JsonPath jsonparser(String response)
	{
		JsonPath jsonres = new JsonPath(response);
		return  jsonres;
	}
	
	public static XmlPath xmlparser(String response)
	{
		XmlPath xmlres = new XmlPath(response);
		return  xmlres;
	}
public static int getstatuscode(Response response)
{
	int status = response.getStatusCode();
	return status;
}

public static String  getstatusmessage (Response response)
{
	String message = response.getStatusLine();
	return message;
}

}
