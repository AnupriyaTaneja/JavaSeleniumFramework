package automationtestingframework.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationtestingframework.pageObjects.CartPage;
import automationtestingframework.pageObjects.ProductCatalog;
import automationtestingframework.testcomponents.BaseTest;
import automationtestingframework.testcomponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups="ErrorHandling",retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
		landingPageObj.loginApplication("anupriya.taneja@gmail.com", "incorrectpass");
		//Assert.assertEquals("Incorrect eail or password.", landingPageObj.getErrorMsg());
		Assert.assertEquals("Incorrect email or password.", landingPageObj.getErrorMsg());

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		ProductCatalog productCatalogueObj = landingPageObj.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogueObj.getProductsList();
		productCatalogueObj.addProductToCart(productName);

		CartPage cartPage = productCatalogueObj.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 32");
		Assert.assertFalse(match);
	}
}
