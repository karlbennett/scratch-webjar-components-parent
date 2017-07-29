package test.scratch.webjar.acceptance.step;

import org.junit.Test;
import org.mockito.InOrder;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.page.LoginPage;
import scratch.webjar.acceptance.step.LoginSteps;
import scratch.webjar.acceptance.step.UserHolder;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class LoginStepsTest {

    @Test
    public void Can_login_a_user() {

        final UserHolder userHolder = mock(UserHolder.class);
        final HomePage homePage = mock(HomePage.class);
        final LoginPage loginPage = mock(LoginPage.class);

        final User user = mock(User.class);

        // Given
        given(userHolder.get()).willReturn(user);

        // When
        new LoginSteps(userHolder, homePage, loginPage).iLogin();

        // Then
        final InOrder order = inOrder(homePage, loginPage);
        order.verify(homePage).clickLogin();
        order.verify(loginPage).login(user);
    }
}