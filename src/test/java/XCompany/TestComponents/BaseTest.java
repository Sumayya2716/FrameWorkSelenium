package XCompany.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import XCompany.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;

	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException {
		

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/sumay/eclipse-workspace/FrameWorkSelenium/src/main/java/XCompany/resources/GlobalData.Properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//XCompany//TestComponents//BaseTest.java");
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeTest(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		 driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
			landingPage.URL();
			landingPage.LoginApplication("Sumayya2716@gmail.com", "Sumayya12");
			return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();

	}
}
