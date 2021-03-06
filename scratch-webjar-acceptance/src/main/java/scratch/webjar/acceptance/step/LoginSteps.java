package scratch.webjar.acceptance.step;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.page.LoginPage;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Karl Bennett
 */
public class LoginSteps {

    private final UserHolder userHolder;
    private final HomePage homePage;
    private final LoginPage loginPage;

    public LoginSteps(UserHolder userHolder, HomePage homePage, LoginPage loginPage) {
        this.userHolder = userHolder;
        this.homePage = homePage;
        this.loginPage = loginPage;
    }

    @When("^I login$")
    public void iLogin() {
        homePage.clickLogin();
        loginPage.login(userHolder.get());
    }

    @Then("^I should see that I am logged in$")
    public void iShouldSeeThatIAmLoggedIn() {
        assertThat("The users email should be visible.", homePage.getEmail(), equalTo(userHolder.get().getEmail()));
    }

    @Then("^I should be able to logout$")
    public void iShouldBeAbleToLogout() {
        assertThat("The logout link should be visible.", homePage.canLogout(), is(true));
    }
}
