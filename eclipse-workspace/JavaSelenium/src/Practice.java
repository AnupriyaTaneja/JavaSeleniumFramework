import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoblaze.com");

        /*driver.findElement(By.id("signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        driver.findElement(By.id("sign-username")).sendKeys("Testuser345");
        driver.findElement(By.id("sign-password")).sendKeys("Testuser345");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        
        wait.until(ExpectedConditions.alertIsPresent());
        Alert signupAlert = driver.switchTo().alert();
        System.out.println("Signup Alert: " + signupAlert.getText());
        signupAlert.accept();
*/
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys("Testuser345");
        driver.findElement(By.id("loginpassword")).sendKeys("Testuser345");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-success btn-lg']")));
        addToCartBtn.click();

        // Handle "Product added" alert
        wait.until(ExpectedConditions.alertIsPresent());
        Alert addCartAlert = driver.switchTo().alert();
        System.out.println("Add to cart Alert: " + addCartAlert.getText());
        addCartAlert.accept();

        // Go to Cart
        driver.findElement(By.id("cartur")).click();

        // Wait until the cart table loads (wait for product row to appear)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr")));

        // Now fetch the product name and price
        WebElement productNameCell = driver.findElement(By.xpath("//tbody/tr/td[2]")); // 2nd column = product name
        WebElement productPriceCell = driver.findElement(By.xpath("//tbody/tr/td[3]")); // 3rd column = price

        System.out.println("Product in Cart: " + productNameCell.getText());
        System.out.println("Price: $" + productPriceCell.getText());

        // Now click "Place Order"
        WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
        placeOrder.click();

        // Fill in order details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Testuser345");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Delhi");
        driver.findElement(By.id("card")).sendKeys("1234123412341234");
        driver.findElement(By.id("month")).sendKeys("Feb");
        driver.findElement(By.id("year")).sendKeys("2026");

        // Click Purchase
        driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();

        // Wait for confirmation dialog
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sweet-alert  showSweetAlert visible']")));
        System.out.println("Order Confirmation:\n" + confirmation.getText());

        // Click OK on confirmation
        WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
        okButton.click();

        // Close the browser
        driver.quit();
    }
}