package scratch.webjar.acceptance.page;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import scratch.webjar.acceptance.finder.Finders;

/**
 * @author Karl Bennett
 */
@Component
public class HomePage {

    private final Finders finders;
    private final String baseUrl;

    public HomePage(Finders finders, @Value("${baseUrl}") String baseUrl) {
        this.finders = finders;
        this.baseUrl = baseUrl;
    }

    public void visit() {
        finders.visit(baseUrl);
    }

    public void clickLogin() {
        finders.clickByText("Login");
    }
}
