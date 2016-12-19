<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加电影 </title>
</head>
<script type="text/javascript" src="/Exam-12699-20161219-1/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	//form提交前，验证
	function check() {
		var title = $("#title").val();
		var description = $("#description").val();
		if (title == "") {
			alert("必须填写标题！");
			return false;
		} else if (description == "") {
			alert("必须填写描述！");
			return false;
		} else {
			return true;
		}
	}
</script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<body>
<form action="/Exam-12699-20161219-1/AppServlet" method="post" onsubmit="return check()">
	<input name="method" value="toAdd" type="hidden"><br>
		<table align="center" border="0px" style="margin-top: 20px"
			width="300">		
			<tr align="center">
				<td>标题</td>
				<td><input id="title" type="text" name="title"/></td>
			</tr>
			<tr align="center">
				<td>描述</td>
				<td><textarea name="description" id="description" rows="10" cols="25" ></textarea></td>
			</tr>
			<tr align="center">
				<td>语言</td>
			<td>
				<select name="language" style="width: 130px">
				<c:forEach items="${languages}" var="language">
				 <option value="${language.language_id}">${language.name}</option>
				</c:forEach>
				</select>
			</td>
			</tr>
		</table>
		<div align="center" style="margin-top: 10px">
			<input type="submit" value="保存" />
		</div>
	</form>
</body>
</html>