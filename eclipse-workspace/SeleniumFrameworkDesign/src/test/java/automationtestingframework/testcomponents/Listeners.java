package automationtestingframework.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationtestingframework.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread safe -> each object creation will have its own thread, 
																		//so it won't interrupt other overriding variable
	
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//sets unique thread id of (ErrorValidationTest) and creates a mapping with test object
	}
	
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		//test.log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//take screenshot, and attach to report
		String filepath = null;
		try 
		{
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
