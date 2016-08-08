<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<script src="../bootstrap/js/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/order.js"></script>
<script src="../js/user.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<img src="../picture/2.jpg" width="1200" /> <span
					class="label label-default">欢迎进入12306订票服务系统</span>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="panel-heading">
					<a class="panel-title" data-toggle="collapse"
						data-parent="#panel-543722" href="#panel-element-376069">我的订单</a>
				</div>
				<br>
				<div id="panel-element-376069" class="panel-collapse in">
					<div class="panel-body">
						<a href="../User/user?action=show"> 已完成订单</a>
					</div>
					<div class="panel-body">未完成订单</div>
				</div>
				<div class="panel-heading">
					<a class="panel-title collapsed" data-toggle="collapse"
						data-parent="#panel-543722" href="#panel-element-657715">个人信息</a>
				</div>
				<br>
				<div id="panel-element-657715" class="panel-collapse collapse">
					<div class="panel-body">查看个人信息</div>
					<div class="panel-body">账号安全</div>
					<div class="panel-body">手机核验</div>
					<div class="panel-body">常用联系人</div>
				</div>
				<button type="button" class="btn btn-danger btn-large btn-block"
					id="uBuyBtn">查票或购票</button>
			</div>
			<div class="col-md-9 column">
				<div class="btn-group btn-group-md">
					<button type="button" id="umUpdateBtn"
						class="btn btn-default btn-success">改签</button>
					<button type="button" id="umDeleteBtn"
						class="btn btn-default btn-success">退票</button>
					<button type="button" id="" class="btn btn-default btn-success">
						变更到站</button>
				</div>
				<div class="panel-heading">


					<c:forEach items="${data.orderList}" var="s" varStatus="s1">
						<tbody>
							<a class="panel-title" data-toggle="collapse"
								data-parent="#panel-543722" href="#panel-element">
								<tr>
									<td>
									<td><c:out value="${s.order_date}" /></td>
									<td><c:out value="${s.name}" /></td>
									<td><c:out value="${s.fromplace}" /></td>
									<td><c:out value="${s.toplace}" /></td>
									<td><c:out value="${s.begin}" /></td>
								</tr>
							</a>
							<br />
							<div id="panel-element" class="panel-collapse in">
								<div class="panel-body">
									<table class="table">
										<thead>
											<tr>
												<th>选择</th>
												<th>出发日期</th>
												<th>旅客姓名</th>
												<th>出发地点</th>
												<th>目的地点</th>
												<th>出发时间</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${data.orderList}" var="s" varStatus="s1">
												<tr>
													<td><input type="checkbox" name="sUid" id="cUid"
														value="${s.id}">
													<td><c:out value="${s.order_date}" /></td>
													<td><c:out value="${s.name}" /></td>
													<td><c:out value="${s.fromplace}" /></td>
													<td><c:out value="${s.toplace}" /></td>
													<td><c:out value="${s.begin}" /></td>
													<!-- <td><c:out value="${s.price}"/></td> -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
					</c:forEach>
					</tbody>
				</div>

			</div>
		</div>
	</div>
</body>
</html>