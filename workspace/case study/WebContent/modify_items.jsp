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


function validateForm()
{
	var exp=/^[a-zA-Z0-9- ]*$/;
	var a=document.forms["modify_items"]["itemname"].value;
	if(a==null || a=="")
	{
		alert("Item name must be filled");
		return false;
	}
	if(a.match(exp))
	{
	
	var b=document.forms["modify_items"]["itemprice"].value;
	if(b==null || b=="" )
	{
		alert("Item price must be filled");
		return false;
	}
	
	var f=document.forms["modify_items"]["itemtype"].value;
	if(f==null || f=="")
	{
		alert("Item type must be filled");
		return false;
	}
	
	var d=document.forms["modify_items"]["vendorid"].value;
	if(d==null || d=="")
	{
		alert("Vendor ID must be filled");
		return false;
	}
	}
	else
	{
	alert("Item name cannot contain special characters");
	return false;
	}
}


function goBack()
{
window.history.back();
}

</script>

<br>
<br>
<br>
<center>
<h3><font color="#B80000">Select an Item ID and click on READ ITEM to display its details.
<br>You can then modify the details and click UPDATE ITEM.</font></h3>
</center>
<br>
	<form name="modify_items" action="./MainServlet" method="get">
		<table align="center">
			<tr>
				<td><font color="#B80000"><b>ITEM ID:</b></font></td>
				<td><select name="itemid"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model10}" var="items">
			<option value="<c:out value='${items.itemid}'></c:out>"> <c:out value="${items.item_name}"></c:out> </option>
			</c:forEach>
	</select></td>
			<tr>
				<td><font color="#B80000"><b>ITEM NAME:</b></font></td>
				<td><input type="text" name="itemname" value="${model2.item_name}"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ITEM PRICE:</b></font></td>
				<td><input type="text" name="itemprice" value="${model2.price}">
				</td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>ITEM TYPE:</b></font></td>
				<td><input type="text" name="itemtype" value="${model2.item_type}"></td>
			</tr>
			<tr>
				<td><font color="#B80000"><b>VENDOR ID:</b></font></td>
				<td><input type="text" name="vendorid" value="${model2.vendor_id}"></td>
</tr>

		</table>
		<br>
		<center>
			<input type="submit" name="command" value="UPDATE ITEM" onclick="return validateForm()"> 
			<input type="submit" name="command" value="READ ITEM" onClick="if(document.modify_items.itemid.selectedIndex == 0) {alert('select a valid Item ID'); return false}">
		<br>
		<br>
		${model1}
		</center>
</form>
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