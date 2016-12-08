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
	$("body").on("click",".delete-student",function(){
		var studentId = $(this).data("deleteid");
		swal({
			  title: "Are you sure?",
			  text: "You will not be able to recover this imaginary file!",
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
				var set = deleteStudent(studentId);  
				swal("Deleted!", "Student has been deleted.", "success");
				location.reload();

			  } else {
			    swal("Cancelled", "Student is safe :)", "error");
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

function deleteStudent(studentId) {
	var deleteStudentsPath = "/caps/Admin/deleteStudent/" + studentId;
	var set = "false";
	$.ajax({
		type : "POST",
		url : deleteStudentsPath,
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