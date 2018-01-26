<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>密码修改</title>
        <link rel="stylesheet" href="fonts/iconfont.css"/>
        <link rel="stylesheet" href="css/font.css"/>
        <link rel="stylesheet" href="css/weui.min.css"/>
        <link rel="stylesheet" href="css/jquery-weui.min.css"/>
        <link rel="stylesheet" href="css/mui.css"/>
        <link rel="stylesheet" href="css/animate.css"/>
        <link rel="stylesheet" href="css/pages/modify.css"/>
        <link rel="stylesheet" href="css/new.css"/>
        <script type="text/javascript" src="../custom/jquery.min.js"></script>
    	<script type="text/javascript" src="../custom/jquery.easyui.min.js"></script>
    	<script type="text/javascript" src="js/modify.js"></script>
        <style type="text/css">
        body{TEXT-ALIGN: center;}
		</style>
    </head>
    
    
<body>
	<img style="position:absolute;left:0px;top:0px;width:100%;height:100%;z-Index:-1; border:1px solid blue" src="images/1.jpg" />
    <header>
        <div class="titlebar reverse" style="width:32%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <a href="javascript:back()">
                <i class="iconfont">&#xe640;</i>
            </a>
            <h1>密码修改</h1>
        </div>
    </header>
    <article style="bottom: 54px;">
        <div>
                <div class="weui_cell tip">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>用户名</p>
                    </div>
                </div>
        </div>
        <div class="weui_cell password" style="width:30%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div id="username_div" class="weui_cell_bd weui_cell_primary password">
                <input id="username" class="weui_input" type="password" placeholder="请输入用户名">
            </div>
        </div>
        <div >
                <div class="weui_cell tip">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>邮箱</p>
                    </div>
                </div>
        </div>
        <div class="weui_cell password" style="width:30%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div id="email_div" class="weui_cell_bd weui_cell_primary password">
                <input id="email" class="weui_input" type="text" placeholder="请输入绑定的邮箱">
            </div>
            <div style="padding-left:10px">
            	<!-- <button id="getVerCode" type="button" class="shit"><font id="btnFont" color="#ffffff">验证码</font></button> -->
            	<button id="getVerCode"  onclick="getEmailCode()" type="button" class="shit"><font id="btnFont" color="#ffffff">验证码</font></button>
           
            </div>
	        <!-- <div id="getCode" href="javascript:getEmailCode();" class="weui_btn weui_btn_mini weui_btn_primary">获取验证码</div> -->
        </div>
        <div>
                <div class="weui_cell tip">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>验证码</p>
                    </div>
                </div>
        </div>
        <div class="weui_cell password" style="width:30%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div id="verCode_div" class="weui_cell_bd weui_cell_primary password">
                <input id="verCode" class="weui_input" type="text" placeholder="请输入收到的邮箱验证码">
            </div>
        </div>
        <div>
                <div class="weui_cell tip">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>新密码</p>
                    </div>
                </div>
        </div>
        <div class="weui_cell password" style="width:30%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div id="newPassword_div" class="weui_cell_bd weui_cell_primary password" >
                <input id="newPassword" class="weui_input"  type="password" placeholder="请输入新密码">
            </div>
        </div>
        <div>
                <div class="weui_cell tip">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p>新密码确认</p>
                    </div>
                </div>
        </div>
        <div class="weui_cell password" style="width:30%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div id="newPassword2_div" class="weui_cell_bd weui_cell_primary password" >
                <input id="newPassword2" class="weui_input" type="password" placeholder="请再次输入新密码" >
            </div>
        </div>
        <div id="err"></div>
        <div class="button" style="width:32%;MARGIN-RIGHT: auto;MARGIN-LEFT: auto;">
            <div class="bd">
                <a id="btnCommit" href="javascript:btnCommit();" class="weui_btn weui_btn_primary">确认</a>
            </div>
        </div>
        
    </article>
   
</body>
</html>
<script type="text/javascript">
	
</script>