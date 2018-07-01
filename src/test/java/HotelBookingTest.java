import org.testng.annotations.Test;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTestCase {
	@Test
	public void shouldBeAbleToSearchForHotels() {
		HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
		hotelBookingPage.searchHotelsWithoutCheckInDate();
		hotelBookingPage.checkIfSearchSummryFound();
	}
}
