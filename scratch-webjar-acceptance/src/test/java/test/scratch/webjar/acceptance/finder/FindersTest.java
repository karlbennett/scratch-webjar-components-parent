package test.scratch.webjar.acceptance.finder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import scratch.webjar.acceptance.finder.Bys;
import scratch.webjar.acceptance.finder.Finders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class FindersTest {

    private WebDriver driver;
    private Bys by;
    private Finders finders;

    @Before
    public void setUp() {
        driver = mock(WebDriver.class);
        by = mock(Bys.class);
        finders = new Finders(driver, by);
    }

    @Test
    public void Can_visit_a_url() {

        // Given
        final String url = someString();

        // When
        finders.visit(url);

        // Then
        then(driver).should().get(url);
    }

    @Test
    public void Can_find_an_element_by_its_class_name() {

        final String className = someString();

        final By byClassName = mock(By.class);
        final WebElement expected = mock(WebElement.class);

        // Given
        given(by.className(className)).willReturn(byClassName);
        given(driver.findElement(byClassName)).willReturn(expected);

        // When
        final WebElement actual = finders.findByClassName(className);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_find_some_text_by_a_class_name() {

        final String className = someString();

        final By byClassName = mock(By.class);
        final WebElement element = mock(WebElement.class);

        final String expected = someString();

        // Given
        given(by.className(className)).willReturn(byClassName);
        given(driver.findElement(byClassName)).willReturn(element);
        given(element.getText()).willReturn(expected);

        // When
        final String actual = finders.findTextByClassName(className);

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_click_by_text() {

        final String text = someString();

        final By byText = mock(By.class);
        final WebElement element = mock(WebElement.class);

        // Given
        given(by.text(text)).willReturn(byText);
        given(driver.findElement(byText)).willReturn(element);

        // When
        finders.clickByText(text);

        // Then
        then(element).should().click();
    }

    @Test
    public void Can_click_by_text_with_a_root_context_element() {

        final WebElement context = mock(WebElement.class);
        final String text = someString();

        final By byText = mock(By.class);
        final WebElement element = mock(WebElement.class);

        // Given
        given(by.text(text)).willReturn(byText);
        given(context.findElement(byText)).willReturn(element);

        // When
        finders.clickByText(context, text);

        // Then
        then(element).should().click();
    }

    @Test
    public void Can_enter_text_by_an_inputs_label_name() {

        final String label = someString();
        final String text = someString();

        final By byText = mock(By.class);
        final WebElement labelElement = mock(WebElement.class);
        final String id = someString();
        final By byId = mock(By.class);
        final WebElement input = mock(WebElement.class);

        // Given
        given(by.text(label)).willReturn(byText);
        given(driver.findElement(byText)).willReturn(labelElement);
        given(labelElement.getAttribute("for")).willReturn(id);
        given(by.id(id)).willReturn(byId);
        given(driver.findElement(byId)).willReturn(input);

        // When
        finders.enterTextByLabel(label, text);

        // Then
        final InOrder order = inOrder(input);
        order.verify(input).clear();
        order.verify(input).sendKeys(text);
    }

    @Test
    public void Can_click_by_value() {

        final String value = someString();

        final By byValue = mock(By.class);
        final WebElement element = mock(WebElement.class);

        // Given
        given(by.value(value)).willReturn(byValue);
        given(driver.findElement(byValue)).willReturn(element);

        // When
        finders.clickByValue(value);

        // Then
        then(element).should().click();
    }
}