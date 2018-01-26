package cn.xy.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		String username = (String) ServletActionContext.getRequest().getSession().getAttribute("username");
		if(username == null){
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();  
            actionSupport.addActionError("您还没有登录，请先进行登录！");  
            return "loginFail";
		}else{
			return actionInvocation.invoke();
		}
	}

}
