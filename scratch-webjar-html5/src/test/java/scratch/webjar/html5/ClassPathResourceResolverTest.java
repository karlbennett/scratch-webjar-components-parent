package scratch.webjar.html5;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class ClassPathResourceResolverTest {

    private ClassPathResource classPathResource;
    private String resourcePath;
    private ClassPathResourceResolver resolver;

    @Before
    public void setUp() {
        classPathResource = mock(ClassPathResource.class);
        resourcePath = someString();
        resolver = new ClassPathResourceResolver(classPathResource, resourcePath);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_resolve_a_single_file_resource() {

        final Resource expected = mock(Resource.class);

        // Given
        given(classPathResource.createRelative(resourcePath)).willReturn(expected);

        // When
        final Resource actual = resolver.resolveResourceInternal(
            mock(HttpServletRequest.class), someString(), mock(List.class), mock(ResourceResolverChain.class)
        );

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_resolve_a_single_file_resources_url_path() {

        final Resource expected = mock(Resource.class);

        // Given
        given(classPathResource.createRelative(resourcePath)).willReturn(expected);

        // When
        final String actual = resolver
            .resolveUrlPathInternal(someString(), mock(List.class), mock(ResourceResolverChain.class));

        // Then
        assertThat(actual, is(resourcePath));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void Can_fail_to_resolve_a_single_file_resources_url_path() {

        // Given
        given(classPathResource.createRelative(resourcePath)).willReturn(null);

        // When
        final String actual = resolver
            .resolveUrlPathInternal(someString(), mock(List.class), mock(ResourceResolverChain.class));

        // Then
        assertThat(actual, nullValue());
    }
}