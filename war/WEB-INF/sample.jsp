<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="3">
		<tr>
			<th>name</th>
			<th>e-mail</th>
		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td><c:out value="${person.name}" />
				</td>
				<td><c:out value="${person.email}" />
				</td>
				<c:if test="${person.name == 'shoda'}">
				<td>●
				</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>