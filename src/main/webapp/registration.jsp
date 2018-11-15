<%@page isELIgnored="false"%>
<html>
<head>
<title>Spring MVC user registration and login example using
	JDBCTemplate + Oracle</title>
</head>
<body>
	<h1 style="color: CAC2C1; text-align: center"></h1>
	<form action="register" method="POST">
		<pre>
	<Strong>Register Here | <a href="login.jsp">Click here to login</a></Strong>
	User Id: <input type="text" name="userId" />
	Password: <input type="password" name="password" />
	<input type="submit" value="Register" />
	</pre>
	</form>
	${msg}
</body>
</html>