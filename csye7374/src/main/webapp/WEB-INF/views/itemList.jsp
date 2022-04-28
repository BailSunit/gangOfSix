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
		<form action="placeOrder" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">Inventory List</p>
			<table border="1">
				<tr>
					<th>Select</th>
					<th>Item Name</th>
					<th>Item Cost</th>
					<th>Availability</th>
				</tr>
				<c:forEach items="${itemList}" var="item">
					<tr>
						<td><INPUT TYPE="CHECKBOX" NAME="${item.slNo}"
							VALUE="${item.slNo}"></td>
						<td>${item.itemName}</td>
						<td>${item.itemCost}</td>
						<c:choose>
							<c:when test="${item.available ge 20}">
								<td>Available</td>
							</c:when>
							<c:when test="${item.available lt 20}">
								<td>Stock Running Low</td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="hidden" name="source" value="firstForm" />
			<input type="submit" value="Place my Order!" />
		</form>
	</center>
</body>
</html>