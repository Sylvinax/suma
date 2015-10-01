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


function validateForm()
{
	
	var f=document.forms["purchase"]["qty"].value;
	if(f==null || f=="")
	{
		alert("Quantity must be filled");
		return false;
	}
	if(isNaN(f) || f<=0)
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
<h3><font color="#B80000">Enter new Purchase details<br>(New Purchase is possible only when total quantity of item is less than 5 bundles)</font></h3>
</center>
<br>
<form name="purchase" action="./MainServlet" onSubmit="return validateForm()" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>PURCHASE ID :</b></font></td>
	<td><input type="text" name="purchase_id" value="Auto Generated" disabled></td></tr>

<tr><td><font color="#B80000"><b>ITEM NAME :</b></font></td>
	<td><select name="items_dropdown"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model1}" var="items">
			<option value="<c:out value='${items.itemid}'></c:out>"> <c:out value="${items.item_name}"></c:out> </option>
			</c:forEach>
		</select></td>
</tr>
<tr><td><font color="#B80000"><b>VENDOR NAME :</b></font></td>
	<td><select name="vendor_dropdown"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model5}" var="items">
			<option value="<c:out value='${items.vendorID}'></c:out>"> <c:out value="${items.vendor_name}"></c:out> </option>
			</c:forEach>
	</select></td>
</tr>	
<tr><td><font color="#B80000"><b>WAREHOUSE :</b></font></td>
	<td><select name="warehouse_dropdown"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model6}" var="items">
			<option value="<c:out value='${items.warehouseID}'></c:out>"> <c:out value="${items.warehouse_name}"></c:out> </option>
			</c:forEach>
	</select></td>
</tr>
<tr><td><font color="#B80000"><b>QUANTITY :</b></font></td>
	<td><input type="text" name="qty" value="QTY">
	</td>
</tr>
</table>
<center> 
<input type="submit" name="command" value="PURCHASE" onClick="if(document.purchase.items_dropdown.selectedIndex == 0) {alert('select a valid Item Name'); return false } if(document.purchase.vendor_dropdown.selectedIndex == 0) {alert('select a valid Vendor'); return false} if(document.purchase.warehouse_dropdown.selectedIndex == 0) {alert('select a valid Warehouse'); return false }" >
<input type="reset" value="RESET">
<br>
${model3}
</center>
<br>
</form>
<center>
<br>
<form action="./MainServlet" method="get">
<b><font color="#B80000">  Click to view Purchase Details</font></b>
<br>
<br>
<input type="submit" name="command" value="DISPLAY PURCHASE DETAILS"><br><br>
${model4}
</form>
</center>
<br>
<br>
</body>
</html>