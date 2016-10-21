<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>欢迎来到图书信息管理系统！</title>
</head>
<embed src="musics/background.mp3" hidden=true autostart=true loop=true volume="50"> </embed>
<body style="background-image:url(pictures/background.jpg); background-repeat:repeat-y;">
<body>
	<div align="center">
	<form Action = "author_books.action" method = "post">
	<fieldset>
		<legend><b style="font-family:'楷体'; background-color:transparent; font-size:20px;">查询作者</b></legend>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者姓名:</b>
		<br><input name = "name" type = "text" maxlength="30" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br><br>
		<input type = "submit" value = "搜索" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 100px; height:40px;">
	</fieldset>
	</form>
	<form action="add_newbook.action" method = "post">
	<fieldset>
		<legend><b style="font-family:'楷体'; background-color:transparent; font-size:20px;">创建新书</b></legend>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">国际标准书号:</b>
		<br><input name = "isbn" type = "text" maxlength="13" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">书籍名称:</b>
		<br><input name = "title" type = "text" maxlength="50" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者编号:</b>
		<br><input name = "authorID" type = "text" maxlength="5" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">出版社:</b>
		<br><input name = "publisher" type = "text" maxlength="40" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">发行日期:</b>
		<br><input name = "publish_date" type = "text" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">图书价格:</b>
		<br><input name = "price" type = "text" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br><br>
		<input type = "submit" value = "提交" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 100px; height:40px;"><br>
	</fieldset>
	</form>
	<form action="update_book.action" method = "post">
	<fieldset>
		<legend><b style="font-family:'楷体'; background-color:transparent; font-size:20px;">更新图书</b></legend>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">国际标准书号:</b>
		<br><input name = "isbn" type = "text" maxlength="13" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">作者编号:</b>
		<br><input name = "authorID" type = "text" maxlength="5" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">出版社:</b>
		<br><input name = "publisher" type = "text" maxlength="40" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">发行日期:</b>
		<br><input name = "publish_date" type = "text" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br>
		<b style="font-family:'楷体'; background-color:transparent; font-size:20px;">图书价格:</b>
		<br><input name = "price" type = "text" style="font-family:'楷体'; background-color:transparent; font-size:20px;"><br><br>
		<input type = "submit" value = "提交" style="font-family:'楷体'; background-color:transparent; font-size:25px;width: 100px; height:40px;"><br>
	</fieldset>
	</form>
	</div>
	
	<table width="700px" align="center" bgcolor="#008B8B" border="1" cellpadding="7" cellspacing="0" style="font-family:'楷体'; font-size:20px; height:200px;">
		<caption>
			<br>作者信息表<br><br>
		</caption>
		<s:iterator value="Author_List" status="st">
			<tr>
				<s:iterator value="Author_List.get(#st.index)">
					<td valign="middle" align="center">
						<s:property/>
					</td>
				</s:iterator>
			</tr>
		</s:iterator>	
	</table>
	<table width="700px" align="center" bgcolor="#008B8B" border="1" cellpadding="7" cellspacing="0" style="font-family:'楷体'; font-size:20px; height:200px;">
		<caption>
			<br>书籍信息表<br><br>
		</caption>
		<s:iterator value="Book_List" status="st">
			<tr>
				<s:iterator value="Book_List.get(#st.index)">
					<td valign="middle" align="center">
						<s:property/>
					</td>
				</s:iterator>
			</tr>
		</s:iterator>	
	</table>
</body>
</html>