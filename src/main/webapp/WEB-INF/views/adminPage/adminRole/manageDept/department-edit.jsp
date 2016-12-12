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
	<spring:url value="/Admin/editDepartment/${department.departmentID}" var="formsubmit" htmlEscape="true" />
	<form:form method="POST" action="${formsubmit}" modelAttribute="department">
		<form:hidden path="departmentID" />
		<div class="panel panel-primary">
			<div class="panel panel-body">
				<h3>Add new Department</h3>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-6">
						<label>Department Name</label>
						<form:input cssClass="form-control" path="departmentName" />
						<form:errors path="departmentName" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Faculty Name</label>
						<form:select cssClass="form-control" path="facultyID.facultyID">
							<c:forEach var="facut" items="${flist}">
								<option <c:if test="${facut.facultyID eq department.facultyID.facultyID}">selected="selected"</c:if> value="${facut.facultyID}">${facut.facultyName}</option>
							</c:forEach>
						</form:select>
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