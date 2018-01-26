package cn.xy.service;

import java.util.List;

import cn.xy.bean.Authority;
import cn.xy.bean.User;
import cn.xy.dao.SystemDao;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class SystemServiceImpl implements SystemService {
	
	private SystemDao systemDao;
	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}
	
	@Override
	public List getAdminList(String power) throws Exception {
		List userList = systemDao.getAdminList(power);
		return userList;
	}
	
	@Override
	public List getAdminListByIdAndName(String power, String uid, String username) throws Exception {
		return systemDao.getAdminListByIdAndName(power, uid, username);
	}
	
	@Override
	public List getAdminList(String power, String uid, String username) throws Exception {
		return systemDao.getAdminList(power, uid, username);
	}
	@Override
	public List getAdminList() throws Exception {
		return systemDao.getAdminList();
	}
	@Override
	public List getAdminById(String id) throws Exception {
		return systemDao.getAdminById(id);
	}
	@Override
	public void updateAdmin(String[] str) throws Exception {
		systemDao.updateAdmin(str);
	}

	@Override
	public void delAdmin(String id) throws Exception {
		systemDao.delAdmin(id);
	}

	@Override
	public void updateAuthority(String[] str, String[] info) throws Exception {
		systemDao.updateAuthority(str, info);
	}

	@Override
	public List getAuthorityById(String id) throws Exception {
		return systemDao.getAuthorityById(id);
	}

	@Override
	public void addAdmin(String[] str,String[] info) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.USER_ID_PREFIX,8);
		
		User user = new User();
		user.setUid(id);
		user.setUsername(str[0]);
		user.setPassword(str[1]);
		user.setEmail(str[2]);
		user.setPhone(str[3]);
		user.setPower(str[4]);
		
		Authority authority = new Authority();
		authority.setId(id);
		authority.setUsername(str[0]);
		authority.setMain(info[0]);
		authority.setSystem(info[1]);
		authority.setEmployee(info[2]);
		authority.setMenu(info[3]);
		authority.setRoom(info[4]);
		authority.setMember(info[5]);
		authority.setWarehouse(info[6]);
		authority.setFinance(info[7]);
		authority.setHotel(info[8]);
		
		systemDao.addAdmin(user, authority);
	}

	@Override
	public List getPendingList() throws Exception {
		return systemDao.getPendingList();
	}

	@Override
	public List getPendingByInput(String type, String state, String title) throws Exception {
		return  systemDao.getPendingByInput(type, state, title);
	}

	@Override
	public void delPending(String id) throws Exception {
		systemDao.delPending(id);
	}

	@Override
	public List getPendingById(String id) throws Exception {
		return systemDao.getPendingById(id);
	}

	@Override
	public void updateOverTime(String id) throws Exception {
		systemDao.updateOverTime(id);		
	}

	@Override
	public void updateState(String id) throws Exception {
		systemDao.updateState(id);		
	}

	@Override
	public List getWarningList() throws Exception {
		return systemDao.getWarningList();
	}

	@Override
	public List getWarningByInput(String type, String level) throws Exception {
		return  systemDao.getWarningByInput(type, level);
	}

	@Override
	public void delWarning(String id) throws Exception {
		systemDao.delWarning(id);		
	}

	@Override
	public List getWarningById(String id) throws Exception {
		return systemDao.getWarningById(id);
	}

	@Override
	public void updateLevel(String id) throws Exception {
		systemDao.updateLevel(id);
	}

	@Override
	public List getMailList() throws Exception {
		return systemDao.getMailList();
	}

	@Override
	public List getMailByInput(String sendName, String title) throws Exception {
		return  systemDao.getMailByInput(sendName, title);
	}

	@Override
	public void delMail(String id) throws Exception {
		systemDao.delMail(id);
	}

	@Override
	public List getMailById(String id) throws Exception {
		return systemDao.getMailById(id);
	}

	@Override
	public List getPartnerList() throws Exception {
		return systemDao.getPartnerList();
	}

	@Override
	public void delPartnerInfo(String id) throws Exception {
		systemDao.delPartnerInfo(id);
	}

	@Override
	public List getPartnerById(String id) throws Exception {
		return systemDao.getPartnerById(id);
	}

	@Override
	public void updatePartnerInfo(String[] str) throws Exception {
		systemDao.updatePartnerInfo(str);
	}

	@Override
	public void addPartnerInfo(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.PARTNER_ID_PREFIX,8);
		str[0] = id;
		systemDao.addPartnerInfo(str);
	}

	@Override
	public List getInformList() throws Exception {
		return systemDao.getInformList();
	}

	@Override
	public List getInformByInput(String title, String type) throws Exception {
		return systemDao.getInformByInput(title, type);
	}

	@Override
	public void delInformInfo(String id) throws Exception {
		systemDao.delInformInfo(id);
	}

	@Override
	public List getWinnersList() throws Exception {
		return systemDao.getWinnersList();
	}

	@Override
	public void adduploadFile(String id, String fileName, String uploadName, String showName, String fileType, String day) throws Exception {
		systemDao.adduploadFile(id, fileName, uploadName, showName, fileType, day);
	}

	@Override
	public List getFileList(String type) throws Exception {
		return systemDao.getFileList(type);
	}

	@Override
	public List getFileByshowName(String type, String showName) throws Exception {
		return systemDao.getFileByshowName(type, showName);
	}

	@Override
	public void updateFile(String id, String showName) throws Exception {
		systemDao.updateFile(id, showName);
	}

	@Override
	public void delFile(String id) throws Exception {
		systemDao.delFile(id);
	}

	
	
	

}
