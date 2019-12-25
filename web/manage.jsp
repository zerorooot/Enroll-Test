<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: msj10
  Date: 2019/12/23
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>

<body>
<%
    if (Objects.isNull(session.getAttribute("admin"))) {
        out.print("<h1>请登录</h1>");
        return;
    }
%>
<form method="post" action="SubjectServlet">
    创建项目名：<input type="text" name="createName">
    <br>
    <input type="submit" value="确定">
</form>

<form method="post" action="SubjectServlet">
    <br>
    搜索项目名：<input type="text" name="searchName">
    <br>
    <input type="submit" value="确定">
</form>


<form method="post" action="SubjectServlet">
    <br>
    删除项目：<input type="text" name="deleteName">
    <br>
    <input type="submit" value="确定">
</form>


<form method="post" action="SearchPeopleServlet">
    <br>
    搜索项目报名人数：<input type="text" name="searchPeopleName">
    <br>
    <input type="submit" value="确定">
</form>

</body>
</html>
