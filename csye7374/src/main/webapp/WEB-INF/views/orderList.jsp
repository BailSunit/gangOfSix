<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>orderList</title>
    </head>
    <body>
	    <center>
			<form action="itemList" method="post">
				<input type="submit" value="Back to Items List"/>
			</form>
		</center>
		<center>
			<p style="font-family: verdana; font-size: 40px">Order History</p>
			<table border="1">
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
					</tr>
				</c:forEach>
			</table>
		</center>
    </body>
</html>