package md.curs.servlets;

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
 * Created by MG
 */
@WebServlet(urlPatterns = {"/call-count"})
public class SessionServlet extends HttpServlet {

    private static final String CALL_COUNT = "call_count";

    private static int globalCallCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer callCount = 0;

        if (session.getAttribute(CALL_COUNT) != null) {
            callCount = (Integer) session.getAttribute(CALL_COUNT);
        }

        callCount++;
        globalCallCount++;
        session.setAttribute(CALL_COUNT, callCount);

        resp.getWriter().println(String.format("<h1>Page called %d times</h1>", callCount));
        resp.getWriter().println(String.format("<h1>Global count: %d times</h1>", globalCallCount));
    }

}
