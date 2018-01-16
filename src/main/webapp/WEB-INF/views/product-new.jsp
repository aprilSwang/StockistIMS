<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">
			<h3>New Product page</h3>
			<a href="${pageContext.request.contextPath}/admin/product/list"><-
				Back to Product List</a>
			<form:form method="POST" modelAttribute="product"
				action="${pageContext.request.contextPath}/admin/products/create.html">
				<table>

					<tr>
						<td>Part Number</td>
						<td><form:input path="partNumber" /> <form:errors
								path="partNumber" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Unit Price</td>
						<td><form:input path="unitPrice" /> <form:errors
								path="unitPrice" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Quantity</td>
						<td><form:input path="quantity" /> <form:errors
								path="quantity" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Description</td>
						<td><form:input path="description" /> <form:errors
								path="description" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Color</td>
						<td><form:input path="color" /> <form:errors path="color"
								cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Dimension</td>
						<td><form:input path="dimension" /> <form:errors
								path="dimension" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Manufacturer</td>
						<td><form:input path="manufacturer" /> <form:errors
								path="manufacturer" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>ReorderLevel</td>
						<td><form:input path="reorderLevel" /> <form:errors
								path="reorderLevel" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Minimum Reorder Quantity</td>
						<td><form:input path="minReorderQnty" /> <form:errors
								path="minReorderQnty" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Supplier Name</td>
						<td><form:input path="supplierName" /> <form:errors
								path="supplierName" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td>Shelf Location</td>
						<td><form:input path="shelfLocation" /> <form:errors
								path="shelfLocation" cssStyle="color: red;" /></td>
						<td></td>
					</tr>

					<tr>
						<td><input type="submit" value="Create" /></td>
						<td></td>
						<td></td>
					</tr>

				</table>
			</form:form>
</c:when>
		<c:when test="${role.roleID eq 'mech' }">
			<spring:message code="errormesssage.Mechanic" />
		</c:when>
	</c:choose>
</c:forEach>
<c:if test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
	<p>
		Sorry, you cannot access this page. <a
			href="${pageContext.request.contextPath}/home/login">Please
			Login.</a>
	</p>
</c:if>

			