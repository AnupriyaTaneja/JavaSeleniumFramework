import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("APT");
		//driver.findElement(By.xpath("//input[@class='form-control ng-dirty ng-valid ng-touched']")).sendKeys("test@123.com");
		
		driver.findElement(By.name("name")).sendKeys("APT");
		driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test123");
		driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select (dropdown);
		gender.selectByVisibleText("Female");
		
		driver.findElement(By.cssSelector("input[id='inlineRadio1']")).click();
		
		driver.findElement(By.cssSelector("input[class='form-control']")).sendKeys("11-11-1880");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String successMsg = driver.findElement(By.cssSelector(".alert-success")).getText();
		System.out.println(successMsg);
	}

}
