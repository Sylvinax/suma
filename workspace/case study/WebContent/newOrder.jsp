<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inventory.Items,java.util.Iterator,com.inventory.Items, com.inventory.dropDown, java.sql.ResultSet, java.util.ArrayList"%>
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NEW ORDER</title>
</head>
<body background="images/bg6.jpg">
<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<script type="text/javascript">


function validateForm()
{
	var regExp = /^[+].*$/;
	var f=document.forms["order"]["qty"].value;
	if(f==null || f=="")
	{
		alert("Quantity must be filled");
		return false;
	}
	if(isNaN(f) || f<=0 || f.match(regExp))
	{
		alert("Quantity must be a number and must be greater than zero");
		return false;
	}
}
</script> 
<br> 
<br>
<br>
<center>
<h3><font color="#B80000">Enter new Order details</font></h3>
</center>
<br>
<form name="order" action="./MainServlet" onSubmit="return validateForm()" method="get"> 
<table align="center">
<tr><td><font color="#B80000"><b>ORDER ID : </b></font></td>
	<td><input type="text" name="order_id" value="Auto Generated" disabled></td></tr>

<tr><td><font color="#B80000"><b>ITEM NAME :</b></font></td>
	<td><select name="items_dropdown"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model1}" var="items">
			<option value="<c:out value='${items.itemid}'></c:out>"> <c:out value="${items.item_name}"></c:out> </option>
			</c:forEach>				
		</select></td>
</tr>
			 
<tr><td><font color="#B80000"><b>CUSTOMER NAME :</b></font></td>
	<td><select name="cust_dropdown"> 
			<option value="">--SELECT--</option>	
			<c:forEach items="${model5}" var="items">
			<option value="<c:out value='${items.custID}'></c:out>"> <c:out value="${items.cust_name}"></c:out> </option>
			</c:forEach>
	</select></td>
</tr>
<tr><td><font color="#B80000"><b>WAREHOUSE NAME: </b></font></td>
	<td><select name="warehouse_dropdown"> 
			<option value="">--SELECT--</option>	
			<c:forEach items="${model4}" var="items">
			<option value="<c:out value='${items.warehouseID}'></c:out>"> <c:out value="${items.warehouse_name}"></c:out> </option>
			</c:forEach>
	</select></td>
</tr> 
<tr><td><font color="#B80000"><b>QUANTITY : </b></font></td>
	<td><input type="text" name="qty"></td></tr>
</table>
<br>
<center>
<input type="submit" value="ENTER" name="command" onClick="if(document.order.items_dropdown.selectedIndex == 0) {alert('select a valid Item Name'); return false } if(document.order.cust_dropdown.selectedIndex == 0) {alert('select a valid Customer'); return false } if(document.order.warehouse_dropdown.selectedIndex == 0) {alert('select a valid Warehouse'); return false}">
<input type="reset" value="RESET">
<br>
${model2}
</center>
<br>
<br>
<br>
</form> 
<center>
<br>
<form action="./MainServlet" method="get">
<b><font color="#B80000">  Click to view Order Details</font></b>
<br>
<br>
<input type="submit" name="command" value="DISPLAY ORDER DETAILS"><br><br>
${model3}
</form>
</center>
<br>
<br>
</body>
</html>