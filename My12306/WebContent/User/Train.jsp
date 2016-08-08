<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>余票查询</title>
<link rel="stylesheet" href="../css/Admin_main.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../css/Admin_main.css">
<script src="../bootstrap/js/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/user.js"></script>
</head>
<body>
	<form action="user?search" method="post">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" id="mainContent">
				<table class="table table-condensed table-bordered">
					<thead>
<tr style="position: absolute; z-index: 2; left: 10px; top: 0px">
	<div style="position: relative;">
		<img src="../picture/2.jpg" width="1140" height="140" />
	</div>

	</tr>
		<tr>
	<th class="col-md-3 column">出发地
        <input type="text" id="myfromplace" name="myfromplace" required="true"/>
    </th>

   	<th class="col-md-3 column">目的地
   		<input type="text" id="mytoplace" name="mytoplace" required="true"/>
   	</th>
							
	<th class="col-md-3 column">
	出发日
	    <input type="date"	class="form-control" id="mydate" value="date" name="mydate"	required = "true"/>
	</th>

	<th>
		<!-- <input type="button" class="btn btn-default" id = "searchBtn" name = "search" style="background: orange; color: white; width: 100px; height: 45px;" value="查找">
		</input> -->
		<input type="submit" id="searchBtn" name="search" value="查找"/>
	</th>

	    </tr>
	</thead>
</table>
	<table class="table table-condensed table-bordered">
	<tr>
	<th class="col-md-1.5 column" id="id" name="id">序号</th>

	<th class="col-md-1.5 column" id="train_number" name="train_number">车 次 号</th>

	<th class="col-md-1.5 column" id="fromplace" name="fromplace">出 发 地</th>

	<th class="col-md-1.5 column" id="toplace" name="toplace">目 的 地</th>

	<th class="col-md-1.5 column" id="begin" name="begin">出发时间</th>

	<th class="col-md-1.5 column" id="end" name="end">到达时间</th>

	<th class="col-md-1.5 column" id="price" name="price">金 额</th>

	<th class="col-md-1.5 column" id="duration" name="duration">历 时</th>

	<th class="col-md-1.5 column" id="" name="">备 注</th>
	</tr>

	<tbody>
	<c:forEach items="${data.trains}" var="s" varStatus="s1">
		<tr>
			<td><c:out value="${s.id}"/></td>
			<td><c:out value="${s.train_number}"/></td>
			<td><c:out value="${s.fromplace}"/></td>
			<td><c:out value="${s.toplace}"/></td>
			<td><c:out value="${s.begin}"/></td>
			<td><c:out value="${s.end}"/></td>
			<td><c:out value="${s.price}"/></td>
			<td><c:out value="${s.duration}"/></td>
			<td><button type="button" class="btn btn-default"
										style="color: blue">预订</button></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
			</div>
		</div>
	</div>
	</form>
</body>
</html>