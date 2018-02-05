package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.memberBean.MemberInfo;
import cn.xy.service.MemberService;
import cn.xy.utils.JSONResult;

public class MemberAction extends ActionSupport {
	
	private String[] str;
	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public void getMemberList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List memberList = memberService.getMemberList();
		jSONResult.jsonResult("memberList", memberList);
	} 
	
	public void getMemberByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List memberList = memberService.getMemberByInput(str);
		jSONResult.jsonResult("memberList", memberList);
	} 
	
	public void getMemberById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = memberService.getMemberById(id);
		MemberInfo member = (MemberInfo) list.get(0);
		jSONResult.jsonResult("member", member);
	} 
	
	public void updateMember() throws Exception{
		JSONResult jSONResult = new JSONResult();
		memberService.updateMember(str);
		jSONResult.jsonResult("result", true);
	} 
	
	public void delMember() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		memberService.delMember(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addMember() throws Exception{
		JSONResult jSONResult = new JSONResult();
		memberService.addMember(str);
		jSONResult.jsonResult("result", true);
	} 
	

}
