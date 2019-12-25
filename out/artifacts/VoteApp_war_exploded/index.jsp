<%--
  Created by IntelliJ IDEA.
  User: msj10
  Date: 2019/12/23
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  lang="en">
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END
  <form method="post" action="TestServlet">
    <input type="text" name="name">
    <input type="submit"  name="sub" id="search">
  </form>
<h1><%
  for (int i=0; i<10;i++ ) {
  out.print(i);
  }
%>nihaoma</h1>

  </body>
</html>
