import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningNewWindow {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		
		driver.switchTo().newWindow(WindowType.TAB);// opens blank new tab
		//driver.switchTo().newWindow(WindowType.WINDOW); // opens blank new window
	
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentWindowId = it.next();//points to 0th index, which is the parent window id
		String secondWindowId = it.next();

		driver.switchTo().window(secondWindowId);
		driver.get("https://rahulshettyacademy.com");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		driver.switchTo().window(parentWindowId);
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		File file = name.getScreenshotAs(OutputType.FILE);//taking partial screenshots or screenshots only for a particular element
		FileUtils.copyFile(file, new File ("logo.png"));
	
		//Get height & width of web element
		System.out.println(name.getRect().getDimension().height);
		System.out.println(name.getRect().getDimension().width);
		
		
		driver.quit();
		
	}

}
