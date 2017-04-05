package md.curs.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by MG
 */
@WebServlet(urlPatterns = {"/params"})
public class ParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //http://localhost:8080/params?msg=Hello

        String message = req.getParameter("msg");
        resp.getWriter().println("All parameters: " + Collections.list(req.getParameterNames()));
        resp.getWriter().println("Your message: " + message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (parameterMap.containsKey("msg")) {
            resp.getWriter().println("your message: " + parameterMap.get("msg")[0]);
        } else {
            resp.getWriter().println("You have not provided any message");
        }
    }
}
