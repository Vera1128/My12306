$(function() {
	var umAddBtn = $("#umAddBtn");
	var umDeleteBtn = $("#umDeleteBtn");
	var umUpdateBtn = $("#umUpdateBtn");
	var usernameObj = $("#username");
	var uCheck = $("#uCheck");
	umAddBtn.click(function() {
		$("#mainContent").load("userAdd.jsp");
	});

	usernameObj.blur(function() {
		$.ajax({
			type : 'post',
			url : '../register?action=check',
			data : {
				username : usernameObj.val()
			},
			dataType : 'json',
			success : function(data) {
				if (data.flag == "yes") {
					uCheck.html("此用户名已被占用").css({
						color : "red"
					});
					usernameObj.focus();
				} else {
					uCheck.html("此用户名可以注册").css({
						color : 'blue'
					});
				}
			},
			error : function() {
				alert("注册异常");
			}
		});
	});
	
	var province = $("#province");
	province.change(function() {
		var city = $("#city");
		$.ajax({
			type : 'post',
			url : '../register?action=showchild',
			data : {
				provinceid : province.val()				
			},
			dataType : 'json',
			success : function(data) {
				city.html("");
				var cityList = data.data;
				var s = "";
				for (var i = 0; i < cityList.length; i++) {
					s += '<option value=' + cityList[i].id + '>'
							+ cityList[i].city + '</option>';
				}
				city.append(s);
			},
			error : function() {
				alert("省市联动册异常");
			}
		});
	});
	
	function doReFresh(){
		window.location.href="admin?action=show";		
	}

	function doAdd()
	{
		$.ajax({
			type : 'post',
			url : 'admin?action=addUser',
			data : {
				username:$("#username").val(),
				realname:$("#realname").val(),
				rule:$("#rule").val(),
				sex:$("#sex").val(),
				province:$("#province").val(),
				city:$("#city").val(),
				certtype:$("#certtype").val(),
				birthday:$("#birthday").val(),
				cert:$("#cert").val(),
				userType:$("#userType").val(),
				content:$("#content").val()		
			},
			dataType : 'json',
			success : function(data) {
				if(data.flag == "yes")
				{
					alert("数据添加成功");
					doReFresh();
				}else{
					alert("数据添加异常");
				}
			},
			error : function() {
				alert("异常");
			}
		});
	}

	function doUpdate(){
		alert("update");
		$.ajax({
			type : 'post',
			url : 'admin?action=update',
			data : {
				id:$("#uId").val(),
				username:$("#username").val(),
				realname:$("#realname").val(),
				rule:$("#rule").val(),
				sex:$("#sex").val(),
				 province:$("#province").val(),
				city:$("#city").val(),
				certtype:$("#certtype").val(),
				birthday:$("#birthday").val(),
				cert:$("#cert").val(),
				userType:$("#userType").val(),
				content:$("#content").val()		
			},
			dataType : 'json',
			success : function(data) {
				if(data.flag == "yes")
				{
					alert("数据修改成功");
					doReFresh();
				}else{
					alert("数据修改异常");
				}
			},
			error : function() {
				alert("修改异常");
			}
		});
	}
	$("#uSaveBtn").click(function(){
	 	if ($("#uId").val()==0) {
	 		doAdd();
	 	}
		else
		{
			doUpdate();
		}
	});
	
	$("#umDeleteBtn").click(function(){
		var ids=[];
		$('input[name="sUid"]:checked').each(function(){
			ids.push($(this).val());
		});
		if (ids.length == 0) {
			alert("请至少选择一条记录");
		}else{
			if(confirm("确定要删除\n"+ids+"\n共"+ids.length+"条记录？"))	
			{
				doDelete(ids);
			}else{
				$('input[name="sUid"]').attr("checked",false);
			}
		}
	});
	function doDelete(ids){
		$.ajax({
			type : 'post',
			url : 'admin?action=delete',
			data : {
				ids_d:ids.toString()	
			},
			dataType : 'json',
			success : function(data) {
				if(data.flag == "yes")
				{
					alert("数据删除成功");					
					doReFresh();
				}else{
					alert("数据删除异常");
				}
			},
			error : function() {
				alert("异常");
			}
		});
	}
	$("#umUpdateBtn").click(function() {
		var ids=[];
		$('input[name="sUid"]:checked').each(function(){
			ids.push($(this).val());
		});
		if (ids.length != 1) {
			alert("请选择一条记录");
		}else{
			location.href="admin?action=findAndPush&id=" + ids[0];
		}
	});
	
	$("#changeProvince").click(function() {
		$.ajax({
			type : 'post',
			url : '../register?action=findProvince',
			data : {
			}, 
			dataType : 'json',
			success : function(data) {
				province.html="";
				var provincelist = data.data;
				var s = "";
				for (var i = 0; i < provincelist.length; i++) {
					s += '<option value=' + provincelist[i].provinceid + '>'
							+ provincelist[i].province + '</option>';
				}
				province.append(s);
			},
			error : function() {
				alert("省份信息获取异常");
			}
		});
	});
	
	$("#search").click(function() {
		$.ajax({
			type : 'post',
			url : 'admin?action=search',
			data : {
				searchWords:$("#searchWords").val()
			}, 
			dataType : 'json',
			success : function(data) {
				if(data.flag==yes)
					alert("信息查找成功");
				else
					alert("信息查找失败");
			},
			error : function() {
				alert("查找失败");
			}
		});
	});

	$("#npp").change(function(){
		 window.location.href = "admin?action=show&pageSize=" + $(this).val();
	})
});

 