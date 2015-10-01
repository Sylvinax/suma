<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inventory.dropDown, java.sql.ResultSet"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW ITEMS</title>
</head>
<body background="images/bg6.jpg">
<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<script>
function goBack()
{
window.history.back();
}
</script>

<br>
<br>
<center>
<h3><font color="#B80000">Click the appropriate option to view details.</font></h3>
</center>
<br>
<center>

<form name="view_items" action="./MainServlet" method="get">
<table>
<tr><td></td><td><input type="submit" name="command" value="DISPLAY ITEM DETAILS"></td></tr>
<tr><td></td><td><input type="submit" name="command" value="SORT ITEM BY ITEM NAME"/></td></tr> 
</table>
</form>
<br>
<br>
<table>
<form name="view_items1" action="./MainServlet" method="get">

<tr><td><font color="#B80000"><b>VENDOR ID:</b></font></td><td><select name="vendorsid">
			<option value="">--SELECT--</option>
				<c:forEach items="${model11}" var="items">
			<option value="<c:out value='${items.vendorID}'></c:out>"> <c:out value="${items.vendor_name}"></c:out> </option>
			</c:forEach>
		</select></td>

<td><input type="submit" name="command" value="SEARCH BY VENDOR" onClick="if(document.view_items1.vendorsid.selectedIndex == 0) {alert('Select a Vendor ID'); return false }"></td></tr>
</form>
<form name="view_items2" action="./MainServlet" method="get">
<tr><td><font color="#B80000"><b>WAREHOUSE ID:</b></font></td><td><select name="warehouseid"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model13}" var="items">
			<option value="<c:out value='${items.warehouseID}'></c:out>"> <c:out value="${items.warehouse_name}"></c:out> </option>
			</c:forEach>
		</select></td>
<td><input type="submit" name="command" value="SEARCH BY WAREHOUSE" onClick="if(document.view_items2.warehouseid.selectedIndex == 0) {alert('Select a Warehouse ID'); return false }"></td></tr>
</form>
<form name="view_items3" action="./MainServlet" method="get">
<tr><td><font color="#B80000"><b>ITEMS TYPE:</b></font></td><td><select name="item_type"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model14}" var="items">
			<option value="<c:out value='${items.item_type}'></c:out>"> <c:out value="${items.item_type}"></c:out> </option>
			</c:forEach>
		</select></td>
<td><input type="submit" name="command" value="FILTER" onClick="if(document.view_items3.item_type.selectedIndex == 0) {alert('Select an Item Type'); return false } "></td></tr>
</form>
</table>
${model3}
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
<br>
<br>
<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
<br>
<br>
</body>
</html>