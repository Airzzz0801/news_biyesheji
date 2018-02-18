<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
欢迎您，管理员${sessionScope.admin.username}<a href="logout.html">注销</a><br/>
<a href="addNew.html" target="_blank">增加新闻</a>
<div>
<br/>
<c:forEach items="${requestScope.news }" var="u">
${u.newsname}
<a href="changeNew.html?catalogid=${u.catalog.catalogid }&newsid=${u.id}" target="_balnk">
修改</a>
<a href="deleteNew.html?catalogid=${u.catalog.catalogid }&newsid=${u.id}" target="_blank">
删除</a>
<br/>
</c:forEach>
</div>
</body>
</html>