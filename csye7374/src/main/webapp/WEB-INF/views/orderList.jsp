<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>orderList</title>
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
		<form action="itemList" method="get">
			<input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;"
				value="Back" />
		</form>
	</center>
	<center>
		<c:set var="totalCost" value="${0}"></c:set>
		<p
			style="text-align: center; font-family: 'Righteous', cursive; font-size: x-large; color: yellow; font-weight: 400">Order
			History</p>
		<table
			style="text-align: center; font-family: 'Righteous', cursive; font-size: medium; color: white; font-weight: 400"
			border="1">
			<tr>
				<th>Item Name</th>
				<th>Item Cost</th>
				<th>Quantity</th>
				<th>State</th>
			</tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.item.itemName}</td>
					<td>${order.item.itemCost}</td>
					<td>${order.quantity}</td>
					<td>${order.currentStateName}</td>
					<c:set var="totalCost" scope="page"
						value="${totalCost + order.item.itemCost*order.quantity}"></c:set>
				</tr>
			</c:forEach>
		</table>
		<p
			style="text-align: center; font-family: 'Righteous', cursive; font-size: x-large; color: yellow; font-weight: 400">
			Total expenditure

			<fmt:formatNumber value="${totalCost}" type="currency" />
		</p>
	</center>
</body>
</html>