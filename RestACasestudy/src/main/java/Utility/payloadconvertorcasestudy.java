package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadconvertorcasestudy {
	
	public static String generatepayloadstring(String filename) throws IOException
	{
		String filepath ="C:\\Users\\NidhiDhingra\\git\\RestAssure\\RestACasestudy"+ filename;
		return new  String(Files.readAllBytes(Paths.get(filepath)));
		
	}

}
