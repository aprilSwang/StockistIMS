<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
	<c:choose>
		<c:when test="${role.roleID eq 'admin' }">

			<h3>Edit User Page</h3>
			<form:form method="POST" modelAttribute="user"
				action="${pageContext.request.contextPath}/administrator/user/edit/${user.userID}.html">
				<table>
					<tbody>
						<tr>
							<td>User Name</td>
							<td><form:input path="name" readonly="true" /></td>
							<td></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><form:input path="password" /></td>
							<td><form:errors path="password" cssStyle="color: red;" /></td>
						</tr>
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



