<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@ include file="Header.jsp"%>
<style type="text/css">
.content {
    padding-right:0px !important;
    padding-left: 0px !important;
    }
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>J</b>UT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Jaggu</b>University</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <!-- Notifications: style can be found in dropdown.less -->
          <!-- Tasks: style can be found in dropdown.less -->
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="<c:url value="/css/admin/dist/img/user2-160x160.jpg"/>" class="user-image" alt="User Image">
              <span class="hidden-xs">${sessionScope.USERSESSION.user.username}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="<c:url value="/css/admin/dist/img/user2-160x160.jpg"/>" class="img-circle" alt="User Image">

                <p>
                  ${sessionScope.USERSESSION.user.username} - ${sessionScope.USERSESSION.user.roleID.role}
                  <small>Member</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                <spring:url value="/home/logout" var="logout" htmlEscape="true" />  
                  <a href="${logout}" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
        </ul>
      </div>
    </nav>
  </header>
  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <%@ include file="Menu.jsp"%>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
  
    <!----------------------------- Content Header (Page header) ----------------------------->
    <section class="content-header">
      <h1>Dashboard<small>Control panel</small></h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>
    <!----------------------------- Content Header End----------------------------->
    
    <!--------------------------- Main content ------------------------->
    <section class="content" style="minimum-height:0px">
    	<div class="panel">
	    	<div class="panel-body">
	    		<dec:body />
	    	</div>
    	</div>
    </section>
    <!--------------------------- /.content ----------------------------->
    
    
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.7
    </div>
    <strong>Copyright &copy; 2014-2017 <a href="#">Akjn</a>\,,/</strong> All rights
    reserved.
  </footer>
  <div class="control-sidebar-bg"></div>
</div>
<%@ include file="Footer.jsp"%>
</body>
</html>






