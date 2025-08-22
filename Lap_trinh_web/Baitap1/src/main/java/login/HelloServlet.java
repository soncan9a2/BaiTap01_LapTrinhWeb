package login;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        String name = "";
        String holot = "";
        String ten = "";
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if(c.getName().equals("username")) {
                    name = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                } else if(c.getName().equals("holot")) {
                    holot = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                } else if(c.getName().equals("ten")) {
                    ten = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                }
            }
        }
        
        if(name.equals("")) {
            response.sendRedirect("Login.html");
        } else {
            printWriter.println("Xin chào " + holot + " " + ten + " (" + name + ")");
        }
    }
}
