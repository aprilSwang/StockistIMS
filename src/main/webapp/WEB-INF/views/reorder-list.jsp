
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">

			<h3>Reorder List page</h3>


			<c:if test="${fn:length(reorderList) gt 0}">
				<c:forEach items="${reorderList}" var="arrayList">
					<table style="cellspacing: 2; cellpadding: 2; border: 1;">
						<thead>
							<tr class="listHeading">
								<th align="center">Part No</th>
								<th align="center">Supplier Name</th>
								<th align="center">Unit Price</th>
								<th align="center">Qty</th>
								<th align="center">Reorder Qty</th>
								<th align="center">Min Ord Qty</th>
								<th align="center">Ord Qty</th>
								<th align="center">Price</th>
							</tr>
						</thead>
						<c:set var="total" scope="session" value="0" />
						<tbody>
							<c:forEach items="${arrayList}" var="product">
								<tr class="listRecord">
									<td align="center">${product.partNumber}</td>
									<td align="right">${product.supplierName}</td>
									<td align="center">$${product.unitPrice}.00</td>
									<td align="center">${product.quantity}</td>
									<td align="center">${product.reorderLevel}</td>
									<td align="center">${product.minReorderQnty}</td>
									<c:choose>
										<c:when
											test="${product.reorderLevel-$product.quantity gt product.minReorderQnty}">
											<td>${product.reorderLevel-$product.quantity}</td>
										</c:when>
										<c:otherwise>
											<td>${product.minReorderQnty}</td>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when
											test="${product.reorderLevel-$product.quantity gt product.minReorderQnty}">
											<td align="right">$${product.reorderLevel-$product.quantity*product.unitPrice}.00</td>
											<c:set var="total" scope="session"
												value="${product.reorderLevel-$product.quantity*product.unitPrice+total}" />
										</c:when>
										<c:otherwise>
											<td align="right">$${product.minReorderQnty*product.unitPrice}.00</td>
											<c:set var="total" scope="session"
												value="${product.minReorderQnty*product.unitPrice+total }"></c:set>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>TOTAL</td>
								<td><c:out value="$${total}.00" /></td>
							</tr>
						</tbody>
					</table>
				</c:forEach>
			</c:if>
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