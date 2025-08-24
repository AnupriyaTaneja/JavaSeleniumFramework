import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");//window scrolling
		
		Thread.sleep(3000);
		
		//scrolling inside the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<values.size();i++)
		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Sum of numbers= "+sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());		
		Assert.assertEquals(sum, total);
		
		int sum2= 0;
		List<WebElement> values2 = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		for(int i=0;i<values2.size();i++)
		{
			sum2 = sum2 + Integer.parseInt(values2.get(i).getText());
		}
		System.out.println("Sum of numbers= "+sum2);
		
		
		driver.close();
	}

}
