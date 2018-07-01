package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResultPage extends BasePage 
{	
	@FindBy(className = "searchSummary")
	WebElement searchSummary;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkIfSearchSummaryFound() {
		waitForElement(searchSummary);
		Assert.assertTrue(searchSummary.isDisplayed());
	}
}
