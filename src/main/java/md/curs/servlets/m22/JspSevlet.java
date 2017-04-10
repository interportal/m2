package md.curs.servlets.m22;

import md.curs.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet presents an example of working with jsp and simple objects
 * Created by MG
 */
@WebServlet(urlPatterns = {"/jsp"})
public class JspSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("Robert", "Carlson", 54);
        req.setAttribute("user", user);

        // initialize dispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/private.jsp");
        // forward request to jsp view
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");

        Integer age = 0;
        try {
            age = Integer.parseInt(req.getParameter("age")) + 10;
        } catch (NumberFormatException e) {
            System.out.println("Age NAN: " + req.getParameter("age"));
        }

        // we may save the user now
        User user = new User(name, surname, email, age);
        req.setAttribute("user", user);

        // initialize dispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/private.jsp");
        // forward request to jsp view
        dispatcher.forward(req, resp);
    }
}
