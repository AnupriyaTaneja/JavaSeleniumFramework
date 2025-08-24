package automationtestingframework.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automationtestingframework.pageObjects.CartPage;
import automationtestingframework.pageObjects.CheckOutPage;
import automationtestingframework.pageObjects.ConfirmationPage;
import automationtestingframework.pageObjects.LandingPage;
import automationtestingframework.pageObjects.ProductCatalog;
import automationtestingframework.testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{
	
	public LandingPage landingPageObj;
	public ProductCatalog productCatalogueObj;
	public ConfirmationPage confirmPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommmerce_page() throws IOException, InterruptedException
	{
		landingPageObj=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) throws InterruptedException
	{
		productCatalogueObj= landingPageObj.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogueObj.getProductsList();
		productCatalogueObj.addProductToCart(productName);
	}
	
	@When("^Checkout the (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName)
	{
		CartPage cartPage = productCatalogueObj.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckOutPage checkOutObj = cartPage.goToCheckOut();
		checkOutObj.selectCountry("India");
		confirmPage = checkOutObj.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_confirmationPage(String msg)
	{
		String confirmMsg = confirmPage.getConfirmationMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase(msg));
	}
	
	@Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
   
    	Assert.assertEquals(strArg1, landingPageObj.getErrorMsg());
    	driver.close();
	}
}
