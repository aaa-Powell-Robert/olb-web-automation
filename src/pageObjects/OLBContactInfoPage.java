package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OLBContactInfoPage extends BasePage {
	
	@FindBy(name="zip") WebElement zipField;
	@FindBy(name="email") WebElement emailField;
	@FindBy(xpath="//form/button[@type=\"submit\"]") WebElement submitButton;

	public OLBContactInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public void setTextZipField(String s) {
		zipField.clear();
		zipField.sendKeys(s);
	}

	public void setTextEmailField(String s) {
		emailField.clear();
		emailField.sendKeys(s);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
}
