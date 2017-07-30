package scratch.webjar.html5;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.AbstractResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Karl Bennett
 */
public class ClassPathResourceResolver extends AbstractResourceResolver {

    private final ClassPathResource classPathResource;
    private final String resourcePath;

    public ClassPathResourceResolver(String resourcePath) {
        this(new ClassPathResource("/"), resourcePath);
    }

    public ClassPathResourceResolver(ClassPathResource classPathResource, String resourcePath) {
        this.classPathResource = classPathResource;
        this.resourcePath = resourcePath;
    }

    @Override
    protected Resource resolveResourceInternal(
        HttpServletRequest request,
        String requestPath,
        List<? extends Resource> locations,
        ResourceResolverChain chain
    ) {
        return createResource();
    }

    @Override
    protected String resolveUrlPathInternal(
        String resourceUrlPath,
        List<? extends Resource> locations,
        ResourceResolverChain chain
    ) {
        return createResource() != null ? resourcePath : null;
    }

    private Resource createResource() {
        return classPathResource.createRelative(resourcePath);
    }
}
