package scratch.webjar.acceptance.step;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scratch.webjar.acceptance.ITCucumber;
import scratch.webjar.acceptance.page.HomePage;

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

    private final HomePage homePage;
    private final WebDriver driver;

    @Autowired
    public Hooks(HomePage homePage, WebDriver driver) {
        this.homePage = homePage;
        this.driver = driver;
    }

    @Before
    public void setup() {
        homePage.visit();
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
