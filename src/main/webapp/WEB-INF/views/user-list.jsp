<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">
		
<h3>User List page</h3>

<a href="${pageContext.request.contextPath}/administrator/user/create">Add
	User</a>
	<c:if test="${fn:length(userList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th>User ID</th>
				<th>User Name</th>
				<th>Password</th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.userID}</td>
					<td>${user.name}</td>
					<td>${user.password}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/administrator/user/edit/${user.userID}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/administrator/user/delete/${user.userID}.html"><spring:message
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
