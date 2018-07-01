import org.testng.annotations.Test;
import pages.FlightBookingPage;

public class FlightBookingTest extends BaseTestCase {
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		FlightBookingPage flightBookingPage = new FlightBookingPage(driver);
		flightBookingPage.searchOneWayFlightsOnDefaultDates("Bangalore","Delhi");
		flightBookingPage.checkIfSearchSummaryFound();
	}
}
