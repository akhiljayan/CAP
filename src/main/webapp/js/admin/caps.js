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
	$("body").on("click",".delete-department",function(){
		var deptId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteDepartment/" + deptId;
		var deletefor = "Department";
		deleteSwal(deletepath,deletefor);
	});
	
	$("body").on("click",".delete-faculty",function(){
		var facultyId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteFaculty/" + studentId;
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
		var studentId = $(this).data("deleteid");
		var deletepath = "/caps/Admin/deleteCourse/" + studentId;
		var deletefor = "Course";
		deleteSwal(deletepath,deletefor);
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
});

function listStudents(value) {
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
			var set = deleteItem(path);  
			swal("Deleted!", deletefor+" has been deleted.", "success");
			location.reload();

		  } else {
		    swal("Cancelled", deletefor+" is safe :)", "error");
		  }
		});
}

function deleteItem(path){
	var set = "false";
	$.ajax({
		type : "POST",
		url : path,
		context : this,
		beforeSend : function() {
		},
		success : function($data) {
			if($data){
				set = "true";
			}else{
				set = "false";
			}
		},
		complete : function() {
		}
	});
	return set;
}