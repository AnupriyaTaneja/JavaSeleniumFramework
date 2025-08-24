import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class CheckboxDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// 1. select any checkbox -> 2. grab the label of the checkbox -> 3. select the option from dropdown based on the checkbox selected
		//do not hard code the label, get the dropdown option dynamically.
		//4. once done, enter the text of the label in step 2. in the enter your name text box
		//5. click on Alert and then verify if label text grabbed in step 2. is present in the pop up
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
		String checkBoxText = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println("Selected checkbox text is : " + checkBoxText);
		
		WebElement element = driver.findElement(By.cssSelector("select#dropdown-class-example"));
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(checkBoxText);
		
		driver.findElement(By.xpath("//input[@class='inputs']")).sendKeys(checkBoxText);
		
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertTrue(alert.getText().contains(checkBoxText));
		System.out.println(alert.getText());
		
		alert.accept();
		
		driver.close();
	}

}
