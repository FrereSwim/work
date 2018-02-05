package cn.xy.service;

import java.util.List;

public interface MemberService {
	
	List getMemberList() throws Exception;
	List getMemberByInput(String[] str) throws Exception;
	List getMemberById(String id) throws Exception;
	void updateMember(String[] str) throws Exception;
	void delMember(String id) throws Exception;
	void addMember(String[] str) throws Exception;
	
	List getMemActList() throws Exception;
	List getMemActByInput(String[] str) throws Exception;
	List getMemActById(String id) throws Exception;
	void updateMemAct(String[] str) throws Exception;
	void delMemAct(String id) throws Exception;
	void addMemAct(String[] str) throws Exception;

}
