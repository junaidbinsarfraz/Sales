<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<style type="text/css">
		table, th, td {
		   border: 1px solid black;
		}
	</style>
</head>
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
	
	<a href="/">Home</a>
	<a href="/addOrder">Add Order</a>
	<a href="/showProducts">List Products</a>
	<a href="/showCustomers">List Customers</a>
	<form action="/logout" name="form" id="form" method="post">
        <a href="#" onclick="form.submit();">Logout</a>
    </form>
</body>
</html>