<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试-- 商品列表</title>
<style type="text/css">
table, th, td { 
	border-collapse: collapse; 
	border: 1px solid #666;
}
th, td {
	padding: 3px 5px;
}

</style>
</head>
<body>
	<table border="1px" width="100%">
		<tr>
			<th>id</th>
			<th>category_id</th>
			<th>item_type</th>
			<th>title</th>
			<th>sell_point</th>
			<th>price</th>
			<th>num</th>
			<th>barcode</th>
			<th>image</th>
			<th>status</th>
			<th>priority</th>
		</tr>
		<c:forEach items="${goodsList }" var="g">
		<tr>
			<td>${g.id }</td>
			<td>${g.categoryId }</td>
			<td>${g.itemType }</td>
			<td>${g.title }</td>
			<td>${g.sellPoint }</td>
			<td>${g.price }</td>
			<td>${g.num }</td>
			<td>${g.barcode }</td>
			<td><img height="50" src="${pageContext.request.contextPath }/${g.image}"/></td>
			<td>${g.status }</td>
			<td>${g.priority }</td>
		</tr>
		</c:forEach>
	
	
	</table>

</body>
</html>