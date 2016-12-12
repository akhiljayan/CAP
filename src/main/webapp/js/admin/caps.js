$(document).ready(function() {
	$("#datepicker1").datepicker({
		dateFormat : "dd/mm/yy"
	});
});
$(document).ready(function() {
	$("#datepicker2").datepicker({
		dateFormat : "dd/mm/yy"
	});
});

$(document).ready(function(){
	countEnrolmentRequests();
	
	$("body").on("click",".delete-department",function(){
		var deptId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteDepartment/" + deptId;
		var deletefor = "Department";
		deleteSwal(deletepath,deletefor);
	});
	
	$("body").on("click",".delete-faculty",function(){
		var facultyId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteFaculty/" + facultyId;
		var deletefor = "Faculty";
		deleteSwal(deletepath,deletefor);
	});
	
	$("body").on("click",".delete-student",function(){
		var studentId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteStudent/" + studentId;
		var deletefor = "Student";
		deleteSwal(deletepath,deletefor);
	});
	
	$("body").on("click",".delete-course",function(){
		var courseId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteCourse/" + courseId;
		var deletefor = "Course";
		deleteSwalCourse(deletepath,deletefor);
	});
	
	$("body").on("click",".delete-lecturer",function(){
		var lecturerId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteLecturer/" + lecturerId;
		var deletefor = "Lecturer";
		deleteSwal(deletepath,deletefor);
	});
	
	$("body").on("change","#courses-ajax",function(){
		var id = $(this).val();
		if($(this).data("forthe")==="grade"){
			var path = "/caps/Ajax/gradeCourseMenu/" + id;
		}else{
			var path = "/caps/Ajax/viewPerformanceMenu/" + id;
		}
		lecturerMenu(path);
	});
	
	$("body").on("click",".enrol-student",function(){
		var studentId = $(this).data("studentid");
		var courseId = $(this).data("courseid");
		var path = "/caps/AdminEnrol/student-enrole-admin/" + studentId + "/" + courseId;
		$.ajax({
			type : "POST",
			url : path,
			context : this,
			beforeSend : function() {
			},
			success : function($data) {
				if($data != null){
					$(this).removeClass("btn-default");
					$(this).removeClass("enrol-student");
					$(this).addClass("btn-warning");
					$(this).html("Enroled");
				}else{
					swal("Max number of students atained");
				}
			},
			complete : function() {
			}
		});
	});
	
	$("body").on("click",".add-course-request",function(){
		var courseId = $(this).data("courseid");
		var path = "/caps/Student/student-request/" + courseId ;
		$.ajax({
			type : "POST",
			url : path,
			context : this,
			beforeSend : function() {
			},
			success : function($data) {
				if($data != null){
					swal("Request sent");
					location.reload();
				}else{
					swal("Max number of students atained");
				}
			},
			complete : function() {
			}
		});
	});
	
	$("body").on("click",".enrol-student-grant",function(){
		var courseId = $(this).data("courseid");
		var studentId = $(this).data("studentid");
		var path = "/caps/AdminEnrol/student-request-grant/" + courseId + "/" + studentId;
		$.ajax({
			type : "POST",
			url : path,
			context : this,
			beforeSend : function() {
			},
			success : function($data) {
				if($data != null){
					swal("Status Updated");
					location.reload();
				}else{
					swal("Max number of students atained");
				}
			},
			complete : function() {
			}
		});
	});
	
	$("body").on("click",".enrol-student-deny",function(){
		var courseId = $(this).data("courseid");
		var studentId = $(this).data("studentid");
		var path = "/caps/AdminEnrol/enrol-student-deny/" + courseId + "/" + studentId;
		$.ajax({
			type : "POST",
			url : path,
			context : this,
			beforeSend : function() {
			},
			success : function($data) {
				if($data != null){
					swal("Status Updated");
					location.reload();
				}else{
					swal("Max number of students atained");
				}
			},
			complete : function() {
			}
		});
	});
	
});

$(document).ready(function() {

	$("body").on("keyup", ".search-student", function() {
		var key = $(this).val();
		if (key == '' || key == null || key == undefined) {
			listStudents("--");
		} else {
			listStudents(key);
		}
	});
	
	$("body").on("keyup", ".search-student-enrolment", function() {
		var courseId = $(".enrol-courseId").val();
		var key = $(this).val();
		if (key == '' || key == null || key == undefined) {
			listStudentsEnrolment("--",courseId);
		} else {
			listStudentsEnrolment(key,courseId);
		}
	});
	
});

function listStudents(value,courseId) {
	var listStudentsPath = "/caps/Ajax/search-students/" + value;
	$.ajax({
		type : "GET",
		url : listStudentsPath,
		context : this,
		beforeSend : function() {
		},
		success : function($data) {
			$("#list-students-details").html($data);
		},
		complete : function() {
		}
	});
}

function listStudentsEnrolment(value,courseId) {
	var listStudentsPath = "/caps/Ajax/search-students-enrolment/" + value +"/"+courseId;
	$.ajax({
		type : "POST",
		url : listStudentsPath,
		context : this,
		beforeSend : function() {
		},
		success : function($data) {
			$("#list-students-details").html($data);
		},
		complete : function() {
		}
	});
}

function deleteSwal(path,deletefor){
	swal({
		  title: "Are you sure?",
		  text: "You will not be able to recover this "+deletefor+" details!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "Yes, delete it!",
		  cancelButtonText: "No, cancel plx!",
		  closeOnConfirm: false,
		  closeOnCancel: false
		},
		function(isConfirm){
		  if (isConfirm) {  
			  $.ajax({
					type : "POST",
					url : path,
					context : this,
					beforeSend : function() {
					},
					success : function($data) {
						if($data){
							swal("Deleted!", deletefor+" has been deleted.", "success");
							if(deletefor =="Course"){
								location.reload();
							}else{
								window.location.href = "../caps/Admin/manageCourse";
							}
							
						}else{
							set = "false";
						}
					},
					complete : function() {
					}
				});
			  
			

		  } else {
		    swal("Cancelled", deletefor+" is safe :)", "error");
		  }
		});
}

function deleteSwalCourse(path,deletefor){
	swal({
		  title: "Are you sure?",
		  text: "You will not be able to recover this "+deletefor+" details!",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonColor: "#DD6B55",
		  confirmButtonText: "Yes, delete it!",
		  cancelButtonText: "No, cancel plx!",
		  closeOnConfirm: false,
		  closeOnCancel: false
		},
		function(isConfirm){
		  if (isConfirm) {  
			  $.ajax({
					type : "POST",
					url : path,
					context : this,
					beforeSend : function() {
					},
					success : function($data) {
						if($data){
							swal("Deleted!", deletefor+" has been deleted.", "success");
							window.location.href = "../manageCourse";
						}else{
							set = "false";
						}
					},
					complete : function() {
					}
				});
			  
			

		  } else {
		    swal("Cancelled", deletefor+" is safe :)", "error");
		  }
		});
}

function lecturerMenu(path){
	$.ajax({
		type : "POST",
		url : path,
		context : this,
		beforeSend : function() {
		},
		success : function($data) {
			$("#list-students-table").html($data);
		},
		complete : function() {
		}
	});
}


function countEnrolmentRequests(){
	var path = "/caps/Ajax/count-enrolment-requests"
	$.ajax({
		type : "POST",
		url : path,
		context : this,
		beforeSend : function() {
		},
		success : function($data) {
			$("#requestCount").html($data);
			$("#menu-process-enrl").html($data);
		},
		complete : function() {
		}
	});
}