package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public String PAGE_URL;
	public String PAGE_TITLE;
	public WebDriver driver;  		
	public WebDriverWait wait; 		//explicit wait driver
	public FluentWait<WebDriver> fluentWait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;	
        wait = new WebDriverWait(driver,15);
        fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.pollingEvery(250, TimeUnit.MILLISECONDS);
        fluentWait.withTimeout(10, TimeUnit.SECONDS);
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.ignoring(WebDriverException.class);
        fluentWait.ignoring(StaleElementReferenceException.class);
	}
	
	public void loadPage() {
		driver.get(getPageURL());
	}
		
	public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 5) {
            try {
            	WebElement e = driver.findElement(by);
    			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
       			e.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            } catch (WebDriverException e) {
            } catch (NoSuchElementException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public boolean retryingFindAndSelectClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 5) {
            try {
            	WebElement e = driver.findElement(by);
    			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
        		if (!e.isSelected()) {
        			e.click();
        		}
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            } catch (WebDriverException e) {
            } catch (NoSuchElementException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public boolean retryingFindAndDeselectClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 5) {
            try {
            	WebElement e = driver.findElement(by);
    			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
        		if (e.isSelected()) {
        			e.click();
        		}
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            } catch (WebDriverException e) {
            } catch (NoSuchElementException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public void clickElement(WebElement e) {
		e.click();
	}

	// Buttons and radio buttons in the Claim application sometimes show as clickable and then not, as the page gets loaded or reloaded.
	// This method is meant to ensure that these elements get clicked without throwing ugly exceptions about being stale or not clickable.
	private void clickTrickyElement(WebElement e) {
		// Do multiple fluent waits and then multiple retries, for elements that go back and forth on being clickable as the page is redrawn
		fluentWait.until(ExpectedConditions.elementToBeClickable(e));
		fluentWait.until(ExpectedConditions.elementToBeClickable(e));
		try
		{
			e.click();
		}
		catch (StaleElementReferenceException exception)
		{
			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
			try
			{
				e.click();
			}
			catch (StaleElementReferenceException exception2)
			{
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				try
				{
					e.click();
				}
				catch (StaleElementReferenceException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
				catch (WebDriverException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
			}
			catch (WebDriverException exception2)
			{
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				try
				{
					e.click();
				}
				catch (StaleElementReferenceException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
				catch (WebDriverException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
			}
		}
		catch (WebDriverException exception)
		{
			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
			try
			{
				e.click();
			}
			catch (StaleElementReferenceException exception2)
			{
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				try
				{
					e.click();
				}
				catch (StaleElementReferenceException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
				catch (WebDriverException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
			}
			catch (WebDriverException exception2)
			{
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				fluentWait.until(ExpectedConditions.elementToBeClickable(e));
				try
				{
					e.click();
				}
				catch (StaleElementReferenceException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
				catch (WebDriverException exception3)
				{
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					fluentWait.until(ExpectedConditions.elementToBeClickable(e));
					e.click();
				}
			}
		}
	}
	
	public void selectRadioButton(WebElement e) {
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		if (!e.isSelected()) {
			clickTrickyElement(e);			
		}
	}
	
	public void selectRadioButtonBy(By by) {
		retryingFindAndSelectClick(by);	
	}
	
	public void clickButton(WebElement e) {
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		clickTrickyElement(e);			
	}
	
	public void clickButtonBy(By by) {
		if (retryingFindClick(by)) {
			// log success
			System.out.println("Button was clicked");
		}
		else {
			// log failure
			System.out.println("Button was not clicked");
		}
	}
	
	public void selectCheckBoxBy(By by) {
		if (retryingFindAndSelectClick(by))
		{
			// log success
			System.out.println("Checkbox was selected");
		}
		else {
			// log failure
			System.out.println("Checkbox was not selected");
		}
	}
	
	public void deselectCheckBoxBy(By by) {
		retryingFindAndDeselectClick(by);	
	}
	
	public void selectCheckBox(WebElement e) {
// Code to add when making this compatible with all browsers: If in Internet Explorer			
//				e.sendKeys(Keys.SPACE);
		// else
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		if (!e.isSelected()) {
			clickTrickyElement(e);		
		}
	}
	
	public void deselectCheckBox(WebElement e) {
// Code to add when making this compatible with all browsers: If in Internet Explorer			
//				e.sendKeys(Keys.SPACE);
		// else
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		if (e.isSelected()) {
			clickTrickyElement(e);		
		}
	}
	
	// Retry any time we get certain exceptions, so we aren't foiled by stale elements. 
	// Also retry if we check the text box and find the value didn't actually get set.
	public boolean setTextBy(By by, String txt) {
		boolean result = false;
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		int attempts = 0;
        while(attempts < 5) {
            try {
            	WebElement e = driver.findElement(by);
    			fluentWait.until(ExpectedConditions.elementToBeClickable(e));
       			e.clear();
       			e.sendKeys(txt);
       			if (containsText(e, txt))
       			{
       				result = true;
       				break;
       			}
            } catch(StaleElementReferenceException e) {
            } catch (WebDriverException e) {
            } catch (NoSuchElementException e) {
            }
            attempts++;
        }
        return result;
	}
	
	public void setText(WebElement e, String txt) {
		fluentWait.until(ExpectedConditions.visibilityOf(e));
		try
		{
			e.clear();
		}
		catch (StaleElementReferenceException exception2)
		{
			fluentWait.until(ExpectedConditions.visibilityOf(e));
			fluentWait.until(ExpectedConditions.visibilityOf(e));
			try
			{
				e.clear();
			}
			catch (StaleElementReferenceException exception3)
			{
				fluentWait.until(ExpectedConditions.visibilityOf(e));
				fluentWait.until(ExpectedConditions.visibilityOf(e));
				e.clear();
			}
		}
		e.sendKeys(txt);		
	}
	
	public boolean containsText(WebElement e, String txt) {
		// First check that the element is displayed, for those elements that only display if you've done the right prior steps
		boolean matches = e.isDisplayed();
		
		// Now check what's in the element and compare it to the text
		if (matches)
		{
				matches = e.getText().contains(txt);
		}
		
		return matches;
	}
	
	public boolean startsWithText(WebElement e, String txt) {
		// First check that the element is displayed, for those elements that only display if you've done the right prior steps
		boolean matches = e.isDisplayed();
		
		// Now check what's in the element and compare it to the text
		if (matches)
		{
				matches = e.getText().startsWith(txt);
		}
		
		return matches;
	}
	
	public boolean equalsText(WebElement e, String txt) {
		// First check that the element is displayed, for those elements that only display if you've done the right prior steps
		boolean matches = e.isDisplayed();
		
		// Now check what's in the element and compare it to the text
		if (matches)
		{
				matches = e.getText().equals(txt);
		}
		
		return matches;
	}
	
	public void selectDropDown(WebElement d, String val) {
		Select select = new Select(d);
		select.selectByValue(val);
	}
	
	// For DropDowns that aren't select elements, but that also aren't combined with any other element
	public void selectDropDownByXpathWithBoundlist(String xpath1, String txt) {
		// First make sure the dropdown can be located and click it to display the list
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		retryingFindClick(By.xpath(xpath1));
		//WebElement dropDown = driver.findElement(By.xpath(xpath1));
		//dropDown.click();
		// Now pick an item from the list
		//String xpath2 = "//div[starts-with(@id, 'boundlist-')]//li[. = '" + txt + "']";
		//String xpath2 = "//div[contains(@id, 'boundlist-')]//li[. = '" + txt + "']";
		String xpath2 = "//div[contains(@class, 'boundlist-')]//li[. = '" + txt + "']";
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
		retryingFindClick(By.xpath(xpath2));
		//WebElement itemToPick = driver.findElement(By.xpath(xpath2));
		//itemToPick.click();

	}
	
	// To select a DropDown from a button that has a default selection in the center and a DropDown on the right
	public void selectDropDownByIdWithOffset(String id1, String id2) {
		// First make sure the dropdown can be located and click it to display the list
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id1)));
		WebElement dropDown = driver.findElement(By.id(id1));
		
		int width = dropDown.getSize().getWidth();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(dropDown).moveByOffset((width/2)-2, 0).click().perform();
		// Now pick an item from the list
		fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id(id2)));
		
		retryingFindClick(By.id(id2));
		//WebElement itemToPick = driver.findElement(By.id(id2));
		//itemToPick.click();

	}
	
	public void dateTimePicker(WebElement d, WebElement t, String date, String time) {
		d.sendKeys(date);
		d.sendKeys(Keys.TAB);
		t.sendKeys(time);
	}
	
	public String getPageURL () {
		return PAGE_URL;
	}
	
	public  String getPageTitle() {
		return PAGE_TITLE;		
	}
	
	public void clickBack() {
		 driver.navigate().back();
	}

}
