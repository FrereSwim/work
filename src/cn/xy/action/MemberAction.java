package cn.xy.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.service.MemberService;

public class MemberAction extends ActionSupport {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	

}
