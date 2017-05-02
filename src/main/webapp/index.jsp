<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<form method="post" action="/waa/calculate">
		<input type="text" name="add_var1" required value="${add1}"> + <input type="text" name="add_var2" required value="${add2}"> = <input type="text" name="add_result" value="${addResult}"><br>
		<input type="text" name="mul_var1" required value="${mul1}"> + <input type="text" name="mul_var2" required value="${mul2}"> = <input type="text" name="mul_result" value="${mulResult}"><br>
		<input type="submit">
	</form>
</body>
</html>