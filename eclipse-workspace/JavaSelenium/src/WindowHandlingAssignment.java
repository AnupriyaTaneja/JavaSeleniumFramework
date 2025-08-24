import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;

public class WindowHandlingAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		//driver.switchTo().window(secondWindow);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String secondWindow = it.next();
		
		//String thirdWindow = it.next();
		driver.switchTo().window(secondWindow);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		
		driver.quit();
	}

}
