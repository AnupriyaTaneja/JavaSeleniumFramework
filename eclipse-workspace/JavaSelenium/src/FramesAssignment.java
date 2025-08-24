import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame(0);
		//driver.findElement(By.xpath("//frameset[@name='frameset-middle']"));
		//System.out.println(driver.findElement(By.xpath("//frameset[@name='frame-middle']")).getText());
		driver.switchTo().frame(1);
	    String middleText = driver.findElement(By.id("content")).getText();
	    System.out.println(middleText);
	    
	    driver.close();
	}

}
