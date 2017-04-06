package md.curs.servlets.m22;

import md.curs.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This servlet presents an example of working with jstl and a list of objects
 * Created by MG
 */
@WebServlet(urlPatterns = {"/jstl"})
public class JstlSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Random r = new Random();
        int minorsCount = 0;
        List<User> users = new ArrayList<>();
        for (int i =0; i < 10; i++) {
            User u = new User("Name" + i, "Surname" + i, r.nextInt(50));
            if (u.getAge() < 18) {
                minorsCount++;
            }
            users.add(u);
        }
        req.setAttribute("users", users);
        req.setAttribute("minorsCount", minorsCount);

        // dispatch request to the private.jsp page
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/user-list.jsp");
        dispatcher.forward(req, resp);
    }
}
