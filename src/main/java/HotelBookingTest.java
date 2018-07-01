import java.util.concurrent.TimeUnit;

import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HotelBookingPage hotelBookingPage = PageFactory.initElements(driver, HotelBookingPage.class);
        hotelBookingPage.searchHotelsWithoutCheckInDate();
        hotelBookingPage.checkIfSearchResultFound();
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
