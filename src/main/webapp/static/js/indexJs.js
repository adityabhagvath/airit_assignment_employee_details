window.onload = () => {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"
		+ l.pathname.split('/')[1];
	var serviceUrl = base_url + "/getEmployeeList";
	$.ajax({
		url: serviceUrl,
		type: "POST",
		dataType: 'json',
		success: function(data2) {
			$('#listingservice').DataTable().destroy();
			var table = $('#listingservice').DataTable({
				lengthChange: false,
				data: data2,
				pageLength: 5,
				paging: false,
				destroy: true,
				searching: false,
				scrollX: true,
				columnDefs: [{
					"width": "350",
					"targets": 6
				}],
				fixedColumns: false,
				"columnDefs": [{
					"targets": 3,
					"createdCell":
						function(td, cellData, rowData, row, col) {
							if (cellData === 'Out of Service') {
								$(td).css('color', 'red')
							} else if (cellData === 'In Service') {
								$(td).css('color', 'green')
							} else {
								$(td).css('color', '#A9A9A9')
							}
						}
				}]
			});
		}
	})


}

var getUpdateDetails = (usernameUpdate, firstNameUpdate, middleNameUpdate, lastNameUpdate,
	employeeBirthdayUpdate, employeeSalaryUpdate, employeeBloodGroupUpdate,
	emailAddressUpdate, contactNumberUpdate, employeeDesignation) => {
	$('#modalUpdateEmployee').modal('show');
	$('#updateUserName').val(usernameUpdate);
	$('#updateFirstName').val(firstNameUpdate);
	$('#updateMiddleName').val(middleNameUpdate);
	$('#updateLastName').val(lastNameUpdate);
	$('#updateEmployeeBirthday').val(employeeBirthdayUpdate);
	$('#updateEmployeeSalary').val(employeeSalaryUpdate);
	$('#updateEmployeeBloodGroup').val(employeeBloodGroupUpdate);
	$('#updateEmailAddress').val(emailAddressUpdate);
	$('#updateContactNumber').val(contactNumberUpdate);
	$('#updateEmployeeDesignation').val(employeeDesignation);
}

$('#submitBtnUpdateUser').click(() => {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"
		+ l.pathname.split('/')[1];
	var serviceUrl = base_url + "/updateEmployeeDetailsForUser";
	$.ajax({
		url: serviceUrl,
		type: "POST",
		data: "username=" + $('#updateUserName').val()
			+ "&firstName=" + $('#updateFirstName').val()
			+ "&middleName=" + $('#updateMiddleName').val()
			+ "&lastName=" + $('#updateLastName').val()
			+ "&employeeBirthday=" + $('#updateEmployeeBirthday').val()
			+ "&employeeSalary=" + $('#updateEmployeeSalary').val()
			+ "&employeeBloodGroup=" + $('#updateEmployeeBloodGroup').val()
			+ "&emailAddress=" + $('#updateEmailAddress').val()
			+ "&contactNumber=" + $('#updateContactNumber').val()
			+ "&employeeDesignation=" + $('#updateEmployeeDesignation').val(),
		success: function(data2) {
				Swal.fire({
					icon: 'success',
					title: 'Success!',
					text: 'Successfully updated the details!',
					showConfirmButton: true,
					preConfirm: function() {
						var l = window.location;
						var base_url = l.protocol + "//"
							+ l.host + "/";
						window.location.href = base_url;
						// 								var l = window.location;
						// 								var base_url = l.protocol + "//" + l.host + "/"
						// 										+ l.pathname.split('/')[1];
						// 								window.location.href = base_url
						// 										+ "/";
					}
				})
		}
	})
})

var deleteEmployeeDetails = (username) => {

	Swal.fire({
		title: 'Are you sure?',
		text: "You won't be able to revert this!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Yes, delete it!'
	}).then((result) => {
		if (result.isConfirmed) {
			/* Read more about isConfirmed, isDenied below */
			var dataValue;
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
			var serviceUrl = base_url + "/deleteEmployeeDetails";
			$.ajax({
				url: serviceUrl,
				type: "POST",
				data: "username=" + username,
				success: function() {
					Swal.fire({
						icon: 'success',
						title: 'Deleted!',
						text: 'The Employee has been deleted successfully!',
						showConfirmButton: true,
						preConfirm: function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/";
							window.location.href = base_url;
						}
					})
				}
			})
		}
	})
}

