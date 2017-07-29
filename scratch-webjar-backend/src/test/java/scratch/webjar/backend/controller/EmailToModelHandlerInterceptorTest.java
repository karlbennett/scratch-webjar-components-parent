package scratch.webjar.backend.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static shiver.me.timbers.data.random.RandomStrings.someString;
import static shiver.me.timbers.data.random.RandomThings.someThing;

public class EmailToModelHandlerInterceptorTest {

    private EmailToModelHandlerInterceptor interceptor;

    @Before
    public void setUp() {
        interceptor = new EmailToModelHandlerInterceptor();
    }

    @Test
    public void Will_add_the_username_to_the_model_if_the_principal_is_present() throws Exception {

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final ModelAndView modelAndView = mock(ModelAndView.class);

        final Principal principal = mock(Principal.class);
        final String email = someString();

        // Given
        given(request.getUserPrincipal()).willReturn(principal);
        given(principal.getName()).willReturn(email);

        // When
        interceptor.postHandle(request, mock(HttpServletResponse.class), someThing(), modelAndView);

        // Then
        then(modelAndView).should().addObject("email", email);
    }

    @Test
    public void Will_not_try_to_add_the_username_to_the_model_if_the_principal_is_not_present() throws Exception {

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final ModelAndView modelAndView = mock(ModelAndView.class);

        // Given
        given(request.getUserPrincipal()).willReturn(null);

        // When
        interceptor.postHandle(request, mock(HttpServletResponse.class), someThing(), modelAndView);

        // Then
        verifyZeroInteractions(modelAndView);
    }
}