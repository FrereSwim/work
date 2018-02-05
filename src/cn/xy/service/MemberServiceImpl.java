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

}
