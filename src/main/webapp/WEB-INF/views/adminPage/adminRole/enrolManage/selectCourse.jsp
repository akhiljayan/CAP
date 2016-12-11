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
	<spring:url value="/Admin/manageCourse" var="pageurl" />
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Select a course and click proceed</h3>
			</div>
			<!-- /.box-header -->
			<spring:url value="/AdminEnrol/selectStudent" var="formsubmit" htmlEscape="true" />
			<form action="${formsubmit}"  method="POST">
			<div class="box-body table-responsive no-padding" id="list-students-details">
					<div class="col-md-12">
							<c:forEach var="course" items="${clist}" varStatus="loop">
								<c:choose>
    								<c:when test="${loop.index %2  eq 0}">
								 	<div class="col-md-12">
								 		<div class="col-md-6">
											<input type="radio"  name="course-select" value="${course.courseID}">${course.courseName}
										</div>
									</c:when> 
									<c:otherwise>
										<div class="col-md-6">
											<input type="radio"  name="course-select" value="${course.courseID}">${course.courseName}
										</div>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-success pull-right">Proceed</button>
					</div>
					</form>
			
					<%-- <table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Course Name</th>
								<th>Department Name</th>
								<th>Faculty Name</th>
								<th>Description</th>
								<th>Max Size</th>
								<th>Credits</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
							<c:forEach var="course" items="${pageListHolder.pageList}">
								<tr>
									<td>${course.courseID}</td>
									<td>${course.courseName}</td>
									<td>${course.courseDepartmentID.departmentName}</td>
									<td>${course.courseFacultyID.facultyName}</td>
									<td>${course.courseDescription}</td>
									<td>${course.maxClassSize}</td>
									<td>${course.credits}</td>
									<td><a href="/caps/Admin/editCourse/${course.courseID}" title="Edit"><i class="fa fa-pencil-square"></i></a></td>
									<td><a href="javascript:void(0)" class="delete-course" data-deleteid="${course.courseID}" title="Delete"><i class="fa fa-trash-o"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table> --%>
				</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->

</body>
</html>