package Utility;

public class URLCaseStudy {
	
	public static final String URL ="http://rest-api.upskills.in/api/rest_admin";
	
	public static String getEndpoint()
	{
		return URL;

	}
	public static String getEndpoint(String resource)
	{
	return URL + resource;

	}
	}
