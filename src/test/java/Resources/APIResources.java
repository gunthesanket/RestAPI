package Resources;

public enum APIResources {

	AddAPI("/maps/api/place/add/json"), 
	GetAPI("/maps/api/place/get/json"), 
	DeleteAPI("/maps/api/place/delete/json");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getAPIResources() {

		return resource;
	}

}
