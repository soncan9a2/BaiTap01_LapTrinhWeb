package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deletecookie")
public class DeleteCookie extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        
        cookies = request.getCookies();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if (cookies != null) {
            out.println("<h2> Cookies Name and Value</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("ten") == 0) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.print("Deleted cookie : " + cookie.getName() + "<br/>");
                }
                out.print("Name : " + cookie.getName() + ", ");
                out.print("Value: " + cookie.getValue() + " <br/>");
            }
        } else {
            out.println("<h2>No cookies found</h2>");
        }
        
        out.println("<br><br><a href='index.html'>Back to Form</a>");
        out.println("<br><a href='readcookie'>Read Cookies</a>");
        out.close();
    }
}
