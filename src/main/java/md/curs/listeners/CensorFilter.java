package md.curs.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Example of a Filter that limits a request depending on the message of a parameter
 *
 * @author MG
 */
@WebFilter(urlPatterns = {"/params"})
public class CensorFilter implements Filter {
    /**
     * This method will be called when Filter is initialized (Application started)
     *
     * @param filterConfig Filter configuration
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Censor Filter init");
    }

    /**
     * The main filter method, this is where the filter action happens
     *
     * @param request  The intercepted request being sent to servlet
     * @param response The intercepted response being sent from servlet back to client
     * @param chain    The chain (filters and servlet) that is configured to be called after this filter
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // This code is executed before the Servlet handling

        // Get the "msg" parameter from request
        String message = request.getParameter("msg");

        // if it exists and is equal to our censored value, then redirect to "/params?msg=CENSORED"
        if ("hacker".equalsIgnoreCase(message)) {
            ((HttpServletResponse) response).sendRedirect("/params?msg=CENSORED");
            return;
        }

        // pass call to the filter chain, eventually arriving at the destination servlet
        chain.doFilter(request, response);

        // Here you can add code that is executed after Servlet handling
    }

    /**
     * This method will be called when Filter is destroyed (Application is being shut down)
     */
    @Override
    public void destroy() {
        System.out.println("Censor filter destroyed");
    }
}
