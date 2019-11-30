<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="com.nagarro.employeemanagement.entity.Employee"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		location.href = "login.jsp";
	}
	function toemployee() {
		location.href = "upload";
	}
</script>
<style type="text/css">
table, th, td {
	border: 1px solid black;
}

th {
	text-align: centre;
}
</style>
</head>
<body>
	<div>
		<h2>Welcome:${username}</h2>
		<input type="button" value="logout" onclick="logout()" align="right">
	</div>

	<input type="button" value="upload employee details"
		onclick="toemployee()">
	<input type="button" value="Download Employee Details"
		onclick="toPdf()">
	<br>
	<fieldset>
		<table style="width: 100%">
			<tr>
				<th>Employee Code</th>
				<th>Employee Name</th>
				<th>Location</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Action</th>
			</tr>

			<c:if test="${lists!=null }">
				<c:forEach var="list" begin="1" end="${lists.size()}">
					<c:set var="item" value="${lists.get(list - 1)}" />
					<tr>
						<td>${item.getEmpCode()}</td>
						<td>${item.getEmpName()}</td>
						<td>${item.getLocation()}</td>
						<td>${item.getEmail()}</td>
						<td>${item.getDob()}</td>
						<td><a href="employeeUpdate?empid=${item.getEmpCode()}"><input
								type="submit" value="Edit"></a></td>


					</tr>

				</c:forEach>
			</c:if>
		</table>

	</fieldset>

</body>
</html>