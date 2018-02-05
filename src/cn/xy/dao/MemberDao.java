package cn.xy.dao;

import java.util.List;

public interface MemberDao {

	List getMemberList() throws Exception;
	List getMemberByInput(String[] str) throws Exception;
	List getMemberById(String id) throws Exception;
	void updateMember(String[] str) throws Exception;
	void delMember(String id) throws Exception;
	void addMember(String id, String[] str) throws Exception;
}
