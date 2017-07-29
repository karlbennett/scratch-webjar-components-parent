package scratch.webjar.acceptance.domain;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Karl Bennett
 */
@Component
public class JdbcExistingUserFactory implements ExistingUserFactory {

    private final RandomUserFactory randomUserFactory;
    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    public JdbcExistingUserFactory(
        RandomUserFactory randomUserFactory,
        PasswordEncoder passwordEncoder,
        JdbcTemplate jdbcTemplate
    ) {
        this.randomUserFactory = randomUserFactory;
        this.passwordEncoder = passwordEncoder;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createExitingUser() {
        final User user = randomUserFactory.createRandomUser();
        jdbcTemplate.execute(
            "INSERT INTO users (email, password) VALUES (?, ?);",
            new UserPreparedStatementCallback(new User(user.getEmail(), passwordEncoder.encode(user.getPassword())))
        );
        return user;
    }
}
