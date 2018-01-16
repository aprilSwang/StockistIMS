<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">
			<h3>Product Edit Page</h3>
			<form:form method="POST" modelAttribute="product"
				action="${pageContext.request.contextPath}/admin/products/edit/${product.partNumber}.html">
				<table>
					<tbody>
						<tr>
				<td>Part Number</td>
				<td>${product.partNumber}</td>
				<td></td>
			</tr>

			<tr>
				<td>Unit Price</td>
				<td><form:input path="unitPrice" />
<%-- 				<form:errors path="unitPrice" cssStyle="color: red;" /> --%>
				</td>
				<td></td>
			</tr>
			
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" />
				<%--  <form:errors path="quantity" cssStyle="color: red;" /> --%>
				 </td>
				<td></td>
			</tr>
					
			<tr>
				<td>Description</td>
				<td><form:input path="description" />
				</td>
				<td></td>
			</tr>
			
			<tr>
				<td>Color</td>
				<td><form:input path="color" /></td>
				<td></td>
			</tr>
					
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Manufacturer</td>
				<td><form:input path="manufacturer" /></td>
				<td></td>
			</tr>
			
			<tr>
				<td>Reorder Level</td>
				<td><form:input path="reorderLevel" />
				<%-- <form:errors path="partNumber" cssStyle="color: red;" /> --%>
				</td>
				<td></td>
			</tr>
					
			<tr>
				<td>Minimum Reorder Quantity</td>
				<td><form:input path="minReorderQnty" />
			<%-- 	<form:errors path="minReorderQnty" cssStyle="color: red;" /> --%>
				</td>
				<td></td>
			</tr>
			
			<tr>
				<td>Supplier Name</td>
				<td><form:input path="supplierName" />
				<form:errors path="minReorderQnty" cssStyle="color: red;" />
				</td>
				<td></td>
			</tr>
			
			<tr>
				<td>Shelf Location</td>
				<td><form:input path="shelfLocation" /></td>
				<td></td>
			</tr>		
					
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
					</tbody>
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