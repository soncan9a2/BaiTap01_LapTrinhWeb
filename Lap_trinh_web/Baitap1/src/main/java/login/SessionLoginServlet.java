package login;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class SessionLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username.equals("thanhnhan") && password.equals("123")) {
            out.print("Chào mừng bạn, " + username);
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
        } else {
            out.print("Tài khoản hoặc mật khẩu không chính xác");
            request.getRequestDispatcher("SessionLogin.html").include(request, response);
        }
    }
}
