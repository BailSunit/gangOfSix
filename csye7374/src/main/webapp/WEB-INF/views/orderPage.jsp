<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Orders</title>
</head>
<body>
	<center>
		<form action="pastOrder" method="post">
			<input type="submit" value="Past Orders">
		</form>
		<form action="logout" method="post">
			<br /> <br />
			<c:set var="totalCost" value="${0}"></c:set>
			<p style="font-family: verdana; font-size: 40px">My Orders</p>
			<table border="1">
				<tr>
					<th>Item Name</th>
					<th>Item Cost</th>
				</tr>
				<c:forEach items="${orders}" var="order">
					<tr>
						<td>${order.item.itemName}</td>
						<td>${order.item.itemCost}</td>
						<c:set var="totalCost" scope="page"
							value="${totalCost + order.item.itemCost}"></c:set>
					</tr>
				</c:forEach>
			</table>
			<h1>
				Your Order total is
				<fmt:formatNumber value="${totalCost}" type="currency" />
			</h1>
			<br /> <br /> <input type="submit" value="Logout" />
		</form>
	</center>
</body>
</html>