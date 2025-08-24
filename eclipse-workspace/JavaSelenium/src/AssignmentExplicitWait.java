import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AssignmentExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='user']"))).click();
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();


		//driver.findElement(By.cssSelector("span.radiotextsty")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-body")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();
		WebElement element = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.id("signInBtn")).click();
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-lg-9")));
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-sm-12 col-md-10 col-md-offset-1")));*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		for(int i =0;i<products.size();i++)
		{
		products.get(i).click();
		}

		driver.findElement(By.partialLinkText("Checkout")).click();
		
		System.out.println("All items added successfully!");
		driver.close();
	}

}
