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
<title>upload files</title>
<script type="text/javascript">
	var errorMsg = "${errors}";
	
	Array.prototype.contains = function ( needle ) {
		for (i in this) {
			 if (this[i] == needle) return true;
		}
		return false;
	}
	var fileList = ${fileList};
	function checkFile() {
		var elm = document.getElementById("fileInput");
		value = elm.value;
		var extList = "jsp,asp,aspx,html,htm,exe,bat,com,js".split(",");
		if(value == "") {
			alert("Please, select a file to be upload");
			return false;
		} 
		if(extList.contains(value.substring(value.lastIndexOf(".") + 1))) {
			alert("you can't upload these file types : [" + extList.join(", ") + "]");
			return false;
		}
		
		return true;
	}
	window.onload = function () {
		if( errorMsg != "") {
			alert(errorMsg);
		}
	};
</script>
</head>
<body>
<form method="post" action='<c:url value="/app/file/upload.do"/>' onsubmit="return checkFile();" enctype="multipart/form-data">
	<input type="file" id="fileInput" name="fileInput"/>
	<input type="submit" value="upload"/>
</form>
</body>
</html>