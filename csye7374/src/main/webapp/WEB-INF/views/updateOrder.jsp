<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Page</title>
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
		<form action="adminHomePage" method="post">
			<input type="submit" value="Back To Dashboard">
		</form>
	</center>
	<center>
		<form action="updateOrder" method="post">
			<br /> <br />
			<p
				style="text-align: center; font-family: 'Righteous', cursive; font-size: x-large; color: yellow; font-weight: 400">Fulfill
				Orders</p>

			<table
				style="text-align: center; font-family: 'Righteous', cursive; font-size: medium; color: white; font-weight: 400"
				border="1">
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
			<br /> <br /> <input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;"
				value="Update These Orders" />
		</form>
	</center>
</body>
</html>