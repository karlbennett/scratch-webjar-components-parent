package scratch.webjar.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.java.spring.CucumberScopeFixConfiguration;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Karl Bennett
 */
@Configuration
@ComponentScan("scratch.webjar")
@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class ITCucumber extends CucumberScopeFixConfiguration {
}
