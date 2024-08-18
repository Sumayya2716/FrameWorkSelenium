package XCompany.AbstractComponants;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import XCompany.pageobject.OrderPage;

public class AbstractComponant {
	
	WebDriver driver;

	


	public AbstractComponant(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']") 	
	WebElement CartIcon;
	
	@FindBy(css="[routerlink*='myorders']") 	
	WebElement OrderHeader;
	

	
	public void WaitforElementToAppear(By FindBy)  // here By is the datatype of the By.cssSelector(".mb-3")
	{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void WaitforWebElementToAppear(WebElement FindBy)  // here By is the datatype of the By.cssSelector(".mb-3")
	{

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	

	public void goToCartPage() {
		CartIcon.click();
	}
	
	public OrderPage goToOrdersPage() {
		OrderHeader.click();
		OrderPage order = new OrderPage(driver);
		return order;
	}

	public void WaitforElementToDisappear(WebElement ele)  // here By is the datatype of the By.cssSelector(".mb-3")
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
