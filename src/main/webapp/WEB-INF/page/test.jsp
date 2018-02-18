<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="ckeditor/config.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>Insert title here</title>
</head>
<body>
<form action="index.html" method="post">
<textarea rows="30" cols="50" name="editor01">请输入.</textarea>
<script type="text/javascript">CKEDITOR.replace('editor01');
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