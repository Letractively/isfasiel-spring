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
<script type="text/javascript" src="<c:url value='/common/editor/js/HuskyEZCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/common/editor/js/sEditor.js'/>"></script>
<script type="text/javascript" src="<c:url value='/common/js/jQuery.js'/>"></script>
<script type="text/javascript">
	function load() {
		$NSE.load("ir1");
	}
	
	window.onload = function () {
		load();
	};
	
	function doSubmit() {
		$("#body").val($NSE.get());
		return true;
	} 
</script>
</head>
<body>
<form method="post" action="<c:url value="/app/doc/edit.do"/>" onsubmit="return doSubmit();">
	id <input type="text" name="contentId" value="${result.contentId}"/><br/>
	title<input type="text" name="title" value="${result.title}"/><br/>
<!--	body <input type="text" name="body" value="${result.body}"/><br/>-->
	<input type="hidden" name="body" id="body" value=""/>
	<textarea name="ir1" id="ir1" style="width:725px; height:300px; display:none;">${result.body}</textarea><br/>
	userId <input type="text" name="userId" value="adm"/><br/>
	userIdx <input type="text" name="userIdx" value="1"/><br/>
	userName <input type="text" name="userName" value="adm"/><br/>
	<c:choose>
		<c:when test="${tag != null }">
			<c:forEach var="list" items="${tag}">
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