package scratch.webjar.backend.data;

import org.springframework.data.repository.CrudRepository;
import scratch.webjar.backend.domain.User;

/**
 * @author Karl Bennett
 */
public interface UserRepository extends CrudRepository<User, String> {
}
