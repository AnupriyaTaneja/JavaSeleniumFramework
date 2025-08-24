import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

public class WebTableFilter {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList = veggies.stream().filter(veg -> veg.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filteredList.size());
		System.out.println(veggies.size());
		System.out.println(filteredList.size());
		driver.close();
	}
}
