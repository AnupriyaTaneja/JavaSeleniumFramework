import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		driver.findElement(By.cssSelector("input.a-button-input")).click();
        //driver.navigate().refresh();
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		WebElement element = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
		a.moveToElement(element).contextClick().build().perform();
		
		
		System.out.println("All good!");
		driver.close();
	}

}
