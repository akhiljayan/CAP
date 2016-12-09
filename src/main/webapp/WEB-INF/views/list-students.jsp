<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>"${u}"</h1>
<h1>"${us.user}"</h1>
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th></th>
					<th>DESCRIPTION</th>
					<th>PLAY</th>
				</tr>
			</thead>
			<tbody>
					<tr class="listHeading">
						<td>${us.user.roleID.role}</td>
						<td></td>
					</tr>
			</tbody>
		</table>

</body>
</html>