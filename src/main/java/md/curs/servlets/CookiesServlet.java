package md.curs.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * This Servlet presents an example of working with Cookies
 *
 * @author MG
 */
@WebServlet(urlPatterns = {"/cookies"})
public class CookiesServlet extends HttpServlet {

    private static final String COOKIES = "cookies_count";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get all received cookies
        Cookie[] cookies = req.getCookies();
        if (cookies == null) cookies = new Cookie[0];

        // Filter cookies that have the COOKIES name and get an optional of one
        Optional<Cookie> optionalCookie = Arrays.stream(cookies)
                .filter(c -> c.getName().equals(COOKIES))
                .findAny();

        // Get the cookie if exists, else create a new one
        Cookie cookie = optionalCookie.orElseGet(() -> new Cookie(COOKIES, "0"));

        // Increment the cookie value
        cookie.setValue(increment(cookie.getValue()));

        // write cookie value as response
        resp.getWriter().println(String.format("<h1>You have %s cookies!</h1>", cookie.getValue()));

        // add the updated cookie to response
        resp.addCookie(cookie);
    }

    private String increment(String number) {
        // bad code :P
        // never trust client data, this code should handle cases when number is NAN (Not A Number)
        return String.valueOf(Integer.parseInt(number) + 1);
    }

}
