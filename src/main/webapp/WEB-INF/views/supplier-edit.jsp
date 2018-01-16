<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Supplier Page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/administrator/supplier/edit/${supplier.supplierID}.html">
	<table>
		<tbody>
			<tr>
			    <td>Supplier Name</td>
				<td><form:input path="supplierName" readonly="true"/></td>
				<td></td>
				</tr>
					<tr>
				<td>Email Address</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red;" /></td>
				</tr>
				<tr>
				<td><input type="submit" value="create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>



		
	