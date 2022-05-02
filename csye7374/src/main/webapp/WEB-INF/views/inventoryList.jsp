<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Page</title>
</head>
<body>
	<center>
		<form action="adminHomePage" method="get">
			<input type="submit" value="Back To Dashboard">
		</form>
	</center>
	<center>
		<form action="inventory" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">Inventory List</p>
			<br /> <br />
			<table border="1">
				<tr>
					<th>Select</th>
					<th>Item Name</th>
					<th>Item Cost</th>
					<th>Availability</th>
					<th>Added Value</th>
				</tr>
				<c:forEach items="${itemList}" var="item">
					<tr>
						<td><INPUT TYPE="CHECKBOX" NAME="${item.slNo}"
							VALUE="${item.slNo}"></td>
						<td>${item.itemName}</td>
						<td>${item.itemCost}</td>
						<td>${item.available}</td>
						<td><INPUT TYPE="NUMBER" ID="${item.slNo}_value" NAME="${item.slNo}_value" MIN="1"
							MAX="100"/></td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="submit" value="Update My Inventory" />
		</form>
	</center>
</body>
</html>