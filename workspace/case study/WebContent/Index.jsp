<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REDDY PHARMACEUTICAL COMPANY</title>

</head>
<center>
<font color="#B8000"><b>
${model5}
</b></font>
<br>
<h1><img src="images/logo1.png" align="middle"></h1>
</center>
<body>
<center>
<br>
<br>
<h3><font color="#B80000">Please login to proceed!</font></h3>
<br>
<form name="login" action="./MainServlet" method="post">
<table>
<tr><td><font color="#FFAD33"><b> USER ID : </b></font></td><td> <input type="text" name="userid"></td></tr>

<tr><td><font color="#FFAD33"><b>PASSWORD : </b></font></td><td> <input type="password" name="password"></td></tr>
</table>
<br>
<input type="submit" value="LOGIN" name="command">
<input type="reset" value="RESET">
</form>

</center>
</body>
</html>