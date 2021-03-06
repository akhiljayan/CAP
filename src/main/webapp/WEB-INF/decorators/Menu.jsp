<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Sidebar user panel -->
<div class="user-panel">
	<div class="pull-left image">
		<img src="<c:url value="/css/admin/dist/img/user2-160x160.jpg"/>"
			class="img-circle" alt="User Image">
	</div>
	<div class="pull-left info">
		<p>${sessionScope.USERSESSION.user.username}</p>
		<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
	</div>
</div>
<!-- search form -->
<!-- /.search form -->
<!-- sidebar menu: : style can be found in sidebar.less -->
<ul class="sidebar-menu">
	<li class="header">MAIN NAVIGATION</li>

	<spring:url value="/home/redirect" var="redirect" htmlEscape="true" />
	<c:choose>
		<c:when test="${sessionScope.USERSESSION.user.roleID.role == 'Admin'}">
			<spring:url value="/Admin/studListManage" var="listStudManage" htmlEscape="true" />
			<spring:url value="/Admin/manageDepartment" var="manageDepartment" htmlEscape="true" />
			<spring:url value="/Admin/manageLecturer" var="manageLecturer" htmlEscape="true" />
			<spring:url value="/Admin/manageFaculty" var="manageFaculty" htmlEscape="true" />
			<spring:url value="/Admin/manageCourse" var="manageCourse" htmlEscape="true" />
			<spring:url value="/AdminEnrol/manageEnrolment" var="manageEnrolment" htmlEscape="true" />
			<spring:url value="/AdminEnrol/processEnrolmentRequest" var="processEnrolmentRequest" htmlEscape="true" />
			<li class="active treeview"><a href="${redirect}"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span> <span
					class="pull-right-container"> <span
						class="label label-primary pull-right">D</span>
				</span>
			</a></li>
			<li><a href="${listStudManage}"> <i
					class="fa fa-circle-o text-red"></i> <span>Student
						Management</span> <span class="pull-right-container"> <small
						class="label pull-right bg-red">S</small>
				</span>
			</a></li>
			<li><a href="${manageLecturer}"> <i
					class="fa fa-circle-o text-red"></i> <span>Lecturer
						Management</span> <span class="pull-right-container"> <small
						class="label pull-right bg-red">L</small>
				</span>
			</a></li>
			<li><a href="${manageCourse}"> <i
					class="fa fa-circle-o text-red"></i> <span>Course Management</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">C</small>
				</span>
			</a></li>
			<li><a href="${manageDepartment}"> <i
					class="fa fa-circle-o text-red"></i> <span>Manage Departments</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">MD</small>
				</span>
			</a></li>
			<li><a href="${manageFaculty}"> <i
					class="fa fa-circle-o text-red"></i> <span>Manage Faculty</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">MF</small>
				</span>
			</a></li>
			<li><a href="${manageEnrolment}"> <i
					class="fa fa-circle-o text-red"></i> <span>Manage Enrolment</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">ME</small>
				</span>
			</a></li>
			<li><a href="${processEnrolmentRequest}"> <i
					class="fa fa-circle-o text-red"></i> <span>Process Request</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red" id="requestCount"></small>
				</span>
			</a></li>
		</c:when>
		<c:when
			test="${sessionScope.USERSESSION.user.roleID.role == 'Lecturer'}">
			<spring:url value="/Lecturer/viewMyCourses" var="viewMyCourses" htmlEscape="true" />
			<spring:url value="/Lecturer/gradeStds" var="gradeStds" htmlEscape="true" />
			<spring:url value="/Lecturer/viewEnrlmnt" var="viewEnrlmnt" htmlEscape="true" />
			<li class="active treeview"><a href="${redirect}"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span> <span
					class="pull-right-container"> <span
						class="label label-primary pull-right">10</span>
				</span>
			</a></li>
			<li><a href="${viewMyCourses}"> <i
					class="fa fa-circle-o text-red"></i> <span>View My Courses</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">VC</small>
				</span>
			</a></li>
			<li><a href="${gradeStds}"> <i
					class="fa fa-circle-o text-red"></i> <span>Grade Students</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">GS</small>
				</span>
			</a></li>
			<li><a href="${viewEnrlmnt}"> <i
					class="fa fa-circle-o text-red"></i> <span>View Enrolements</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">VE</small>
				</span>
			</a></li>
		</c:when>
		<c:when
			test="${sessionScope.USERSESSION.user.roleID.role == 'Student'}">
			<spring:url value="/Student/viewGrades" var="viewGrades" htmlEscape="true" />
			<spring:url value="/Student/viewCourses" var="viewCourses" htmlEscape="true" />
			<spring:url value="/Student/requestEnrolment" var="requestEnrolment" htmlEscape="true" />
			<li class="active treeview">
				<a href="${redirect}"> 
					<i class="fa fa-dashboard"></i> 
					<span>Dashboard</span> 
					<span class="pull-right-container"> 
						<span class="label label-primary pull-right">DB</span>
					</span>
				</a>
			</li>
			<li><a href="${viewGrades}"> <i
					class="fa fa-circle-o text-red"></i> <span>View Grades</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">VG</small>
				</span>
			</a></li>
			<li><a href="${viewCourses}"> 
					<i class="fa fa-circle-o text-red"></i> <span>View Courses</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">VG</small>
				</span>
			</a></li>
			<li><a href="${requestEnrolment}"> 
					<i class="fa fa-circle-o text-red"></i> <span>Request Enrolment</span>
					<span class="pull-right-container"> <small
						class="label pull-right bg-red">VG</small>
				</span>
			</a></li>
		</c:when>
	</c:choose>

