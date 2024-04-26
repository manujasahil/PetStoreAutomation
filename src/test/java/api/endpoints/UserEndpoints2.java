package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	static ResourceBundle getURL(){
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
public static Response createUser(User payload){
	
		String post_url= getURL().getString("post_url");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return response;
	}
	
	public static Response getUser(String Username){
		
		String get_url= getURL().getString("get_url");
		
		Response response=given()
			.pathParam("username", Username)
		.when()
			.get(get_url);
		
		return response;
	}

	public static Response updateUser(User payload, String Username){
		
		String put_url= getURL().getString("put_url");
	
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", Username)
		.when()
			.put(put_url);
	
	return response;
}

	public static Response deleteUser(String Username){
		
		String delete_url= getURL().getString("delete_url");
	
		Response response=given()
			.pathParam("username", Username)
		.when()
			.delete(delete_url);
	
	return response;
}

}
