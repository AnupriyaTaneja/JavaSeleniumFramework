import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");

/*		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);*/
		
		List <WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		for(WebElement link: links) 
		{
			
			//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode<400,"The link with text "+link.getText()+" is broken with code "+responseCode);
			/*if(responseCode>=400) 
			{
				System.out.println("The link with text "+link.getText()+" is broken with code "+responseCode);
				Assert.assertTrue(false);//hard assertion - stops script from running further as soon as failure occurs
			}*/
			
		}
		a.assertAll();//if any failures, then this will fail the script; if no failures then this passes your script
		//catches all failures & reports all of them only at the end of execution to tell which ones failed
		
		driver.close();
	}

}
