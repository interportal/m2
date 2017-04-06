package md.curs.servlets.m21;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * This Servlet presents an example of working with query parameters and post data
 *
 * @author MG
 */
@WebServlet(urlPatterns = {"/params"})
public class ParametersServlet extends HttpServlet {

    private static final String MSG_KEY = "msg";

    /**
     * Displays back the MSG_KEY sent query parameter
     *
     * @param req   request
     * @param resp  response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // example url:
        // http://localhost:8080/params?msg=Hello

        // get query parameter
        String message = req.getParameter(MSG_KEY);

        // write response
        resp.getWriter().println("All parameters: " + Collections.list(req.getParameterNames()));
        resp.getWriter().println("Your message: " + message);
    }

    /**
     * Displays back the MSG_KEY query parameter or post data
     * @param req   request
     * @param resp  response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the parameters map which holds data for both query and post data
        Map<String, String[]> parameterMap = req.getParameterMap();

        // display response depending on the existence of the MSG_KEY in parameters map
        if (parameterMap.containsKey(MSG_KEY)) {
            resp.getWriter().println("your message: " + parameterMap.get(MSG_KEY)[0]);
        } else {
            resp.getWriter().println("You have not provided any message");
        }
    }
}
