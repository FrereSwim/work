package cn.xy.service;

import java.util.List;

import cn.xy.dao.MemberDao;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Override
	public List getMemberList() throws Exception {
		return memberDao.getMemberList();
	}
	@Override
	public List getMemberByInput(String[] str) throws Exception {
		return memberDao.getMemberByInput(str);
	}
	@Override
	public List getMemberById(String id) throws Exception {
		return memberDao.getMemberById(id);
	}
	@Override
	public void updateMember(String[] str) throws Exception {
		memberDao.updateMember(str);
	}
	@Override
	public void delMember(String id) throws Exception {
		memberDao.delMember(id);
	}
	@Override
	public void addMember(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.MEMBER_ID_PREFIX,8);
		memberDao.addMember(id, str);
	}
	
	@Override
	public List getMemActList() throws Exception {
		return memberDao.getMemActList();
	}
	@Override
	public List getMemActByInput(String[] str) throws Exception {
		return memberDao.getMemActByInput(str);
	}
	@Override
	public List getMemActById(String id) throws Exception {
		return memberDao.getMemActById(id);
	}
	@Override
	public void updateMemAct(String[] str) throws Exception {
		memberDao.updateMemAct(str);
	}
	@Override
	public void delMemAct(String id) throws Exception {
		memberDao.delMemAct(id);
	}
	@Override
	public void addMemAct(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.MEMACT_ID_PREFIX,8);
		memberDao.addMemAct(id, str);
	}

}
