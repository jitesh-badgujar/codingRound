import org.testng.annotations.Test;

import pages.FlightBookingPage;
import pages.SearchResultPage;

public class FlightBookingTest extends BaseTestCase {
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		FlightBookingPage flightBookingPage = new FlightBookingPage(driver);
		SearchResultPage searchResultPage=flightBookingPage.searchOneWayFlightsOnDefaultDates("Bangalore","Delhi");
		searchResultPage.checkIfSearchSummaryFound();
	}
}
