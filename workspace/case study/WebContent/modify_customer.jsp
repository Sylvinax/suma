<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inventory.dropDown, java.sql.ResultSet"%>
    
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
	var exp=/^[a-zA-Z]*$/;
	var b=document.forms["modify_customer"]["customer_name"].value;
	if(b==null || b=="" )
	{
		alert("Customer Name must be filled");
		return false;
	}
	if(b.match(exp))
	{
	
	var a=document.forms["modify_customer"]["address"].value;
	if(a==null || a=="")
	{
		alert("Address must be filled");
		return false;
	}
	
	var f=document.forms["modify_customer"]["phone_num"].value;
	if(f==null || f=="")
	{
		alert("Phone Number must be filled");
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
<h3><font color="#B80000">Select a Customer ID and click on READ CUSTOMER to display its details.
<br>You can then modify the details and click UPDATE CUSTOMER.</font></h3>
</center>
<br>
<form name="modify_customer" action="./MainServlet" method="get">
<table align="center">
<tr>
	<td><font color="#B80000"><b>CUSTOMER ID :</b></font></td>
	<td><select name="customerid"> 
			<option value="">--SELECT--</option>
				<c:forEach items="${model10}" var="items">
			<option value="<c:out value='${items.custID}'></c:out>"> <c:out value="${items.cust_name}"></c:out> </option>
			</c:forEach>
	</select></td>
			<tr>
				<td><font color="#B80000"><b>CUSTOMER NAME :</b></font></td>
				<td><input type="text" name="customer_name" value="${model2.cust_name}"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ADDRESS :</b></font></td>
				<td><input type="text" name="address" value="${model2.address}">
				</td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>PHONE NUM :</b></font></td>
				<td><input type="text" name="phone_num" value="${model2.phone_number}" maxlength="10"></td>
			</tr>

		</table>
		<br>
		<center>
			<input type="submit" name="command" value="UPDATE CUSTOMER" onClick="return validateForm()"> 
			<input type="submit" name="command" value="READ CUSTOMER" onClick="if(document.modify_customer.customerid.selectedIndex == 0) {alert('select a valid Customer ID'); return false}">
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