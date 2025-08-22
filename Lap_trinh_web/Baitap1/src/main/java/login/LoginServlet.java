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
        
        // Lấy dữ liệu từ tham số của form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String holot = request.getParameter("holot");
        String ten = request.getParameter("ten");
        
        if(username.equals("thanhnhan") && password.equals("123")) {
            // Tạo cookie với encoding để tránh lỗi khoảng trắng
            Cookie cookieUsername = new Cookie("username", URLEncoder.encode(username, StandardCharsets.UTF_8));
            Cookie cookieHolot = new Cookie("holot", URLEncoder.encode(holot, StandardCharsets.UTF_8));
            Cookie cookieTen = new Cookie("ten", URLEncoder.encode(ten, StandardCharsets.UTF_8));
            
            // Thiết lập thời gian tồn tại 30s của cookie
            cookieUsername.setMaxAge(30);
            cookieHolot.setMaxAge(30);
            cookieTen.setMaxAge(30);
            
            // Thêm cookie vào response
            response.addCookie(cookieUsername);
            response.addCookie(cookieHolot);
            response.addCookie(cookieTen);
            
            // Chuyển sang trang HelloServlet
            response.sendRedirect("hello");
        } else {
            // Chuyển sang trang LoginServlet
            response.sendRedirect("Login.html");
        }
    }
}
