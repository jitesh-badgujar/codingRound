package pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FlightBookingPage {
	private WebDriver driver;

	@FindBy(id = "OneWay")
	WebElement oneWayRadioButton;

	@FindBy(id = "FromTag")
	@CacheLookup
	WebElement sourceCityTextBox;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li[@class='list']")
	List<WebElement> autoCompleteSourceCityList;

	@FindBy(name = "destination")
	@CacheLookup
	WebElement destintionCityTextBox;

	@FindBy(xpath = "//ul[@id='ui-id-2']/li[@class='list']")
	List<WebElement> autoCompleteDestinationCityList;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
	WebElement datePicker;

	@FindBy(id = "SearchBtn")
	WebElement searchButton;

	@FindBy(className = "searchSummary")
	WebElement searchSummary;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchOneWayFlights() {
		oneWayRadioButton.click();

		sourceCityTextBox.clear();
		sourceCityTextBox.sendKeys("Bangalore");
		// wait for autocomplete to load
		waitForElement(autoCompleteSourceCityList.get(0)).click();

		destintionCityTextBox.clear();
		destintionCityTextBox.sendKeys("Delhi");
		// wait
		waitForElement(autoCompleteDestinationCityList.get(0)).click();

		datePicker.click();

		searchButton.click();
	}

	public void checkIfSearchSummaryFound() {
		Assert.assertTrue(searchSummary.isDisplayed());
	}

	public WebElement waitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));

		if (element != null) {
			return element;
		} else {
			throw new NoSuchElementException(
					"Element not found within expected time:"
							+ locator.toString());
		}
	}
}
