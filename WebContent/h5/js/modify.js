(function (doc, win) {
	    var docEl = doc.documentElement,
	      resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
	      recalc = function () {
	        var clientWidth = docEl.clientWidth;
	        if (!clientWidth) return;
	        docEl.style.fontSize = 20 * (clientWidth / 320) + 'px';
	      };
	
	    if (!doc.addEventListener) return;
	    win.addEventListener(resizeEvt, recalc, false);
	    doc.addEventListener('DOMContentLoaded', recalc, false);
	  })(document, window);
	
	/* function getEmailCode(){
	} */
	//判断验证码能够获取，发送验证码
	var countdown = 60;
	var clickTime;
	function getEmailCode(){
		//console.log(verCode);
		var str =new Array;
		var email = $("#email").val();
		var username = $("#username").val();
		str.push(username);
		str.push(email);
		$.ajax({
		      type:"post",
		      url: "getEmailCode.action",
		      data: {
		    	  "str":str 
		      },
		      traditional: true,
		      dataType: "json",
		      success: function(result){
		    	  var res = result["result"];
		    	  switch(res){
		    	  case "-1": $("#username_div").attr("style","border: 1px solid red;");
	    		  			 $("#email_div").attr("style","border: 1px solid red;");
	    		 			 errHtml("用户名与邮箱信息不一致，请确认后重新填写");
	    		  			 return;
		    	  case "0": $("#username_div").attr("style","border: 1px solid red;");
		  			 		$("#email_div").attr("style","border: 1px solid red;");
		    		  		errHtml("获取验证码失败");
		    	  			return;
		    	  case "1": $("#username_div").attr("style","");
		    	 		    $("#email_div").attr("style","");
		    	 		    errHtml("");
		    	 		    getEmailCodeText();
		    	 		    var myDate = new Date();
		    	 		    clickTime = myDate.getTime();
		    	 		    //console.log(clickTime);
		    	  }
		      },
			  error : function() {
				  alert("获取失败");
			  }
         });
	}
	//倒计时
	function getEmailCodeText() {
	if (countdown == 0) { 
		$("#getVerCode").removeAttr("disabled");
		$("#btnFont").text("获取");
		countdown = 60; 
		return true;
	}else{ 
		$("#getVerCode").attr("disabled","true");
		$("#btnFont").text(countdown + "s");
		//console.log(countdown);
		countdown--; 
	} 
	setTimeout(function() { 
		getEmailCodeText() 
	},1000); 
	}
	//确认提交
	function btnCommit(){
		var username = $("#username").val();
		var email = $("#email").val();
		var verCode = $("#verCode").val();
		var newPassword = $("#newPassword").val();
		var newPassword2 = $("#newPassword2").val();
		if(isEmpty(username)){
			$("#username_div").attr("style","border: 1px solid red;");
			return;
		}else{
			$("#username_div").attr("style","");
		}
		if(isEmpty(email)){
			$("#email_div").attr("style","border: 1px solid red;");
			return;
		}else{
			$("#email_div").attr("style","");
		}
		if(isEmpty(verCode)){
			$("#verCode_div").attr("style","border: 1px solid red;");
			return;
		}else{
			$("#verCode_div").attr("style","");
		}
		if(isEmpty(newPassword)){
			$("#newPassword_div").attr("style","border: 1px solid red;");
			return;
		}else{
			$("#newPassword_div").attr("style","");
		}
		if(isEmpty(newPassword2)){
			$("#newPassword2_div").attr("style","border: 1px solid red;");
			return;
		}else{
			$("#newPassword2_div").attr("style","");
		}
		if(newPassword != newPassword2){
			$("#newPassword2_div").attr("style","border: 1px solid red;");
			errHtml("两次密码不一致");
			return;
		}else{
			errHtml("");
		}
		var myDate = new Date();
		var comTime = myDate.getTime();
		if(comTime - clickTime > 60000){
			$("#verCode_div").attr("style","border: 1px solid red;");
			errHtml("验证码已过期，请重新获取");
		}
		var str = new Array();
		str.push(verCode);
		str.push(username);
		str.push(newPassword);
		$.ajax({
		      type:"post",
		      url: "updatePassword.action",
		      data: {
		    	  "str":str 
		      },
		      traditional: true,
		      dataType: "json",
		      success: function(result){
		    	  var res = result["result"];
		    	  switch(res){
		    	  case "-1":  $("#verCode_div").attr("style","border: 1px solid red;");
		 					  errHtml("验证码错误");
		  					  return;
		    	  case "0":   $("#verCode_div").attr("style","");
		    		  		  errHtml("网络异常，修改失败");
					  		  return;
		    	  case "1":   $("#verCode_div").attr("style","");
		    	  			  //$("#btnCommit").attr("onclick","false");
		    	  			  $("#btnCommit").hide();
		    	  			  var html = "提交成功，5秒后" + "<a href='../page/login.jsp'>" + "跳转到登录页面。。。" + "</a>";
		    	  			  successHtml(html);
		    	  			  setTimeout("document.location.href ='../page/login.jsp'",5000);
		    	  }
		      }
		});
		
	}
	//错误提示框
	function errHtml(valtxt){
		$("#err").html("<text style='color:red'>" + valtxt + "</text>");
	}
	function successHtml(valtxt){
		$("#err").html("<text style='color:green'>" + valtxt + "</text>");
	}
	
	function isEmpty(message){
		return  message=="" || message==null || message==undefined ;
	}
	
    function back(){
    	history.back();
    }