</ul>

<!--  <li class="active treeview"><a href="#"> <i
			class="fa fa-dashboard"></i> <span>Dashboard</span> <span
			class="pull-right-container"> <span
				class="label label-primary pull-right">10</span>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-files-o"></i>
			<span>Layout Options</span> <span class="pull-right-container">
				<span class="label label-primary pull-right">4</span>
		</span>
	</a></li>
	<li><a href="pages/widgets.html"> <i class="fa fa-th"></i> <span>Widgets</span>
			<span class="pull-right-container"> <small
				class="label pull-right bg-green">new</small>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-pie-chart"></i>
			<span>Charts</span> <span class="pull-right-container"> <i
				class="fa fa-angle-left pull-right"></i>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
			<span>UI Elements</span> <span class="pull-right-container"> <i
				class="fa fa-angle-left pull-right"></i>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-edit"></i> <span>Forms</span>
			<span class="pull-right-container"> <i
				class="fa fa-angle-left pull-right"></i>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-table"></i>
			<span>Tables</span> <span class="pull-right-container"> <i
				class="fa fa-angle-left pull-right"></i>
		</span>
	</a></li>
	<li><a href="pages/calendar.html"> <i class="fa fa-calendar"></i>
			<span>Calendar</span> <span class="pull-right-container"> <small
				class="label pull-right bg-red">3</small> <small
				class="label pull-right bg-blue">17</small>
		</span>
	</a></li>
	<li><a href="pages/mailbox/mailbox.html"> <i
			class="fa fa-envelope"></i> <span>Mailbox</span> <span
			class="pull-right-container"> <small
				class="label pull-right bg-yellow">12</small> <small
				class="label pull-right bg-green">16</small> <small
				class="label pull-right bg-red">5</small>
		</span>
	</a></li>
	<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
			<span>Examples</span> <span class="pull-right-container"> <i
				class="fa fa-angle-left pull-right"></i>
		</span>
	</a></li>
	<li><a href="documentation/index.html"> <i class="fa fa-book"></i>
			<span>Documentation</span>
	</a></li>
	<li class="header">LABELS</li>
	<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
	<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
	<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
</ul>-->

