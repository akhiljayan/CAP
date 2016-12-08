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