<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="java">
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
	<link rel="stylesheet" href="../css/Admin_main.css">
	<script src="../bootstrap/js/jquery.min.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<script src="../js/admin.js"></script>
</head>
<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="panel-group" id="Administrator">
				<div class="panel panel-default"><!-- /// -->
					<div class="panel-heading">
						 <a class="panel-title" data-toggle="collapse" data-parent="#Administrator" href="#userManager">管理员</a>
					</div>
					<div id="userManager" class="panel-collapse in">
						<div class="panel-body">
							用户管理
						</div>
						<div class="panel-body">
							新增用户
						</div>
					</div>					
				</div><!-- //// -->		
			</div>
			<!-- <div class="panel-group" id="maintenance">
				<div class="panel-heading">
							 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#maintenance" href="#a">用户数据维护</a>
						</div>
						<div id="a" class="panel-collapse collapse">
							<div class="panel-body">
								a
							</div>
							<div class="panel-body">
								b
							</div>
						</div>		
				</div>
			</div> -->
		</div>
		<div class="col-md-9 column" id="mainContent">	
			<button type="button" class="btn btn-default" id="umAddBtn">添加</button>
			<button type="button" class="btn btn-default" id="umDeleteBtn">删除</button>
			<button type="button" class="btn btn-default" id="umUpdateBtn">修改</button>	
			<input type="text" id="searchWords" name="searchWords" placeholder="请输入关键字"/>
			<input type="button" id="search" name="search" value="查找"/>
			<!-- <select name="searchtype" id="searchtype">
				<option value="1">请选择关键字类型</option>
				<option value="1">用户名</option>
				<option value="2">真实姓名</option>
			</select> -->
			<table class="table table-condensed table-bordered">
				<thead>
					<tr>
						<th>
							选择
						</th>
						<th>
							编号
						</th>
						<th>
							用户名
						</th>
						<th>
							真实姓名
						</th>
						<th>
							性别
						</th>
						<th>
							证件类型
						</th>
						<th>
							证件号
						</th>
						<th>
							旅客类型
						</th>
						<th>
							所在城市
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.users}" var="s" varStatus="s1">
						<tr>
							<td>
								<c:if test='${s.rule ne "1"}'>
									<input type="checkbox" name="sUid" id="sUid" value="${s.id}"/>
								</c:if>
							</td>
							<td><c:out value="${s.id}"/></td>
							<td><c:out value="${s.username}"/></td>
							<td><c:out value="${s.realname}"/></td>
							<td><c:out value="${s.sex}"/></td>
							<td><c:out value="${s.cert_type.content}"/></td>
							<td><c:out value="${s.cert}"/></td>
							<td><c:out value="${s.user_type.content}"/></td>
							<td><c:out value="${s.city.city}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<c:forEach items = "${data.pages}" var = "s" varStatus = "s1">
					<li>
					 <a href="admin?action = show&page=${s}">${s}</a>
				    </li>		
				</c:forEach>
				每页显示
				<select name="" id="npp">
					<option value="5">5</option>
					<option value="10">10</option>
				</select>
			</ul>
		</div>
	</div>
	</div>
</body>
</html>