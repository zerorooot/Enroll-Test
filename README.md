# Enroll-Test
用jsp+mysql+java写的活动报名小练习

先去 /src/domain/dbconfig.properties 更改你数据库的相关信息

在mysql里创建一个subject的表

CREATE TABLE subject(
name varchar(20) NOT NULL,
time date
);


初始账号密码在/src/Servlet/LoginServlet.java 的第 27行，请自行更改
使用时，进入login.html登录，然后会跳转到manage.jsp页面
先创建一个项目
此时，enroll.jsp的标题就是你所创建的项目名

manage.jsp中的‘搜索项目报名人数’既此项目的报名人数

