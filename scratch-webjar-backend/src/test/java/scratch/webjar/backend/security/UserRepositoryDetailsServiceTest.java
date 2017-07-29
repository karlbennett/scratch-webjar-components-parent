package scratch.webjar.backend.security;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import scratch.webjar.backend.data.UserRepository;
import scratch.webjar.backend.domain.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserRepositoryDetailsServiceTest {

    private UserRepository userRepository;
    private UserDetailsFactory userDetailsFactory;
    private UserRepositoryDetailsService service;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userDetailsFactory = mock(UserDetailsFactory.class);
        service = new UserRepositoryDetailsService(userRepository, userDetailsFactory);
    }

    @Test
    public void Can_create_a_user_details_from_an_existing_user() {

        final String email = someString();

        final User user = mock(User.class);

        final UserDetails expected = mock(UserDetails.class);

        // Given
        given(userRepository.findOne(email)).willReturn(user);
        given(userDetailsFactory.create(user)).willReturn(expected);

        // When
        final UserDetails actual = service.loadUserByUsername(email);

        // Then
        assertThat(actual, is(expected));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void Can_fail_to_create_a_user_details_from_a_nonexistent_user() {

        final String email = someString();

        // Given
        given(userRepository.findOne(email)).willReturn(null);

        // When
        service.loadUserByUsername(email);
    }
}