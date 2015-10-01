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
	var b=document.forms["modify_warehouse"]["warehouse_name"].value;
	if(b==null || b=="" )
	{
		alert("Warehouse Name must be filled");
		return false;
	}
	if(b.match(exp))
	{
	var a=document.forms["modify_warehouse"]["address"].value;
	if(a==null || a=="")
	{
		alert("Address must be filled");
		return false;
	}
	
	var f=document.forms["modify_warehouse"]["capacity"].value;
	if(f==null || f=="")
	{
		alert("Capacity must be filled");
		return false;
	}
	if(isNaN(f) || f<=0)
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
<h3><font color="#B80000">Select a Warehouse ID and click on READ WAREHOUSE to display its details.
<br>You can then modify the details and click UPDATE WAREHOUSE.</font></h3>
</center>
<br>
<form name="modify_warehouse" action="./MainServlet" method="get">
<table align="center">
<tr>
	<td><font color="#B80000"><b>WAREHOUSE ID :</b></font></td>
	<td><select name="warehouseid"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model10}" var="items">
			<option value="<c:out value='${items.warehouseID}'></c:out>"> <c:out value="${items.warehouse_name}"></c:out> </option>
			</c:forEach>
	</select></td>
			<tr>
				<td><font color="#B80000"><b>WAREHOUSE NAME :</b></font></td>
				<td><input type="text" name="warehouse_name" value="${model2.warehouse_name}"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ADDRESS :</b></font></td>
				<td><input type="text" name="address" value="${model2.address}">
				</td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>CAPACITY :</b></font></td>
				<td><input type="text" name="capacity" value="${model2.capacity}"></td>
</tr>

		</table>
		<br>
		<center>
			<input type="submit" name="command" value="UPDATE WAREHOUSE" onClick="return validateForm()"> 
			<input type="submit" name="command" value="READ WAREHOUSE" onClick="if(document.modify_warehouse.warehouseid.selectedIndex == 0) {alert('select a valid Warehouse ID'); return false}">
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
<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
<br>
<br>
</body>
</html>