<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>测试-- 商品分类列表</title>
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
<%-- ${goodsCategoryList } --%>
	<table border="1px" width="100%">
		<tr>
			<th>id</th>
			<th>parent_id</th>
			<th>name</th>
			<th>status</th>
			<th>sort_order</th>
			<th>is_parent</th>
		</tr>
		<c:forEach items="${goodsCategoryList }" var="category">
		<tr>
			<td>${category.id }</td>
			<td>${category.parentId }</td>
			<td>${category.name }</td>
			<td>${category.status }</td>
			<td>${category.sortOrder }</td>
			<td>${category.isParent }</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>