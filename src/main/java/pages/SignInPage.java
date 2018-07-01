package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {
	private WebDriver driver;

	@FindBy(linkText = "Your trips")
	WebElement yourTripsLink;

	@FindBy(id = "SignIn")
	WebElement startSignInButton;

	private final String signInWindow = "modal_window";

	@FindBy(id = "signInButton")
	WebElement signInButton;

	@FindBy(id = "errors1")
	WebElement errorMessage;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void trySignInWithoutEnteringCredentials() {
		yourTripsLink.click();
		startSignInButton.click();
		driver.switchTo().frame(signInWindow);
		signInButton.click();
	}

	public void checkIfErrorMessageReceived() {
		String errorText = errorMessage.getText();

		Assert.assertTrue(errorText
				.contains("There were errors in your submission"));
	}

}
