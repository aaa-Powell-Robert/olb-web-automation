package test.java.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.java.pageObjects.OLBContactInfoPage;
import test.java.pageObjects.OLBMainPage;
import test.java.utilities.DriverFactory;
import test.java.utilities.DriverFactory.BrowserType;

public class SimpleLoginTest {
	public WebDriver driver;
	
	OLBMainPage olbMainPage;
	OLBContactInfoPage olbContactInfoPage;
	
	@BeforeTest
	public void setup() {
		this.driver = DriverFactory.getDriver(BrowserType.CHROME);
		olbMainPage = PageFactory.initElements(driver,  OLBMainPage.class);
		olbContactInfoPage = PageFactory.initElements(driver,  OLBContactInfoPage.class);
	}

	@Test
	public void testLoginPage() {
		olbMainPage.loadPage();
		System.out.println("olbMainPage Title:" + olbMainPage.driver.getTitle());
		olbMainPage.clickContactInfoLink();

		// olbContactInfoPage.loadPage();
		System.out.println("olbContactInfoPage Title:" + olbContactInfoPage.driver.getTitle());
		
		olbContactInfoPage.setTextZipField("90210");
		olbContactInfoPage.setTextEmailField("test@aaa-calif.com");
		olbContactInfoPage.clickSubmit();
	}
	
	@AfterClass (alwaysRun=true)
	public void cleanup() {
		driver.close();
		driver.quit();
	}

}
