<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录系统</title>
</head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<body>
<div>
 <span>电影租赁系统</span><br><br><br>
<form action="/Exam-12699-20161219-1/AppServlet" method="post">
	<input name="method" value="login" type="hidden">
	<input name="path" value="${path}" type="hidden">
	请输入first_name：<input type="text" name="first_name"><span>${message}</span><br><br><br>
	<input type="submit" value="登录">
	<input type="reset" value="重置">
</form>
</div>
</body>
</html>