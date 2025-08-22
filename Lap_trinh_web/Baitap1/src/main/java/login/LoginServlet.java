package login;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String holot = request.getParameter("holot");
        String ten = request.getParameter("ten");
        
        if(username.equals("thanhnhan") && password.equals("123")) {
            Cookie cookieUsername = new Cookie("username", URLEncoder.encode(username, StandardCharsets.UTF_8));
            Cookie cookieHolot = new Cookie("holot", URLEncoder.encode(holot, StandardCharsets.UTF_8));
            Cookie cookieTen = new Cookie("ten", URLEncoder.encode(ten, StandardCharsets.UTF_8));
            
            cookieUsername.setMaxAge(30);
            cookieHolot.setMaxAge(30);
            cookieTen.setMaxAge(30);
            
            response.addCookie(cookieUsername);
            response.addCookie(cookieHolot);
            response.addCookie(cookieTen);
            
            response.sendRedirect("hello");
        } else {
            response.sendRedirect("Login.html");
        }
    }
}
