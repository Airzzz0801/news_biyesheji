<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">   
    <link rel="stylesheet" type="text/css" href="themes/icon.css">   
    <link rel="stylesheet" type="text/css" href="css/admin.css" rel="external nofollow" > 
    <script type="text/javascript" src="javascript/jquery.min.js"></script>   
    <script type="text/javascript" src="javascript/jquery.easyui.min.js"></script>
<style type="text/css">
p{
display: inline;
}
</style>
<title>管理系统</title>
</head>
<body style="background-color:#FFFFF0;">
<div id="header" >
    <div class="logo" onclick="window.location.href='admin.html'">
      <strong>管理系统</strong>
    </div>
  </div>
欢迎您，管理员${sessionScope.user.username}</br>
<a href="logout.html"class="easyui-linkbutton">注销</a>
<a href="addNew.html" target="_blank" class="easyui-linkbutton">增加新闻</a>
<div>
<br/>
<br/>
<table class="easyui-datagrid" id="a"
data-options="fitColumns:true" singleSelect="true" url="changNews.html"
>
    <thead>
		<tr>
			<th data-options="field:'name',width:100">标题</th>
			<th data-options="field:'time',width:200">时间</th>
			<th data-options="field:'caltalog',width:100">种类</th>
			<th data-options="field:'origin',width:100">来源</th>
			<th data-options="field:'download',width:100">下载</th>
			<th data-options="field:'change',width:100,align:'right'">修改</th>
			<th data-options="field:'delete',width:100,align:'right'">删除</th>
		</tr>
    </thead>
    <tbody>
    <c:forEach items="${pageInfo.list }" var="u">
		<tr>
			<td>${u.newsname}</td>
			<td>${u.date}</td>
			<td>${u.catalog.catalogname}</td>
			<td>${u.origin}</td>
			<td><c:if test="${u.download!=null}">
			<a href="download.html?download=${u.download}" target="_balnk">下载</a></c:if></td>
			<td><a href="changeNew.html?catalogid=${u.catalog.catalogid }&newsid=${u.id}" target="_balnk">修改</a></td>
			<td><a href="deleteNew.html?catalogid=${u.catalog.catalogid }&newsid=${u.id}" target="_blank">删除</a></td>
		</tr>
</c:forEach>
	</tbody>
</table>
</div>
 <div class="row">  
        <!--文字信息-->  
        <div class="col-md-6" style="text-align: center;">  
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录  
        </div>  
  
        <!--点击分页-->  
        <div class="col-md-6">  
            <nav aria-label="Page navigation">  
                <ul class="pagination" style="text-align: center;">  
                      
                    <p><a class="easyui-linkbutton" href="${pageContext.request.contextPath}/changeNews.html?pn=1">首页</a></p>  
                      
                    <!--上一页-->  
                    <p>  
                        <c:if test="${pageInfo.hasPreviousPage}">  
                            <a href="${pageContext.request.contextPath}/changeNews.html?pn=${pageInfo.pageNum-1}" aria-label="Previous">  
                                <span aria-hidden="true" class="easyui-linkbutton">«</span>  
                            </a>  
                        </c:if>  
                    </p>  
  
                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->  
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">  
                        <c:if test="${page_num == pageInfo.pageNum}">  
                            <p class="active"><a  class="easyui-linkbutton" href="#">${page_num}</a></p>  
                        </c:if>  
                        <c:if test="${page_num != pageInfo.pageNum}">  
                            <p><a  class="easyui-linkbutton" href="${pageContext.request.contextPath}/changeNews.html?pn=${page_num}">${page_num}</a></p>  
                        </c:if>  
                    </c:forEach>  
  
                    <!--下一页-->  
                    <p>  
                        <c:if test="${pageInfo.hasNextPage}">  
                            <a href="${pageContext.request.contextPath}/changeNews.html?pn=${pageInfo.pageNum+1}"  
                               aria-label="Next">  
                                <span aria-hidden="true" class="easyui-linkbutton">»</span>  
                            </a>  
                        </c:if>  
                    </p>  
                      
                    <p><a class="easyui-linkbutton" href="${pageContext.request.contextPath}/changeNews.html?pn=${pageInfo.pages}">尾页</a></p>  
                </ul>  
            </nav>  
        </div>  
        </div>
        <div id="bootom">
    <div id="bootom_content">
      <p style="display: block;"><strong>关于我们      法律声明      服务条款     联系我们</strong></p>
      <p style="display: block;"> 
      陶佳建
      </p>
      <p style="display: block;">
      14通信工程
      </p>
    </div>
  </div>
</body>
</html>