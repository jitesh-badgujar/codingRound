package pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelBookingPage {

	WebDriver driver;

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
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
