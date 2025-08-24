import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all web elements in a list
		List <WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all web elements into a new list -> originalList
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the list of step 3 -> sortedList
		List<String> sortedList= originalList.stream().sorted().collect(Collectors.toList());
		
		//compare originalList with sortedList
		Assert.assertTrue(originalList.equals(sortedList)); //returns true if they both are equal
		
		System.out.println(originalList.equals(sortedList));
		
		//How to print price of a particular item (Beans) in the list:
		//scan the name column with get text -> once the item name (Beans) is found then print the price of that particular vegetable
		/*List <String> price= elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s))
				.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));*/
		List <String> price;
		
		do
		{
			List <WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price= rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}
		while(price.size()<1);
		
		
		driver.close();
	}

	private static String getPriceVeggie(WebElement s) 
	{
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); 
		// The list already has path - //tr/td[1] so we only apply the following-sibling::td[1]
		return priceValue;
	}

}
