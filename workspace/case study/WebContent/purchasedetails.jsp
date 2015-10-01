<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Details</title>
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
<br>
<center>
<h1><font color="#B80000"><b>PURCHASE DETAILS</b></font></h1>

<table border=1>
<tr><th><font color="#B80000"><b>PURCHASE ID</b></font></th><th><font color="#B80000"><b>PURCHASE DATE</b></font></th><th><font color="#B80000"><b>ITEM ID</b></font></th><th><font color="#B80000"><b>QUANTITY</b></font></th><th><font color="#B80000"><b>VENDOR ID</b></font></th><th><font color="#B80000"><b>WAREHOUSE ID</b></font></th></tr>

<c:forEach items="${model4}" var="items">
<tr><td><font color="#B80000"><b><c:out value="${items.purchaseid}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.purchase_date}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.itemid}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.quantity}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.vendorid}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.warehouseid}"></c:out></b></font></td>
</tr>
</c:forEach>
</table>
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