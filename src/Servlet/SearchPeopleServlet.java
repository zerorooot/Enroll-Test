package Servlet;

import Dao.PeopleDao;
import domain.People;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Author: zero
 * @Date: 2019/12/24 13:45
 */
@WebServlet("/SearchPeopleServlet")
public class SearchPeopleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String tableName = request.getParameter("searchPeopleName");
        PeopleDao peopleDao = new PeopleDao();
        ArrayList<People> peopleArrayList = peopleDao.searchPeopleTable(tableName, "");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = response.getWriter();
        out.println("id  " + " 姓名 "+ "  年纪 "+ " 性别 "+ " 电话 "+ " 报名时间");
        out.println("<br>");
        peopleArrayList.forEach(s->{
            out.println(s.toString());
            out.flush();
            out.println("<br>");
        });
        out.close();
    }

}
