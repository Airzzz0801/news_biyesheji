<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="picture">
<a href="testResponseEntity.html">
<img  alt=""   src="images/logo.jpg"/>
</a>
<script type="text/javascript" src="javascript/wrap.js">
</script>
</div>
<div class="zonghe">
综合新闻<br/>
<ul class="neirong">
<c:forEach items="${requestScope.news }" var="u">
<li>
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}
</a>
<li>
</c:forEach>
</ul>
</div>
<div class="zonghe">
通知公告<br/>
<ul class="neirong">
<c:forEach items="${requestScope.tongzhi }" var="u">
<li>
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</li>
</c:forEach>
</ul>
</div>
<div class="rencai">
人才招聘<br/>
<ul class="neirong">
<c:forEach items="${requestScope.rencai }" var="u">
<li>
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</li>
</c:forEach>
</ul>
</div>
<div class="rencai">
学术报告<br/>
<ul class="neirong">
<c:forEach items="${requestScope.xueshu }" var="u">
<li>
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</li>
</c:forEach>
</ul>
</div>
${requestScope.ckValue}<br/>
<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>