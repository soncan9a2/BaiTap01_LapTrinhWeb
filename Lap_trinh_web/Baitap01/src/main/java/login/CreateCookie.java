package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createcookie")
public class CreateCookie extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String holot = request.getParameter("holot");
        
        Cookie firstName = new Cookie("ten", ten);
        Cookie lastName = new Cookie("holot", holot);
        
        firstName.setMaxAge(60 * 60 * 24);
        lastName.setMaxAge(60 * 60 * 24);
        
        response.addCookie(firstName);
        response.addCookie(lastName);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b>First Name</b>: " + firstName.getValue() + " - <b>Last Name</b>: " + lastName.getValue());
        out.println("<br><br><a href='readcookie'>Read Cookies</a>");
        out.println("<br><a href='index.html'>Back to Form</a>");
    }
}
