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
				<h3 class="box-title">Your Grades</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
				<c:if test="${fn:length(clist) gt 0 }">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Course Name</th>
								<th>Description</th>
								<th>Strength</th>
								<th>Action</th>
							</tr>
							<c:forEach var="c" items="${clist}">
									<tr>
										<td>0</td>
										<td>${c.courseName}</td>
										<td>${c.courseDescription}</td>
										<td>${c.maxClassSize}</td>
										<td>
											<a class="btn btn-success add-course-request" data-courseid="${c.courseID}">Request</a> 
										</td>
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