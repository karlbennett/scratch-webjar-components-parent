package test.scratch.webjar.acceptance.finder;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import scratch.webjar.acceptance.finder.Bys;

import static java.lang.String.format;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.ByClassName;
import static org.openqa.selenium.By.ById;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import static shiver.me.timbers.matchers.Matchers.hasField;

public class BysTest {

    private Bys by;

    @Before
    public void setUp() {
        by = new Bys();
    }

    @Test
    public void Can_create_a_by_id() {

        // Given
        final String id = someString();

        // When
        final By actual = by.id(id);

        // Then
        assertThat(actual, instanceOf(ById.class));
        assertThat(actual, hasField("id", id));
    }

    @Test
    public void Can_create_a_by_class_name() {

        // Given
        final String className = someString();

        // When
        final By actual = by.className(className);

        // Then
        assertThat(actual, instanceOf(ByClassName.class));
        assertThat(actual, hasField("className", className));
    }

    @Test
    public void Can_create_a_by_text() {

        // Given
        final String text = someString();

        // When
        final By actual = by.text(text);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//*[contains(text(),'%s')]", text)));
    }

    @Test
    public void Can_create_a_by_value() {

        // Given
        final String value = someString();

        // When
        final By actual = by.value(value);

        // Then
        assertThat(actual, hasField("xpathExpression", format(".//input[@value='%s']", value)));
    }
}