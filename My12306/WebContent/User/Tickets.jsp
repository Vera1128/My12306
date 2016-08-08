<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>购票系统</title>
<link rel="stylesheet" href="../css/Admin_main.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../css/Admin_main.css">
<script src="../bootstrap/js/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/admin.js"></script>
</head>
<body>
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
							<th class="col-md-3 column">出发地<input type="text"
								id="fromplace" name="fromplace"
								value="${data.userData.fromplace}" /></th>
							<th class="col-md-3 column">目的地<input type="text"
								id="toplace" name="toplace" value="${data.userData.toplace}" /></th>
							<th class="col-md-3 column">出发日<input type="date"
								class="form-control" id="date" value="${data.userData.date}"
								name="date">
							</th>
							<th>
								<button type="button" class="btn btn-default"
									style="background: orange; color: white; width: 100px; height: 45px;">查询</button>
							</th>
						</tr>
					</thead>
				</table>
				<table class="table table-condensed table-bordered">
					<thead>
						<tr>
							<th class="col-md-1.5 column">车 次 号</th>
							<th class="col-md-1.5 column">出 发 地</th>
							<th class="col-md-1.5 column">目 的 地</th>
							<th class="col-md-1.5 column">出发时间</th>
							<th class="col-md-1.5 column">到达时间</th>
							<th class="col-md-1.5 column">金 额</th>
							<th class="col-md-1.5 column">历 时</th>
							<th class="col-md-1.5 column">备 注</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data.users}" var="s" varStatus="s1">
							<tr>
								<td><input type="checkbox" name="sUid" id="sUid"
									value="${s.id}" /></td>
								<td><c:out value="${s.train_number}" /></td>
								<td><c:out value="${s.fromplace}" /></td>
								<td><c:out value="${s.toplace}" /></td>
								<td><c:out value="${s.begin}" /></td>
								<td><c:out value="${s.end}" /></td>
								<td><c:out value="${s.price}" /></td>
								<td><c:out value="${s.duration}" /></td>
								<td><button type="button" class="btn btn-default"
										style="color: blue">预订</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>