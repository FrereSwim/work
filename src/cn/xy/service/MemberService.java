package cn.xy.service;

import java.util.List;

public interface MemberService {
	
	List getMemberList() throws Exception;
	List getMemberByInput(String[] str) throws Exception;
	List getMemberById(String id) throws Exception;
	void updateMember(String[] str) throws Exception;
	void delMember(String id) throws Exception;
	void addMember(String[] str) throws Exception;

}
