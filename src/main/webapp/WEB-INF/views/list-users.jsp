<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${fn:length(ulist) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th>NAME</th>
					<th>DESCRIPTION</th>
					<th>PLAY</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${ulist}">
					<tr class="listHeading">
						<td>${user.username}</td>
						<td>${user.password}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>