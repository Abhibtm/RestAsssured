package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to Perform CRUD Operation in USER API
public class UserEndPoint {
 
	public static Response creatUser(User payload)
	{
	         Response response=  given()
			              .contentType(ContentType.JSON)
			              .accept(ContentType.JSON)
			              .body(payload)
			              .when()
			              .post(Routes.post_url);
	         
	         //Validation will be done with URL
	         
	         return response;
			              
			              
	}
	public static Response  getUser(String username)
	{
	         Response response=  given()
	        		      .pathParam("username",username)
			              .when()
			              .get(Routes.get_url);
	         //here if we observe we are passsing querry parameter with URL
	         //Which will be provided by pathParam
	         //Validation will be done with URL
			     
	         return response;
			              
	}
	public static Response updateUser(User payload,String username)
	{
	         Response response=  given()
			              .contentType(ContentType.JSON)
			              .accept(ContentType.JSON)
			              .pathParam("username", username)
			              .body(payload)
			              .when()
			              .put (Routes.put_url);
	         
	         //Validation will be done with URL
	         
	         return response;
			              
			              
	}
	
	public static Response  deleteUser(String username)
	{
	         Response response=  given()
	        		      .pathParam("username",username)
			              .when()
			              .get(Routes.delete_url);
	         //here if we observe we are passsing querry parameter with URL
	         //Which will be provided by pathParam
	         //Validation will be done with URL
			     
	         return response;
			              
	}
	
	
	
	
	
	
	
}
