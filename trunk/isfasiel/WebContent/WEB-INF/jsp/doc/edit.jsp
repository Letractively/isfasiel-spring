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
<form method="post" action="<c:url value="/app/doc/insert.do"/>">
	id <input type="text" name="contentId" value="${result.contentId}"/><br/>
	title<input type="text" name="title" value="${result.title}"/><br/>
	body <input type="text" name="body" value="${result.body}"/><br/>
	userId <input type="text" name="userId" value="adm"/><br/>
	userIdx <input type="text" name="userIdx" value="1"/><br/>
	userName <input type="text" name="userName" value="adm"/><br/>
	<c:choose>
		<c:when test="${tag != null }">
			<c:forEach var="list" items="result">
				tag name <input type="text" name="tagName" value="${list.tagName}}"/><br/>
			</c:forEach>		
		</c:when>
		<c:otherwise>
			tag name <input type="text" name="tagName" value=""/><br/>
		</c:otherwise>
	</c:choose>
	<input type="text" name="ipAddr" value="127.0.0.1"/><br/>
	<input type="submit" value="gogogo" />
</form>
</body>
</html>