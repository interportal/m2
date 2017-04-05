package md.curs.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Example of a Listener that is notified of creation / destruction of sessions
 *
 * @author MG
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    /**
     * This method will be called when a new session is created (i.e. a new client called our app)
     *
     * @param se Session event
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created");
    }

    /**
     * This method will be called when a session is destroyed
     *
     * @param se Session event
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session destroyed");
    }
}
