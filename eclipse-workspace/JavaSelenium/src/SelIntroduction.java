import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// Invoking the browser
		// Selenium Manager
		//for chrome download chromedriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91981\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//for firefox download geckodriver
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\91981\\OneDrive\\Documents\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//similarly for edge download edge driver & use setproperty method, then set driver object to EdgeDriver
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close();//closes only current window which gets opened by Selenium test
		//driver.quit();//closes all open associated windows which gets opened by Selenium test
		//if script opens multiple windows then use quit
	}

}
