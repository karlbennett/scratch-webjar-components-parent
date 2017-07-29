package test.scratch.webjar.acceptance.step;

import cucumber.api.Scenario;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import scratch.webjar.acceptance.page.HomePage;
import scratch.webjar.acceptance.step.Hooks;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.openqa.selenium.OutputType.BYTES;
import static org.openqa.selenium.WebDriver.Options;
import static shiver.me.timbers.data.random.RandomBytes.someBytes;

public class HooksTest {

    private ScreenShotDriver driver;
    private HomePage homePage;
    private Hooks hooks;

    @Before
    public void setUp() {
        homePage = mock(HomePage.class);
        driver = mock(ScreenShotDriver.class);
        hooks = new Hooks(homePage, driver);
    }

    @Test
    public void Will_visit_the_main_page_before_every_scenario() {

        // When
        hooks.setup();

        // Then
        then(homePage).should().visit();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_sign_out_after_every_scenario() {

        final Scenario scenario = mock(Scenario.class);

        final Options options = mock(Options.class);

        // Given
        given(scenario.isFailed()).willReturn(false);
        given(driver.manage()).willReturn(options);

        // When
        hooks.tearDown(scenario);

        // Then
        then(driver).should(never()).getScreenshotAs(any(OutputType.class));
        then(scenario).should(never()).embed(any(byte[].class), anyString());
        then(options).should().deleteAllCookies();
    }

    @Test
    public void Can_take_a_screen_shot_if_the_scenario_fails() {

        final Scenario scenario = mock(Scenario.class);

        final Options options = mock(Options.class);
        final byte[] bytes = someBytes();

        // Given
        given(scenario.isFailed()).willReturn(true);
        given(driver.getScreenshotAs(BYTES)).willReturn(bytes);
        given(driver.manage()).willReturn(options);

        // When
        hooks.tearDown(scenario);

        // Then
        then(scenario).should().embed(bytes, "image/png");
        then(options).should().deleteAllCookies();
    }

    @Test
    public void Will_not_attempt_to_take_a_screenshot_if_the_driver_does_not_support_it() {

        final WebDriver driver = mock(WebDriver.class);
        final Scenario scenario = mock(Scenario.class);

        final Options options = mock(Options.class);

        // Given
        given(scenario.isFailed()).willReturn(true);
        given(driver.manage()).willReturn(options);

        // When
        new Hooks(homePage, driver).tearDown(scenario);

        // Then
        then(scenario).should(never()).embed(any(byte[].class), anyString());
        then(options).should().deleteAllCookies();
    }

    private interface ScreenShotDriver extends WebDriver, TakesScreenshot {
    }
}
