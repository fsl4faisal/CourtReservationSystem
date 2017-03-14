<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Player Form</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<form:form method="post" commandName="reservation">
		<table>
			<tr>
				<td>Player Name</td>
				<td><form:input path="player.name" /></td>
				<td><form:errors path="player.name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Player Phone</td>
				<td><form:input path="player.phone" /></td>
				<td><form:errors path="player.phone" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Sport Type</td>
				<td><form:select items="${sportTypes}" path="sportType" itemLabel="name" itemValue="id"/></td>
				<td><form:errors path="sportType" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="hidden" value="2" name="_page" />
					<input type="submit" value="Previous" name="_target1" /> 
					<input type="submit" value="Finish" name="_finish" /> 
					<input type="submit" value="Cancel" name="_cancel" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>