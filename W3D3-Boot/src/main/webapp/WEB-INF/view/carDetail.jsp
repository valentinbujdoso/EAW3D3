<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${msg} a Car</title>
</head>

<body>
	<c:if test="${msg == 'Update'}">
		<form:form modelAttribute="car" action="../cars/${car.id}" method="post">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>Make:</td>
					<td><form:input path="make" /> </td>
					<td><form:errors path="make" cssClass="error" /> </td>
						<%--			<td><input type="text" name="make" value="${car.make}" /> </td>--%>
				</tr>
				<tr>
					<td>Model:</td>
					<td><form:input path="model" /> </td>
					<td><form:errors path="model" cssClass="error" /> </td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="year" /> </td>
					<td><form:errors path="year" cssClass="error" /> </td>
				</tr>
				<tr>
					<td>Color:</td>
					<td><form:input path="color" /> </td>
					<td><form:errors path="color" cssClass="error" /> </td>
				</tr>
			</table>
			<input type="submit" value="${msg}"/>
		</form:form>
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form:form modelAttribute="car" action="../cars" method="post">
		<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>Make:</td>
					<td><form:input path="make" /> </td>
					<td><form:errors path="make" cssClass="error" /> </td>
						<%--			<td><input type="text" name="make" value="${car.make}" /> </td>--%>
				</tr>
				<tr>
					<td>Model:</td>
					<td><form:input path="model" /> </td>
					<td><form:errors path="model" cssClass="error" /> </td>
<%--					<td><input type="text" name="model" value="${car.model}" /> </td>--%>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="year" /> </td>
					<td><form:errors path="year" cssClass="error" /> </td>
<%--					<td><input type="text" name="year" value="${car.year}" /> </td>--%>
				</tr>
				<tr>
					<td>Color:</td>
					<td><form:input path="color" /> </td>
					<td><form:errors path="color" cssClass="error" /> </td>
<%--					<td><input type="text" name="color" value="${car.color}" /> </td>--%>
				</tr>
			</table>
<%--			<input type="submit"/>--%>
			<input type="submit" value="${msg}"/>
		</form:form>
	</c:if>
	<c:if test="${msg == 'Update'}">
		<form action="delete?carId=${car.id}" method="post">
			<button type="submit">Delete</button>
		</form>
	</c:if>
</body>

</html>