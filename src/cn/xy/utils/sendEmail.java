package cn.xy.utils;

import org.apache.commons.mail.HtmlEmail;

public class sendEmail {

	public static boolean sendEmail(String emailaddress,String code){  
        try {  
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com  
            email.setCharset("UTF-8");  
            email.addTo(emailaddress);// 收件地址  
  
            email.setFrom("xieyongwork@163.com", "admin");//此处填邮箱地址和用户名,用户名可以任意填写  
  
            email.setAuthentication("xieyongwork@163.com", "xxy19951024");//此处填写邮箱地址和客户端授权码  
  
            email.setSubject("邮箱验证码");//此处填写邮件名，邮件名可任意填写  
            email.setMsg("尊敬的管理员您好,您本次获取得的验证码是:    <text style='color:red;font-size:30px'>"
            				+ code + "</text>    此次验证码的有效时间为" + "<text style='color:red;'>" + "60S" + "</text>" + "，请尽快处理。");//此处填写邮件内容  
  
            email.send();  
            return true;  
        }  
        catch(Exception e){  
            e.printStackTrace();  
            return false;  
        }  
    }
	public static void main(String[] args) {
		
		/*boolean a = sendEmail("1454966925@qq.com","123456");
		if(a){
			System.out.println("aaa");
		}*/
		boolean a = sendEmail("1065968095@qq.com","123456");
	}
}
