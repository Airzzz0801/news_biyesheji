<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="ckeditor/config.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>新闻修改</title>
</head>
<body>
<form action="changeNew_success.html" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${requestScope.newsid}" />
新闻标题：<input type="text" name="newsname" value="${requestScope.newsname }"><br/>
是否置顶：<label><input type="radio" name="flag" id="flag" value="1">是</label>
<label><input type="radio" name="flag" id="flag" value="0" checked="checked">否</label><br/>
<input type="hidden" name="image" value="${requestScope.image }">
上传封面图片：<input type="file" accept="image/png,image/gif" name="file"><br/>
来源：<input type="text" name="origin" value="${requestScope.origin }"><br/>
<input type="hidden" name="time" value="${requestScope.date }">
类型：<select name="catalog">
<c:forEach items="${requestScope.catalogs}" var="u">
<option value="${u.catalogid}">${u.catalogname}</option>
</c:forEach>
</select><br/>
<textarea rows="30" cols="50" name="news">${requestScope.news }</textarea>
<script type="text/javascript">CKEDITOR.replace('news');
function OnSave(){  
	        if(CKEDITOR.instances.editor01.getData()==""){  
	        alert("内容不能为空！");  
	        return false;  
	        }else {  
	        alert(CKEDITOR.instances.editor01.getData());  
	        }  
	    }  
	 </script>  
	<input type="submit" value="提交">
</form>
</body>
</html>