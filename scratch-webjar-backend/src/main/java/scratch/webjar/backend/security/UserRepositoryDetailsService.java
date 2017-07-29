package scratch.webjar.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import scratch.webjar.backend.data.UserRepository;
import scratch.webjar.backend.domain.User;

/**
 * @author Karl Bennett
 */
@Component
public class UserRepositoryDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserDetailsFactory userDetailsFactory;

    public UserRepositoryDetailsService(UserRepository userRepository, UserDetailsFactory userDetailsFactory) {
        this.userRepository = userRepository;
        this.userDetailsFactory = userDetailsFactory;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findOne(email);

        if (user != null) {
            return userDetailsFactory.create(user);
        }

        throw new UsernameNotFoundException("No user found for email: " + email);
    }
}
