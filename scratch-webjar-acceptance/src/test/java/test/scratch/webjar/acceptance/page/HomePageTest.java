package test.scratch.webjar.acceptance.page;

import org.junit.Before;
import org.junit.Test;
import scratch.webjar.acceptance.finder.Finders;
import scratch.webjar.acceptance.page.HomePage;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class HomePageTest {

    private Finders finders;
    private String baseUrl;
    private HomePage homePage;

    @Before
    public void setUp() {
        finders = mock(Finders.class);
        baseUrl = someString();
        homePage = new HomePage(finders, baseUrl);
    }

    @Test
    public void Can_visit_the_home_page() {

        // When
        homePage.visit();

        // Then
        then(finders).should().visit(baseUrl);
    }

    @Test
    public void Can_click_login() {

        // When
        homePage.clickLogin();

        // Then
        then(finders).should().clickByText("Login");
    }
}