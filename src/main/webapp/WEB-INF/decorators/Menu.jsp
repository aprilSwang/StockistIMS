<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/logout" var="logout" />
<ul>
	<c:if test="${sessionScope.USERSESSION.user.roleSet.size() gt 0}">
		<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
			<c:choose>
				<c:when test="${role.roleID eq 'admin' }">
					<li><spring:url value="/admin/transaction/list" var="tlist"
							htmlEscape="true" /> <a href="${tlist}"> <spring:message
								code="menu.transactionList" />
					</a></li>
					<li><spring:url value="/admin/products/list" var="ulist"
							htmlEscape="true" /> <a href="${ulist}"> <spring:message
								code="menu.productCatalog" />
					</a></li>
					<li><spring:url value="/administrator/user/list" var="rlist"
							htmlEscape="true" /> <a href="${rlist}"> <spring:message
								code="menu.userList" />
					</a></li>
					<li><spring:url value="/administrator/supplier/list" var="elist"
							htmlEscape="true" /> <a href="${elist}"> <spring:message
								code="menu.supplierList" />
					</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="menu.logout" />
					</a></li>

				</c:when>
				<c:when test="${role.roleID eq 'mech' }">
					<li><spring:url value="/admin/transaction/list" var="tlist"
							htmlEscape="true" /> <a href="${tlist}"> <spring:message
								code="menu.transactionList" />
					</a></li>
					<li><spring:url value="/mechanic/products/list" var="phistory"
							htmlEscape="true" /> <a href="${phistory}"> <spring:message
								code="menu.productCatalog" />
					</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="menu.logout" />
					</a></li>

				</c:when>
			</c:choose>

		</c:forEach>
	</c:if>
</ul>

