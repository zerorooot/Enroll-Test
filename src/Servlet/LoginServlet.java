package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: zero
 * @Date: 2019/12/23 9:37
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String password = request.getParameter("userPassword");
        String vc = request.getParameter("vcname");
        HttpSession session = request.getSession();

        System.out.println(name + "   " + password + "    " + vc);
        System.out.println(session.getAttribute("vc"));

        if (vc.equalsIgnoreCase((String) session.getAttribute("vc"))) {
            if ("admin".equals(name) && "qazwsx".equals(password)) {
                session.setAttribute("userName", name);
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("<script type=\"text/javascript\">alert(\"登录成功\");window.location" +
                        ".href='manage.jsp';</script>");
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("<script type=\"text/javascript\">alert(\"error\");window.location" +
                        ".href='login.html';</script>");
            }
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("<script type=\"text/javascript\">alert(\"error\");window.location" +
                    ".href='login.html';</script>");
        }

        session.setAttribute("admin", name);
    }

}
