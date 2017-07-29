package test.scratch.webjar.acceptance.step;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.page.LoginPage;
import scratch.webjar.acceptance.step.LoginSteps;
import scratch.webjar.acceptance.step.UserHolder;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class LoginStepsTest {

    private UserHolder userHolder;
    private HomePage homePage;
    private LoginPage loginPage;
    private LoginSteps steps;

    @Before
    public void setUp() {
        userHolder = mock(UserHolder.class);
        homePage = mock(HomePage.class);
        loginPage = mock(LoginPage.class);
        steps = new LoginSteps(userHolder, homePage, loginPage);
    }

    @Test
    public void Can_login_a_user() {

        final User user = mock(User.class);

        // Given
        given(userHolder.get()).willReturn(user);

        // When
        steps.iLogin();

        // Then
        final InOrder order = inOrder(homePage, loginPage);
        order.verify(homePage).clickLogin();
        order.verify(loginPage).login(user);
    }

    @Test
    public void Can_check_that_the_user_is_logged_in() {

        final User user = mock(User.class);
        final String email = someString();

        // Given
        given(userHolder.get()).willReturn(user);
        given(user.getEmail()).willReturn(email);
        given(homePage.getEmail()).willReturn(email);

        // When
        steps.iShouldSeeThatIAmLoggedIn();

        // Then
        then(user).should().getEmail();
        then(homePage).should().getEmail();
    }

    @Test(expected = AssertionError.class)
    public void Can_check_that_the_user_is_not_logged_in() {

        final User user = mock(User.class);

        // Given
        given(userHolder.get()).willReturn(user);
        given(user.getEmail()).willReturn(someString());
        given(homePage.getEmail()).willReturn(someString());

        // When
        steps.iShouldSeeThatIAmLoggedIn();
    }

    @Test
    public void Can_check_that_the_user_has_the_option_to_logout() {

        // Given
        given(homePage.canLogout()).willReturn(true);

        // When
        steps.iShouldBeAbleToLogout();

        // Then
        then(homePage).should().canLogout();
    }

    @Test(expected = AssertionError.class)
    public void Can_check_that_the_user_does_not_have_the_option_to_logout() {

        // Given
        given(homePage.canLogout()).willReturn(false);

        // When
        steps.iShouldBeAbleToLogout();
    }
}