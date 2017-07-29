package scratch.webjar.backend.security;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import scratch.webjar.backend.domain.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserDetailsFactoryTest {

    @Test
    public void Can_create_a_user_details() {

        final User user = mock(User.class);

        final String username = someString();
        final String password = someString();

        // Given
        given(user.getEmail()).willReturn(username);
        given(user.getPassword()).willReturn(password);

        // When
        final UserDetails actual = new UserDetailsFactory().create(user);

        // Then
        assertThat(actual.getAuthorities(), Matchers.<GrantedAuthority>empty());
        assertThat(actual.getUsername(), is(username));
        assertThat(actual.getPassword(), is(password));
        assertThat(actual.isAccountNonExpired(), is(true));
        assertThat(actual.isAccountNonLocked(), is(true));
        assertThat(actual.isCredentialsNonExpired(), is(true));
        assertThat(actual.isEnabled(), is(true));
    }
}