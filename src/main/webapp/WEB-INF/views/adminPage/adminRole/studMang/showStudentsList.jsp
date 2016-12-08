<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:if test="${fn:length(slist) gt 0}">
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Faculty</th>
					<th>Department</th>
					<th>Status</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="student" items="${slist}">
					<tr>
						<td>${student.studentID}</td>
						<td>${student.studentName}</td>
						<td>${student.studentFacultyID.facultyName}</td>
						<td>${student.studentDepartmentID.departmentName}</td>
						<td>${student.status}</td>
						<td><a href="/caps/Admin/editStudent/${student.studentID}" title="Edit"><i class="fa fa-pencil-square"></i></a></td>
						<td><a href="/caps/Admin/deleteStudent/${student.studentID}" title="Delete"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

</body>
</html>