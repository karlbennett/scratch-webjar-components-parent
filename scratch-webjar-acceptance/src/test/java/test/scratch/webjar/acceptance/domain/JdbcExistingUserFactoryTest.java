package test.scratch.webjar.acceptance.domain;

import org.junit.Test;
import org.mockito.Matchers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import scratch.webjar.acceptance.domain.JdbcExistingUserFactory;
import scratch.webjar.acceptance.domain.RandomUserFactory;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.domain.UserPreparedStatementCallback;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import static shiver.me.timbers.matchers.Matchers.hasProperty;

public class JdbcExistingUserFactoryTest {

    @Test
    public void Can_create_a_random_existing_user() {

        final RandomUserFactory randomUserFactory = mock(RandomUserFactory.class);
        final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        final JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

        final String email = someString();
        final String password = someString();
        final String encodedPassword = someString();

        final User expected = mock(User.class);

        // Given
        given(randomUserFactory.createRandomUser()).willReturn(expected);
        given(expected.getEmail()).willReturn(email);
        given(expected.getPassword()).willReturn(password);
        given(passwordEncoder.encode(password)).willReturn(encodedPassword);

        // When
        final User actual = new JdbcExistingUserFactory(randomUserFactory, passwordEncoder, jdbcTemplate)
            .createExitingUser();

        // Then
        then(jdbcTemplate).should().execute(
            eq("INSERT INTO users (email, password) VALUES (?, ?);"),
            Matchers.<UserPreparedStatementCallback>argThat(allOf(
                instanceOf(UserPreparedStatementCallback.class),
                hasProperty("user.email", email),
                hasProperty("user.password", encodedPassword)
            ))
        );
        assertThat(actual, is(expected));
    }
}