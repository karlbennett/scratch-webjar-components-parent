package scratch.webjar.html5;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Karl Bennett
 */
@Configuration
public class RouterConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/components/page-header").setViewName("/components/page-header");
        registry.addViewController("/components/form-login").setViewName("/components/form-login");
        registry.addViewController("/login").setViewName("/login.html");
    }
}
