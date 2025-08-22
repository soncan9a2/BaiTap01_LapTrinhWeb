package login;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        // Lấy thông tin trước khi hủy Session
        HttpSession session = request.getSession(false);
        String name = null;
        if(session != null) {
            name = (String)session.getAttribute("name");
            // Hủy Session
            session.invalidate();
        }
        
        if(name != null) {
            out.print("Tạm biệt, " + name + "! Bạn đã đăng xuất thành công");
        } else {
            out.print("Đăng xuất thành công");
        }
    }
}
