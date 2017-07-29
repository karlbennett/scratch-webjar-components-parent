package scratch.webjar.acceptance.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scratch.webjar.acceptance.ITCucumber;

import static org.openqa.selenium.OutputType.BYTES;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

/**
 * @author Karl Bennett
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ITCucumber.class)
@TestPropertySource("/application-acceptance.properties")
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class Hooks {

    private final WebDriver driver;

    @Autowired
    public Hooks(WebDriver driver) {
        this.driver = driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        driver.manage().deleteAllCookies();
    }

    private void takeScreenshot(Scenario scenario) {
        if (driver instanceof TakesScreenshot) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(BYTES), "image/png");
        }
    }
}
