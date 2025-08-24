import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		//Proxy server:
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);

		//to set the default directory where the file downloaded will be saved when chrome downloads a file:
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		options.setAcceptInsecureCerts(true);//ssl issues will get automatically handled will be taken care as we are setting this property to true
				
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());
		
		driver.close();

	}

}