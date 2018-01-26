var username;

function showSuperMenu(){
	var str = "<li id='main' class='pf-nav-item home' data-menu='sys-manage'><a href='main.jsp'><span class='iconfont'>&#xe620;</span><span class='pf-nav-title'>--首页--</span></a></li>";
		str += "<li id='system' class='pf-nav-item home' data-menu='sys-manage'><a href='system.jsp'><span class='iconfont'>&#xe63f;</span><span class='pf-nav-title'>系统管理</span></a></li>";
		str += "<li id='employee' class='pf-nav-item home' data-menu='org-manage'><a href='employee.jsp'><span class='iconfont'>&#xe60d;</span><span class='pf-nav-title'>员工管理</span></a></li>";
		str += "<li id='menu' class='pf-nav-item home' data-menu='main-data'><a href='menu.jsp'><span class='iconfont'>&#xe61e;</span><span class='pf-nav-title'>菜单管理</span></a></li>";
		str += "<li id='room' class='pf-nav-item home' data-menu='supplier-mange'><a href='room.jsp'><span class='iconfont'>&#xe64b;</span><span class='pf-nav-title'>客房管理</span></a></li>";
		str += "<li id='member' class='pf-nav-item home' data-menu='supplier-dev'><a href='member.jsp'><span class='iconfont'>&#xe646;</span><span class='pf-nav-title'>会员管理</span></a></li>";
		str += "<li id='warehouse' class='pf-nav-item home' data-menu='pur-source'><a href='warehouse.jsp'><span class='iconfont'>&#xe623;</span><span class='pf-nav-title'>仓库管理</span></a></l>";
		str += "<li id='finance' class='pf-nav-item home' data-menu='contract-mange'><a href='finance.jsp'><span class='iconfont'>&#xe625;</span><span class='pf-nav-title'>财务管理</span></a></li>";
		str += "<li id='hotel' class='pf-nav-item home' data-menu='sys-manage'><a href='hotel.jsp'><span class='iconfont'>&#xe64c;</span><span class='pf-nav-title'>酒店管理</span></a></li>";
	$("#menu_ul").html(str);
	
	var strUrl = window.location.href;
	var arrUrl = strUrl.split("/");
	var strPage=arrUrl[arrUrl.length-1];
	var jspName = strPage.split(".");
	var name = jspName[0];
	$("#" + name).addClass("current");
}

function showAdminMenu(username){
	var str = "";
	$.ajax({
	      type:"post",
	      url: "getJSP.action",
	      data: {
	    	  "username":username
	      },
	      //traditional: true,
	      dataType: "json",
	      success: function(result){
	    	   var a = result.authority;
	    	   var main = a[0].main;
	    	   var system = a[0].system;
	    	   var employee = a[0].employee;
	    	   var menu = a[0].menu;
	    	   var room = a[0].room;
	    	   var member = a[0].member;
	    	   var warehouse = a[0].warehouse;
	    	   var finance = a[0].finance;
	    	   var hotel = a[0].hotel;
	    	   
	    	   if(main == "1"){
	    		   str += "<li id='main' class='pf-nav-item home' data-menu='sys-manage'><a href='main.jsp'><span class='iconfont'>&#xe620;</span><span class='pf-nav-title'>--首页--</span></a></li>";
	    	   }
	    	   if(system == "1"){
	    		   str += "<li id='system' class='pf-nav-item home' data-menu='sys-manage'><a href='system.jsp'><span class='iconfont'>&#xe63f;</span><span class='pf-nav-title'>系统管理</span></a></li>";
	    	   }
	    	   if(employee == "1"){
	    		   str += "<li id='employee' class='pf-nav-item home' data-menu='org-manage'><a href='employee.jsp'><span class='iconfont'>&#xe60d;</span><span class='pf-nav-title'>员工管理</span></a></li>";
	    	   }
	    	   if(menu == "1"){
	    		   str += "<li id='menu' class='pf-nav-item home' data-menu='main-data'><a href='menu.jsp'><span class='iconfont'>&#xe61e;</span><span class='pf-nav-title'>菜单管理</span></a></li>";
	    	   }
	    	   if(room == "1"){
	    		   str += "<li id='room' class='pf-nav-item home' data-menu='supplier-mange'><a href='room.jsp'><span class='iconfont'>&#xe64b;</span><span class='pf-nav-title'>客房管理</span></a></li>";
	    	   }
	    	   if(member == "1"){
	    		   str += "<li id='member' class='pf-nav-item home' data-menu='supplier-dev'><a href='member.jsp'><span class='iconfont'>&#xe646;</span><span class='pf-nav-title'>会员管理</span></a></li>";
	    	   }
	    	   if(warehouse == "1"){
	    		   str += "<li id='warehouse' class='pf-nav-item home' data-menu='pur-source'><a href='warehouse.jsp'><span class='iconfont'>&#xe623;</span><span class='pf-nav-title'>仓库管理</span></a></l>";
	    	   }
	    	   if(finance == "1"){
	    		   str += "<li id='finance' class='pf-nav-item home' data-menu='contract-mange'><a href='finance.jsp'><span class='iconfont'>&#xe625;</span><span class='pf-nav-title'>财务管理</span></a></li>";
	    	   }	
	    	   if(hotel == "1"){
	    		   str += "<li id='hotel' class='pf-nav-item home' data-menu='sys-manage'><a href='hotel.jsp'><span class='iconfont'>&#xe64c;</span><span class='pf-nav-title'>酒店管理</span></a></li>";
	    	   }
	    	   
	    	   $("#menu_ul").html(str);
	    	   var strUrl = window.location.href;
	    	   var arrUrl = strUrl.split("/");
	    	   var strPage=arrUrl[arrUrl.length-1];
	    	   var jspName = strPage.split(".");
	    	   var name = jspName[0];
	    	   $("#" + name).addClass("current");
	      }
	});
}


function logout(){
	zdconfirm('退出确认框','是否退出系统',function(r){
	     if(r)
	      {
	    	 $.ajax({
	        		type : "POST",
	    		    url : "userActionLogout.action",
	    		    dataType: "json",
	    		    success: function(result){
	    		    	var res = result["result"];
	    		    	if(res == "0"){
	    		    		document.location.href ="login.jsp";	
	    		    	}
	    		    }
	        	});
	      }
	    });
	
}

