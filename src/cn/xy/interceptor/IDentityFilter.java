package cn.xy.interceptor;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xy.action.AuthorityAction;
import cn.xy.bean.Authority;
import cn.xy.utils.AuthorityUtils;

public class IDentityFilter implements Filter {
	
	protected FilterConfig filterConfig = null;    
	private String redirectURL = null;    
	private Set<String> commonURLList = new HashSet<String>();
	private Set<String> notCheckURL = new HashSet<String>();
	private String sessionKey = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		commonURLList.clear();
		notCheckURL.clear();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;    
	    HttpServletResponse response = (HttpServletResponse) servletResponse;    
	    HttpSession session = request.getSession();    
	    if (sessionKey == null) {    
	      filterChain.doFilter(request, response);    
	      return;    
	    }
	    String p = (String)session.getAttribute("power");
	    if(p != null && p.equals("admin")){
		    try {
				getAuthority(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    boolean a = checkRequestURIIntNotFilterList(request);
		    boolean b =  checkURIFilterList(request);
	    	if (!a && !b) {
		    	response.sendRedirect(request.getContextPath() + redirectURL);    
		        return;
		    }
	    }
	    filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		this.filterConfig = filterConfig;    
	    redirectURL = filterConfig.getInitParameter("redirectURL");    
	    sessionKey = filterConfig.getInitParameter("checkSessionInfo");    
	    //String commonURLListstr = filterConfig.getInitParameter("commonURLList");
	    String notCheckURLStr = filterConfig.getInitParameter("notCheckURL");
	    if (notCheckURLStr != null) {    
	      //System.out.println(notCheckURLListStr);    
	      String[] params1 = notCheckURLStr.split(",");    
	      for (int i = 0; i < params1.length; i++) {    
	    	  notCheckURL.add(params1[i].trim());    
	      }    
	    }
	    
	}
	
	
	public void getAuthority(ServletRequest servletRequest) throws Exception{
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(username != null){
		    List<Authority> list = (List<Authority>)session.getAttribute("authority");
			if(list != null){
				Authority obj = list.get(0);
				AuthorityUtils authorityUtils = new AuthorityUtils();
				List<String> JSPList = authorityUtils.getAuthorityJSP(obj);
				for(int i = 0; i < JSPList.size(); i++){
					String a = "/page/" + JSPList.get(i);
					commonURLList.add(a);
				}
			}
		}
	}

	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {    
	    String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());    
	    String temp = request.getRequestURI();  
	    temp = temp.substring(request.getContextPath().length() + 1);    
	    return notCheckURL.contains(uri);    
	  }
	
	private boolean checkURIFilterList(HttpServletRequest request) {    
	    String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());    
	    String temp = request.getRequestURI();  
	    temp = temp.substring(request.getContextPath().length() + 1);    
	    return commonURLList.contains(uri);    
	  }
	
}
