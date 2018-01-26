package cn.xy.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class JSONResult {
	
	private String result;
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
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
