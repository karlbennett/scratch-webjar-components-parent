package test.scratch.webjar.acceptance.domain;

import org.junit.Test;
import scratch.webjar.acceptance.domain.User;
import scratch.webjar.acceptance.domain.UserPreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class UserPreparedStatementCallbackTest {

    @Test
    public void Can_set_the_values_for_the_email_ane_password() throws SQLException {

        final User user = mock(User.class);
        final PreparedStatement statement = mock(PreparedStatement.class);

        final String email = someString();
        final String password = someString();

        // Given
        given(user.getEmail()).willReturn(email);
        given(user.getPassword()).willReturn(password);

        // When
        final User actual = new UserPreparedStatementCallback(user).doInPreparedStatement(statement);

        // Then
        then(statement).should().setString(1, email);
        then(statement).should().setString(2, password);
        assertThat(actual, is(user));
    }
}