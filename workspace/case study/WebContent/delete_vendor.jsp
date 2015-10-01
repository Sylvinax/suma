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
<h3><font color="#B80000">Select Vendor Name to be deleted.</font></h3>
</center>
<br>
<form name="delete_vendor" action="./MainServlet" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>VENDOR NAME:</b></font></td>
<td><select name="vendorid"> 
			<option value="">--SELECT--</option>
			<c:forEach items="${model10}" var="items">
			<option value="<c:out value='${items.vendorID}'></c:out>"> <c:out value="${items.vendor_name}"></c:out> </option>
			</c:forEach>
	</select></td>
</table>
<br>
<center>
<input type="submit" name="command" value="DELETE VENDOR" onClick="if(document.delete_vendor.vendorid.selectedIndex == 0) {alert('select a valid Vendor ID'); return false}">
<input type="reset" value="RESET">
</center>
</form>
<center>
${model2}
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