import org.testng.annotations.Test;

import pages.HotelBookingPage;
import pages.SearchResultPage;

public class HotelBookingTest extends BaseTestCase {
	@Test
	public void shouldBeAbleToSearchForHotels() {
		HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
		SearchResultPage searchResultPage=hotelBookingPage.searchHotelsWithoutCheckInDate("Indiranagar, Bangalore","1 room, 2 adults");
		searchResultPage.checkIfSearchSummaryFound();
	}
}
