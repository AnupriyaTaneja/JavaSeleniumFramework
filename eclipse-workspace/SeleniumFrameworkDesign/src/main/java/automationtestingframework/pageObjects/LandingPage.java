package automationtestingframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationtestingframework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);//sends the driver info to the AbstractComponents parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//writing the same step above with PageFactory
	@FindBy(id="userEmail")
	WebElement userEmailId;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;	
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errorMsg;
	
	public ProductCatalog loginApplication(String email, String pwd) throws InterruptedException
	{
		userEmailId.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
	//	waitForElementToDisappear(errorMsg);
		ProductCatalog productCatalogueObj = new ProductCatalog(driver);
		return productCatalogueObj;
	}
	
	public String getErrorMsg()
	{
		waitForWebElementToAppear(errorMsg);
		System.out.println(errorMsg.getText());
		return errorMsg.getText();
	}
		
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
