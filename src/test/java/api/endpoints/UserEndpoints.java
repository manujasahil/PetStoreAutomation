package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response createUser(User payload){
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String Username){
		
		Response response=given()
			.pathParam("username", Username)
		.when()
			.get(Routes.get_url);
		
		return response;
	}

	public static Response updateUser(User payload, String Username){
	
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", Username)
		.when()
			.put(Routes.put_url);
	
	return response;
}

	public static Response deleteUser(String Username){
	
		Response response=given()
			.pathParam("username", Username)
		.when()
			.delete(Routes.delete_url);
	
	return response;
}

}
