package scratch.webjar.acceptance.step;

import cucumber.api.java.en.Then;
import scratch.webjar.acceptance.page.HomePage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Karl Bennett
 */
public class HomePageSteps {

    private final HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Then("^I should be on the homepage$")
    public void iShouldBeOnTheHomepage() {
        assertThat("Should be on the home page.", homePage.isCurrentPage(), is(true));
    }
}
