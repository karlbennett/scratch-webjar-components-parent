package scratch.webjar.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is the main class that Spring boot uses to start the stand alone application.
 * It must be located at the high level package so that all the auto-configuration scanning works correctly.
 *
 * @author Karl Bennett
 */
@Configuration
@ComponentScan("scratch.webjar")
@EnableAutoConfiguration
public class ServletApplication extends SpringBootServletInitializer {

    /**
     * This override registers the Spring Boot application with the J2EE container it has been deployed to.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }
}
