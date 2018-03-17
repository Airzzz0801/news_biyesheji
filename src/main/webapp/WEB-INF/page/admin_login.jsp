<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <!-- 引用的css -->
  <link rel="stylesheet" type="text/css" href="themes/default/easyui.css" rel="external nofollow" >  
  <link rel="stylesheet" type="text/css" href="themes/default/panel.css" rel="external nofollow" >  
  <link rel="stylesheet" type="text/css" href="themes/icon.css" rel="external nofollow" > 
  <link rel="stylesheet" type="text/css" href="css/admin.css" rel="external nofollow" > 
  <script type="text/javascript" src="javascript/jquery.min.js"></script>
  <script type="text/javascript" src="javascript/jquery.easyui.min.js"></script>
  <title>系统首页</title>
</head>
<body>
  <div id="header" >
    <div class="logo" onclick="window.location.href='admin.html'">
      <strong>管理系统</strong>
    </div>
  </div>
  <div id="picture" style="background:url(images/IMG_7891.JPG) no-repeat; background-size: cover;">
  <div data-options=" region:'east',split:true,style:{position:'absolute',right:50,top:150}"
 class="easyui-panel " title="用户登录" style="width:300px;text-align: center;">
      <div style="padding:10px 60px 20px 60px">
        <!-- <form class="easyui-form" method="post" action="admin.html">
          <input type="text" class="easyui-textbox" style="width:100%;height:32px"/>
           <input type="password" class="easyui-textbox" style="width:100%;height:32px"></input>
        <div style="text-align:center;padding:5px; ">
          <input class="easyui-linkbutton" style="width:45%;height:32px" type="submit" value="登陆">
        </div> -->
        <form action="admin.html" method="post">
账号：<input type="text" name="username" style="width:100%;height:32px;"class="easyui-textbox"><br/>
密码：<input type="password" name="password" style="width:100%;height:32px"class="easyui-textbox"><br/>
<input type="submit" value="登录" style="width:45%;height:32px"class="easyui-linkbutton">
        </form>
         <!-- <a href="#" rel="external nofollow" rel="external nofollow" class="easyui-linkbutton" style="width:45%;height:32px">登录</a>     -->
      </div>
    </div>
  </div>
  <div id="bootom">
    <div id="bootom_content">
      <p><strong>关于我们      法律声明      服务条款     联系我们</strong></p>
      <p> 
      陶佳建
      </p>
      <p>
      14通信工程
      </p>
    </div>
  </div>
</body>
</html>
<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</html> --%>