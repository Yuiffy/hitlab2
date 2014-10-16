<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>带鱼新主页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<h2>
			带鱼图书管理系统
		</h2>

		<table border=2>
			<tr><td><jsp:include page="find.jsp" /></td></tr>
			<tr><td><jsp:include page="newbook.jsp" /></td></tr>
			<tr><td><jsp:include page="newauthor.jsp" /></td></tr>
			<tr><td><jsp:include page="a.jsp" /></td></tr>
		</table>
	</body>
</html>
