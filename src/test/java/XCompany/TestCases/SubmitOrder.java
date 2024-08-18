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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import XCompany.TestComponents.BaseTest;
import XCompany.pageobject.CartPage;
import XCompany.pageobject.CheckOutPage;
import XCompany.pageobject.ConfirmationPage;
import XCompany.pageobject.LandingPage;
import XCompany.pageobject.OrderPage;
import XCompany.pageobject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrder extends BaseTest {
	String ItemName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups={"Purchase"})
		
		public void submitOrder(String UserName,String Password,String ItemName) throws IOException, InterruptedException {
		
		LandingPage landingPage = launchApplication();
		landingPage.URL();
		ProductCatalog productcatalog =	landingPage.LoginApplication(UserName, Password);

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

	}
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistory() {
		ProductCatalog productcatalog =	landingPage.LoginApplication("Sumayya2716@gmail.com", "Sumayya12");
		OrderPage ordername = productcatalog.goToOrdersPage();
		Assert.assertTrue(ordername.VerifyOrderDisplayed(ItemName));

	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {{"Sumayya2716@gmail.com","Sumayya12","ZARA COAT 3"} , {"Sumayya2716@gmail.com","Sumayya12","ADIDAS ORIGINAL"}};
	}
}
