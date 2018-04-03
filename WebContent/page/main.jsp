<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>酒店信息管理系统</title> 
	<link href="css/base.css" rel="stylesheet">
	<link href="css/platform.css" rel="stylesheet">
	<link rel="stylesheet" href="../custom/uimaker/easyui.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/new.js" type="text/javascript"></script>
	
	
	<style type="text/css">
		
	</style>
</head> 
<body>
    <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img src="images/main/main_logo.png" alt="logo">
            </div>
            
            <div class="pf-nav-wrap">
              <div class="pf-nav-ww">
                <ul id="menu_ul" class="pf-nav">
                </ul>
              </div>
              <a href="javascript:;" class="pf-nav-prev disabled iconfont">&#xe606;</a>
              <a href="javascript:;" class="pf-nav-next iconfont">&#xe607;</a>
            </div>

            <div class="pf-user">
                <div class="pf-user-photo">
                    <img src="images/main/user.png" alt="">
                </div>
                <h4 class="pf-user-name ellipsis">${username }</h4>
                <i class="iconfont xiala">&#xe607;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:;">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                        <li class="pf-modify-pwd">
                            <a href="../h5/modify.jsp">
                                <i class="iconfont">&#xe634;</i>
                                <span class="pf-opt-name">修改密码</span>
                            </a>
                        </li>
                        <li class="pf-logout">
                            <a href="javascript:logout()">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>

        <div id="pf-bd">
            <div id="pf-sider">
                <h2 class="pf-model-name">
                    <span class="iconfont">&#xe64a;</span>
                    <span class="pf-name">首页</span>
                    <span class="toggle-icon"></span>
                </h2>

                <ul class="sider-nav">
                     <li class="current">
                        <a href="javascript:;">
                            <span class="iconfont sider-nav-icon">&#xe620;</span>
                            <span class="sider-nav-title">欢迎登录本系统！</span>
                            <i class="iconfont">&#xe642;</i>
                        </a>
                     </li>
                 </ul> 
            </div>

            <div id="pf-page">
                <div id="easyui-tabs1" class="easyui-tabs1" style="width:100%;height:100%;">
                  <div title="工作台" style="padding:10px 5px 5px 10px;">
                    <iframe id="iframe" class="page-iframe" src="workbench.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="酒店简介" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="introduction.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="系统简介" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="sysIntro.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="警示语" style="padding:10px 5px 5px 10px;" data-options="closable:true">
                    <iframe class="page-iframe" src="demo.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                    </div>
                  <!-- <div title="基本信息" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="basic_info.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="供应商" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="providers.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="业务流程" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="process.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="表单管理" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="providers1.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div> -->
                  
                </div>
            </div>
        </div>

        <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>信息管理系统&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>createDay&nbsp;2017/11&nbsp;&nbsp;XY&nbsp;版权所有</span>
              <i class="iconfont" >&#xe6ff;</i>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="../custom/jquery.min.js"></script>
    <script type="text/javascript" src="../custom/jquery.easyui.min.js"></script>
    <!-- <script type="text/javascript" src="js/menu.js"></script> -->
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/showMenu.js"></script>
    <!--[if IE 7]>
      <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
        
      </script>
    <![endif]-->  

    
<script type="text/javascript">
    $('.easyui-tabs1').tabs({
      tabHeight: 44,
      onSelect:function(title,index){
        var currentTab = $('.easyui-tabs1').tabs("getSelected");
        if(currentTab.find("iframe") && currentTab.find("iframe").size()){
            currentTab.find("iframe").attr("src",currentTab.find("iframe").attr("src"));
        }
      }
    })
    $(window).resize(function(){
          $('.tabs-panels').height($("#pf-page").height()-46);
          $('.panel-body').height($("#pf-page").height()-76)
    }).resize();

    var page = 0,
        pages = ($('.pf-nav').height() / 70) - 1;

    if(pages === 0){
      $('.pf-nav-prev,.pf-nav-next').hide();
    }
    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){


      if($(this).hasClass('disabled')) return;
      if($(this).hasClass('pf-nav-next')){
        page++;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == pages){
          $(this).addClass('disabled');
          $('.pf-nav-prev').removeClass('disabled');
        }else{
          $('.pf-nav-prev').removeClass('disabled');
        }
        
      }else{
        page--;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == 0){
          $(this).addClass('disabled');
          $('.pf-nav-next').removeClass('disabled');
        }else{
          $('.pf-nav-next').removeClass('disabled');
        }
        
      }
    })
	
	$(".sider-nav-s li").click(function(){
		$(".sider-nav-s li").attr("class","");
		//$(this).siblings().attr("class","");
		$(this).attr("class","active");
	});	
	
	$(document).ready(function(){
		inti();
		
	});
	
	function inti(){
		var power = "<%=session.getAttribute("power")%>";
		var username = "<%=session.getAttribute("username")%>";
		if(power == 'super'){
			showSuperMenu();
		}else{
			showAdminMenu(username);
		}
	}
	/* function add(){
		alert("aa");
		var html = "<li class='pf-nav-item manger' data-menu='pur-source'><a href='login.jsp'><span class='iconfont'>&#xe64c;</span><span class='pf-nav-title'>酒店管理</span></a></li>"
		$(".pf-nav").append(html);
	} */
    // setTimeout(function(){
    //    $('.tabs-panels').height($("#pf-page").height()-46);
    //    $('.panel-body').height($("#pf-page").height()-76)
    // }, 200)
    </script>
</body> 
</html>

