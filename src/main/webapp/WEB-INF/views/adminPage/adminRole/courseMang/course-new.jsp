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
	<spring:url value="/Admin/createNewCourse" var="formsubmit" htmlEscape="true" />
	<form:form method="POST" modelAttribute="courseInfo" action="${formsubmit}">
		
		<div class="panel  panel-primary">
			<div class="panel-body">
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Course Name</label>
						<form:input path="courseName" cssClass="form-control" required="required"/>
						<form:errors path="courseName" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Faculty Name</label>
						<form:select path="courseFacultyID.facultyID" cssClass="form-control" required="required">
							<c:forEach var="facut" items="${flist}">
								<option value="${facut.facultyID}">${facut.facultyName}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<div class="col-md-6">
						<label>Department Name</label> 
						<form:select path="courseDepartmentID.departmentID" cssClass="form-control" required="required">
							<c:forEach var="dept" items="${dlist}">
								<option value="${dept.departmentID}">${dept.departmentName}</option>
							</c:forEach>
						</form:select>
						<form:errors path="courseDepartmentID.departmentID" cssStyle="color: red;" />
					</div>
					<div class="col-md-6">
						<label>Course Description</label>
						<form:input path="courseDescription"  cssClass="form-control" required="required"/>
						<form:errors path="courseDescription" cssStyle="color: red;" />
					</div>
				</div>
				<div class="col-md-12" style="margin-top:10px">
					<select class="form-control" name="lecturerId">
						<option>--Select one--</option>
						<c:forEach var="lect" items="${lect}">
							<option value="${lect.lecturerID}">${lect.lecturerName}</option>
						</c:forEach>
					</select>
					<div class="col-md-4">
						<label>>Max Size</label>
						<form:input path="maxClassSize"  cssClass="form-control" required="required"/>
						<form:errors path="maxClassSize" cssStyle="color: red;" />
					</div>
					<div class="col-md-4">
						<label>Credits</label>
						<form:input path="credits" cssClass="form-control" required="required" />
						<form:errors path="credits" cssStyle="color: red;" />
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