<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/bg6.jpg">
<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<script type="text/javascript">

function goBack()
{
window.history.back();
}

function validateForm()
{
	var exp=/^[a-zA-Z]*$/;
	var a=document.forms["add_customer"]["customer_name"].value;
	if(a==null || a=="")
	{
		alert("Customer name must be filled");
		return false;
	}
	
	if(a.match(exp))
	{
	
	var b=document.forms["add_customer"]["customer_addr"].value;
	if(b==null || b=="" )
	{
		alert("Address must be filled");
		return false;
	}
	
	var f=document.forms["add_customer"]["customer_phone"].value;
	if(f==null || f=="")
	{
		alert("Contact number must be filled");
		return false;
	}
	if(isNaN(f) || f==0)
	{
		alert("Enter a valid phone number");
		return false;
	}
	}
	else
	{
	alert("Customer name can contain only characters");
	return false;
	}
}
</script>
<br>
<br>
<br>
<center>
<h3><font color="#B80000">Enter the details to add a new customer.</font></h3>
</center>
<br>
<form name="add_customer" action="./MainServlet" onSubmit="return validateForm()" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>CUSTOMER ID : </b></font></td>
	<td><input type="text" name="customer_id" value="Auto Generated" disabled></td></tr>
<tr><td><font color="#B80000"><b>CUSTOMER NAME : </b></font></td>
	<td><input type="text" name="customer_name" maxlength="20"></td></tr>
<tr><td><font color="#B80000"><b>ADDRESS : </b></font></td>
	<td><input type="text" name="customer_addr" maxlength="50"></td></tr>
<tr><td><font color="#B80000"><b>CONTACT NUMBER : </b></font></td>
	<td><input type="text" name="customer_phone" maxlength="10"></td></tr>
</table>
<center>
<input type="submit" value="ADD CUSTOMER" name="command">
<input type="reset" value="RESET">
</center>
</form>
${model1}
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
<br>
<br>
</body>
</html>