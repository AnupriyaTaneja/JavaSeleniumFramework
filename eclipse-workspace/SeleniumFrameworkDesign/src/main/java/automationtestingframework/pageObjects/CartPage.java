package automationtestingframework.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationtestingframework.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOut()
	{
		checkout.click();
		return new CheckOutPage(driver);
	}
	
}
