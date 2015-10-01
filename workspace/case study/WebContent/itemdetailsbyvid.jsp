<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Details for a particular Vendor ID</title>
</head>
<body background="images/bg6.jpg">
<script type="text/javascript">


function goBack()
{
window.history.back();
}
</script>
<br>
<br>
<br>
<center><font color="#B80000"><b><h2>DETAILS OF ITEMS PURCHASED FROM VENDOR</h2></b></font></center>
<br>
<br>
<center>
<table border=1>
<tr><th align="center"><font color="#B80000"><b>ITEM ID</b></font></th><th align="center"><font color="#B80000"><b>ITEM NAME</b></font></th><th align="center"><font color="#B80000"><b>PRICE</b></font></th><th align="center"><font color="#B80000"><b>ITEM TYPE</b></font></th><th align="center"><font color="#B80000"><b>VENDOR ID</b></font></th><th align="center"><font color="#B80000"><b>VENDOR NAME</b></font></th></tr>

<c:forEach items="${model3}" var="items">
<tr><td><font color="#B80000"><b><c:out value="${items.itemid}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.item_name}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.price}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.item_type}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.vendor_id}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.vendor_name}"></c:out></b></font></td>
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