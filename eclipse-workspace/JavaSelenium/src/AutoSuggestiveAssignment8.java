import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveAssignment8 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		WebElement e = driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input"));
		e.sendKeys("uni");
		
		while (!e.getAttribute("value").equals("United Kingdom (UK)"))
		{
		e.sendKeys(Keys.DOWN);
		//break;
		}
		e.sendKeys(Keys.ENTER);

		System.out.println("Country selected: "+ e.getAttribute("value"));	
		
		driver.close();
	}

}
