import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Form")
public class FormServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get PrintWriter
        PrintWriter pw = response.getWriter();
        //set Content type
        response.setContentType("text/hmtl");
        //read the form values
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        //load the jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //create the connection
        String jdbcUrl = "jdbc:mysql:///student_table";
        String username = "root";
        String password = "";
        try(Connection con = DriverManager.getConnection(jdbcUrl,username,password)){
            String sql = "INSERT INTO member (firstname,lastname,email,contact,gender,dob) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);

            //set the values
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, contact);
            statement.setString(5, gender);
            statement.setString(6, dob);
            statement.executeUpdate();
        }catch(SQLException se) {
            pw.println(se.getMessage());
            se.printStackTrace();
        }
        response.sendRedirect("success.html");
    }
}
