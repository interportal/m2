package md.curs.servlets.m21;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This Servlet just returns response messages for {@code GET} and {@code POST} HTTP messages. <br/>
 * It is mapped to '/first' URL
 *
 * @author MG
 */
@WebServlet(urlPatterns = {"/first"})
public class FirstServlet extends HttpServlet {

    /**
     * Process the {@code GET} request
     *
     * @param req  request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello Get!</h1>");
    }

    /**
     * Process the {@code POST} request
     *
     * @param req  request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Hello Get!</h1>");
    }
}
