import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class MiscellaneousChromeOptions {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		//driver.manage().deleteCookieNamed("sessionKey");
		
		//when deleting a cookie, sometimes we get logout
		//steps to automate this: we need to delete the sessionKey, after deleting click on any link on the page then redirect to login page

		
		driver.get("http://google.com");
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\91981\\Downloads\\screenshot.png"));
		driver.close();
	}

}
