package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OLBMainPage extends BasePage {
	
	//@FindBy(xpath="//a[contains(@href, '/quote/contact')]") WebElement contactInfo;
	@FindBy(xpath="//a[text()=\"Contact Info\"]") WebElement contactInfo;

	public OLBMainPage(WebDriver driver) {
		super(driver);
		this.PAGE_URL="http://aaa-olb.s3-website-us-west-1.amazonaws.com/";
	}
	
	public void clickContactInfoLink() {
		contactInfo.click();
	}
}
