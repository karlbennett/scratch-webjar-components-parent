package scratch.webjar.backend.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserTest {

    private String email;
    private String password;
    private User user;

    @Before
    public void setUp() {
        email = someString();
        password = someString();
        user = new User(email, password);
    }

    @Test
    public void Instantiation_for_coverage() {
        new User();
    }

    @Test
    public void Can_get_the_email() {

        // When
        final String actual = user.getEmail();

        // Then
        assertThat(actual, is(email));
    }

    @Test
    public void Can_get_the_password() {

        // When
        final String actual = user.getPassword();

        // Then
        assertThat(actual, is(password));
    }
}