package Servlet;

import Dao.PeopleDao;
import Dao.SubjectDao;
import domain.Subject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @Author: zero
 * @Date: 2019/12/23 11:42
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String createName = request.getParameter("createName");
        String searchName = request.getParameter("searchName");
        String deleteName = request.getParameter("deleteName");

        System.out.println("createName   " + createName);
        System.out.println("searchName   " + searchName);
        System.out.println("deleteName   " + deleteName);


        SubjectDao subjectDao = new SubjectDao();
        PeopleDao peopleDao = new PeopleDao();
        boolean exitSubject = subjectDao.findSubjectName(createName) || subjectDao.findSubjectName(deleteName);

        System.out.println(exitSubject);


        if (exitSubject && Objects.nonNull(createName)) {
            response.getWriter().println("<script type=\"text/javascript\">alert(\"请勿重复创建\");window.location" +
                    ".href='manage.jsp';</script>");
        }

        //创建项目
        if (!exitSubject && Objects.nonNull(createName) && !"".equals(createName)) {
            int result = subjectDao.createSubject(createName);
            peopleDao.createPeopleTable(createName);
            if (result == 1) {
                response.getWriter().println("<script type=\"text/javascript\">alert(\"创建 " + createName + " 成功\");" +
                        "window.location" +
                        ".href='manage.jsp';</script>");

                //保存项目名到application域中
                request.getServletContext().setAttribute("subject", createName);

            } else {
                response.getWriter().println("<script type=\"text/javascript\">alert(\"创建 " + createName + " 失败！！\");" +
                        "window.location" +
                        ".href='manage.jsp';</script>");
            }
        }

        //搜索项目
        if (Objects.nonNull(searchName)) {
            ArrayList<Subject> subjectArrayList = subjectDao.searchSubject(searchName);
            //无缓存
            response.setHeader("pragma", "no-cache");
            response.setHeader("cache-control", "no-cache");
            PrintWriter out = response.getWriter();
            out.println("项目名称           " + " 创建时间 ");
            out.println("<br>");
            subjectArrayList.forEach(s -> {
                out.println(s.getName() + "    " + s.getTime());
                out.println("<br>");
                out.flush();
            });

            out.println("<a href=\"manage.jsp\">返回</a>");
            out.close();
        }

        //删除项目
        if (exitSubject && Objects.nonNull(deleteName)) {
            if (!"".equals(deleteName)) {
                peopleDao.deletePeople(deleteName);
                int result = subjectDao.deleteSubject(deleteName);
                if (result == 1) {
                    response.getWriter().println("<script type=\"text/javascript\">alert(\"删除 " + deleteName + " " +
                            "成功\");" +
                            "window.location" +
                            ".href='manage.jsp';</script>");
                } else {
                    response.getWriter().println("<script type=\"text/javascript\">alert(\"删除 " + deleteName + " 失败！！\");" +
                            "window.location" +
                            ".href='manage.jsp';</script>");
                }
            }else {
                response.getWriter().println("<script type=\"text/javascript\">alert(\"删除 " + deleteName + " 失败！！\");" +
                        "window.location" +
                        ".href='manage.jsp';</script>");
            }
        }


    }
}
