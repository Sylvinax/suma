<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet, com.inventory.dropDown"%>
    
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
	var b=document.forms["modify_vendor"]["vendor_name"].value;
	if(b==null || b=="" )
	{
		alert("Vendor Name must be filled");
		return false;
	}
	if(b.match(exp))
	{
	var a=document.forms["modify_vendor"]["address"].value;
	if(a==null || a=="")
	{
		alert("Address must be filled");
		return false;
	}
	
	var f=document.forms["modify_vendor"]["phone_num"].value;
	if(f==null || f=="")
	{
		alert("Phone Number must be filled");
		return false;
	}
	if(isNaN(f))
	{
		alert("Enter a valid phone number");
		return false;
	}
	
	var d=document.forms["modify_vendor"]["items_distributed"].value;
	if(d==null || d=="")
	{
		alert("Items Distributed must be filled");
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
<h3><font color="#B80000">Select a Vendor ID and click on READ VENDOR to display its details.
<br>You can then modify the details and click UPDATE VENDOR.</font></h3>
</center>
<br>
<form name="modify_vendor" action="./MainServlet" method="get">
<table align="center">
<tr>
	<td><font color="#B80000"><b>VENDOR ID :</b></font></td>
	<td><select name="vendorid"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model10}" var="items">
			<option value="<c:out value='${items.vendorID}'></c:out>"> <c:out value="${items.vendor_name}"></c:out> </option>
			</c:forEach>
	</select></td>
			<tr>
				<td><font color="#B80000"><b>VENDOR NAME :</b></font></td>
				<td><input type="text" name="vendor_name" value="${model2.vendor_name}"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ADDRESS :</b></font></td>
				<td><input type="text" name="address" value="${model2.address}">
				</td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>PHONE NUMBER :</b></font></td>
				<td><input type="text" name="phone_num" value="${model2.phone_num}" maxlength="10"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ITEMS DISTRIBUTED :</b></font></td>
				<td><input type="text" name="items_distributed" value="${model2.items_distributed}"></td>
</tr>

		</table>
		<br>
		<center>
			<input type="submit" name="command" value="UPDATE VENDOR" onClick="return validateForm()" > 
			<input type="submit" name="command" value="READ VENDOR" onClick="if(document.modify_vendor.vendorid.selectedIndex == 0) {alert('select a valid Vendor ID'); return false}">
		<br>
		<br>
		</center>
</form>
		<center>
		${model1}
		</center>
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