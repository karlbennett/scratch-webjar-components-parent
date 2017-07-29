package test.scratch.webjar.acceptance.domain;

import org.junit.Test;
import scratch.webjar.acceptance.domain.RandomUserFactory;
import scratch.webjar.acceptance.domain.User;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.matchers.Matchers.hasFieldThat;

public class RandomUserFactoryTest {

    @Test
    public void Can_create_a_random_user() {

        // When
        final User actual = new RandomUserFactory().createRandomUser();

        // Then
        assertThat(actual, not(nullValue()));
        assertThat(actual, hasFieldThat("email", not(nullValue())));
        assertThat(actual, hasFieldThat("password", not(nullValue())));
    }
}