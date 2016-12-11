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
	<c:set var="pageListHolder" value="${courseList}" scope="session" />
	<a class="btn btn-primary pull-right" href="/caps/Admin/createNewCourse" style="">Add New Course</a>
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Courses</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
				<%-- <c:if test="${fn:length(courseList) gt 0 }"> --%>
					<table class="table table-hover">
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
					</table>
				</div>
				<div class="box-footer col-md-12">
					<div class="pagination-div" style="float:right">
					<span style="left">
						<c:choose>
							<c:when test="${pageListHolder.firstPage}">
								<i class="btn btn-default">Prev</i>
							</c:when>
							<c:otherwise>
								<a class="btn btn-default" href="${pageurl}/prev">Prev</a>
							</c:otherwise>
						</c:choose>
					</span>
					<span>
						<c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop">
							<c:choose>
								<c:when test="${loop.index == pageListHolder.page}">
									<i class="btn btn-default">${loop.index+1}</i>
								</c:when>
								<c:otherwise>
									<a class="btn btn-default" href="${pageurl}/${loop.index}">${loop.index+1}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</span>
					<span> 
						<c:choose>
							<c:when test="${pageListHolder.lastPage}">
								<i class="btn btn-default">Next</i>
							</c:when>
							<c:otherwise>
								<a class="btn btn-default" href="${pageurl}/next">Next</a>
							</c:otherwise>
						</c:choose>
					</span>
				</div>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>

</body>
</html>