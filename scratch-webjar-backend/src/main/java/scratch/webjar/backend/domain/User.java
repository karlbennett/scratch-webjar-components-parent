package scratch.webjar.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Karl Bennett
 */
@Entity(name = "users")
public class User {

    @Id
    private final String email;

    @Column
    private final String password;

    User() {
        this(null, null);
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
