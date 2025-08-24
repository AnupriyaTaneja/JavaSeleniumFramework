import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesAssignment7 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		//List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tbody tr"));
		//System.out.println("Total number of rows in the table=" + rows.size());
		System.out.println("Total rows: "+ driver.findElements(By.cssSelector(".table-display tbody tr")).size());
		System.out.println("Total columns: "+ driver.findElements(By.cssSelector(".table-display tbody tr th")).size());
		
		List<WebElement> data = driver.findElements(By.cssSelector(".table-display tbody tr:nth-child(3)"));
		//.table-display tbody tr:nth-child(3) td:nth-child(1)
		
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
		}
		
		
		driver.close();

	}

}
