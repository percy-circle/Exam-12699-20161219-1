<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="/Exam-12699-20161219-1/css/zzsc.css">
<link rel="stylesheet" type="text/css" href="/Exam-12699-20161219-1/dist/css/txt.wav.css">
<body>
<div class="txtwav flip">
    <span>电影租赁系统</span><br><br><br>
    <a href="login.jsp">登录</a>
	<a href="add.jsp">添加</a>
	<a href="/Exam-12699-20161219-1/AppServlet?method=findAllFilm">删除</a>
	<a href="/Exam-12699-20161219-1/AppServlet?method=findAllFilm">编辑</a>
	<a href="/Exam-12699-20161219-1/AppServlet?method=findAllFilm">修改</a>
	<a href="/Exam-12699-20161219-1/AppServlet?method=exit">注销用户</a>
</div>
	
</body>
</html>