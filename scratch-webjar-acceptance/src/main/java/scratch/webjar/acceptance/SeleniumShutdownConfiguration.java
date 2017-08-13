package scratch.webjar.acceptance;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * @author Karl Bennett
 */
@Configuration
public class SeleniumShutdownConfiguration {

    @Autowired
    private WebDriver driver;

    @PreDestroy
    public void quitWebDriver() {
        driver.quit();
    }
}
