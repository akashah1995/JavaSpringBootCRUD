<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" TYPE="text/css" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editing ${index}</title>
</head>
<body>
	<form:form method ="POST" action = "/languages/modify/${index}" id = "form" modelAttribute="language">
	<form:label path = "name">Name
	<form:errors path = "name"/>
	<form:input path = "name"/></form:label>
	<br>
	<form:label path = "creator">Creator
	<form:errors path = "creator"/>
	<form:input path = "creator"/></form:label>
	<br>
	<form:label path = "version">Version
	<form:errors path = "version"/>
	<form:input path = "version"/></form:label>
	<br>
	<form:hidden path = "id"/>
	<input type="submit" value="Submit"/>
	<br>
</form:form>

</body>
</html>