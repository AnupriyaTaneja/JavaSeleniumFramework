import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2e {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com"); // URL in the browser
		driver.findElement(By.xpath("//div[contains(text(),'one way')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		Thread.sleep(2000);
		//Click 'From'
		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[text()='DEL']")).click();

		//Click 'To'
		driver.findElement(By.xpath("//div[contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//div[text()='MAA']")).click();

		driver.findElement(By.cssSelector(
				".css-1dbjc4n r-1awozwy r-19m6qjp r-156aje7 r-y47klf r-1phboty r-1d6rzhh r-1pi2tsx r-1777fci r-13qz1uu"))
				.click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(2000L);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		// driver.findElement(By.xpath("//input[@value='Search']")).click();
		// driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}

}