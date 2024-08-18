package XCompany.TestCases;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import XCompany.TestComponents.BaseTest;
import XCompany.pageobject.CartPage;
import XCompany.pageobject.CheckOutPage;
import XCompany.pageobject.ConfirmationPage;
import XCompany.pageobject.LandingPage;
import XCompany.pageobject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SandAloneTest extends BaseTest {
	@Test
		
		public void SubmitOrder() throws IOException, InterruptedException {
		
		String ItemName = "ZARA COAT 3";
		
		ProductCatalog productcatalog =new ProductCatalog(driver);
		List<WebElement> products= productcatalog.getProductList();
		productcatalog.addProductToCart(ItemName);
		productcatalog.goToCartPage();
		CartPage CartPageObject = new CartPage(driver);
		CartPageObject.VerifyProductDisplayed(ItemName);
		CartPageObject.goToCheckOut();
		CheckOutPage CheckOutPageObject = new CheckOutPage(driver);
		CheckOutPageObject.CheckOut("India");
		CheckOutPageObject.SubmitOrder();
		ConfirmationPage ConfirmationPageObject = new ConfirmationPage(driver);
		String Confirmmsg =ConfirmationPageObject.GetConfirmationResult();

		
		Assert.assertTrue(Confirmmsg.equalsIgnoreCase("Thankyou for the order."));
// 
		
		//Step 1 : Get all the product list
		//Step 2 :Iterate to all the products in the list and verify for which product this product "Zara Coat is displayed" and then capture the product and then click on Add to cart button
	/**		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));//step 1 **/
		
	/**		WebElement prod= products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(ItemName)).findFirst().orElse(null);			
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); **/
		
	
		/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));			
		 	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); */
		 
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	//Step 3: We need to scan all the items in the My Cart list and search if whatever added to the cart are displaying on the My Cart screen			
	
		/**	List<WebElement> CartProducts= driver.findElements(By.cssSelector(".cartSection h3"));//step 3
				Boolean match =CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ItemName));
				System.out.println(match);

				Assert.assertTrue(match);
				driver.findElement(By.cssSelector(".totalRow button")).click();
		**/
		
	
		//Select country with auto-suggestive drop down
	/*	Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));//wait until complete options are displayed
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click(); */

	//	String ConfirmationText=driver.findElement(By.cssSelector(".hero-primary")).getText();
	}
}
