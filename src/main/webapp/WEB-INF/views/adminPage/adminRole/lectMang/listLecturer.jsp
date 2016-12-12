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


	<a class="btn btn-primary pull-right" href="/caps/Admin/addLecturer" style="">Add a Lecturer</a>
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Lecturers</h3>

				<div class="box-tools">
					<div class="input-group input-group-sm" style="width: 400px;">
						<input type="text" name="table_search"
							class="form-control pull-right search-student"
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
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
				<c:if test="${fn:length(lecList) gt 0}">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Name</th>
								<th>Faculty</th>
								<th>Department</th>
								<th>Status</th>
								<th>Gender</th>
								<th>DoB</th>
								<th>Email</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
							<c:forEach var="lec" items="${lecList}">
								<tr>
									<td>${lec.lecturerID}</td>
									<td>${lec.lecturerName}</td>
									<td>${lec.lecturerFacultyID.facultyName}</td>
									<td>${lec.lecturerDepartmentID.departmentName}</td>
									<td>${lec.status}</td>
									<td>${lec.gender}</td>
									<td>${lec.dob}</td>
									<td>${lec.email}</td>
									<td><a href="/caps/Admin/editLecturer/${lec.lecturerID}" title="Edit"><i class="fa fa-pencil-square"></i></a></td>
									<td><a href="javascript:void(0)" class="delete-lecturer" data-deleteid="${lec.lecturerID}" title="Delete"><i class="fa fa-trash-o"></i></a></td>
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