<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
</head>
<link rel="stylesheet" type="text/css" href="/Exam-12699-20161219-1/css/main.css">
<body>
	<a href='/Exam-12699-20161219-1/AppServlet?method=add' id="add">添加</a>
	<table align='center' border='1px' style='margin-top: 20px' width='1100'>
		<tr align="center">
			<th>ID</th>
			<th>标题</th>
			<th>描述</th>
			<th>语言</th>
			<th>操作</th>
		</tr>
    
		<c:forEach items="${films}" var="film" varStatus="order">
			<tr align="center">
				<td>${film.film_id}</td>
				<td>${film.title}</td>
				<td>${film.description}</td>
				<td>${film.language}</td>
				<td><a href='/Exam-12699-20161219-1/AppServlet?method=update&id=${film.film_id}'>修改</a>
					<a href='/Exam-12699-20161219-1/AppServlet?method=delete&id=${film.film_id}'>删除</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>