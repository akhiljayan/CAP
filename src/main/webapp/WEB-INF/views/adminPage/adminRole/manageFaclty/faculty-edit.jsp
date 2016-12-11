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
	<spring:url value="/Admin/editFaculty/${faculty.facultyID}" var="formsubmit" htmlEscape="true" />
	<form:form method="POST" action="${formsubmit}" modelAttribute="faculty">
		<form:hidden path="facultyID"/>
		<div class="panel panel-primary">
			<div class="panel panel-body">
				<h3>Add new Faculty</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-3">
						<label  style="float: right;">Faculty Name</label>
					</div>
					<div class="col-md-9">
						<form:input cssClass="form-control" path="facultyName" />
						<form:errors path="facultyName" cssStyle="color: red;" />
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