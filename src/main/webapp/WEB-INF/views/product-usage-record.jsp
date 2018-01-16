<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${fn:length(p1) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th><spring:message code="fieldLabel.transactionID" /></th>
					<th><spring:message code="fieldLabel.transactionDate" /></th>
					<th><spring:message code="fieldLabel.quantity" /></th>
					<th><spring:message code="fieldLabel.customerName" /></th>
					<th><spring:message code="fieldLabel.userID" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transaction" items="${p1}">
					<tr class="listHeading">
						<td>${transaction.transactionID}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${transaction.transactionDate}" /></td>
						<td>${transaction.quantity}</td>
						<td>${transaction.customerName}</td>
						<td>${transaction.userID}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
	<p style="font-size:30px" align="center"><spring:message code="label.nousage" /></p>
	</c:otherwise>
	</c:choose>
</body>
</html>