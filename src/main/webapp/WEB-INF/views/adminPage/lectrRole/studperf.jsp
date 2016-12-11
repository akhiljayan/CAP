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
	<a href="/caps/Lecturer/enrolbycourse/${courseID }"><i class="fa fa-2x fa-arrow-circle-left" aria-hidden="true"></i><i>Go Back</i></a>
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Performance for <i>${sperf[0].studentID.studentName}</i></h3><br>
				<span>Faculty: ${sperf[0].studentID.studentFacultyID.facultyName}</span><br>
				<span>Department: ${sperf[0].studentID.studentDepartmentID.departmentName}</span>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
				<c:if test="${fn:length(sperf) gt 0 }">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Course ID</th>
								<th>Course Name</th>
								<th>Grade</th>
								<th>Status</th>
							</tr>
							<c:forEach var="lec" items="${sperf}">
								<tr>
									<td>0</td>
									<td>${lec.courseID.courseID}</td>
									<td>${lec.courseID.courseName}</td>
									<td>${lec.grade}</td>
									<td>${lec.completionStatus}</td>
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