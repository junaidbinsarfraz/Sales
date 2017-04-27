<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<h1>List of Orders</h1>

	<c:if test="${ not empty orders }">

		<c:forEach var="order" items="${ orders }">
			
			<h3>${ order.oId }</h3>
			
			<table>
				<thead>
					<tr>
						<th>Quantity</th>
						<th>Order Date</th>
						<th>Customer ID</th>
						<th>Customer Name</th>
						<th>Product ID</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ order.qty }</td>
						<td>${ order.orderDate }</td>
						<td>${ order.cust.cId }</td>
						<td>${ order.cust.cName }</td>
						<td>${ order.prod.pId }</td>
						<td>${ order.prod.pDesc }</td>
					</tr>
				</tbody>
			</table>
		</c:forEach>

	</c:if>
</body>
</html>