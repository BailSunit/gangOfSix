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
		<form action="adminHomePage" method="get">
			<input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;"
				value="Back To Dashboard">
		</form>
	</center>
	<center>
		<form action="inventory" method="post">
			
			<p style="text-align: center; font-family: 'Righteous', cursive;; font-size: xxx-large; color: yellow; font-weight: 700">Inventory List</p>
			
			<table style="text-align: center; font-family: 'Righteous', cursive;; font-size: medium; color: white; font-weight: 100"
				border="1">
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
						<td><INPUT TYPE="NUMBER" ID="${item.slNo}_value"
							NAME="${item.slNo}_value" MIN="1" MAX="100" /></td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="submit"
				style="margin: 30px 10px; font-family: 'Righteous', cursive;" value="Update My Inventory" />
		</form>
	</center>
</body>
</html>