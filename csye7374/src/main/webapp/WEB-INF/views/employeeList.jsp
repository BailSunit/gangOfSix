<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Registry</title>
</head>
<body>
	<center>
		<h3>To update your Employee's Review State, select your employee
			and click Update Review Status</h3>
		<form action="updateStatus" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">Inventory List</p>
			<table border="1">
				<tr>
					<th>Select</th>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Employee Position</th>
					<th>Employee Email</th>
					<th>Employee Phone</th>
					<th>Review State</th>
				</tr>
				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td><INPUT TYPE="CHECKBOX" NAME="${employee.eid}"
							VALUE="${employee.eid}"></td>
						<td>${employee.name}</td>
						<td>${employee.position}</td>
						<td>${employee.email}</td>
						<td>${employee.phone}</td>
						<td>${employee.currentState}</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="submit" value="Update Review Status" />
		</form>
	</center>
</body>
</html>