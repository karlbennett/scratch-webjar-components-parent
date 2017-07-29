package test.scratch.webjar.acceptance.step;

import org.junit.Before;
import org.junit.Test;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.step.HomePageSteps;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class HomePageStepsTest {

    private HomePage homePage;
    private HomePageSteps steps;

    @Before
    public void setUp() {
        homePage = mock(HomePage.class);
        steps = new HomePageSteps(homePage);
    }

    @Test
    public void Can_check_that_we_are_on_the_home_page() {

        // Given
        given(homePage.isCurrentPage()).willReturn(true);

        // When
        steps.iShouldBeOnTheHomepage();

        // Then
        then(homePage).should().isCurrentPage();
    }

    @Test(expected = AssertionError.class)
    public void Can_check_that_we_are_not_on_the_home_page() {

        // Given
        given(homePage.isCurrentPage()).willReturn(false);

        // When
        steps.iShouldBeOnTheHomepage();
    }
}