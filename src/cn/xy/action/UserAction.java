package cn.xy.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.User;
import cn.xy.service.UserService;
import cn.xy.utils.ExportExcel;
import cn.xy.utils.VerifyCodeUtils;
import net.sf.json.JSONObject;

public class UserAction extends ActionSupport {
	
	private String str[];
	private String result;
	public String[] getStr() {
		return str;
	}
	public void setStr(String[] str) {
		this.str = str;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//登录判断
	public String check() throws Exception {
		String username = str[0];
		String password = str[1];
		String verCode  = str[2].toLowerCase();
		String res = "";
		Map result = new HashMap();
		HttpServletRequest request = ServletActionContext.getRequest();
		String sessionVerCode = (String) request.getSession().getAttribute("verCode");
		//获取user对象
		List<User> userList = userService.checkLogin(username);
		if(userList.isEmpty()){
			res = "0";
		}else if(!verCode.equals(sessionVerCode)){
			res = "-2";
		}else{
			String dbpassword = userList.get(0).getPassword();
			if(password.equals(dbpassword)){
				res =  "1";
				request.getSession().setAttribute("username", username);
				String dbpower = userList.get(0).getPower();
				request.getSession().setAttribute("power", dbpower);
				result.put("dbpower", dbpower);
				//jsonResult("dbpower",dbpower);
			}else{
				res =  "-1";
			}
		}
		result.put("res", res);
		jsonResult("result",result);
		return SUCCESS;
	}
	
	//登出逻辑
	public String logout() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("username");
		jsonResult("result","0");
		return SUCCESS;
	}
	
	//获取邮箱验证码
	public void getEmailCode() throws  Exception{
		String username = str[0];
		String email = str[1];
		String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
		boolean checkEmail = checkEmail(username, email);//一致为true
		if(checkEmail){
			System.out.println(verifyCode);
			//发送验证码  
			/*boolean sendresult = sendEmail.sendEmail(email, verifyCode);
			if(!sendresult){
				jsonResult("result","0");
				return;
			}*/
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("verifyCode", verifyCode);
			jsonResult("result","1");
			
		}
		jsonResult("result","-1");
		return;
		
	}
	//判断输入的用户名邮箱信息与数据库是否一致
	public boolean checkEmail(String username, String email) throws Exception{
		boolean checkResult = userService.checkEmail(username, email);
		return checkResult;
	}
	
	//提交密码修改申请
	public void updatePassword() throws Exception{
		String userVerifyCode = str[0];//用户填写的验证码
		String username = str[1];//用户填写的用户名
		String newPassword = str[2];//用户填写的新密码
		HttpServletRequest request = ServletActionContext.getRequest();
		String verifyCode = (String) request.getSession().getAttribute("verifyCode");//系统发送的验证码
		if(!userVerifyCode.equals(verifyCode)){
			jsonResult("result","-1");
			return;
		}else{
			if(userService.updatePassword(username, newPassword)){//修改成功
				jsonResult("result","1");
			}else{
				jsonResult("result","0");
			}
		}
	}
	
	//json格式方法
	public void jsonResult(String key,Object value){
		JSONObject json = new JSONObject();
		json.element(key, value);
		result = json.toString();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(result);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
