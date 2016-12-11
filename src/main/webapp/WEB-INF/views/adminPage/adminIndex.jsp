<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.inner{
		height:100px !important;
	}
</style>
</head>
<body>
<h1>Welcome "${sessionScope.USERSESSION.user.username}" </h1>
<div class="col-md-12" style="margin-top:20px">
		
		
		<spring:url value="/home/redirect" var="redirect" htmlEscape="true" />
	<c:choose>
		<c:when test="${sessionScope.USERSESSION.user.roleID.role == 'Admin'}">
			<spring:url value="/Admin/studListManage" var="listStudManage" htmlEscape="true" />
			<spring:url value="/Admin/manageDepartment" var="manageDepartment" htmlEscape="true" />
			<spring:url value="/Admin/manageFaculty" var="manageFaculty" htmlEscape="true" />
			<spring:url value="/Admin/manageCourse" var="manageCourse" htmlEscape="true" />
			<spring:url value="/AdminEnrol/manageEnrolment" var="manageEnrolment" htmlEscape="true" />
			<spring:url value="/AdminEnrol/processEnrolmentRequest" var="processEnrolmentRequest" htmlEscape="true" />
			 

				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <p>Dashboard</p>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${redirect}" class="small-box-footer">
		              Go to Dashboard <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Student Management</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${listStudManage}" class="small-box-footer">
		              Go to Manage Students <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
				
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Lecturer Management</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="javascript:void(0)" class="small-box-footer">
		              Go to Manage Lecturer <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Course Management</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${manageCourse}" class="small-box-footer">
		              Go to Course Management <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Manage Departments</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${manageDepartment}" class="small-box-footer">
		              Go to Manage Departments <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Manage Faculty</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${manageFaculty}" class="small-box-footer">
		              Go to Manage Departments <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Manage Enrolments</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${manageFaculty}" class="small-box-footer">
		              Go to Manage Enrolments <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-red">
		            <div class="inner" style="height:100px">
		              <h4>Process Enrolment Requests</h4>
		              <p id="menu-process-enrl"></p>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${processEnrolmentRequest}" class="small-box-footer">
		              Process Enrolment Requests<i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		</c:when>
		<c:when test="${sessionScope.USERSESSION.user.roleID.role == 'Lecturer'}">
			<spring:url value="/Lecturer/viewMyCourses" var="viewMyCourses" htmlEscape="true" />
			<spring:url value="/Lecturer/gradeStds" var="gradeStds" htmlEscape="true" />
			<spring:url value="/Lecturer/viewEnrlmnt" var="viewEnrlmnt" htmlEscape="true" />
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-green">
		            <div class="inner" style="height:100px">
		              <h4>Dashboard</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${redirect}" class="small-box-footer">
		              Go to Dashboard <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-green">
		            <div class="inner" style="height:100px">
		              <h4>View My Courses</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${viewMyCourses}" class="small-box-footer">
		              Go to view your courses <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-green">
		            <div class="inner" style="height:100px">
		              <h4>Grade Students</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${gradeStds}" class="small-box-footer">
		              Go to Grade Students <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-green">
		            <div class="inner" style="height:100px">
		              <h4>View Enrolements</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${viewEnrlmnt}" class="small-box-footer">
		              Go to View Enrolements <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		</c:when>
		<c:when
			test="${sessionScope.USERSESSION.user.roleID.role == 'Student'}">
			<spring:url value="/Student/viewGrades" var="viewGrades" htmlEscape="true" />
			<spring:url value="/Student/viewCourses" var="viewCourses" htmlEscape="true" />
			<spring:url value="/Student/requestEnrolment" var="requestEnrolment" htmlEscape="true" />
			
			<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-yellow">
		            <div class="inner" style="height:100px">
		              <h4>Dashboard</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${redirect}" class="small-box-footer">
		              Go to Dashboard <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-yellow">
		            <div class="inner" style="height:100px">
		              <h4>View Grades</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${viewGrades}" class="small-box-footer">
		              Go to View Grades <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
			
				<div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-yellow">
		            <div class="inner" style="height:100px">
		              <h4>View Courses</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${viewCourses}" class="small-box-footer">
		              Go to View Courses <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		        
		        <div class="col-lg-3 col-xs-6">
		          <div class="small-box bg-yellow">
		            <div class="inner" style="height:100px">
		              <h4>Request Enrolment</h4>
		            </div>
		            <div class="icon">
		              <i class="fa fa-star-o" style="margin-top:22px"></i>
		            </div>
		            <a href="${requestEnrolment}" class="small-box-footer">
		              Go to Request Enrolment <i class="fa fa-arrow-circle-right"></i>
		            </a>
		          </div>
		        </div>
		</c:when>
	</c:choose>

        

</div>
</body>
</html>