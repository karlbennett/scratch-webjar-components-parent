package test.scratch.webjar.acceptance.steps;

import org.junit.Test;
import scratch.webjar.acceptance.steps.GenericHolder;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static shiver.me.timbers.data.random.RandomThings.someThing;

public class GenericHolderTest {

    @Test
    public void Can_set_a_value() {

        // Given
        final GenericHolder<Object> holder = new GenericHolder<>();
        final Object expected = someThing();

        // When
        holder.set(expected);

        // Then
        assertThat(holder.get(), is(expected));
    }
}