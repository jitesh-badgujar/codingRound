package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

	@FindBy(className = "searchSummary")
	private WebElement searchSummary;

	public HotelBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchHotelsWithoutCheckInDate() {
		hotelLink.click();

		localityTextBox.sendKeys("Indiranagar, Bangalore");

		autoCompleteOptionList.get(0).click();

		searchForm.click(); // This is to void selecting date

		new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
		searchButton.click();
	}

	public void checkIfSearchSummryFound() {
		Assert.assertTrue(searchSummary.isDisplayed());
	}
}
