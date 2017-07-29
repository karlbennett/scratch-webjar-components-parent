package scratch.webjar.acceptance.domain;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Karl Bennett
 */
public class UserPreparedStatementCallback implements PreparedStatementCallback<User> {

    private final User user;

    public UserPreparedStatementCallback(User user) {
        this.user = user;
    }

    @Override
    public User doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getPassword());
        return user;
    }
}
