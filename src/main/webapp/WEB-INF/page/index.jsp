<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
<link rel="stylesheet" type="text/css" href="css/index.css">
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
<title>校园新闻</title>
<script type="text/javascript">
$(document).ready(function(){
	$(".neirong p:odd").addClass("bg-success");
	$(".neirong p:even").addClass("bg-info");
});
</script>
</head>
<body style="background: #d2d2ff;">
<jsp:include page="head.jsp"></jsp:include>
<!-- <div class="picture"> -->
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>   
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="images/IMG_7895.JPG" style="margin-top:1px;width:100%;height: 458px" alt="First slide">
        </div>
        <div class="item">
            <img src="images/IMG_7896.JPG" style="margin-top:1px;width:100%;height: 458px" alt="Second slide">
        </div>
        <div class="item">
            <img src="images/IMG_7894.JPG" style="margin-top:1px;width:100%;height: 458px" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel" 
        data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#myCarousel" 
        data-slide="next">&rsaquo;
    </a>
</div>
<!-- <a href="testResponseEntity.html">
<img  alt=""   src="images/logo.jpg"/>
</a>
<script type="text/javascript" src="javascript/wrap.js">
</script> -->
<!-- </div> -->
<div class="zonghe">
综合新闻<br/>
<ul class="neirong">
<c:forEach items="${requestScope.news }" var="u">
<p style="margin: 0;text-align: left;font-weight: normal">
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}
</a>
</p>
</c:forEach>
</ul>
</div>
<div class="zonghe">
通知公告<br/>
<ul class="neirong">
<c:forEach items="${requestScope.tongzhi }" var="u">
<p  style="margin: 0;text-align: left;font-weight: normal;">
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</p>
</c:forEach>
</ul>
</div>
<div class="rencai">
人才招聘<br/>
<ul class="neirong">
<c:forEach items="${requestScope.rencai }" var="u">
<p  style="margin: 0;text-align: left;font-weight: normal;">
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</p>
</c:forEach>
</ul>
</div>
<div class="rencai">
学术报告<br/>
<ul class="neirong">
<c:forEach items="${requestScope.xueshu }" var="u">
<p  style="margin: 0;text-align: left; font-weight: normal;">
<a href="browseNewsPaging.html?catalogid=${u.catalog.catalogid }&curragePage=1&newsid=${u.id}">
${u.newsname}<br/>
</a>
</p>
</c:forEach>
</ul>
</div>
${requestScope.ckValue}<br/>
<jsp:include page="foot.jsp"></jsp:include>
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="javascript/bootstrap.min.js"></script>
</body>
</html>