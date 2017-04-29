<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
	<h1>Add New Customer</h1>

	<form action="/addCustomer" method="post">
		<label>Cust Name: </label>
		<input type="text" name="cName" />
		<c:if test="${ not empty error }">${ error }</c:if>
		<br />
		<input type="submit" value="Add" />
	</form>
	
	<a href="/">Home</a>
	<a href="/showProducts">List Products</a>
	<a href="/showOrders">List Orders</a>
</body>
</html>