<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/bg6.jpg">
<script>
function goBack()
{
window.history.back();
}
</script>
<h6><center><img src="mm2.png" height=50 width=680></center></h6>

<center>
 <table border=2>
<tr><td><font color="#B80000"><b>WAREHOUSE ID :</b></font></td><td><font color="#B80000"><b>${model3.warehouseID}</b></font></td></tr>
<tr><td><font color="#B80000"><b>WAREHOUSE NAME :</b></font></td><td><font color="#B80000"><b>${model3.warehouse_name}</b></font></td></tr>
<tr><td><font color="#B80000"><b>ADDRESS :</b></font></td><td><font color="#B80000"><b>${model3.address}</b></font></td></tr>
<tr><td><font color="#B80000"><b>CAPACITY:</b></font></td><td><font color="#B80000"><b>${model3.capacity}</b></font></td></tr>
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
<center>
<button type="button" onClick="goBack()">BACK</button>
</center>
</body>
</html>