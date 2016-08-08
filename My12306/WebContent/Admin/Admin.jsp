<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户管理</title>
	<link rel="stylesheet" href="../css/Admin_main.css">
</head>
<body>
	<!-- header -->
	<div style="position: absolute; z-index: 2; left: 357px; top: 10px">
		<td><img src="./picture/2.jpg" width="500" height="40"></td>
	</div>
		<div id = "header" class="box">
			当前位置：所有用户管理
			<div class="fr">欢迎你，某某</div>
		</div>
	<!-- menu -->
		<div id="menu" class="box fl">
			<h3>管理员</h3>
			<!-- <div id="menu"> -->
				用户管理<br/>			
				新增用户
			<!-- </div> -->
		</div>
	<!-- content -->
		<div id="content" class="box fr">
			<h3>用户管理</h3>
			<div id="search">
				姓名<input type="text" id="userName">
				性别<select name="" id="gender">
							<option>男</option>
							<option>女</option>
						</select>
				证件类型<select name="" id="certtype">
							<option>二代身份证</option>
							<option>港澳通行证</option>
							<option>台湾通行证</option>
							<option>护照</option>
							<option>学生证</option>
						</select>	
				证件号码<input type="text" id="userName">
				旅客类型<select name="" id="usertype">
							<option>成人</option>
							<option>学生</option>
							<option>儿童</option>
							<option>残疾军人、伤残人民警察</option>
						</select>	
				<input type="submit" value="查询">
				<form action="">
				<table border="1"  class="t1">  
                   <tr>
                   		<th>选择</th>
                   		<th>姓名</th>
                   		<th>性别</th>
                   		<th>证件类型</th>
                   		<th>证件号码</th>
                   		<th>旅客类型</th>
                   		<th>操作</th>
                   </tr>  
			       <tr>  
			            <td><input type="checkbox" ></td>
			      		<td>用户1</td>
			      		<td>男</td>
			      		<td>二代身份证</td>
			      		<td>123</td>
			      		<td>成人</td>      		
			      		<td>修改</a></td>
			      </tr> 
			     <tr>  
			            <td><input type="checkbox" ></td>
			      		<td>用户2</td>
			      		<td>男</td>
			      		<td>二代身份证</td>
			      		<td>123</td>
			      		<td>成人</td>      		
			      		<td>修改</a></td>
			      </tr>  
			      <tr>  
			            <td><input type="checkbox" ></td>
			      		<td>用户3</td>
			      		<td>男</td>
			      		<td>二代身份证</td>
			      		<td>123</td>
			      		<td>成人</td>      		
			      		<td>修改</a></td>
			      </tr> 
			      <tr>  
			            <td><input type="checkbox" ></td>
			      		<td>用户4</td>
			      		<td>男</td>
			      		<td>二代身份证</td>
			      		<td>123</td>
			      		<td>成人</td>      		
			      		<td>修改</a></td>
			      </tr> 
			      <tr>  
			            <td><input type="checkbox" ></td>
			      		<td>用户5</td>
			      		<td>男</td>
			      		<td>二代身份证</td>
			      		<td>123</td>
			      		<td>成人</td>      		
			      		<td>修改</a></td>
			      </tr> 
                </table>  
			</form>
			</div>
		</div>

</body>
</html>