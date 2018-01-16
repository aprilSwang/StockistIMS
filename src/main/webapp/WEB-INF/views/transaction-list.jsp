<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<spring:url value="/css/simple.css" var="style" />
<link rel="STYLESHEET" type="text/css" href="${style}" />

<c:choose>
	<c:when test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
		<p>
			Sorry, you cannot access this page. <a
				href="${pageContext.request.contextPath}/home/login">Please
				Login.</a>
		</p>
	</c:when>
	<c:otherwise>

		<h3>Transaction List</h3>
		<a href="${pageContext.request.contextPath}/admin/transaction/create">Record
			Usage</a>
		<c:if test="${fn:length(transactionList) gt 0}">
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<thead>
					<tr class="listHeading">
						<th>Transaction ID</th>
						<th>User ID</th>
						<th>Quantity</th>
						<th>Part Number</th>
						<th>Customer Name</th>
						<th>Transaction Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transaction" items="${transactionList}">
						<tr class="listRecord">
							<td>${transaction.transactionID}</td>
							<td>${transaction.userID}</td>
							<td>${transaction.quantity}</td>
							<td>${transaction.partNumber}</td>
							<td>${transaction.customerName}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${transaction.transactionDate}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</c:otherwise>
</c:choose>