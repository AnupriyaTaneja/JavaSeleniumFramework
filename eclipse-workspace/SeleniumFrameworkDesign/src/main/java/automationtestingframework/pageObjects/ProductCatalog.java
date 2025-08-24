package automationtestingframework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationtestingframework.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
//	@FindBy(css=".ng-animating")
	@FindBy(css=".ngx-spinner-overlay")
	WebElement spinner;
	
	By prods = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");// add to cart button for the ZARA COAT product only
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(prods);
		return products;
	}
	
	public WebElement getProductByName(String prodName)
	{
		WebElement prd = getProductsList().stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst()
				.orElse(null);

		return prd;																					
	}
	
	public void addProductToCart(String prod) throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement prd = getProductByName(prod);
	   // JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("arguments[0].scrollIntoView(true);", prd);
	      ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '75%'");
		prd.findElement(addToCart).click();// add to cart button for the ZARA COAT product only
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
	}
	
}
