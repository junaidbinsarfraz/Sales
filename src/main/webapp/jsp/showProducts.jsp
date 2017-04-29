<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
	<style type="text/css">
		table, th, td {
		   border: 1px solid black;
		}
	</style>
</head>
<body>

	<h1>List of Products</h1>

	<c:if test="${ not empty products }">

		<table>
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Description</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${ products }">
					<tr>
						<td>${ product.pId }</td>
						<td>${ product.pDesc }</td>
						<td>${ product.qtyInStock }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	<a href="/">Home</a>
	<a href="/addProduct">Add Product</a>
	<a href="/showProducts">List Products</a>
	<a href="/showOrders">List Orders</a>
	<form action="/logout" name="form" id="form" method="post">
        <a href="#" onclick="form.submit();">Logout</a>
    </form>
</body>
</html>