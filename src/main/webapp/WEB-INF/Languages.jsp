<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" TYPE="text/css" href="style.css" />
<title>Insert title here</title>
</head>
<body>
	<table id = "table">
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Action</th>
		</tr>
		<c:set var = "count" value = "0"/>
		<c:forEach items="${listLanguages}" var="language" varStatus ="loop">
		<%-- <c:set var = "count" value = "${language}"/> --%>
		<tr>
			<td><c:out value="${language.name}"/></td>
			<td><c:out value="${language.creator}"/></td>
			<td><c:out value="${language.version}"/></td>
			<td> <a href = "/languages/edit/<c:out value = "${language.id}"/>"> Edit</a>
				<a href = "/languages/delete/<c:out value = "${language.id}"/>">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>

<form:form method ="POST" action = "/languages" id = "form" modelAttribute="language">
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