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
				<c:if test="${fn:length(glist) gt 0}">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Student Name</th>
								<th>Course Name</th>
								<th>Action</th>
							</tr>
							<c:forEach var="g" items="${glist}">
								<tr>
									<td>.</td>
									<td>${g.studentID.studentName}</td>
									<td>${g.courseID.courseName}</td>
									<td>
										<a class="btn btn-primary enrol-student-grant" id="student-${g.studentID.studentID}" data-studentid="${g.studentID.studentID}" data-courseid="${g.courseID.courseID}" href="javascript:void(0)">Grant Request</a>
										<a class="btn btn-primary enrol-student-deny" id="student-${g.studentID.studentID}" data-studentid="${g.studentID.studentID}" data-courseid="${g.courseID.courseID}" href="javascript:void(0)">Deny Request</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
</body>
</html>