<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inventory.dropDown, java.sql.ResultSet"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADDING NEW ITEMS</title>
</head>
<body background="images/bg6.jpg">
<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<script type="text/javascript">


function goBack()
{
window.history.back();
}
</script>
<script type="text/javascript">
function validateForm()
{
	var exp=/^[a-zA-Z0-9- ]*$/;
	var a=document.forms["add_items"]["itemname"].value;
	var b=document.forms["add_items"]["itemprice"].value;
	var c=document.forms["add_items"]["quantiy"].value;
	
	if(a==null || a=="")
	{
		alert("Item name must be filled");
		return false;
	}
	if(a.match(exp))
	{
	
	if(b==null || b=="")
	{
		alert("Item price must be filled");
		return false;
	}
	if(isNaN(b) || b<=0)
	{
		alert("Price must be a number and must be greater than zero");
		return false;
	}
	
	if(c==null || c=="")
	{
		alert("Quantity must be filled");
		return false;
	}
	if(isNaN(c) || c<=0)
	{
		alert("Quantity must be a number and must be greater than zero");
		return false;
	}
	}
	else
	{
	alert("Item name cannot contain special characters");
	return false;
	}
	
}
</script>

<br>
<br>
<br>
<center>
<h3><font color="#B80000">Enter the details to add a new item.</font></h3>
</center>
<br>
<form name="add_items" action="./MainServlet" onSubmit="return validateForm();" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>ITEM ID:</b></font></td><td> <input type="text" name="itemid" value="Auto Generated" disabled></td></tr>
<tr><td><font color="#B80000"><b>ITEM NAME:</b></font></td><td> <input type="text" name="itemname"></td></tr>
<tr><td><font color="#B80000"><b>ITEM PRICE:</b></font></td><td> <input type="text" name="itemprice"></td></tr>
		
<tr><td><font color="#B80000"><b>VENDOR NAME :</b></font></td> 
	<td><select name="vendorsid" > 
			<option value="">--SELECT--</option>
			<c:forEach items="${model11}" var="items">
			<option value="<c:out value='${items.vendorID}'></c:out>"> <c:out value="${items.vendor_name}"></c:out> </option>
			</c:forEach>
		</select></td>
</tr>

<tr><td><font color="#B80000"><b>ITEM TYPE: </b></font></td><td><select name="itemtype" > 
			<option value="">--SELECT--</option>
			<c:forEach items="${model14}" var="items">
			<option value="<c:out value='${items.item_type}'></c:out>"> <c:out value="${items.item_type}"></c:out> </option>
			</c:forEach>
		</select></td></tr>
	
<tr><td><font color="#B80000"><b>WAREHOUSE NAME :</b></font></td><td><select name="warehouseid" > 
			<option value="">--SELECT--</option>
			<c:forEach items="${model13}" var="items">
			<option value="<c:out value='${items.warehouseID}'></c:out>"> <c:out value="${items.warehouse_name}"></c:out> </option>
			</c:forEach>
		</select></td></tr>	
		
<tr><td><font color="#B80000"><b>QUANTITY :</b></font></td><td> <input type="text" name="quantiy"></td></tr>

	</table>
<center>
<input type="submit" name="command" value="ADD ITEM" onClick="if(document.add_items.vendorsid.selectedIndex == 0) {alert('select a valid Vendor Name'); return false} if(document.add_items.itemtype.selectedIndex == 0) {alert('select a valid Item type'); return false} if(document.add_items.warehouseid.selectedIndex == 0) {alert('select a valid Warehouse Name'); return false}">
<input type="reset" value="RESET">
</center>
${model1}
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