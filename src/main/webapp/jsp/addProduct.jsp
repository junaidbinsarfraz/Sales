<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	
	<h1>Add New Product</h1>

	<form action="/addProduct" method="post">
		<label>Product Description: </label>
		<input type="text" name="pDesc" />
		<c:if test="${ not empty emptyDescripion }">${ emptyDescripion }</c:if>
		<br />
		<br />
		<label>Quantity in Stock: </label>
		<input type="text" name="qty" />
		<c:if test="${ not empty qtyInStockLessThenZero }">${ qtyInStockLessThenZero }</c:if>
		<br />
		<input type="submit" value="Add" />
		<!-- <input type="hidden" name="qtyInStock" /> -->
	</form>
</body>
</html>