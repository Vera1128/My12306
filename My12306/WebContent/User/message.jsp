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
    <script src="../js/user.js"></script>
	<link rel="stylesheet" href="../css/User_main.css">
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
		<img src="../picture/2.jpg" width="1100"/>
		 <br><span class="label label-default">欢迎进入12306订票服务系统</span>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="panel-heading">
					<a class="panel-title" data-toggle="collapse" data-parent="#panel-543722" href="#panel-element-376069">我的订单</a>
					</div>
					<br><div id="panel-element-376069" class="panel-collapse in">
						<div class="panel-body"><a href="../User/user?action=show">
							未完成订单</a>
						</div>
						<div class="panel-body">
							已完成订单
						</div>
					</div>						
				<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-543722" href="#panel-element-657715">个人信息</a>
					</div>
					<br><div id="panel-element-657715" class="panel-collapse collapse">
						<div class="panel-body">
							查看个人信息
						</div>
						<div class="panel-body">
							账号安全
						</div>
						<div class="panel-body">
							手机核验
						</div>
						<div class="panel-body">
							常用联系人
						</div>
					</div>
					<button type="button" class="btn btn-danger btn-large btn-block"
					id="uBuyBtn">选择并购票</button>
		</div>
		<div class="col-md-5 column">
		<div id="single_menu">
				查看个人信息<hr/>
			</div>
			<div id="single_menu">
				<font color="red">*</font>用户名：&nbsp&nbsp
				<span id="username" name="username"></span>					
			</div>

			<div id="single_menu">
				<font color="red">*</font>真实姓名：&nbsp&nbsp
				<span id="realname" name="realname"></span>
			</div>
			<div id="single_menu">
				<font color="red">*</font>性别：&nbsp&nbsp
				<span id="sex" name="sex"></span>
			</div>
			<div id="single_menu">
				<font color="red">*</font>省份：&nbsp&nbsp
				<span id="province" name="province"></span>
			</div>
			<div id="single_menu">
				<font color="red">*</font>城市：&nbsp&nbsp
				<span id="city" name="city"></span>
			</div>
			<div id="single_menu">
				<font color="red">*</font>证件类型：&nbsp&nbsp
				<span id="certtype" name="certtype"></span>
			</div>
			<div id="single_menu">
				<font color="red">*</font>证件号码：&nbsp&nbsp
				<span id="cert" name="cert"></span>
			</div>
		</div>
		<div class="col-md-4 column">
		<img alt="140x140" src="../picture/5.jpeg" class="img-thumbnail" />
		 <br><a id="modal-534681" href="#modal-container-534681" role="button" class="btn" data-toggle="modal">修改照片</a>
		 <div class="modal fade" id="modal-container-534681" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								请选择照片
							</h4>
						</div>
						<div class="modal-body">
							<img alt="140x140" src="../picture/5.jpeg" class="img-thumbnail" />
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>