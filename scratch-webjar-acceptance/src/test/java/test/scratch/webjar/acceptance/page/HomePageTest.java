package test.scratch.webjar.acceptance.page;

import org.junit.Before;
import org.junit.Test;
import scratch.webjar.acceptance.finder.Finders;
import scratch.webjar.acceptance.page.HomePage;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class HomePageTest {

    private Finders finders;
    private String heading;
    private String baseUrl;
    private HomePage page;

    @Before
    public void setUp() {
        finders = mock(Finders.class);
        heading = someString(8);
        baseUrl = someString(13);
        page = new HomePage(finders, heading, baseUrl);
    }

    @Test
    public void Can_check_if_the_current_page_is_the_home_page() {

        // Given
        given(finders.findTextByClassName("main-heading")).willReturn(heading);

        // When
        final boolean actual = page.isCurrentPage();

        // Then
        assertThat(actual, is(true));
    }

    @Test
    public void Can_check_if_the_current_page_is_not_the_home_page() {

        // Given
        given(finders.findTextByClassName("main-heading")).willReturn(someString());

        // When
        final boolean actual = page.isCurrentPage();

        // Then
        assertThat(actual, is(false));
    }

    @Test
    public void Can_visit_the_home_page() {

        // When
        page.visit();

        // Then
        then(finders).should().visit(baseUrl);
    }

    @Test
    public void Can_click_login() {

        // When
        page.clickLogin();

        // Then
        then(finders).should().clickByText("Login");
    }
}