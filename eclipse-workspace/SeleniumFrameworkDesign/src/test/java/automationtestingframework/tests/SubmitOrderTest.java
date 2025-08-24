package automationtestingframework.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationtestingframework.pageObjects.CartPage;
import automationtestingframework.pageObjects.CheckOutPage;
import automationtestingframework.pageObjects.ConfirmationPage;
import automationtestingframework.pageObjects.OrdersPage;
import automationtestingframework.pageObjects.ProductCatalog;
import automationtestingframework.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest{
	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{	
		
		ProductCatalog productCatalogueObj= landingPageObj.loginApplication(input.get("email"), input.get("password"));
		Thread.sleep(2000);
		List<WebElement> products = productCatalogueObj.getProductsList();
		//productCatalogueObj.getProductsList();
		productCatalogueObj.addProductToCart(input.get("product"));
		
		CartPage cartPage = productCatalogueObj.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		CheckOutPage checkOutObj = cartPage.goToCheckOut();
		checkOutObj.selectCountry("India");
		ConfirmationPage confirmPage = checkOutObj.submitOrder();

		String confirmMsg = confirmPage.getConfirmationMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods="submitOrder")
	public void OrderHistoryTest() throws IOException, InterruptedException
	{
	    ProductCatalog productCatalogueObj= landingPageObj.loginApplication("anupriya.taneja@gmail.com", "Jobinaug@2025");
		OrdersPage ordersPage = productCatalogueObj.goToOrderPage();
		Assert.assertTrue(ordersPage.VerifyOrderCodeDisplay(productName));
	}	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+"\\src\\test\\java\\automationtestingframework\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
/*	@DataProvider
	public Object[][] getData() throws IOException
	{
		HashMap <String,String> map = new HashMap <String,String>();
		map.put("email", "anupriya.taneja@gmail.com");
		map.put("password", "Jobinaug@2025");
		map.put("product", "ZARA COAT 3");
		
		HashMap <String,String> map1 = new HashMap <String,String>();
		map1.put("email", "shetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
	}*/
	
	 //@DataProvider
//	  public Object[][] getData()
//	  {
//	    return new Object[][]  {{"anupriya.taneja@gmail.com","Jobinaug@2025","ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL" } }

//		}
	
	
	
}
