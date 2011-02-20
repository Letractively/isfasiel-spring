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
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value='/common/editor/js/HuskyEZCreator.js'/>"></script>
<script type="text/javascript" src="<c:url value='/common/editor/js/sEditor.js'/>"></script>
<script type="text/javascript">
	function load() {
		$NSE.load("ir1");
	}
</script>
</head>
<body onload="load()">
<input type="button" value="add" onclick="$NSE.add('test')">
<input type="button" value="reset" onclick="$NSE.reset()">
<input type="button" value="get" onclick="alert($NSE.get());">
<br/>
<textarea name="ir1" id="ir1" style="width:725px; height:300px; display:none;"><p>에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 값을 지정하지 않으시면 됩니다.</p></textarea>


</body>
</html>