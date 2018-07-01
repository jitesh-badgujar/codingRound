import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sun.javafx.PlatformUtil;

public class BaseTestCase {

	protected WebDriver driver;

	@BeforeClass
	public void setUp() {
		setDriverPath();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}
}
