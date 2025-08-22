package login;

import java.io.IOException;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;
import java.io.PrintWriter;


public class ShowSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Hiển thị session lên web
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String ten = "";
        
        HttpSession session = request.getSession(); // Khởi tạo session
        Object obj = session.getAttribute("ten"); // Truy xuất dữ liệu từ session
        
        // Kiểm tra đối tượng Object có null không
        if(obj != null) {
            ten = String.valueOf(obj); // Ép kiểu về String
        } else {
            response.sendRedirect("createsession"); // Nếu null thì chuyển về trang tạo session
            return;
        }
        
        int tuoi = (Integer)session.getAttribute("tuoi"); // Ép kiểu
        
        // Hiển thị session lên web
        out.println("Xin chào bạn: " + ten + " tuổi: " + tuoi);
        out.close();
    }
}
