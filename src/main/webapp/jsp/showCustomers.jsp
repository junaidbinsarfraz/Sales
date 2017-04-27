<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
	<h1>List of Customers</h1>

	<c:if test="${ not empty customers }">

		<ul>
			<c:forEach var="customer" items="${ customers }"
				varStatus="customerLoop">
				<h1>${ customerLoop.index + 1 }.${ customer.cName }</h1>
				${ customer.cName }'s Orders
				<table>
					<thead>
						<tr>
							<th>Order ID</th>
							<th>Quantity</th>
							<th>Product ID</th>
							<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${ customer.orders }">
							<tr>
								<td>${ order.oId }</td>
								<td>${ order.qty }</td>
								<td>${ order.prod.pId }</td>
								<td>${ order.prod.pDesc }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>