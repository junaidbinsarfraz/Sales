<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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
</body>
</html>