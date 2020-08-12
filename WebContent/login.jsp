<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/userlogin.css">
<title>Globetortin.com</title>
</head>

<body>
	<nav> <header>
	<h1>Globetortin.com</h1>
	</header> </nav>

	<div class="loginbox">
		<img src="<%=request.getContextPath()%>/mkk5.jpg" class="avatar">
		<h1>login here</h1>
		<form method="post" action="<%=request.getContextPath()%>/auth">
			<p>email</p>
			<input type="email" id="email" name="email" placeholder="email "
				required>
			<p>Password</p>
			<input type="password" id="password" name="password"
				placeholder="password" required> <input type="submit"
				id="submit" name="submit" value="Login"> <a
				href="forgotPassword">forgotPassword ?</a>

		</form>

	</div>
</body>
</html>