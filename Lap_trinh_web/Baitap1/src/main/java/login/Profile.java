package login;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        String name = null;
        if(session != null) {
            name = (String)session.getAttribute("name");
        }
        
        if(session != null && name != null) {
            out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
        } else {
            out.print("Xin vui lòng đăng nhập");
            response.sendRedirect("SessionLogin.html");
        }
    }
}
