package XCompany.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import XCompany.AbstractComponants.AbstractComponant;

public class CheckOutPage extends AbstractComponant{
	
	//Select country with auto-suggestive drop down
/*	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));//wait until complete options are displayed
	
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click(); */
	
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']") 	
	WebElement selectCountry;
	
	@FindBy(xpath="(//button[@type='button'])[2]") 	
	WebElement SelectCountryIndia;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted") 	
	WebElement Submit;
	
	By WaitingEle = By.cssSelector(".ta-results");
	
	@FindBy(css="li[class='totalRow'] button[type='button']") 	
	WebElement CheckOutButton;
	
	
	public void CheckOut(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, countryName).build().perform();
		
		WaitforElementToAppear(WaitingEle);//wait until complete options are displayed
		
		SelectCountryIndia.click();
	}
	
	public void ClickCheckOUtButton() {
		CheckOutButton.click();
	}
	public void SubmitOrder() {
		Submit.click();
	}
	

}
