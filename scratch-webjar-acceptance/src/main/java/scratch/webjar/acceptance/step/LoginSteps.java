package scratch.webjar.acceptance.step;

import cucumber.api.java.en.When;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.page.LoginPage;

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
}
