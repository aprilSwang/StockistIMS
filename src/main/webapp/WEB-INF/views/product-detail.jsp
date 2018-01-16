<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
		<p>
			Sorry, you cannot access this page. <a
				href="${pageContext.request.contextPath}/home/login">Please
				Login.</a>
		</p>
	</c:when>
	<c:otherwise>

		<h3>Product Detail Page</h3>

		<%-- <c:if test="${fn:length(productList) gt 0}"> --%>
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr>
				<td>Part Number</td>
				<td>${product.partNumber}</td>
			</tr>
			<tr>
				<td>Unit Price</td>
				<td><fmt:formatNumber currencySymbol="$" type="currency"
						value="${product.unitPrice}" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td>${product.quantity}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>Color</td>
				<td>${product.color}</td>
			</tr>
			<tr>
				<td>Dimension</td>
				<td>${product.dimension}</td>
			</tr>
			<tr>
				<td>Manufacturer</td>
				<td>${product.manufacturer}</td>
			</tr>
			<tr>
				<td>Reorder Level</td>
				<td>${product.reorderLevel}</td>
			</tr>
			<tr>
				<td>Min Reorder Quantity</td>
				<td>${product.minReorderQnty}</td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td>${product.supplierName}</td>
			</tr>
			<tr>
				<td>Shelf Location</td>
				<td>${product.shelfLocation}</td>
			</tr>
			

			<!-- <tr class="listHeading">
				<th>Part Number</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Description</th>
				<th>Color</th>
				<th>Dimension</th>
				<th>Manufacturer</th>
				<th>Reorder Level</th>
				<th>Min Reorder Quantity</th>
				<th>Supplier Name</th>
				<th>Shelf Location</th>
			</tr> -->

<%-- 			<tr class="listRecord">
				<td>${product.partNumber}</td>
				<td><fmt:formatNumber currencySymbol="$" type="currency"
						value="${product.unitPrice}" /></td>
				<td>${product.quantity}</td>
				<td>${product.description}</td>
				<td>${product.color}</td>
				<td>${product.dimension}</td>
				<td>${product.manufacturer}</td>
				<td>${product.reorderLevel}</td>
				<td>${product.minReorderQnty}</td>
				<td>${product.supplierName}</td>
				<td>${product.shelfLocation}</td>
			</tr> --%>
		</table>
		<%-- </c:if> --%>
	</c:otherwise>
</c:choose>