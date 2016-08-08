function checkStrength()
	{
		var psw1 = document.getElementById("psw1").value;
		var length = psw1.length;
		var strength = document.getElementById("strength");
		if(length>0 && length <= 3)
		{
			strength.innerHTML = "弱";
		}
		else if(length>3 && length <= 6)
		{
			strength.innerHTML = "中";
		}
		else
		{
			strength.innerHTML = "强";
		}
	}
	function checkAccurate()
	{	
		var psw1 = document.getElementById("psw1").value;
		var psw2 = document.getElementById("psw2").value;
		var accurate = document.getElementById("accurate");
		if (psw1 != psw2) 
		{
			accurate.innerHTML = "两次输入的密码必须一致";
		}
		else
		{
			accurate.innerHTML = "正确";
		}
	}
	var req = false;
	function processRequest()
	{
		if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		}else if (window.ActiveXObject) {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (req) {
			
			var url = "register?action=check";
			req.open("post",url,false);
			req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var username = document.getElementById("username").value;
			req.onreadystatechange = updatePage;
			req.send("username=" + username);
		}
		
	}
	function updatePage() {
		if(req.readyState == 4)
		{
			if(req.status == 200)
			{
				var res = req.responseText;
				if(res == 1){
					document.getElementById("res").innerHTML="可以使用";
				}else{
					document.getElementById("res").innerHTML="已被占用";
					document.getElementById("username").focus();
				}
	
			}
		}
	}

	var req1 = false;
	function showChild()
	{
		if (window.XMLHttpRequest) {
			req1 = new XMLHttpRequest();
		}else if (window.ActiveXObject) {
			req1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		if (req1) {
			
			var url = "register?action=showchild";
			req1.open("post",url,false);
			req1.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var province = document.getElementById("province").value;
			req1.onreadystatechange = getCityData;/////
			req1.send("province=" + province);
		}
		
	}

	function getCityData()
	{
		if(req1.readyState == 4)
		{
			if(req1.status == 200)
			{
				 var jsonstr = req1.responseText;
				 if(jsonstr!=null){
				 	var city = document.getElementById("city");
				 	var dataArray = eval("(" + jsonstr + ")").data;
				 	city.innerHTML="";
				 	for (var i = 0; i < dataArray.length;i++) 
				 	{
				 		var op = document.createElement('option');
				 	 	op.value = dataArray[i].id;
				 	 	op.text = dataArray[i].city;
				 	 	city.options.add(op);
				 	}
				 }
	
			}
		}
	}

	function init()
	{
		 window.location.href = "register?action=show";
	}

	//  function submitAlert()
	//  {
	// 	var username = document.getElementById("username").value;
	// 	var email = document.getElementById("email").value;
	// 	var psw1 = document.getElementById("psw1").value;
	// 	var psw2 = document.getElementById("psw2").value;
	// 	var gender = document.getElementById("gender").value;
	// 	var birth = document.getElementById("birth").value;
	// 	var address = document.getElementById("address").value;

	// 	if(document.getElementById("username").checkValidity() 
	// 		&& document.getElementById("email").checkValidity() 
	// 		&& document.getElementById("psw1").checkValidity() 
	// 		&& document.getElementById("birth").checkValidity() 
	// 		&& document.getElementById("address").checkValidity())
	// 	{
	// 		alert("确认注册信息：\n" + 
	// 			"用户名：" + username +"\n" +
	// 			"邮箱：" + email +"\n" +
	// 			"性别：" + gender +"\n" +
	// 			"生日：" + birth +"\n" +
	// 			"地址：" + address+"\n");
	// 	}
	// }