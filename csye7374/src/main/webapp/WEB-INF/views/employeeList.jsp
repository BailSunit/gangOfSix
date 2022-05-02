<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Registry</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Righteous&family=Satisfy&display=swap"
	rel="stylesheet">
<style>
body {
	min-height: 100vh;
	background-image: linear-gradient(transparent, black 99%),
		url(https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
	background-size: cover;
}
</style>
</head>
<body>
	<center>
		<form action="adminHomePage" method="get">
			<input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;"
				value="Back To Dashboard">
		</form>
	</center>
	<div style="padding: 0px 200px 20px 200px">
		<p
			style="text-align: center; font-family: 'Righteous', cursive;; font-size: xxx-large; color: yellow; font-weight: 700">Employee
			List</p>
		<p
			style="text-align: center; font-family: 'Righteous', cursive;; font-size: x-large; color: yellow; font-weight: 400">To
			update your Employee's Review State, select your employee and click
			Update Review Status</p>
	</div>
	<center>
		<form action="employeeList" method="post">
			<table
				style="text-align: center; font-family: 'Righteous', cursive;; font-size: medium; color: white; font-weight: 100"
				border="1">
				<tr>
					<th>Select</th>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Employee Email</th>
					<th>Employee Phone</th>
					<th>Employee Position</th>
					<th>Review State</th>
				</tr>
				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td><INPUT TYPE="CHECKBOX" NAME="${employee.eid}"
							VALUE="${employee.eid}"></td>
						<td>${employee.eid}</td>
						<td>${employee.name}</td>
						<td>${employee.email}</td>
						<td>${employee.phone}</td>
						<td>${employee.position}</td>
						<td>${employee.currentState}</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;"
				value="Update Review Status" />
		</form>
	</center>
</body>
</html>