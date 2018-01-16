<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:url value="/css/simple.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

<%-- <link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" /> --%>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>

<c:choose>
	<c:when test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
		<p>
			Sorry, you cannot access this page. <a
				href="${pageContext.request.contextPath}/home/login">Please
				Login.</a>
		</p>
	</c:when>
	<c:otherwise>
		<h3>New Transaction page</h3>
		<a href="${pageContext.request.contextPath}/admin/transaction/list"><-
			Back to Usage Records</a>
		<form:form method="POST" modelAttribute="transaction"
			action="${pageContext.request.contextPath}/admin/transaction/create.html">
			<table>
				<tbody>
					<tr>
						<td>Transaction ID</td>
						<td>${tid}</td>
						<td></td>
					</tr>
					<tr>
						<td>User ID</td>
						<td><form:input path="userID"
								value="${sessionScope.USERSESSION.user.userID}" readonly="true"
								cssStyle="border-color:black;color:white;background-color:black" /></td>
						<td></td>
					</tr>
					<tr>
						<td>Quantity</td>
						<td><form:input path="quantity" name="qty" /> <form:errors
								path="quantity" cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td>Part Number</td>
						<td><form:select name="pnum" path="partNumber"
								items="${pnumlist}" /></td>
						<td></td>
					</tr>
					<tr>
						<td>Customer Name</td>
						<td><form:select path="customerName" items="${cnamelist}" /></td>
						<td></td>
					</tr>
					<tr>
						<td>Transaction Date</td>
						<%-- <td><form:input path="transactionDate"/></td> --%>
						<td><form:input size="16" path="transactionDate"
								id="datepicker2" /> <form:errors path="transactionDate"
								cssStyle="color: red;" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Create" /></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</c:otherwise>
</c:choose>

