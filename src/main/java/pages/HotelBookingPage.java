package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPage extends BasePage
{
	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li[@class='list']")
	List<WebElement> autoCompleteOptionList;

	@FindBy(xpath = "//h1[contains(.,'Search')]")
	private WebElement searchForm;

	public HotelBookingPage(WebDriver driver) {
		super(driver);
	}

	public SearchResultPage searchHotelsWithoutCheckInDate(String location,
			String travellers) {
		hotelLink.click();

		localityTextBox.sendKeys(location);

		waitForElement(autoCompleteOptionList.get(0)).click();

		searchForm.click(); // This is to void selecting date

		new Select(travellerSelection).selectByVisibleText(travellers);
		
		searchButton.click();
		
		return new SearchResultPage(driver);
	}
}
