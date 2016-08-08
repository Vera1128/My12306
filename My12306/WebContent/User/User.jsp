<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<link rel="stylesheet" href="../css/User_main.css">
</head>
<body>
	<!-- header -->
		<div id = "header" class="box">
			当前位置：所有用户管理
			<div class="fr">欢迎你，某某</div>
		</div>
	<!-- menu -->
		<div id="menu" class="box fl">
			<h3>普通用户</h3>
			<div id="single_menu">
				用户管理<br/>			
				新增用户
			</div>
		</div>
	<!-- content -->
		<div id="content" class="box fr">
			<div id="single_menu">
				查看个人信息<hr/>
			</div>
			<div id="single_menu">
				<font color="red">*</font>用户名：&nbsp&nbsp
				<span id="username" name="username"></span>					
				<!-- <input type="text" required = "true" id="username"> -->
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
	<!-- footer -->
		<!-- <div id="footer" class="box cl">
			footer
		</div> -->
</body>
</html>