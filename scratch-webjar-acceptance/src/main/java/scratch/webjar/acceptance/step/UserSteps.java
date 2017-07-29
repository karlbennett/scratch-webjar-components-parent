package scratch.webjar.acceptance.step;

import cucumber.api.java.en.Given;
import scratch.webjar.acceptance.domain.ExistingUserFactory;

/**
 * @author Karl Bennett
 */
public class UserSteps {

    private final ExistingUserFactory existingUserFactory;
    private final UserHolder userHolder;

    public UserSteps(ExistingUserFactory existingUserFactory, UserHolder userHolder) {
        this.existingUserFactory = existingUserFactory;
        this.userHolder = userHolder;
    }

    @Given("^I am an existing user$")
    public void iAmAnExistingUser() {
        userHolder.set(existingUserFactory.createExitingUser());
    }
}
