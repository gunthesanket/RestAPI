package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;

import org.testng.Assert;

import Resources.APIResources;
import Resources.Deletebody;
import Resources.TestData;
import Resources.Utils;

public class StepDefination extends Utils {
	public static JsonPath js;
	public static String placeid;
	RequestSpecification req;
	Response res;

	@Given("add payload {string}, {string},{string}")
	public void add_payload(String name, String address, String lan) throws FileNotFoundException {

		req = given().log().all().spec(requesbuilder()).body(TestData.settestdata(name, address, lan));

	}

	@When("User hits {string} with {string}  request")
	public void user_hits_with_request(String api, String post) {

		APIResources a = APIResources.valueOf(api);
		String apiurl = a.getAPIResources();
		if (post.equalsIgnoreCase("POST")) {
			res = req.when().post(apiurl);
		} else if (post.equalsIgnoreCase("GET")) {
			res = req.when().get(apiurl);
		}

		System.out.println("--------------");
		System.out.println(res.toString());
	}

	@Then("verify the status code {int}")
	public void verify_the_status_code(Integer int1) {
		int statuscode = res.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println(statuscode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String exp) {
		String m = res.asString();
		js = new JsonPath(m);
		String act = js.getString(key);
		System.out.println("Actua : " + act);
		Assert.assertEquals(act, exp);

	}

	@Then("verify the get request with {string}")
	public void verify_the_get_request_with(String name) throws FileNotFoundException {
		System.out.println(js);
		placeid = js.getString("place_id");

		System.out.println(placeid);
		req = given().spec(requesbuilder()).queryParam("place_id", placeid);
		user_hits_with_request("GetAPI", "GET");
		in_response_body_is("name", name);

	}

	@Given("Add Payload")
	public void add_payload() throws FileNotFoundException {
		req = given().spec(requesbuilder()).body(Deletebody.deletebo(placeid));
	}
}
