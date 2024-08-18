package XCompany.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XCompany.AbstractComponants.AbstractComponant;

public class ProductCatalog extends AbstractComponant{

	
		WebDriver driver;
		public ProductCatalog(WebDriver driver){
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		//PageFactory
		
		@FindBy(css=".mb-3") 	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		List<WebElement> product;
		
		@FindBy(css=".ng-animating") 	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement spinner;
		
		By Products = By.cssSelector(".mb-3");
		By addToCart = By.cssSelector(".card-body button:last-of-type");
		By toastMessage = By.cssSelector("#toast-container");


		
		public List<WebElement> getProductList() throws InterruptedException
		{
			WaitforElementToAppear(Products);
			return product;
		}
		public WebElement getProductByName(String ItemName) throws InterruptedException
		{
			WebElement prod= getProductList().stream().filter(product->
			product.findElement(By.cssSelector("b")).getText().equals(ItemName)).findFirst().orElse(null);			
			
			return prod;
		}
		
		public void addProductToCart(String ItemName) throws InterruptedException {
			
			WebElement ProductName =getProductByName(ItemName);
			ProductName.findElement(addToCart).click();
			WaitforElementToAppear(toastMessage);
			WaitforElementToDisappear(spinner);
			
		}
		
	

}
