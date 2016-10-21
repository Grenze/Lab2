<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加作者</title>
</head>
<body style="background-image:url(pictures/background.jpg); background-repeat:repeat-y;">
<body>
	<div align="center">
	<form action="add_newauthor.action" method = "post">
	<fieldset>
		<legend><b style="font-family:'楷体'; background-color:transparent; font-size:20px;">添加作者</b></legend>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者编号:</b>
		<br><input type="text" name="author_ID" value="${authorID}" readonly="readonly" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<input type="hidden" name="title" value="${title}">
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者姓名:</b>
		<br><input name="name" type="text" maxlength="30" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者年龄:</b>
		<br><input name="age" type="text" maxlength="3" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者国籍:</b>
		<br><input name="country" type="text" maxlength="15" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br><br>
		<input type="submit" value="提交" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 100px; height:40px;">
	</fieldset>
	</form>
	</div>
</body>
</html>