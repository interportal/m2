package md.curs.servlets.m21;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

/**
 * This servlet presents an example of working with HTTP Sessions
 *
 * @author MG
 */
@WebServlet(urlPatterns = {"/call-count"})
public class SessionServlet extends HttpServlet {

    /**
     * Session attribute key
     */
    private static final String CALL_COUNT = "call_count";

    /**
     * This static variable will all call counts to this Servlet across all Sessions
     */
    private static int globalCallCount = 0;

    /**
     * Will display 2 lines: </br>
     * First line  - The session call count (how many times this Servlet was called during the current Session). </br>
     * Second line - The Global call count (how many times this Servlet was called in total across all Sessions).
     *
     * @param req  request
     * @param resp response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get current session
        HttpSession session = req.getSession();
        Integer callCount = 0;

        // get the CALL_COUNT attribute from the session if exists
        if (session.getAttribute(CALL_COUNT) != null) {
            callCount = (Integer) session.getAttribute(CALL_COUNT);
        }

        callCount++;
        globalCallCount++;

        // set the updated CALL_COUNT attribute back to Sesson
        session.setAttribute(CALL_COUNT, callCount);

        // write response
        resp.getWriter().println(String.format("<h1>Page called %d times</h1>", callCount));
        resp.getWriter().println(String.format("<h1>Global count: %d times</h1>", globalCallCount));
    }

}
