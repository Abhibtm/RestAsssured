package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManger implements ITestListener {

	public ExtentSparkReporter spartReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onTestStart(ITestResult result) {
		String name=result.getName();
		   test=extent.createTest(name);
		
		
		}

	public void onTestSuccess(ITestResult result) {
		String name=result.getName();
		   test.log(Status.PASS,name+"Passsed");
		   
	}

	public void onTestFailure(ITestResult result) {
		String name=result.getName();
		   test.log(Status.FAIL,name+"Passsed");
		   test.log(Status.FAIL,result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		String name=result.getName();
		   test.log(Status.SKIP,name+"Passsed");
		
	}

	
	public void onStart(ITestContext context) {
	  
		   String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());	
		   repName="Test-Report"+timeStamp+".html";
		   
		   spartReporter = new ExtentSparkReporter(".\\reports\\"+repName);
		   
		   spartReporter.config().setDocumentTitle("RestAssuredAutomationProject");
	       spartReporter.config().setReportName("pet Strore User API");
	       spartReporter.config().setTheme(Theme.DARK);
	       
	       
	       extent = new ExtentReports();
	       extent.attachReporter(spartReporter);
	       extent.setSystemInfo("App","PetStore");
	       extent.setSystemInfo("Operating System", timeStamp);
	       extent.setSystemInfo("UserName","user.name");
	       extent.setSystemInfo("EnVironment","QA");
	       extent.setSystemInfo("User","ABhi");
	    
	
	}

	public void onFinish(ITestContext context) {
            
		extent.flush();
	
	}

}
