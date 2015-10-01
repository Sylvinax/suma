<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	var exp=/^[a-zA-Z0-9- ]*$/;
	var a=document.forms["add_vendor"]["vendor_name"].value;
	if(a==null || a=="")
	{
		alert("Vendor name must be filled");
		return false;
	}
	if(a.match(exp))
	{
	var b=document.forms["add_vendor"]["vendor_addr"].value;
	if(b==null || b=="" )
	{
		alert("Address must be filled");
		return false;
	}
	
	var f=document.forms["add_vendor"]["vendor_phone"].value;
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
	
	var c=document.forms["add_vendor"]["item_dist"].value;
	if(c==null || c=="")
	{
		alert("Items distributed must be filled");
		return false;
	}
	}
	else
	{
	alert("Vendor name cannot contain special characters");
	return false;
	}
	
}
</script>
<br>
<br>
<br>
<center>
<h3><font color="#B80000">Enter the details to add a new vendor.</font></h3>
</center>
<br>
<form name="add_vendor" action="./MainServlet" onSubmit="return validateForm()" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>VENDOR ID : </b></font></td>
	<td><input type="text" name="vendor_id" value="Auto Generated" disabled></td></tr>
<tr><td><font color="#B80000"><b>VENDOR NAME : </b></font></td>
	<td><input type="text" name="vendor_name" maxlength="20"></td></tr>
<tr><td><font color="#B80000"><b>ADDRESS : </b></font></td>
	<td><input type="text" name="vendor_addr" maxlength="50"></td></tr>
<tr><td><font color="#B80000"><b>CONTACT NUMBER : </b></font></td>
	<td><input type="text" name="vendor_phone" maxlength="10"></td></tr>
<tr><td><font color="#B80000"><b>ITEMS DISTRIBUTED : </b></font></td>
	<td><input type="text" name="item_dist" maxlength="100"></td></tr>
</table>
<center>
<input type="submit" value="ADD VENDOR" name="command">
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
<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
<br>
<br>
</body>
</html>