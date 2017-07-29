package scratch.webjar.acceptance.page;

import org.springframework.stereotype.Component;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.finder.Finders;

/**
 * @author Karl Bennett
 */
@Component
public class LoginPage {

    private final Finders finders;

    public LoginPage(Finders finders) {
        this.finders = finders;
    }

    public void login(User user) {
        finders.enterTextByLabel("Email", user.getEmail());
        finders.enterTextByLabel("Password", user.getPassword());
        finders.clickByText(finders.findByClassName("login-form"), "Login");
    }
}
