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
    private final String heading;
    private final String baseUrl;

    public HomePage(
        Finders finders,
        @Value("${homepage.heading}") String heading,
        @Value("${baseUrl}") String baseUrl
    ) {
        this.finders = finders;
        this.heading = heading;
        this.baseUrl = baseUrl;
    }

    public boolean isCurrentPage() {
        return heading.equals(finders.findTextByClassName("main-heading"));
    }

    public void visit() {
        finders.visit(baseUrl);
    }

    public void clickLogin() {
        finders.clickByText("Login");
    }
}
