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
	<a href="/caps/Lecturer/viewMyCourses"><i class="fa fa-2x fa-arrow-circle-left" aria-hidden="true"></i><i>Go Back to view courses</i></a>
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Enrolment for: ${sment[0].courseID.courseName}</h3>

				<div class="box-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<input type="text" name="table_search"
							class="form-control pull-right search-department"
							placeholder="Search by name">

						<div class="input-group-btn">
							<button type="" class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding" id="list-students-details">
				<c:if test="${fn:length(sment) gt 0 }">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Student ID</th>
								<th>Student Name</th>
								<th>Action</th>
							</tr>
							<c:forEach var="lec" items="${sment}">	
								<tr>
									<td>0</td>
									<td>${lec.studentID.studentID}</td>
									<td>${lec.studentID.studentName}</td>
									<td><a class="label label-warning" href="/caps/Lecturer/studperf/${lec.studentID.studentID}">View Performance</a></td>
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