package automationtestingframework.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationtestingframework.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPageObj;
	
	public WebDriver initializeDriver() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\automationtestingframework\\resources\\GlobalData.properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//automationtestingframework//resources//GlobalData.properties");
		prop.load(fis);
		//java ternary operator ---> condition ? execute in case cond is true : execute when cond is false
		//condition is true (browser value is not null) so it is taking value from maven ; if false then take value from GlobalData.properties
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser"); 
		
		//prop.getProperty("browser");
		
		if (browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			if(browserName.contains("headless"))
			{
				  options.addArguments("--headless=new"); // use new headless mode
				  Thread.sleep(5000);
	      options.addArguments("--window-size=1440,900"); // set size via ChromeOptions
		    options.addArguments("--disable-gpu");
			      options.addArguments("--no-sandbox");
			      options.addArguments("--disable-dev-shm-usage");
		//		options.addArguments("--headless");
			}
			// Only maximize if NOT headless
	/*   if (!browserName.contains("headless")) {
		        driver.manage().window().maximize();
		    }*/
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
			// Only maximize if NOT headless
		  
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//String to Hashmap Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data;		
		
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File (System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		landingPageObj = new LandingPage(driver);
		landingPageObj.goTo();
		return landingPageObj;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.quit();
	}
	
	
}
