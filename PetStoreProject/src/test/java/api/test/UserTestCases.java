package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;


public class UserTestCases {
	
	Faker faker;
	User userPayload; 
	@BeforeClass
	public void setupData()
	{
	  //I will use here faker lib so that i can  create Random Data in POJO
	  //pass the data in POJO
		faker = new Faker();
		userPayload = new User();
				
		userPayload.setUsername(faker.name().username());
		userPayload.setId(faker.idNumber().hashCode());;
		userPayload.setFirstName(faker.name().username());;
		userPayload.setFirstName(faker.name().firstName());;
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());;
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	    
	}
	
	@Test(priority = 1)
 	public void testPostUser()
	{
		Response response =UserEndPoint.creatUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.statusCode(),200);
		
	}
	@Test(priority = 2)
	public void testUserByName()
	{
		Response response= UserEndPoint.getUser(userPayload.getUsername());
	    response.then().log().all();
	    
	    AssertJUnit.assertEquals(response.statusCode(),200);
	    
	
	}
	
	@Test(priority = 3)
	public void testUpdateByName()
	{
		 //Update the Data By using Payload
		userPayload.setFirstName(faker.name().firstName());;
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());;
	
		Response response =UserEndPoint.updateUser(this. userPayload,userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.statusCode(),200);
	
		//Checking data after update
		Response responseafterUpdate= UserEndPoint.getUser(userPayload.getUsername());
	    responseafterUpdate.then().log().all();
	    
	    AssertJUnit.assertEquals(responseafterUpdate.statusCode(),200);
	    	
	}
	@Test(priority = 4)
	public void testDeleteUserByName()
	{
		Response response =UserEndPoint.deleteUser(this.userPayload.getUsername());
		 AssertJUnit.assertEquals(response .statusCode(),200);
		   
	}
	
	
	
	
	
	
	
	
	
	

}
