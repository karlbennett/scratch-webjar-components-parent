package scratch.webjar.acceptance.step;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import scratch.webjar.acceptance.domain.User;

/**
 * @author Karl Bennett
 */
@Component
@Scope("cucumber-glue")
public class UserHolder extends GenericHolder<User> {
}
