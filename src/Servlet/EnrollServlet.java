package Servlet;

import Dao.PeopleDao;
import domain.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zero
 * @Date: 2019/12/24 15:21
 */
@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = dateFormat.format(new Date());
        Timestamp currentTime=Timestamp.valueOf(dateFormat.format(new Date()));
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        String gender = request.getParameter("gender");
        String tele = request.getParameter("tele");


        People people = new People(name, gender, grade, tele, currentTime);
        PeopleDao peopleDao = new PeopleDao();

        if (peopleDao.insertPeople((String) request.getServletContext().getAttribute("subject"), people) == 1) {
            response.getWriter().println("<script type=\"text/javascript\">alert(\"报名成功\");" +
                    "window.location" +
                    ".href='enroll.jsp';</script>");
        }else {
            response.getWriter().println("<script type=\"text/javascript\">alert(\"报名失败！！活动时间已截止\");" +
                    "window.location" +
                    ".href='enroll.jsp';</script>");
        }

    }

}
