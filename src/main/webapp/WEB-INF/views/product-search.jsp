<%@page import="sg.edu.iss.team1.service.ProductService"%>
<%@page import="sg.edu.iss.team1.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:choose>
	<c:when test="${sessionScope.USERSESSION.user.roleSet.size() eq  null}">
		<p>
			Sorry, you cannot access this page. <a
				href="${pageContext.request.contextPath}/home/login">Please
				Login.</a>
		</p>
	</c:when>
	<c:otherwise>
		<h3>Search Product page</h3>


		<form:form method="POST"
			action="${pageContext.request.contextPath}/mechanic/products/search.html">

			<input type="hidden" name="typeName" value="" id="typeName" />

			<table>
				<tbody>
					<tr>
						<td>Product Parameter</td>
						<td><input type="text" name="select"></td>
					</tr>
					<tr>
						<td>Search for</td>
						<td><input type="text" name="searchtext" /> <!-- <td>
				
				< select id ="select"name="select" >
				< option value="partNumber" >partNumber<option/>
				< option value="description" >description<option/>
				< option value="color" >color<option/>
				< option value="manufacturer">manufacturer<option/>
				
				</select>
				 --></td>

						<td><input type="submit" value="Search" class="blcass" /></td>

					</tr>

					<tr>


					</tr>
				</tbody>
			</table>
			<br>
			<br>
			<br>
			<table style="cellspacing: 2; cellpadding: 2; border: 1;">

				<tr class="listHeading">
					<th>Part Number</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Description</th>
					<th>Color</th>
					<th>Dimension</th>
					<th>Manufacturer</th>
					<th>Reorder Level</th>
					<th>Minimum Reorder Quantity</th>
					<th>Supplier Name</th>
					<th>Shelf Location</th>

				</tr>
				<c:forEach var="product" items="${productList}">
					<tr class="listRecord">
						<td>${product.partNumber}</td>
						<td>${product.unitPrice}</td>
						<td>${product.quantity}</td>
						<td>${product.description}</td>
						<td>${product.color}</td>
						<td>${product.dimension}</td>
						<td>${product.manufacturer}</td>
						<td>${product.reorderLevel}</td>
						<td>${product.minReorderQnty}</td>
						<td>${product.supplierName}</td>
						<td>${product.shelfLocation}</td>

					</tr>
				</c:forEach>
		</form:form>
	</c:otherwise>
</c:choose>