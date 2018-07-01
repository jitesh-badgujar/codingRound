import org.testng.annotations.Test;
import pages.HotelBookingPage;

public class HotelBookingTest extends BaseTestCase {
	@Test
	public void shouldBeAbleToSearchForHotels() {
		HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
		hotelBookingPage.searchHotelsWithoutCheckInDate("Indiranagar, Bangalore","1 room, 2 adults");
		hotelBookingPage.checkIfSearchSummryFound();
	}
}
