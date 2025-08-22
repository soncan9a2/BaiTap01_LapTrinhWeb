package login;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class CreateSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Khởi tạo session
        HttpSession session = request.getSession();
        
        // Gán dữ liệu vào session
        session.setAttribute("ten", "Huỳnh Thanh Nhân");
        session.setAttribute("tuoi", Integer.valueOf(20));
        
        // Thiết lập thời gian tồn tại session
        session.setMaxInactiveInterval(30);
        
        // Hiển thị thông báo lên web
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Xin chào bạn session đã được tạo");
        out.close();
    }
}
