package test.scratch.webjar.acceptance.page;

import org.junit.Test;
import org.mockito.InOrder;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.finder.Finders;
import scratch.webjar.acceptance.page.LoginPage;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class LoginPageTest {

    @Test
    public void Can_login_a_user() {

        final Finders finders = mock(Finders.class);
        final User user = mock(User.class);

        final String email = someString();
        final String password = someString();

        // Given
        given(user.getEmail()).willReturn(email);
        given(user.getPassword()).willReturn(password);

        // When
        new LoginPage(finders).login(user);

        // Then
        final InOrder order = inOrder(finders);
        order.verify(finders).enterTextByLabel("Email", email);
        order.verify(finders).enterTextByLabel("Password", password);
        order.verify(finders).clickByValue("Login");
    }
}