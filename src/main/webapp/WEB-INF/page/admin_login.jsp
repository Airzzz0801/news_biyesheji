<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
请输入管理员账号密码<br/>
<form action="admin.html" method="post">
账号：<input type="text" name="username"><br/>
密码：<input type="password" name="password"><br/>
<input type="submit" value="登录">
<br/><div style="color:red;">${requestScope.message }</div>
</form>
</body>
</html>