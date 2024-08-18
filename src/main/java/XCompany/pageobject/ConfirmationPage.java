package XCompany.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import XCompany.AbstractComponants.AbstractComponant;

public class ConfirmationPage  extends AbstractComponant {
	
	/*String ConfirmationText=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(ConfirmationText.equalsIgnoreCase("Thankyou for the order."));*/
	

WebDriver driver;
	
	public ConfirmationPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary") 	
	WebElement ConfirmationText;
	
	
	public String GetConfirmationResult() {
		
		return ConfirmationText.getText();
}
}