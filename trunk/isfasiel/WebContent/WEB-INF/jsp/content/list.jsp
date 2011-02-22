<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert content</title>
</head>
<body>
<form method="post" action="<c:url value="/content/insert.do"/>">
	<input type="text" name="body" value="test body"/>
	<input type="text" name="title" value="test title"/>
	<input type="text" name="userId" value="adm"/>
	<input type="text" name="userIdx" value="1"/>
	<input type="text" name="userName" value="adm"/>
</form>
</body>
</html>