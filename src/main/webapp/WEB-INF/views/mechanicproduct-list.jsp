
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
		<h3>Product List page</h3>
		<a href="${pageContext.request.contextPath}/admin/products/create">Add
			Product</a>
			<a href="${pageContext.request.contextPath}/mechanic/products/search">Search Product</a>
		<c:if test="${fn:length(productList) gt 0}">
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">

				<tr class="listHeading">
					<th>Part Number</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>Color</th>
					<th>Supplier Name</th>
					<th><spring:message code="caption.detail" /></th>
					<th><spring:message code="caption.view" /></th>
				</tr>
				<c:forEach var="product" items="${productList}">
					<tr class="listRecord">
						<td>${product.partNumber}</td>
						<td><fmt:formatNumber currencySymbol="$" type="currency"
								value="${product.unitPrice}" /></td>
						<td>${product.quantity}</td>
						<td>${product.description}</td>
						<td>${product.color}</td>
						<td>${product.supplierName}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/products/detail/${product.partNumber}.html"><spring:message
									code="caption.detail" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/products/usagerecord/${product.partNumber}.html"><spring:message
									code="caption.usage" /></a></td>
					</tr>
				</c:forEach>

			</table>
		</c:if>
	</c:otherwise>
</c:choose>