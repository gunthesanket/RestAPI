package Resources;

public class Deletebody {

	public static String deletebo(String placeid) {
		String body ="{\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}\r\n"
				+ "";
		
		return body;
	}
}
