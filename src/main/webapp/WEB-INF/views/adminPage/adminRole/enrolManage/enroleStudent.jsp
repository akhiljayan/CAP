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

	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Course: ${crsName}</h3>

				<div class="box-tools">
					<div class="input-group input-group-sm" style="width: 400px;">
						<input type="text" name="table_search"
							class="form-control pull-right search-student-enrolment"
							placeholder="Search by name">
							<input type="hidden" class="enrol-courseId" value="${courseId}">

						<div class="input-group-btn">
							<button type="" class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
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
													<c:when test="${enrl.completionStatus eq 'Requested'}">
														<td>
															<a class="btn btn-primary enrol-student-grant" id="student-${student.studentID}" data-studentid="${student.studentID}" data-courseid="${courseId}" href="#">Grant Request</a>
															<a class="btn btn-primary enrol-student-deny" id="student-${student.studentID}" data-studentid="${student.studentID}" data-courseid="${courseId}" href="#">Deny Request</a>
														</td>
													</c:when>
													<c:when test="${enrl.completionStatus eq 'Failed'}">
														<td><a class="btn btn-warning" href="javascript:void(0)">Not Eligible</a>
													</c:when>
												</c:choose>
												<c:set var="flag" scope="session" value="inside"/>
											</c:when>
										</c:choose>
									</c:forEach>
									<c:if test="${flag eq 'outside'}">
										<td><a class="btn btn-default enrol-student" id="student-${student.studentID}" data-studentid="${student.studentID}" data-courseid="${courseId}" href="javascript:void(0)">Enrole to course</a>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>

</body>
</html>