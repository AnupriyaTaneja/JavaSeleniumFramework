import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException  {
		//1. Count the number of links on the page
		//a -> find the tags with anchor tag
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Count of total number of links on the page: " + driver.findElements(By.tagName("a")).size());
		
		//2. Count the number of links on the footer section
		//Limiting the scope of driver to only the footer section by creating a new sub driver web element specific to that section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Count of total number of links on the footer of the page: " + footerDriver.findElements(By.tagName("a")).size());

		//3. Count the number of links only in the first section of the footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Count of total number of links on the 1st column of the footer of the page: " + columnDriver.findElements(By.tagName("a")).size());
		
		//4. click on each link in the column and check if the pages are opening
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		
		//int num = columnDriver.findElements(By.tagName("a")).size() - 1;
		//System.out.println("All the "+ num + " links opened successfully");
		}
		//5. opens all the tabs and print the page title for each of them
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
				
		while(it.hasNext())//hasNext() tells whether next index is present or not
			{			
			   driver.switchTo().window(it.next());//next() actually moves to the next tab when the next page index is present
			   System.out.println(driver.getTitle());
				
			}
		

		driver.quit();
	}

}
