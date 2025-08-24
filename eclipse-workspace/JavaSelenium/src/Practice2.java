import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6")));
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Samsung galaxy s6")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Add to cart")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("cartur")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
        
        //wait.until(ExpectedConditions.alertIsPresent());
      //  driver.switchTo().alert();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='name']")))).sendKeys("ABC");
       // driver.findElement(By.cssSelector("input[id='name']")).sendKeys("ABC");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='country']")))).sendKeys("India");
       // driver.findElement(By.cssSelector("input[id='country']")).sendKeys("India");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='city']")))).sendKeys("Delhi");
//        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Delhi");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='card']")))).sendKeys("1234123412341234");
        //driver.findElement(By.cssSelector("input[id='card']")).sendKeys("1234123412341234");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='month']")))).sendKeys("Feb");
        //driver.findElement(By.cssSelector("input[id='month']")).sendKeys("Feb");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id='year']")))).sendKeys("2026");
        //driver.findElement(By.cssSelector("input[id='year']")).sendKeys("2026");
        
        
        driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
        
        System.out.println(driver.findElement(By.xpath("//div[@class = 'sweet-alert  showSweetAlert visible']")).getText());
        //System.out.println(driver.findElement(By.xpath("div.sweet-alert.showSweetAlert.visiblep")).getText());
        //wait.until(ExpectedConditions.alertIsPresent());
       // Alert confirmorder = driver.switchTo().alert();
        //System.out.println(confirmorder.getText());
        //confirmorder.accept();
        
        driver.quit();
	
	}

}
