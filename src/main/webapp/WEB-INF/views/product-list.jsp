
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
	<p>
		Sorry, you cannot access this page. <a
			href="${pageContext.request.contextPath}/home/login">Please
			Login.</a>
	</p>
</c:if>

<h3>Product List page</h3>
<a href="${pageContext.request.contextPath}/products/create">Add
	Product</a>
<c:if test="${fn:length(productList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">

		<tr class="listHeading">
			<th align="center">partNumber</th>
			<th align="center">unitPrice</th>
			<th align="center">quantity</th>
			<th align="center">description</th>
			<th align="center">color</th>
			<th align="center">dimension</th>
			<th align="center">manufacturer</th>
			<th align="center">reorderLevel</th>
			<th align="center">minReorderQnty</th>
			<th align="center">supplierName</th>
			<th align="center">shelfLocation</th>	
			<th><spring:message code="caption.edit" /></th>
			<th><spring:message code="caption.delete" /></th>
			<th><spring:message code="caption.detail" /></th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr class="listRecord">
				<td align="center">${product.partNumber}</td>
				<td align="center">${product.unitPrice}</td>
			    <td align="center">${product.quantity}</td>
				<td align="center">${product.description}</td>
				<td align="center">${product.color}</td>
				<td align="center">${product.dimension}</td>
				<td align="center">${product.manufacturer}</td>
				<td align="center">${product.reorderLevel}</td>
				<td align="center">${product.minReorderQnty}</td>
				<td align="center">${product.supplierName}</td>
				<td align="center">${product.shelfLocation}</td>		
				<td align="center"><a 
					href="${pageContext.request.contextPath}/products/edit/${product.partNumber}.html"><spring:message
							code="caption.edit" /></a></td>
				<td><a
					href="${pageContext.request.contextPath}/products/delete/${product.partNumber}.html"><spring:message
							code="caption.delete" /></a></td>
			   <td><a
					href="${pageContext.request.contextPath}/products/detail/${product.partNumber}.html"><spring:message
							code="caption.detail" /></a></td>
			</tr>
		</c:forEach>

	</table>
</c:if>
