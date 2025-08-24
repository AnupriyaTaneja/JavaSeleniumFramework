import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;

public class CalenderTest {

	public static void main(String[] args) {
		
		String month = "7";
		String day = "12";
		String year = "2027";
		String[] expectedList = {month,day,year};
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		//as the index will start from 0, so month-1 will select 6th index which will be July(7)

		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		//System.out.println(driver.findElement(By.className("react-date-picker__inputGroup")).getText());

		List <WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for (int i=0; i<actualList.size(); i++)
		{
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}

		driver.close();
	}

	

}
