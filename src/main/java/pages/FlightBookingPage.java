package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FlightBookingPage extends BasePage 
{
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

	public FlightBookingPage(WebDriver driver){
		super(driver);
	}

	public SearchResultPage searchOneWayFlightsOnDefaultDates(String sourceCity,
			String destinationCity) {
		oneWayRadioButton.click();

		sourceCityTextBox.clear();
		sourceCityTextBox.sendKeys(sourceCity);
		// wait for autocomplete to load
		waitForElement(autoCompleteSourceCityList.get(0)).click();

		destintionCityTextBox.clear();
		destintionCityTextBox.sendKeys(destinationCity);
		// wait autocomplete to load
		waitForElement(autoCompleteDestinationCityList.get(0)).click();

		datePicker.click();
		
		searchButton.click();
	
		return new SearchResultPage(driver);
	}
}
