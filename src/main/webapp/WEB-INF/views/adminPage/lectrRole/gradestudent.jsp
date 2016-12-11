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
	<spring:url value="/Lecturer/updategrade" var="formsubmit" htmlEscape="true" />
	<form action="${formsubmit}" method="post">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<span>Student Name: ${glist.studentID.studentName}</span></br>
				<small>Course Name: ${glist.courseID.courseName}</small>
			</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="col-md-4">
						Current Grade: ${glist.grade}
					</div>
					<div class="col-md-4">
						<label> New Grade</label>
						<select name="newgrade" class="form-control" style="width:30%">
						    <option value="A">A</option>
						    <option value="B">B</option>
						    <option value="C">C</option>
						    <option value="D">D</option>
						    <option value="E">E</option>
						    <option value="F">F</option>
						  </select>
					</div>
					<div class="col-md-4">
						<input type="hidden" name="enrolmentID" value="${glist.enrolmentID}">
	  					<input type="hidden" name="courseID" value="${glist.courseID.courseID}">
						<a class="btn btn-danger pull-right" style="width:50%" href="/caps/Lecturer/gradebycourse/${glist.courseID.courseID}">Cancel</a>
						<button type="submit" style="width:50%" class="btn btn-primary form-control pull-right">Save</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>