package XCompany.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XCompany.AbstractComponants.AbstractComponant;

public class LandingPage extends AbstractComponant {

	
		WebDriver driver;
		public LandingPage(WebDriver driver){
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		//PageFactory
		@FindBy(id="userEmail") 	//WebElement UserEmail = driver.findElement(By.id("userEmail"));
		WebElement UserEmail;
		@FindBy(id="userPassword") 	//WebElement UserPassword = driver.findElement(By.id("userPassword"));
		WebElement UserPassword;
		@FindBy(id="login") 	
		WebElement Submit;
		
		@FindBy(css="[class*='flyInOut'") 	
		WebElement errorMessage;
		
		public ProductCatalog LoginApplication(String email ,String  Password) {
			UserEmail.sendKeys(email);
			UserPassword.sendKeys(Password);
			Submit.click();
			ProductCatalog productcatalog = new ProductCatalog(driver);
			return productcatalog;
		}
		
		public String geterrormessage() {
			WaitforWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		
		public void URL()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		

	

}
