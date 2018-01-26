package cn.xy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.Authority;
import cn.xy.service.AuthorityService;
import cn.xy.utils.AuthorityUtils;
import cn.xy.utils.JSONResult;

public class AuthorityAction extends ActionSupport {
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	private AuthorityService authorityService;
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	
	//根据用户名获取对应的权限
	public void getJSPbyUsername() throws Exception{
		List<Authority> list =  authorityService.getAuthoritybyUsername(username);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("authority", list);
	}
	
	//根据用户名获取对应的显示JSP
	public void getJSP() throws Exception{
		List<Authority> list =  authorityService.getAuthoritybyUsername(username);
		/*AuthorityUtils authorityUtils = new AuthorityUtils();
		List list1 = new ArrayList();
		int len = list.size();
		for(int i = 0; i < len; i++){
			list1 = authorityUtils.getAuthorityJSP(list.get(i));
		}*/
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("authority", list);
	}
}
