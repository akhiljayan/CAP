<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			$(".datepicker").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
		$(document).ready(function() {
			$("#datepicker2").datepicker({
				dateFormat : "dd/mm/yy"
			});
		});
	</script>
	<spring:url value="/Admin/editLecturer" var="formsubmit" htmlEscape="true" />
	<form:form method="POST" action="${formsubmit}/${lecturer.lecturerID}" modelAttribute="lecturer">
	<form:hidden path="lecturerID" />
	<form:hidden path="userID.userID" />
		<div class="panel panel-primary">
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-4">
						<label>Username</label>
						<input type="text" class="form-control" required name="username"  value="${user.username}">
					</div>
					<div class="col-md-4">
						<label>Password</label>
						<input type="text" class="form-control" required name="password" value="${user.password}">
					</div>
					<div class="col-md-4">

					</div>
				</div>
			</div>
		</div>
		<div class="panel  panel-primary">
			<div class="panel-body">
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Lecturer Name</label>
						<form:input path="lecturerName" cssClass="form-control" required="required"/>
						<form:errors path="lecturerName" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Faculty</label>
						<form:select path="lecturerFacultyID.facultyID" cssClass="form-control" required="required">
								<c:forEach var="fac" items="${faculties}">
									<option <c:if test="${fac.facultyID eq lecturer.lecturerFacultyID.facultyID}">selected="selected"</c:if> value="${fac.facultyID}">${fac.facultyName}</option>
								</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Department</label> 
						<form:select path="lecturerDepartmentID.departmentID" cssClass="form-control" required="required">
								<c:forEach var="dep" items="${departments}">
									<option <c:if test="${dep.departmentID eq lecturer.lecturerDepartmentID.departmentID}">selected="selected"</c:if> value="${dep.departmentID}">${dep.departmentName}</option>
								</c:forEach>
						</form:select>
					</div>
					<div class="col-md-6">
						<label>Status</label>
						<form:input path="status" cssClass="form-control" required="required"/>
						<form:errors path="status" cssStyle="color: red;" />
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Gender</label>
						<form:select path="gender" cssClass="form-control">
							<form:option value="0" label="--- Select one ---" />
							<form:option value="M" label="Male" />
							<form:option value="F" label="Female" />
						</form:select>
						<form:errors path="gender" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Date of Birth</label>
						<form:input path="dob" cssClass="form-control datepicker" required="required" />
						<form:errors path="dob" cssStyle="color: red;" />
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Email</label>
						<form:input path="email" cssClass="form-control" required="required" />
						<form:errors path="email" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Address</label>
						<form:input path="address" cssClass="form-control" required="required" />
						<form:errors path="address" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Employment Start Date</label>
						<form:input path="employedDate" cssClass="form-control datepicker" required="required" />
						<form:errors path="employedDate" cssStyle="color: red;" />
					</div>
				</div>
			</div>
		</div>
		<div class="panel">
			<div class="panel-body">
				<button type="submit" class="btn btn-primary form-control pull-right">Save</button>
			</div>
		</div>
	</form:form>
</body>
</html>