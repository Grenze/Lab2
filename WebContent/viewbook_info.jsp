<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>书籍及作者信息展示</title>
</head>
<body style="background-image:url(pictures/background.jpg); background-repeat:repeat-y;">
<body>
	<table width="700px" align="center" bgcolor="#008B8B" height="256" border="1" cellpadding="10" cellspacing="0" style="font-family:'楷体'; font-size:20px; height:400px;">
	<caption>
			<br>书籍信息表<br><br>
	</caption>
	<tr>
	<th>国际标准书号</th>
	<th>书籍名称</th>
	<th>作者编号</th>
	<th>出版社</th>
	<th>发行日期</th>
	<th>图书价格</th>
	</tr>
	<tr>
	<td><s:property value="isbn"/></td>
	<td><s:property value="title"/></td>
	<td><s:property value="authorID"/></td>
	<td><s:property value="publisher"/></td>
	<td><s:date name="publishdate" format="yyyy-MM-dd"/></td>
	<td><s:property value="price"/></td>
	</tr>
	</table>
	<br>

	<table width="700px" align="center" bgcolor="#008B8B" height="256" border="1" cellpadding="10" cellspacing="0" style="font-family:'楷体'; font-size:20px; height:400px;">
		<caption>
			<br>作者信息表<br><br>
		</caption>	
	<tr>
	<th>作者编号</th>
	<th>作者姓名</th>
	<th>作者年龄</th>
	<th>作者国籍</th>
	</tr>
	<tr>
	<td><s:property value="authorID"/></td>
	<td><s:property value="name"/></td>
	<td><s:property value="age"/></td>
	<td><s:property value="country"/></td>
	</tr>
	</table><br>
	<div align="center">
	<form action="inputMessage" method="post"><input type="submit" value="返回首页" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 120px; height:40px;"></form><br>
	</div>
</body>
</html>