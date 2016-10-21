<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>作者书籍名称展示</title>
</head>
<body style="background-image:url(pictures/background.jpg); background-repeat:repeat-y;">
<body>
	<div align="center">
	<p><b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者书籍名称展示</b></p>
	<ol>
		<s:iterator value="books" var="s">
		<s:a href="viewbook?title=%{s}">
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;"><s:property value="#s"/><br></b>
		<form action="deleteBook" method="post"><input type="hidden" name="title" value="${s}"><input type="submit" value="删除图书" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 120px; height:40px;"></form>
		</s:a>
		</s:iterator>	
	</ol><br>
	</div>
	<div align="right">
	<form action="inputMessage" method="post"><input type="submit" value="返回首页" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 120px; height:40px;"></form>	
	</div>
</body>
</html>