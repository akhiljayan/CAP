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
				Select a Course:
				<select class="form-control" id="courses-ajax" data-forthe="grade">
					<option>--Select a course--</option>
					<c:forEach var="course" items="${clist}">
						<option value="${course.courseID}">${course.courseName}</option>
					</c:forEach>
				</select>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding" id="list-students-table">
				
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>
</body>
</html>