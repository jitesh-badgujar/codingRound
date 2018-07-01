package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement waitForElement(WebElement locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

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
