
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">
			<h3>Administrator List page</h3>

			<a
				href="${pageContext.request.contextPath}/admin/administrator/reorder">Add
				Administrator</a>
			<c:if test="${fn:length(administratorList) gt 0}">
				<table style="cellspacing: 2; cellpadding: 2; border: 1;">
					<thead>
						<tr class="listHeading">
							<th>Admin ID</th>
							<th>User ID</th>
							<th>Full Name</th>
							<th>Email</th>
							<th><spring:message code="caption.edit" /></th>
							<th><spring:message code="caption.delete" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="administrator" items="${administratorList}">
							<tr class="listRecord">
								<td>${administrator.adminID}</td>
								<td>${administrator.userID}</td>
								<td>${administrator.fullName}</td>
								<td>${administrator.email}</td>
								<td align="center"><a
									href="${pageContext.request.contextPath}/admin/administrator/edit/${administrator.adminID}.html"><spring:message
											code="caption.edit" /></a></td>
								<td><a
									href="${pageContext.request.contextPath}/admin/employee/delete/${administrator.adminID}.html"><spring:message
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