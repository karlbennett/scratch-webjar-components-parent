package scratch.webjar.backend.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * @author Karl Bennett
 */
public class EmailToModelHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView
    ) throws Exception {
        final Principal principal = request.getUserPrincipal();
        if (principal != null) {
            modelAndView.addObject("email", principal.getName());
        }
    }
}
