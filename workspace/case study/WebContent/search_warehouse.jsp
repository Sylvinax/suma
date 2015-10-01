<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/bg6.jpg">
<h6><center><img src="mm2.png" height=50 width=680></center></h6>
<script type="text/javascript">


function goBack()
{
window.history.back();
}

function validateForm()
{
	var b=document.forms["search_warehouse"]["warehouse_name"].value;
	if(b==null || b=="" )
	{
		alert("Warehouse Name must be filled");
		return false;
	}
}
</script>
<br>
<br>
<br>
<center>
<h3><font color="#B80000">Enter the Warehouse name to be searched.</font></h3>
</center>
<br>
<form name="search_warehouse" action="./MainServlet" onSubmit="return validateForm()" method="get">
<table align="center">
<tr><td><font color="#B80000"><b>WAREHOUSE NAME:</b></font></td><td> <input type="text" name="warehouse_name" ></td></tr>
</table>
<center>
<input type="submit" name="command" value="SEARCH WAREHOUSE" >
<input type="reset" value="RESET">

</center>
<br>
<br>
</form>
${model3}
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