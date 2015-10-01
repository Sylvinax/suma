<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Details</title>
</head>
<body background="images/bg6.jpg">
<script type="text/javascript">

function goBack()
{
window.history.back();
}
</script>

<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<center>
<h1><font color="#B80000"><b>VENDOR DETAILS</b></font></h1>

<table border=1>
<tr><th><font color="#B80000"><b>VENDOR ID</b></font></th><th><font color="#B80000"><b>VENDOR NAME</b></font></th><th><font color="#B80000"><b>VENDOR ADDRESS</b></font></th><th><font color="#B80000"><b>PHONE NUMBER</b></font></th><th><font color="#B80000"><b>ITEMS DISTRIBUTED</b></font></th></tr>

<c:forEach items="${model3}" var="items">
<tr><td><font color="#B80000"><b><c:out value="${items.vendorID}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.vendor_name}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.address}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.phone_num}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.items_distributed}"></c:out></b></font></td>

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
<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
</body>
</html>