<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Login</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com">
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
        <div style="padding: 0px 200px 20px 200px ">
            <p style="text-align: center;font-family: 'Righteous', cursive;; font-size: xxx-large;color:yellow;font-weight: 900">Customer Login</p>
</div>
        <div style="text-align: center; border: 2px solid black; margin: 10px 400px; border-radius: 5%">
       <form:form modelAttribute="customer" method="POST">
        <p style="margin: 20px 10px; font-family: 'Righteous', cursive;color:yellow">User-name:<form:input type="text" path="username" required="true"/></p><br>
        <p style="margin: 20px 10px; font-family: 'Righteous', cursive;color:yellow">Password:<form:input type="password" path="password" required="true"/></p><br>
        <p style="margin: 20px 10px; font-family: 'Righteous', cursive;color:yellow"><input type="submit" value="Signin"></p>
        </form:form>
        </div>
        
    </body>
</html>