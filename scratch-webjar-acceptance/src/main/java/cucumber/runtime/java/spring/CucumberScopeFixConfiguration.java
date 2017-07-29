package cucumber.runtime.java.spring;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;

/**
 * This configuration is a hack to get the Cucumber Spring bean scope working.
 * https://github.com/cucumber/cucumber-jvm/issues/965
 *
 * @author Karl Bennett
 */
public class CucumberScopeFixConfiguration {

    @Bean
    public CustomScopeConfigurer glueScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("cucumber-glue", new GlueCodeScope());
        return configurer;
    }
}
