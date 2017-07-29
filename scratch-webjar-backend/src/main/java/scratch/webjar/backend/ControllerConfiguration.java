package scratch.webjar.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import scratch.webjar.backend.controller.EmailToModelHandlerInterceptor;

/**
 * @author Karl Bennett
 */
@Configuration
public class ControllerConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EmailToModelHandlerInterceptor());
    }
}
