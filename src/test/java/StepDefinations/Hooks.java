package StepDefinations;

import java.io.FileNotFoundException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@Deleteplace")
	public void beforedelte() throws FileNotFoundException {
		System.out.println("sanket gunthe");
		StepDefination obj = new StepDefination();
		if (obj.placeid == null) {
			obj.add_payload("pankaj", "khamgaon", "Asia");
			obj.user_hits_with_request("AddAPI", "POST");
			obj.in_response_body_is("status", "OK");
			obj.verify_the_get_request_with("pankaj");
			System.out.println(obj.placeid);

		}

	}
}
