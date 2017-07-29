package scratch.webjar.acceptance.domain;

import org.springframework.stereotype.Component;

import static java.lang.String.format;
import static shiver.me.timbers.data.random.RandomStrings.someAlphanumericString;
import static shiver.me.timbers.data.random.RandomStrings.someString;

/**
 * @author Karl Bennett
 */
@Component
public class RandomUserFactory {

    public User createRandomUser() {
        return new User(
            format(
                "%s@%s.%s",
                someAlphanumericString(8),
                someAlphanumericString(5),
                someAlphanumericString(3)
            ),
            someString(20)
        );
    }
}
