import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Practice3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
/*		driver.findElement(By.linkText("Signup / Login")).click();
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-qa='signup-name']")));
		driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("username101");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-qa='signup-email']")));
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("username101@test.com");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
		driver.findElement(By.xpath("//button[text()='Signup']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("uniform-id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys("demo123");
		
		Select nameDropdown = new Select(driver.findElement(By.id("days")));
		nameDropdown.selectByVisibleText("10");
		
		Select monthDropdown = new Select(driver.findElement(By.id("months")));
		monthDropdown.selectByVisibleText("May");
		
		Select yearDropdown = new Select(driver.findElement(By.id("years")));
		yearDropdown.selectByVisibleText("1975");

		
		driver.findElement(By.id("first_name")).sendKeys("ABCuser");
		driver.findElement(By.id("last_name")).sendKeys("XYZ");
		driver.findElement(By.id("address1")).sendKeys("213, 1234, exfs co");
		
		Select countryDropdown = new Select (driver.findElement(By.id("country")));
		countryDropdown.selectByVisibleText("Canada");
		
		driver.findElement(By.id("state")).sendKeys("Ontario");
		driver.findElement(By.id("city")).sendKeys("Missisauga");
		driver.findElement(By.id("zipcode")).sendKeys("4564");
		driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		
//		driver.switchTo().alert().dismiss();
		
		System.out.println(driver.findElement(By.cssSelector("div.col-sm-9.col-sm-offset-1")).getText());
		
		driver.findElement(By.linkText("Continue"));
		
		driver.findElement(By.linkText("Signup / Login")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("username101@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("demo101");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		*/
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		//driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("(//p[contains(text(),'Men Tshirt')])[1]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")));
		driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
		
		//wait.until(ExpectedConditions.alertIsPresent());
		//<p class="text-center">Your product has been added to cart.</p>
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//driver.close();
	}

}
