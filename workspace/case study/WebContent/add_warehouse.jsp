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
	var exp=/^[a-zA-Z0-9- ]*$/;
	var b=document.forms["add_warehouse"]["warehouse_name"].value;
	if(b==null || b=="" )
	{
		alert("Warehouse name must be filled");
		return false;
	}
	if(b.match(exp))
	{
	var f=document.forms["add_warehouse"]["address"].value;
	if(f==null || f=="")
	{
		alert("Address must be filled");
		return false;
	}
	
	var c=document.forms["add_warehouse"]["capacity"].value;
	if(c==null || c=="")
	{
		alert("Capacity must be filled");
		return false;
	}
	if(isNaN(c) || c<=0)
	{
		alert("Capacity must be a number and must be greater than zero");
		return false;	
	}
		}
	else
	{
	alert("Warehouse name cannot contain special characters");
	return false;
	}
	
}
</script>
<br>
<br>
<br>
<center>
<h3><font color="#B80000">Enter the details to add a new warehouse.</font></h3>
</center>
<br>
<form name="add_warehouse" action="./MainServlet" onSubmit="return validateForm()" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>WAREHOUSE ID : </b></font></td>
	<td><input type="text" name="warehouseid" value="Auto Generated" disabled></td></tr>
<tr><td><font color="#B80000"><b>WAREHOUSE NAME : </b></font></td>
	<td><input type="text" name="warehouse_name" maxlength="20"></td></tr>
<tr><td><font color="#B80000"><b>ADDRESS : </b></font></td>
	<td><input type="text" name="address" maxlength="50"></td></tr>
<tr><td><font color="#B80000"><b>CAPACITY : </b></font></td>
	<td><input type="text" name="capacity" maxlength="5"></td><td>(in BUNDLES)</td></tr>
</table>
<center>
<input type="submit" value="ADD WAREHOUSE" name="command">
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