package XCompany.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import XCompany.AbstractComponants.AbstractComponant;

public class CartPage extends AbstractComponant{
	
	
	//Step 3: We need to scan all the items in the My Cart list and search if whatever added to the cart are displaying on the My Cart screen			
	
	/**	List<WebElement> CartProducts= driver.findElements(By.cssSelector(".cartSection h3"));//step 3
			Boolean match =CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ItemName));
			System.out.println(match);

			Assert.assertTrue(match);
			driver.findElement(By.cssSelector(".totalRow button")).click();
	**/
	
	WebDriver driver;
	String ItemName = "ZARA COAT 3";

	
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3") 	
	List<WebElement> CartProducts;
	
	@FindBy(css=".totalRow button") 	
	WebElement CheckOutElement;
	
	
	public Boolean  VerifyProductDisplayed(String ItemName) {
		Boolean match =CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ItemName));
		System.out.println(match);

		return match;
	}
	
	public void goToCheckOut() {
		CheckOutElement.click();
	}

}
