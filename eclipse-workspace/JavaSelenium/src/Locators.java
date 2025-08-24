import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91981\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait - mention the time in seconds for execution to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //applicable throughout the program not just this line
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("APT");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		
		//<p class="error" xpath="1">* Incorrect username or password </p>
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//<a href="#" xpath="1">Forgot your password?</a>
		driver.findElement(By.linkText("Forgot your password?")).click();
		//driver.findElement(By.partialLinkText("Forgot ")).click();

		Thread.sleep(1000);
		
		//<input type="text" placeholder="Name" fdprocessedid="38krnq" xpath="1">
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("APT");
		
		//<input type="text" placeholder="Email" fdprocessedid="ut68nx" xpath="1">
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@xyz.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();//indexing is not preferred, use only when there is no unique attribute
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("xyz@abc.com");

		//<input type="text" placeholder="Phone Number" fdprocessedid="7aq4cqf" xpath="1">
		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("1234567890");
		
		//<button class="reset-pwd-btn" fdprocessedid="wgokui" xpath="1">Reset Login</button>
		//driver.findElement(By.className("reset-pwd-btn")).click();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); //or tagname.classname --> "button.reset-pwd-btn"
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//<button class="go-to-login-btn" fdprocessedid="rwjvrj" xpath="1">Go to Login</button>
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("APT");
		driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(1000);
		//<div class="login-container" xpath="1"><h2>Hello APT,</h2><h1>Welcome to <strong style="color: rgb(255, 75, 43);">Rahul Shetty 
		//</strong>Academy</h1><p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.
		//</p><button class="logout-btn" fdprocessedid="4k5qm">Log Out</button></div>
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h1")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
		
		driver.close();
		
	}

}
