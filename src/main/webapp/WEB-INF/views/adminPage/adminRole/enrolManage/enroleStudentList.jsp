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
				<c:if test="${fn:length(students) gt 0}">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Name</th>
								<th>Action</th>
							</tr>
							<c:forEach var="student" items="${students}">
								<tr>
									<td>${student.studentID}</td>
									<td>${student.studentName}</td>
									<c:set var="flag" scope="session" value="outside"/>
									<c:forEach var="enrl" items="${enrolStstus}">
										<c:choose>
											<c:when test="${student.studentID eq enrl.studentID.studentID}">
												<c:choose>
													<c:when test="${enrl.completionStatus eq 'Completed'}">
														<td><a class="btn btn-success" href="javascript:void(0)">Completed</a></td>
													</c:when>
													<c:when test="${enrl.completionStatus eq 'Enroled'}">
														<td><a class="btn btn-warning" href="javascript:void(0)">Enroled</a></td>
													</c:when>
													<c:when test="${enrl.completionStatus eq 'Failed'}">
														<td><a class="btn btn-warning" href="javascript:void(0)">Failed</a>
														<a class="btn btn-default enrol-student" id="student-${student.studentID}" href="#">Enrole to course</a></td>
													</c:when>
												</c:choose>
												<c:set var="flag" scope="session" value="inside"/>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${flag eq 'outside'}">
										<td><a class="btn btn-default enrol-student" data-studentid="${student.studentID}" data-courseid="${courseId}"  id="student-${student.studentID}" href="#">Enrole to course</a>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
</body>
</html>