<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/Login_css.css">
<script>
	function UserRegistration() {
		window.location.href = "UserRegistration.jsp";
	}
</script>
<script src="js/Checkreg.js"></script>
</head>
<body>
	<div style="position: relative;">
		<img src="picture\1.jpg" />
		<div style="position: absolute; z-index: 2; left: 150px; top: 10px">
			<div id="page">
				<div id="input" class="box">
					<form action="login">
						<!-- <div id="single_input" class="font_color fr">				
						<h2>&nbsp;&nbsp;&nbsp;&nbsp;用户登录信息</h2>
						</div> -->
						<div id="single_input" class="fr">
							用户名：&nbsp;<input type="text" id="username" name="username"
								required="true">
						</div>
						<div id="single_input" class="fr">
							密&nbsp;码：&nbsp;&nbsp;<input type="password" id="psw1" name="psw1"
								required="true">
						</div>
						<div id="single_input" class="fr">
							验证码：&nbsp;<input type="text" id="checkwords">
							<div class="fr">刷新</div>
						</div>
						<div id="single_input" class="fr">
							&nbsp;&nbsp;<input type="submit" value="登录" onclick="login()">&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="reset" value="重置"> &nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" value="注册" onclick="UserRegistration()"> 
								<!-- <input type="button" value="数据初始化" onclick="init()" /> -->
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>