package scratch.webjar.freemarker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import scratch.webjar.freemarker.controller.PubliclyCachedHandlerInterceptor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.CacheControl.maxAge;

/**
 * @author Karl Bennett
 */
@Configuration
public class RouterConfiguration extends WebMvcConfigurerAdapter {

    @Value("#{'${public.cache.paths}'.split(',')}")
    private List<String> paths;

    @Value("${public.cache.maxAge}")
    private long maxAge;

    @Value("${public.cache.maxAgeUnit}")
    private TimeUnit maxAgeUnit;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/components/page-header").setViewName("/components/page-header");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").setCacheControl(maxAge(maxAge, maxAgeUnit))
            .addResourceLocations("classpath:/META-INF/resources/css/");
        registry.addResourceHandler("/webjars/**").setCacheControl(maxAge(maxAge, maxAgeUnit))
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PubliclyCachedHandlerInterceptor(paths, maxAge, maxAgeUnit));
    }
}
