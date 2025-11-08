import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("sid");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Attendance VALUES (?, ?, ?)");
            ps.setInt(1, Integer.parseInt(sid));
            ps.setString(2, date);
            ps.setString(3, status);

            int result = ps.executeUpdate();

            if (result > 0)
                out.println("<h2>Attendance marked successfully!</h2>");
            else
                out.println("<h2>Failed to mark attendance.</h2>");

            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}
