package XCompany.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XCompany.AbstractComponants.AbstractComponant;

public class OrderPage extends AbstractComponant{
	WebDriver driver;
	String ItemName = "ZARA COAT 3";

	
	public OrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)") 	
	List<WebElement> ProductNames;
	
	public Boolean  VerifyOrderDisplayed(String ItemName) {
		Boolean match =ProductNames.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ItemName));
		System.out.println("ProductNames:"+ match);

		return match;
	}
}
