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
	<spring:url value="/Admin/newStudentPersist" var="formsubmit" htmlEscape="true" />
	<form:form method="POST" action="${formsubmit}" commandName="student">
		<div class="panel panel-primary">
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-4">
						<label>Username</label>
						<input type="text" class="form-control" required name="username">
					</div>
					<div class="col-md-4">
						<label>Password</label>
						<input type="text" class="form-control" required name="password">
					</div>
					<div class="col-md-4">
						<label>Role</label>
						<select class="form-control" name="role">
							<option>--Select one--</option>
							<c:forEach var="role" items="${roles}">
								<option value="${role.roleID}">${role.role}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<div class="panel  panel-primary">
			<div class="panel-body">
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Name</label>
						<form:input path="studentName" cssClass="form-control" required="required"/>
					</div>
					<div class="col-md-6">
						<label>Faculty</label>
						<select class="form-control" name="student-faculty">
							<option>--Select one--</option>
							<c:forEach var="faculty" items="${faculties}">
								<option value="${faculty.facultyID}">${faculty.facultyName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Department</label> 
						<select class="form-control" name="student-department">
							<option>--Select one--</option>
							<c:forEach var="department" items="${departments}">
								<option value="${department.departmentID}">${department.departmentName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-md-6">
						<label>Status</label>
						<form:input path="status" cssClass="form-control" required="required"/>
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
					</div>
					<div class="col-md-6">
						<label>Date of Birth</label>
						<form:input path="dob" cssClass="form-control datepicker" required="required" />
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Email</label>
						<form:input path="email" cssClass="form-control" required="required" />
					</div>
					<div class="col-md-6">
						<label>Mobile</label>
						<input type="text" class="form-control" required name="mobile">
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Address</label>
						<form:input path="address" cssClass="form-control" required="required" />
					</div>
					<div class="col-md-6">
						<label>Metric Date</label>
						<form:input path="matricDate" cssClass="form-control datepicker" required="required" />
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