var validate = () => {
	$('#firstName').on('focusout', function() {

		var usertype = $('#firstName').val();

		if (usertype.trim() == "") {
			ToolTip('firstName', 'show');
		}
		else {
			ToolTip('firstName', 'hide');
		}
	});

	$('#firstName').on('focus', function() {
		ToolTip('firstName', 'destroy');
	});

	$('#middleName').on('focusout', function() {

		var usertype = $('#middleName').val();

		if (usertype.trim() == "") {
			ToolTip('middleName', 'show');
		}
		else {
			ToolTip('middleName', 'hide');
		}
	});

	$('#middleName').on('focus', function() {
		ToolTip('middleName', 'destroy');
	});

	$('#lastName').on('focusout', function() {

		var usertype = $('#lastName').val();

		if (usertype.trim() == "") {
			ToolTip('lastName', 'show');
		}
		else {
			ToolTip('lastName', 'hide');
		}
	});

	$('#lastName').on('focus', function() {
		ToolTip('lastName', 'destroy');
	});

	$('#userName').on('focusout', function() {

		var usertype = $('#userName').val();

		if (usertype.trim() == "") {
			ToolTip('userName', 'show');
		}
		else {
			ToolTip('userName', 'hide');
		}
	});

	$('#userName').on('focus', function() {
		ToolTip('userName', 'destroy');
	});

	$('#employeeBirthday').on('focusout', function() {

		var usertype = $('#employeeBirthday').val();

		if (usertype.trim() == "") {
			ToolTip('employeeBirthday', 'show');
		}
		else {
			ToolTip('employeeBirthday', 'hide');
		}
	});

	$('#employeeBirthday').on('focus', function() {
		ToolTip('employeeBirthday', 'destroy');
	});

	$('#employeeBloodGroup').on('focusout', function() {

		var usertype = $('#employeeBloodGroup').val();

		if (usertype.trim() == "") {
			ToolTip('employeeBloodGroup', 'show');
		}
		else {
			ToolTip('employeeBloodGroup', 'hide');
		}
	});

	$('#employeeBloodGroup').on('focus', function() {
		ToolTip('employeeBloodGroup', 'destroy');
	});

	$('#emailAddress').on('focusout', function() {

		var usertype = $('#emailAddress').val();

		if (usertype.trim() == "") {
			ToolTip('emailAddress', 'show');
		}
		else {
			ToolTip('emailAddress', 'hide');
		}
	});

	$('#emailAddress').on('focus', function() {
		ToolTip('emailAddress', 'destroy');
	});

	$('#contactNumber').on('focusout', function() {

		var usertype = $('#contactNumber').val();

		if (usertype.trim() == "") {
			ToolTip('contactNumber', 'show');
		}
		else {
			ToolTip('contactNumber', 'hide');
		}
	});

	$('#contactNumber').on('focus', function() {
		ToolTip('contactNumber', 'destroy');
	});

	$('#employeeDesignation').on('focusout', function() {

		var usertype = $('#employeeDesignation').val();

		if (usertype.trim() == "") {
			ToolTip('employeeDesignation', 'show');
		}
		else {
			ToolTip('employeeDesignation', 'hide');
		}
	});

	$('#employeeDesignation').on('focus', function() {
		ToolTip('employeeDesignation', 'destroy');
	});

	$('#employeeSalary').on('focusout', function() {

		var usertype = $('#employeeSalary').val();

		if (usertype.trim() == "") {
			ToolTip('employeeSalary', 'show');
		}
		else {
			ToolTip('employeeSalary', 'hide');
		}
	});

	$('#employeeSalary').on('focus', function() {
		ToolTip('employeeSalary', 'destroy');
	});

}

var ToolTip = (fieldName, status) => {
	if (fieldName == "firstName") {
		var errorMessage = "<span>Enter First Name<span>";
	} else if (fieldName == "middleName") {
		var errorMessage = "<span>Enter Middle Name<span>";
	} else if (fieldName == "lastName") {
		var errorMessage = "<span>Enter Last Name<span>";
	} else if (fieldName == "userName") {
		var errorMessage = "<span>Enter Username<span>";
	} else if (fieldName == "employeeBirthday") {
		var errorMessage = "<span>Select Birthday<span>";
	} else if (fieldName == "employeeBloodGroup") {
		var errorMessage = "<span>Enter Blood Group<span>";
	} else if (fieldName == "emailAddress") {
		var errorMessage = "<span>Enter Email Address<span>";
	} else if (fieldName == "contactNumber") {
		var errorMessage = "<span>Enter Contact Number<span>";
	} else if (fieldName == "employeeDesignation") {
		var errorMessage = "<span>Enter Designation<span>";
	} else if (fieldName == "employeeSalary") {
		var errorMessage = "<span>Enter Salary<span>";
	}

	$("#" + fieldName).tooltip({
		trigger: 'manual',
		placement: 'top',
		title: errorMessage,
		animation: true,
		delay: 1000,
		html: true
	});

	if (status == "show") {

		$("#" + fieldName).tooltip('show');

	} else {
		$("#" + fieldName).tooltip('hide');
	}
}

