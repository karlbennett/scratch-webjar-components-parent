package scratch.webjar.html5;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.springframework.http.CacheControl.maxAge;

/**
 * @author Karl Bennett
 */
@Configuration
public class RouterConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/components/page-login").setViewName("/components/page-login");
        registry.addViewController("/login").setViewName("/login.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").setCacheControl(maxAge(120, SECONDS))
            .addResourceLocations("classpath:/META-INF/resources/css/");
        registry.addResourceHandler("/components/**").setCacheControl(maxAge(120, SECONDS))
            .addResourceLocations("classpath:/public/components/");
        registry.addResourceHandler("/webjars/**").setCacheControl(maxAge(120, SECONDS))
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
