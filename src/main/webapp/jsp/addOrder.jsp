<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
	<h1>Add New Order</h1>

	<form action="/addOrder" method="post">
		<label>Customer ID: </label>
		<input type="text" name="cId" />
		<br />
		<br />
		<label>Product ID: </label>
		<input type="text" name="pId" />
		<br />
		<br />
		<label>Quantity: </label>
		<input type="text" name="qty" />
		<c:if test="${ not empty qtyInStockLessThenOne }">${ qtyInStockLessThenOne }</c:if>
		<br />
		<input type="submit" value="Add" />
	</form>
</body>
</html>