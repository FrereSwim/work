package cn.xy.action;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.xy.utils.VerifyCodeUtils;

public class AuthImage extends HttpServlet implements Servlet {
	static final long serialVersionUID = 1L; 
    //生成随机字串 
    @Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        response.setContentType("image/jpeg");
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5); 
        //存入会话session 
        HttpSession session = request.getSession(true); 
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //生成图片 
        int w = 115, h = 40; 
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
	
}
