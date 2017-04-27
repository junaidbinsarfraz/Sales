<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Error Creating the following Order</h1>
	
	<h3>${ exception }</h3>
	
	<table>
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Customer ID</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${ productId }</td>
				<td>${ customerId }</td>
				<td>${ quantity }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>