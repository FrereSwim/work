<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>酒店餐饮管理系统</title> 
    <link href="css/base.css" rel="stylesheet">
    <link href="css/login/login.css" rel="stylesheet">
	<script src="js/jquery-3.2.1.min.js"></script>
	<link href="css/qikoo.css" rel="stylesheet">
	<script src="js/qikoo.js"></script>
	<style type="text/css">
	 
	</style>
</head>
<body>

<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
			<span class="sys-name">酒店管理平台</span>
		</div>
	</div>
	<div class="login-bd">
		<div class="bd-inner">
			<div class="inner-wrap">
				<div class="lg-zone">
					<div class="lg-box">
						<div class="lg-label"><h4>用户登录</h4></div>
						<div id="promptBox" class="alert alert-error">
			              <i class="iconfont">&#xe62e;</i>
			              <span id="errorInfo"></span>
			            </div>
						<form>
							<div class="lg-username input-item clearfix">
								<i class="iconfont">&#xe60d;</i>
								<input id="zhanghao" type="text" placeholder="请输入账号">
							</div>
							<div class="lg-password input-item clearfix">
								<i class="iconfont">&#xe634;</i>
								<input id="mima" type="password" placeholder="请输入密码">
							</div>
							<div class="lg-check clearfix">
								<div class="input-item">
									<i class="iconfont">&#xe633;</i>
									<input id="yanzhengma" type="text" placeholder="验证码">
								</div>
								<!-- <span class="check-code">XD34F</span> -->
								<img id="img" src="<%=request.getContextPath() %>/authImage" onclick="javascript:changeImg()"/>
							</div>
							<div class="tips clearfix">
								<label><input id="remUsername" type="checkbox">记住用户名</label>
								<a href="javascript:resetPassword();" class="forget-pwd" style="margin-right:30px">忘记密码？</a>
							</div>
							<div class="enter" style="padding-left:110px;">
								<!-- <a href="javascript:adminCheck(0)" class="purchaser" >管理员</a> -->
								<a href="javascript:adminCheck(1)" class="supplier">登录</a>
							</div>
						</form>
					</div>
				</div>
				<div class="lg-poster"></div>
			</div>
		</div>
	</div>
	<div class="login-ft">
		<div class="ft-inner">
			<div class="about-us">
				<a href="javascript:;">关于我们</a>
				<a href="javascript:;">法律声明</a>
				<a href="javascript:;">服务条款</a>
				<a href="javascript:;">联系方式</a>
			</div>
			<div class="address">地址：xx省xx市xx区xx&nbsp;邮编：******&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2017&nbsp;-&nbsp;2018&nbsp;xy&nbsp;版权所有</div>
			<div class="other-info">建议使用IE8及以上版本浏览器&nbsp;xx省&nbsp;yyyyyyyy号&nbsp;E-mail：xxxxxxxxxx@xx.com</div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	$(function(){  
		$("#promptBox").hide();
		changeImg();
		writeName();
		verCodekeydown();
	}); 
	function adminCheck(ID){
		remName();
		var zhanghao = $("#zhanghao").val();
		if(isEmpty(zhanghao)){
			$("#promptBox").show();
			$("#errorInfo").text("请输入正确的账号");
			return;
		}
		var mima = $("#mima").val();
		if(isEmpty(mima)){
			$("#promptBox").show();
			$("#errorInfo").text("请输入正确的密码");
			return;
		}
		var yanzhengma = $("#yanzhengma").val();
		if(isEmpty(yanzhengma)){
			$("#promptBox").show();
			$("#errorInfo").text("请输入正确的验证码");
			return;
		}
		var str =new Array;
		str.push(zhanghao);
		str.push(mima);
		str.push(yanzhengma);
		$.ajax({
		      type:"post",
		      url: "check.action",
		      data: {
		    	  "str":str
		      },
		      traditional: true,
		      dataType: "json",
		      success: function(result){
		    	  var result = result["result"];
		    	  //console.log(result.res);
		    	  var res = result.res;
		    	  if(res == "-2"){
		    		  $("#promptBox").show();
		    	   	  $("#errorInfo").text("验证码错误");
		    	   	  return;  
		    	  }
	    	   	  if(res == "0"){
	    	   		$("#promptBox").show();
	    	   		$("#errorInfo").text("用户名不存在");
	    	   		return;
	    	   	  }else if(res == "-1"){
	    	   		$("#promptBox").show();
	    	   		$("#errorInfo").text("密码错误");
	    	   		return;
	    	   	  }else if(res == "1"){
	    	   		$("#promptBox").show().css({"background":"#eefce8","color":"#1cc750","border-color":"#1cc750"});
	    	   		$("#errorInfo").text("登陆成功");
	    	   		$.ajax({
	    	  	      type:"post",
	    	  	      url: "getJSPbyUsername.action",
	    	  	      data: {
	    	  	    	  "username":zhanghao
	    	  	      },
	    	  	      //traditional: true,
	    	  	      dataType: "json",
	    	  	      success: function(result){
	    	  	    	   console.log(result);
	    	  	      	}
	    	  		});
	    	   		var ID = result.dbpower;
	    	   		//if(ID == "super"){
	    	   			setTimeout("document.location.href ='main.jsp'",0);
	    	   		//}else if(ID == "admin"){
	    	   			//setTimeout("document.location.href ='employee.jsp'",0);
	    	   		//}
	    	   	  }
	    	     
			},
			error : function() {
			}
		});
	
	}
	
	function changeImg(){
		$("#yanzhengma").val("");
        var img = document.getElementById("img"); 
        img.src = "<%=request.getContextPath() %>/authImage?date=" + new Date();;
    }
	
	function verCodekeydown(){
		$("#yanzhengma").keydown(function(event) {    
            if (event.keyCode == 13) {    
            	adminCheck(0);    
            }    
        });
	}
	
	function remName(){
		var storage = window.localStorage;
		if($("#remUsername").is(':checked')){
		 	//存储到loaclStage
			storage["zhanghao"] = $("#zhanghao").val();
			storage["mima"] = $("#mima").val();
			storage["isstorename"] =  "yes"; 
		}else{
			storage["zhanghao"] = "";
			storage["mima"] = "";
			storage["isstorename"] =  "no"; 
		}
	}
	function writeName(){
		var storage = window.localStorage;
		if("yes" == storage["isstorename"]){
			$("#remUsername").attr("checked", true);
			$("#zhanghao").val(storage["zhanghao"]);
			$("#mima").val(storage["mima"]);
		}
	}
	
	function resetPassword(){
		//sqikoo.dialog.alert("请联系超级管理员！");
		qikoo.dialog.confirm('管理员请联系超级管理员修改!<br>超级管理员请按确定进行下一步!',function(){
			document.location.href ='../h5/modify.jsp';
        },function(){
	    });
	}

	function isEmpty(message){
		return  message=="" || message==null || message==undefined ;
	}
	
</script>
