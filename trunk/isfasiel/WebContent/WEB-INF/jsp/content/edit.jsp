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
<form method="post" action="<c:url value="/app/content/insert.do"/>">
	<input type="text" name="body" value="test body"/><br/>
	<input type="text" name="title" value="test title"/><br/>
	<input type="text" name="userId" value="adm"/><br/>
	<input type="text" name="userIdx" value="1"/><br/>
	<input type="text" name="userName" value="adm"/><br/>
	<input type="text" name="tagName" value="adm"/><br/>
	<input type="text" name="tagName" value="test"/><br/>
	<input type="text" name="tagName" value="user"/><br/>
	<input type="text" name="ipAddr" value="127.0.0.1"/><br/>
	<input type="submit" value="gogogo" />
</form>
</body>
</html>