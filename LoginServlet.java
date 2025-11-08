import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded validation
        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>Login Successful.</p>");
        } else {
            out.println("<h2>Invalid Credentials!</h2>");
            out.println("<a href='login.html'>Try Again</a>");
        }
    }
}
