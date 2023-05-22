package api.endpoints;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class DemoDate {
	
	@Test
	public void m1()
	{
		String date = new SimpleDateFormat("yyyy.MM.dd ").format(new Date());
		System.out.println(date);
		
		System.out.println(System.getProperty("os.name"));
	}

}
