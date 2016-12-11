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


	<a class="btn btn-primary pull-right" href="/caps/Admin/createFaculty" style="">Add a Faculty</a>
	<div class="col-xs-12" style="margin-top:10px">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Faculty</h3>

				<div class="box-tools">
					<div class="input-group input-group-sm" style="width: 150px;">
						<input type="text" name="table_search"
							class="form-control pull-right search-faculty"
							placeholder="Search by name">

						<div class="input-group-btn">
							<button type="" class="btn btn-default">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body table-responsive no-padding"
				id="list-students-details">
				<c:if test="${fn:length(flist) gt 0 }">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th>#</th>
								<th>Faculty Name</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
							<c:forEach var="facut" items="${flist}">
								<tr>
									<td>${dept.facultyID}</td>
									<td>${facut.facultyName}</td>
									<td><a href="/caps/Admin/editFaculty/${facut.facultyID}" title="Edit"><i class="fa fa-pencil-square"></i></a></td>
									<td><a href="javascript:void(0)" class="delete-faculty" data-deleteid="${facut.facultyID}" title="Delete"><i class="fa fa-trash-o"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>

</body>
</html>