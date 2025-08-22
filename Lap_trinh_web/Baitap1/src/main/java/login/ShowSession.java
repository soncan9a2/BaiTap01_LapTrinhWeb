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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String ten = "";
        
        HttpSession session = request.getSession(); 
        Object obj = session.getAttribute("ten"); 
        
        if(obj != null) {
            ten = String.valueOf(obj); 
        } else {
            response.sendRedirect("createsession"); 
            return;
        }
        
        int tuoi = (Integer)session.getAttribute("tuoi"); 
        
        // Hiển thị session lên web
        out.println("Xin chào bạn: " + ten + " tuổi: " + tuoi);
        out.close();
    }
}
