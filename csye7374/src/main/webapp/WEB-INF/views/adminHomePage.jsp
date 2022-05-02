<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN HOME PAGE</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Righteous&family=Satisfy&display=swap" rel="stylesheet">
        <style>
            
            body{
                min-height: 100vh;
                background-image: linear-gradient(transparent,black 99%), url(https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
                background-size: cover;
            }
          
            </style>
    </head>
    <body>
    <p>
        
         <div style="padding: 0px 200px 20px 200px ">
            <p style="text-align: center;font-family: 'Righteous', cursive;; font-size: xxx-large;color:yellow;font-weight: 900">Welcome to Breakfast at GangOfSix!</p>
	</div>
        <div style="text-align: center; border: 2px solid white; margin: 50px 400px; border-radius: 5%">
            <p style="margin: 30px 10px;font-family: 'Righteous', cursive;"><a href="completeOrderList" style="text-decoration: none; font-size: xx-large;color: yellow">Order List</a></p><br>
            <p style="margin: 30px 10px;font-family: 'Righteous', cursive;"><a href="updateOrder" style="text-decoration: none; font-size: xx-large;color: yellow">Update Order</a></p><br>
            <p style="margin: 30px 10px;font-family: 'Righteous', cursive;"><a href="inventory" style="text-decoration: none; font-size: xx-large;color: yellow">Check Inventory</a></p><br>
			<p style="margin: 30px 10px;font-family: 'Righteous', cursive;"><a href="employeeList" style="text-decoration: none; font-size: xx-large;color: yellow">Employee Registry</a></p><br>
			
			<button type="button" style="margin: 30px 10px;font-family: 'Righteous', cursive;">Logout</button><br>
			            
        </div>
    </p>
    </body>
</html>
