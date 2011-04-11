<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8" ?><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<root>
<c:forEach var="list" items="${path}">
	<content>
		<id>${list.pathId}</id>
		<name>${list.pathName}</name>
	</content>
</c:forEach>
</root>