<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="css/UserRegistration.css">
</head>
<body>
	<div id="page">
	<div style="position: absolute; z-index: 2; left: 357px; top: 10px">
		<td><img src="./picture/2.jpg" width="700" height="100"></td>
	</div>

		<form action="register">
			<div id="input_block">
				<div id="font_color">
					<h2 font_color=blue>注册信息</h2>
				</div>
				<hr />
				<h5>注：标有 * 处，均为必填项</h5>
				<!-- <%=request.getSession().getAttribute("citydata")%> -->

				<!-- <td width="5%">&nbsp;</td>
				<td width="95%" align="left">注：标有注：标有 * 处，均为必填项</td> -->
			</div>
			<div id="input_block">
				<!-- style="padding:5px;width=600px" -->
				<div id="font_color">
					<font>登录信息</font>
					<input type="button" value="数据初始化" onclick="init()"/>
				</div>
				<div id="single_input">
					<font color="red">*</font>用户名&nbsp&nbsp <input type="text"
						required="true" id="username" name="username" onblur="processRequest()">
						<span id = "res">长度不超过10位</span>
				</div>
				<div id="single_input">
					<font color="red">*</font>密&nbsp码&nbsp&nbsp&nbsp <input
						type="password" id="psw1"required="true" name="psw1"
						onkeyup="checkStrength()"> <span id="strength">不少于六位字符</span>
				</div>
				<div id="single_input">
					<font color="red">*</font>确认密码 <input type="password" id="psw2"	required="true" onblur="checkAccurate()">
						<span id = "accurate">请再次输入密码</span>
				</div>
				<!-- <div id="single_input">
					<font color="red">*</font>邮&nbsp箱&nbsp&nbsp&nbsp <input type="email" id="email" required="true"name="email">
				</div>
 -->
			</div>

			<div id="input_block" style="margin-top: 10px; margin-bottomL: 20px">
				<div id="font_color">
					<font>详细信息</font>
				</div>
				<div id="single_input">
					<font color="red">*</font>真实姓名 <input type="text" id="realName" name="realName" 
						required="true">
				</div>

				<div id="single_input">
					<font color="red">*</font>性别&nbsp&nbsp&nbsp <input type="radio"
						name="gender" value="1" required="true" checked="checked">男 <input
						type="radio" name="gender" value="2" required="true">女
				</div>

				<div id="single_input">
					<font color="red">*</font>省份&nbsp&nbsp&nbsp&nbsp 
					<select name="province" id="province" required="true" onchange="showChild()">
						<!-- <option>省份</option>
						<option>湖北省</option>
						<option>河北省</option>
						<option>北京</option>
						<option>天津</option> -->
						<c:forEach items="${provinceData.data}" var="s" varStatus="s1">
							<option value="<c:out value="${s.provinceid}"/>">
							<c:out value="${s.province}"/>
							</option>
						</c:forEach>
					</select> 
					<font color="red">&nbsp&nbsp*</font>市县&nbsp 
					<select name="city"	id="city" required="true">
						<!-- <c:forEach items="${citydata.data}" var="s" varStatus="s1">
							<option value="<c:out value="${s.id}"/>">
							<c:out value="${s.city}"/>
							</option>
						</c:forEach> -->
					</select>
				</div>
				<div id="single_input">
					<font color="red">*</font>证件类型 
					<select name="certtype" id="certtype" required="true">
						<!-- <option>证件类型</option> -->
						<c:forEach items="${certTypeData.data}" var="s" varStatus="s1">
							<option value="<c:out value="${s.id}"/>">
							<c:out value="${s.content}"/>
							</option>
						</c:forEach>
						<!-- <option value="1">二代身份证</option>
						<option value="2">港澳通行证</option>
						<option value="3">台湾通行证</option>
						<option value="4">护照</option>
						<option value="5">学生证</option> -->
					</select>
				</div>

				<div id="single_input">
					<font color="red">*</font>证件号码 <input type="text" id="certNum" name="certNum" 
						required="true"> <span id="certLength">请输入证件号码</span>
				</div>

				<div id="single_input">
					<font color="red">*</font>出生日期 <input type="date" id="birth" name="birth" 
						required="true">
				</div>

				<div id="single_input">
					<font color="red">*</font>旅客类型 <select name="usertype" id="usertype"
						required="true">
						<c:forEach items="${userTypeData.data}" var="s" varStatus="s1">
							<option value="<c:out value="${s.id}"/>">
								<c:out value="${s.content}"/>
							</option>
						</c:forEach>
						<!-- <option>旅客类型</option>
						<option value="1">成人</option>
						<option value="2">儿童</option>
						<option value="3">学生</option>
						<option value="4">残疾军人、伤残人民警察</option> -->
					</select>
				</div>
				<div id="single_input">
					备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="content" name="content">
				</div>
			</div>
			<div id="input_block">
				<div id="single_input">
					<input type="checkBox" name="" id="agree" required="true">我已阅读并同意遵守</input>
					<a href="">《中国铁路客户服务中心网站服务条款》</a>
				</div>
				<div style="padding: 5px;width=600px"></div>
				<div style="margin-top: 10px; margin-bottomL: 20px"></div>
				<div id="single_input">
					&nbsp&nbsp&nbsp<input type="submit" value="注册新用户" id="submit" onclick="UserManagement()"
					>&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="reset" value="重置">
				</div>
			</div>
		</form>
	</div>
	
</body>
<script type="text/javascript" src=" js/Checkreg.js"></script>
</html>