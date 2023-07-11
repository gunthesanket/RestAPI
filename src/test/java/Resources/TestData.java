package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.addplace;
import pojo.location;

public class TestData {

	public static addplace settestdata(String name, String address, String lan) {

		addplace obj = new addplace();
		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		obj.setLocation(loc);
		obj.setAccuracy("50");
		obj.setName(name);
		obj.setPhone_number("(+91) 983 893 3937");
		obj.setAddress(address);

		List<String> k = new ArrayList<String>();
		k.add("shoe park");
		k.add("shop");

		obj.setTypes(k);
		obj.setWebsite("http://google.com");
		obj.setLanguage(lan);
		return obj;

	}
}
