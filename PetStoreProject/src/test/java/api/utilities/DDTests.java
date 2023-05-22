package api.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority = 1,dataProvider = "A",dataProviderClass = FetchData.class)
	//Parameter must be in same order like in Excel
	public void testPostUser(String userID,String UserName,String Fname,String lname,String userEmal,String pwd,String phNum)
	{
	  //Using the parameter create the Payload in POJO Class	
	  User userPayload = new User();
	  userPayload.setUsername(UserName);
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setFirstName(Fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userEmal);;
		userPayload.setPhone(phNum);
		userPayload.setPassword(pwd);
		
		Response response =UserEndPoint.creatUser(userPayload);
		response.then().log().all();
		//Assert.assertEquals(response.statusCode(),200);
		
		
		
	}

	 @Test(priority = 2,dataProvider = "username",dataProviderClass = FetchData.class)
	public void testDeleteUser(String username)
	{
		        Response res=   UserEndPoint.deleteUser(username);
		        
		        Assert.assertEquals(res.statusCode(),200);
	}
	
	
	
	

}
