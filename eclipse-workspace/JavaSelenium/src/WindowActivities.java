import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");//there is in-built wait here, selenium will wait until page is ready
		driver.navigate().to("https://rahulshettyacademy.com/");//no waiting
		driver.navigate().back();
		driver.navigate().forward();
	}

}
