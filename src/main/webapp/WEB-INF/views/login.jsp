<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<spring:url value="/css/simple.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />
<c:choose>
	<c:when
		test="${sessionScope.USERSESSION.user.roleSet.size() gt 0}">
		<spring:message code="error.loggedin" />
	</c:when>
	<c:otherwise>
		<form:form modelAttribute="user" method="POST"
			action="${pageContext.request.contextPath}/home/authenticate">
			<table class="framed">
				<tr>
					<td><spring:message code="fieldLabel.username" /></td>
					<td colspan="3"><form:input path="name" size="40" />
						<form:errors path="name" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td><spring:message code="fieldLabel.password" /></td>
					<td colspan="3"><form:password path="password" size="40" />
						<form:errors path="password" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><form:button name="submit" type="submit" value="s">
							<img
								src="${pageContext.request.contextPath}/image/button_login.gif"
								alt="" align="middle">
						</form:button></td>
					<td><form:button name="clear" type="reset" value="r">
							<img
								src="${pageContext.request.contextPath}/image/button_clear.gif"
								alt="" align="middle">
						</form:button></td>
				</tr>
			</table>
		</form:form>
	</c:otherwise>
</c:choose>
</html>