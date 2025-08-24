package packTwo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeClass
	public void BeforeMyClass()
	{
		System.out.println("I will execute before all methods in this class-----Before class");
	}
	
	@AfterClass
	public void AfterMyClass()
	{
		System.out.println("I will execute after all methods in this class------After class");
	}
	
	
	@BeforeMethod
	public void UseridGeneration() {
		System.out.println("This block executes Before each Method-----Before Method");
	}

	@BeforeTest
	public void Cookies() {
		System.out.println("This block executes Before all Testcases----Before Test");
		// delete cookies
	}

	@AfterTest
	public void Cookiesclose() {
		System.out.println("This block executes After all Testcases-----After Test");
		// close the browsers
	}

	@AfterMethod
	public void Reportadding() {
		System.out.println("This block executes After each Method-----After Method");
	}

	@Test(timeOut=5000)
	public void OpeningBrowser() {
		// This opens the Browser
		System.out.println("Executing Test 2-----@test");
	}
	
	@Test (enabled=false)
	public void ErrorneousTest() {
		System.out.println("Executing error test-----@test");
	}

	@AfterSuite
	public void SuiteTestAfter()
	{
		System.out.println("I am the last---after suite");
	}
	
	@Test(groups="Smoke")
	public void FlightBooking() {
		System.out.println("Executing Test 1-----@test");
	}

	@Test(dependsOnMethods= {"OpeningBrowser","FlightBooking"})
	public void FlightCancel() {
		System.out.println("Executing Test Priority 2-----@test");
	}
	
	@Parameters("URL")
	@Test
	public void MyMethod(String urlname) {
		System.out.println("Executing method with parameters-----@test");
		System.out.println(urlname);
	}
	
	@Test(dataProvider="getData")
	public void DataProviderTest(String username, String password) {
		System.out.println("Executing method with data provider-----@test");
		System.out.println(username);	
		System.out.println(password);
	}
	
	@Test
	public void Demo()
	{
		System.out.println("This is demo method--------@test");
		Assert.assertTrue(false);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//1st combination - user name, password --good credit history
		//2nd combination - user name, password --no credit history
		//3rd combination - user name, password --fraud credit history
		Object[][] data = new Object[3][2]; //defining array with 3 rows for 3 scenarios mentioned above and 2 columns - user name, password
		
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetpassword";
		
		data[1][0] = "secondsetusername";
		data[1][1] = "secondsetpassword";
		
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdsetpassword";
		
		return data;
	}
	
	@BeforeSuite
	public void SuiteTest()
	{
		System.out.println("I am number one---before suite");
	}

}
