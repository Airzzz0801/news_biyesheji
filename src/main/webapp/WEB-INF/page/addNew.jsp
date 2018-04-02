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
<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="javascript/ajaxfileupload.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
function uploadFile(obj, type) {  
	  
    $.ajaxFileUpload({  
        url : "downloadsave.do",
        secureuri : false,// 一般设置为false  
        fileElementId : "fileUpload1",// 文件上传表单的id <input type="file" id="fileUpload" name="file" />  
        dataType : 'JSON',// 返回值类型 一般设置为json  
        data: {'type': type},
        success : function(data) // 服务器成功响应处理函数  
        {  
        	var aToString=JSON.stringify(data);
        	result = $.parseJSON(data.replace(/<.*?>/ig,""));
        	alert("上传成功，文件名"+result.save);
        	document.getElementById("download1").value=result.save;
                },  
        error : function(data)// 服务器响应失败处理函数  
        {  
            console.log("服务器异常");  
        }  
    });  
    return false;  
}  

</script>
<title>新闻添加</title>
</head>
<body>
<form action="addNew_success.html" method="post" enctype="multipart/form-data">
新闻标题：<input type="text" name="newsname"><br/>
是否置顶：<label><input type="radio" name="flag" value="1">是</label>
<label><input type="radio" name="flag" value="0" checked="checked">否</label><br/>
上传封面图片：<input type="file" accept="image/png,image/gif" name="file"><br/>
上传附件:<input type="file" name="fileUpload1" id="fileUpload1" onchange ="uploadFile(this,1)">最大1024MB<br/>
<input type="hidden" value="" id="download1" name="download1">
来源：<input type="text" name="origin"><br/>
类型：<select name="catalog">
<c:forEach items="${requestScope.catalogs}" var="u">
<option value="${u.catalogid}">${u.catalogname}</option>
</c:forEach>
</select><br/>
<textarea rows="30" cols="50" name="news">请输入.</textarea>
<script type="text/javascript">CKEDITOR.replace('news',{   
	filebrowserImageUploadUrl : 'imageUpload.do',  
	language : 'zh-cn',  
	});
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