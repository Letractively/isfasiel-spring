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
<form method="post" action="<c:url value="/app/comment/create.do"/>" onsubmit="return doSubmit();">
<userId>${user.id}</userId>
	id <input type="text" name="contentId" value="3009"/><br/>
<!--	body <input type="text" name="body" value="${result.body}"/><br/>-->
	<input type="hidden" name="body" id="body" value=""/>
	<textarea name="ir1" id="ir1" style="width:725px; height:300px; display:none;">${result.body}</textarea><br/>
	<input type="text" name="ipAddr" value="127.0.0.1"/><br/>
	<input type="text" name="parentCommentId" value="1"/><br/>
	<input type="submit" value="gogogo" />
</form>
</body>
</html>

