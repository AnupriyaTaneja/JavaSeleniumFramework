import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoBlaze{
	
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[id='signin2']")).click();
		String name = "admin54640";
		String password = "admin54640";
		driver.findElement(By.id("sign-username")).sendKeys(name);
		driver.findElement(By.id("sign-password")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@onclick='register()']")).click();
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.alertIsPresent());
		
		Alert a = driver.switchTo().alert();
		//if((a.getText()).equals("This user already exist."))
		//{
			//a.accept();
		//}
		//else
		//{
			System.out.println(a.getText());
			a.accept();
		//}
		
		WebDriverWait waitClose = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitClose.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='signInModal']//button[text()='Close']")));
			
//		driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
		driver.findElement(By.xpath("//div[@id='signInModal']//button[text()='Close']")).click();
			
		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		WebDriverWait waitLoad = new WebDriverWait(driver,Duration.ofSeconds(10));
		waitLoad.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		driver.findElement(By.xpath("//a[text()='Nokia lumia 1520']")).click();
		Thread.sleep(3000);
		System.out.println("Item name: "+ driver.findElement(By.xpath("//div/h2")).getText());
		System.out.println("Item price: "+ driver.findElement(By.xpath("//div/h3")).getText());
		System.out.println("Item description: "+ driver.findElement(By.cssSelector("h3.price-container")).getText());
		
		driver.findElement(By.cssSelector("a.btn.btn-success.btn-lg")).click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.alertIsPresent());
		
		Alert b = driver.switchTo().alert();
		System.out.println(b.getText());
		b.accept();
		
		driver.findElement(By.cssSelector("a[id='cartur']")).click();
		Thread.sleep(3000);
		System.out.println("Item name in cart: "+ driver.findElement(By.xpath("//tbody/tr/td[2]")).getText());
		System.out.println("Item price in cart: "+ driver.findElement(By.xpath("//tbody/tr/td[3]")).getText());
		
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("1234123412341234");
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("Feb");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2027");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
		//System.out.println(driver.switchTo().alert().getText());
		System.out.println(driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']")).getText());
		System.out.println(driver.findElement(By.cssSelector("p.lead.text-muted")).getText());

		
		driver.close();
		
		
	}
}