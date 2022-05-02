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
	<center></center>
	<center>
		<form action="updateOrder" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">Fulfill Orders</p>
			<br /> <br />
			<table border="1">
				<tr>
					<th>Select</th>
					<th>Customer Name</th>
					<th>Item Name</th>
					<th>Item Cost</th>
					<th>Quantity</th>
					<th>State</th>
				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td><INPUT TYPE="CHECKBOX" NAME="${order.orderId}"
							VALUE="${order.orderId}"></td>
						<td>${order.customerName}</td>
						<td>${order.item.itemName}</td>
						<td>${order.item.itemCost}</td>
						<td>${order.quantity}</td>
						<td>${order.currentStateName}</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="submit" value="Update These Orders" />
		</form>
	</center>
</body>
</html>