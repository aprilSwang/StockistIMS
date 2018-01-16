<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">
		
<h3>Supplier List page</h3>

<a href="${pageContext.request.contextPath}/administrator/supplier/create">Add
	Supplier</a>
	<c:if test="${fn:length(supplierList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Email Address</th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<tr class="listRecord">
					<td>${supplier.supplierID}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.email}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/administrator/supplier/edit/${supplier.supplierID}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/administrator/supplier/delete/${supplier.supplierID}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
						</c:forEach>
					</tbody>
				</table>
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