package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.memberBean.MemActInfo;
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
		if(list.size() == 0) {
			jSONResult.jsonResult("member", "0");
		}else{
			MemberInfo member = (MemberInfo) list.get(0);
			jSONResult.jsonResult("member", member);
		}
		
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
	
	//会员活动管理
	public void getMemActList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List memActList = memberService.getMemActList();
		jSONResult.jsonResult("memActList", memActList);
	} 
	
	public void getMemActByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List memActList = memberService.getMemActByInput(str);
		jSONResult.jsonResult("memActList", memActList);
	} 
	
	public void getMemActById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = memberService.getMemActById(id);
		MemActInfo memAct = (MemActInfo) list.get(0);
		jSONResult.jsonResult("memAct", memAct);
	} 
	
	public void updateMemAct() throws Exception{
		JSONResult jSONResult = new JSONResult();
		memberService.updateMemAct(str);
		jSONResult.jsonResult("result", true);
	} 
	
	public void delMemAct() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		memberService.delMemAct(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addMemAct() throws Exception{
		JSONResult jSONResult = new JSONResult();
		memberService.addMemAct(str);
		jSONResult.jsonResult("result", true);
	}
	

}
