import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "APT";
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait - mention the time in seconds for execution to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //applicable throughout the program not just this line
		
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("APT");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		//<p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;" xpath="1">You are successfully logged in.</p>
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in."); 
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+ name + ",");
		//System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h1")).getText());
		//System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
	
		//<button class="logout-btn" fdprocessedid="4k5qm" xpath="1">Log Out</button>
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();//or (By.xpath("//*[text()='Log Out']"))
		
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException
	{
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String passwordText =driver.findElement(By.cssSelector("form p")).getText();
	//Please use temporary password 'rahulshettyacademy' to Login.
	String[] passwordArray = passwordText.split("'");
	// String[] passwordArray2 = passwordArray[1].split("'");
	// passwordArray2[0]
	String password = passwordArray[1].split("'")[0];
	return password;

	//0th index - Please use temporary password
	//1st index - rahulshettyacademy' to Login.


	//0th index - rahulshettyacademy
	//1st index - to Login.

	}
}
