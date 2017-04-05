package md.curs.listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by MG
 */
@WebFilter(urlPatterns = {"/params"})
public class CensorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Censor Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // executed before servlet
        String message = request.getParameter("msg");
        System.out.println("filter message: " + message);
        if ("hacker".equalsIgnoreCase(message)) {
            ((HttpServletResponse) response).sendRedirect("/params?msg=CENSORED");
            return;
        }

        chain.doFilter(request, response);

        // executed after servlet
    }

    @Override
    public void destroy() {
        System.out.println("Censor filter destroyed");
    }
}
