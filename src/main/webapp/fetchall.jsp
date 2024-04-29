<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="springmvc_crud_friday.dto.EmployeeDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetching all in table format</title>
<style>
th {
	text-align: center;
}

td {
	text-align: left;
}

table {
	border: 1px solid black;
}
</style>
</head>
<body>

	<%
	List<EmployeeDto> li = (List<EmployeeDto>) request.getAttribute("data");
	%>
	<table style="width: 10%" border=" ">
		<tr>
			<th style="width: 50%">Id</th>
			<th style="width: 100%">Name</th>
		</tr>

		<%
		for (EmployeeDto a : li) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getName()%></td>

		</tr>
		<%
		}
		%>

	</table>
</body>

</body>
</html>