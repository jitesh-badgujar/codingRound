import org.testng.annotations.Test;

import pages.SignInPage;

public class SignInTest extends BaseTestCase {
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		SignInPage singInPage = new SignInPage(driver);
		singInPage.trySignInWithoutEnteringCredentials();
		singInPage.checkIfErrorMessageReceived();
	}

}
