<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<br>
<br>
<br>
<table border=1>
<tr><th><font color="#B80000"><b>ITEM ID</b></font></th><th><font color="#B80000"><b>ITEM NAME</b></font></th><th><font color="#B80000"><b>ITEM PRICE</b></font></th><th><font color="#B80000"><b>ITEM TYPE</b></font></th><th><font color="#B80000"><b>VENDOR ID</b></font></th><th><font color="#B80000"><b>QUANTITY</b></font></th></tr>

<c:forEach items="${model3}" var="items">
<tr><td><font color="#B80000"><b><c:out value="${items.itemid}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.item_name}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.price}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.item_type}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.vendor_id}"></c:out></b></font></td>
<td><font color="#B80000"><b><c:out value="${items.quantity}"></c:out></b></font></td>

</tr>
</c:forEach>
</table>
</center>

 <%-- <table border=2>
<tr><td><font color="#B80000"><b>ITEM ID:</b></font></td><td><font color="#B80000"><b>${model3.itemid}</b></font></td></tr>
<tr><td><font color="#B80000"><b>ITEM NAME:</b></font></td><td><font color="#B80000"><b>${model3.item_name}</b></font></td></b></font></tr>
<tr><td><font color="#B80000"><b>ITEM PRICE:</b></font></td><td><font color="#B80000"><b>${model3.price}</b></font></td></tr>
<tr><td><font color="#B80000"><b>ITEM TYPE:</b></font></td><td><font color="#B80000"><b>${model3.item_type}</b></font></td></tr>
<tr><td><font color="#B80000"><b>VENDOR ID:</b></font></td><td><font color="#B80000"><b>${model3.vendor_id}</b></font></td></tr>
<tr><td><font color="#B80000"><b>QUANTITY:</b></font></td><td><font color="#B80000"><b>${model3.quantity}</b></font></td></tr>

</table>
</center>
--%>
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