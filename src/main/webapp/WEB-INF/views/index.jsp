<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Employee Details</title>

<!-- Icons font CSS-->
<link
	href="<%=request.getContextPath()%>/static/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link
	href="<%=request.getContextPath()%>/static/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link
	href="<%=request.getContextPath()%>/static/vendor/select2/select2.min.css"
	rel="stylesheet" media="all">
<link
	href="<%=request.getContextPath()%>/static/vendor/datepicker/daterangepicker.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="<%=request.getContextPath()%>/static/css/main.css"
	rel="stylesheet" media="all">
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/static/images/favicon.ico">

<!-- Data Tables -->
<link
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css"
	rel="stylesheet">

<!-- SweetAlert JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<!-- FontAwesome CSS -->
<link
	href="<%=request.getContextPath()%>/static/js/vendor/font-awesome-4.7/font-awesome.css"
	rel="stylesheet">

<!-- Bootstrap Modal CSS -->
<link
	href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Add New Employee</h2>
					<c:url var="saveoem" value="/addNewEmployee" />
					<form:form method="POST" class="form-horizontal"
						action="${saveoem}" onSubmit=" return validate();">
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">first name</label> <input
										class="input--style-4" type="text" id="firstName"
										name="firstName" placeholder="Enter First Name">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">middle name</label> <input
										class="input--style-4" type="text" id="middleName"
										name="middleName" placeholder="Enter Middle Name">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">last name</label> <input
										class="input--style-4" type="text" id="lastName"
										name="lastName" placeholder="Enter Last Name">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">user name</label> <input
										class="input--style-4" type="text" id="userName"
										name="userName" placeholder="Enter Username">
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Birthday</label>
									<div class="input-group-icon">
										<input class="input--style-4 js-datepicker" type="text"
											name="employeeBirthday" id="employeeBirthday"
											placeholder="Select Birthday"> <i
											class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
									</div>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Blood Group</label>
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="employeeBloodGroup" id="employeeBloodGroup">
											<option value="">-- Please Select --</option>
											<option value="O Positive">O Positive</option>
											<option value="O Negative">O Negative</option>
											<option value="A Positive">A Positive</option>
											<option value="A Negative">A Negative</option>
											<option value="B Positive">B Positive</option>
											<option value="B Negative">B Negative</option>
											<option value="AB Positive">AB Positive</option>
											<option value="AB Negative">AB Negative</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Email</label> <input
										class="input--style-4" type="email" name="emailAddress"
										id="emailAddress" placeholder="Enter Email Address">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Phone Number</label> <input
										class="input--style-4" type="number" name="contactNumber"
										id="contactNumber" placeholder="Enter Contact Number">
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Designation</label> <input
										class="input--style-4" type="text" name="employeeDesignation"
										id="employeeDesignation" placeholder="Enter Designation">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Employee Salary</label> <input
										class="input--style-4" type="number" name="employeeSalary"
										id="employeeSalary" placeholder="Enter Salary">
								</div>
							</div>
						</div>
						<div class="p-t-15">
							<button class="btn btn--radius-2 btn--blue" type="submit"
								id="submitBtnAddNewUser">Submit</button>
						</div>
					</form:form>
				</div>
			</div>

			<br> <br> <br>
			<div class="card card-4"
				style="margin-left: -50%; margin-right: -55%;">
				<div class="card-body">
					<h2 class="title">Employee List</h2>
					<div class="row">
						<div class="pad">
							<table id="listingservice" style="width: 100%"
								class="table table-striped">
								<thead>
									<tr>
										<th>UPDATE</th>
										<th>DELETE</th>
										<th>EMPLOYEE <br>FULL NAME
										</th>
										<th>EMPLOYEE <br>BIRTHDAY
										</th>
										<th>EMPLOYEE <br>SALARY
										</th>
										<th>EMPLOYEE <br>BLOOD GROUP
										</th>
										<th>EMAIL ADDRESS</th>
										<th>CONTACT NUMBER</th>
										<th>EMPLOYEE <br> DESIGNATION
										</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="modalUpdateEmployee" tabindex="-1"
				role="dialog" aria-labelledby="modalUpdateEmployee"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="card card-4">
							<div class="card-body">
								<h2 class="title">Update Employee</h2>
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group">
											<label class="label">user name</label> <input
												class="input--style-4" type="text" id="updateUserName"
												name="updateUserName" readonly>
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">first name</label> <input
												class="input--style-4" type="text" id="updateFirstName"
												name="updateFirstName" placeholder="Enter First Name">
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">middle name</label> <input
												class="input--style-4" type="text" id="updateMiddleName"
												name="updateMiddleName" placeholder="Enter Middle Name">
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">last name</label> <input
												class="input--style-4" type="text" id="updateLastName"
												name="updateLastName" placeholder="Enter Last Name">
										</div>
									</div>
								</div>
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group">
											<label class="label">Birthday</label>
											<div class="input-group-icon">
												<input class="input--style-4 js-datepicker" type="text"
													name="updateEmployeeBirthday" id="updateEmployeeBirthday"
													placeholder="Select Birthday"> <i
													class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
											</div>
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">Employee Blood Group</label>
											<div class="rs-select2 js-select-simple select--no-search">
												<select name="updateEmployeeBloodGroup"
													id="updateEmployeeBloodGroup">
													<option value="">-- Please Select --</option>
													<option value="O Positive">O Positive</option>
													<option value="O Negative">O Negative</option>
													<option value="A Positive">A Positive</option>
													<option value="A Negative">A Negative</option>
													<option value="B Positive">B Positive</option>
													<option value="B Negative">B Negative</option>
													<option value="AB Positive">AB Positive</option>
													<option value="AB Negative">AB Negative</option>
												</select>
												<div class="select-dropdown"></div>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group">
											<label class="label">Email</label> <input
												class="input--style-4" type="email"
												name="updateEmailAddress" id="updateEmailAddress"
												placeholder="Enter Email Address">
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">Phone Number</label> <input
												class="input--style-4" type="number"
												name="updateContactNumber" id="updateContactNumber"
												placeholder="Enter Contact Number">
										</div>
									</div>
								</div>
								<div class="row row-space">
									<div class="col-2">
										<div class="input-group">
											<label class="label">Employee Designation</label> <input
												class="input--style-4" type="text"
												name="updateEmployeeDesignation"
												id="updateEmployeeDesignation"
												placeholder="Enter Designation">
										</div>
									</div>
									<div class="col-2">
										<div class="input-group">
											<label class="label">Employee Salary</label> <input
												class="input--style-4" type="number"
												name="updateEmployeeSalary" id="updateEmployeeSalary"
												placeholder="Enter Salary">
										</div>
									</div>
								</div>
								<div class="p-t-15">
									<button class="btn btn--radius-2 btn--blue" type="submit"
										id="submitBtnUpdateUser">Submit</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<c:choose>
				<c:when test="${add == 'success'}">
					<!-- 					<div class="alert alert-success alert-dismissible"> -->
					<!-- 						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
					<!-- 						<strong>Success!</strong> New User Added! -->
					<!-- 					</div> -->
					<script type="text/javascript">
						Swal.fire({
									icon : 'success',
									title : 'Success!',
									text : 'New Employee has been Added!',
									showConfirmButton : true,
									preConfirm : function() {
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
					</script>
				</c:when>

				<c:when test="${add == 'failed'}">
					<!-- 					<div class="alert alert-danger alert-dismissible"> -->
					<!-- 						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> -->
					<!-- 						<strong>Fail!</strong> Failed To Add User. -->
					<!-- 					</div> -->
					<script type="text/javascript">
						Swal.fire({
									icon : 'error',
									title : 'Failed!',
									text : 'Failed to add the Employee',
									showConfirmButton : true,
									preConfirm : function() {
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/";
										window.location.href = base_url;
									}
								})
					</script>
				</c:when>
			</c:choose>
		</div>
	</div>

	<!-- Jquery JS-->
	<script
		src="<%=request.getContextPath()%>/static/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script
		src="<%=request.getContextPath()%>/static/vendor/select2/select2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/vendor/datepicker/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/vendor/datepicker/daterangepicker.js"></script>

	<!-- Data Table JS -->
	<script
		src="<%=request.getContextPath()%>/static/js/datatables/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/datatables/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/datatables/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/datatables/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/datatables/datatables_listing/dataTables.buttons.min.js"></script>

	<!-- Main JS-->
	<script src="<%=request.getContextPath()%>/static/js/global.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/indexJs.js"></script>

	<!-- Bootstrap Modal JS -->
	<script
		src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>

	<script type="text/javascript">
	
	</script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->