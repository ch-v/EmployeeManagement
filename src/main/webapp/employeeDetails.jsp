<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function back() {
		location.href = "dashboard.jsp";
	}
</script>
</head>
<body>
	<form action="${controller}">
		<h3>
			Employee Code :<input type="text" name="empcode" value="${empid}">
		</h3>
		<h3>
			Employee Name :<input type="text" name="empname" maxlength="100">
		</h3>
		<h3>
			Location :<input type="text" name="location" maxlength="500">
		</h3>
		<h3>
			Email :<input type="email" name="email" maxlength="100">
		</h3>
		<h3>
			DOB :<input type="date" name="dob">
		</h3>
		<input type="submit" value="save"> <input type="button"
			value="cancel" onclick="back()">
	</form>

</body>
</html>