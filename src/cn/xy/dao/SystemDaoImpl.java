package cn.xy.dao;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.Authority;
import cn.xy.bean.DownloadFile;
import cn.xy.bean.InformInfo;
import cn.xy.bean.MailInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.PendingEvent;
import cn.xy.bean.User;
import cn.xy.bean.WarningInfo;
import cn.xy.bean.WinnersInfo;

public class SystemDaoImpl implements SystemDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List getAdminList(String power) throws Exception {
		List<User> list = (List<User>) hibernateTemplate.find("from User where power=?", power);
		return list;
	}

	@Override
	public List getAdminList() throws Exception {
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		return list;
	}
	@Override
	public List getAdminListByIdAndName(String power, String uid, String username) throws Exception {
		String sql = "from User where id != '' and power=?";
		List str = new ArrayList();
		str.add(power);
		if(!uid.equals("")){
			sql += "and uid like ?";
			str.add("%" + uid + "%");
		}
		if(!username.equals("")){
			sql += "and username like ?";
			str.add("%" + username + "%");
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<User> list = (List<User>) hibernateTemplate.find(sql,strings);
		return list;
	}
	
	@Override
	public List getAdminList(String power, String uid, String username) throws Exception {
		List<User> list = (List<User>) hibernateTemplate.find("from User where power=? and uid=? or username=?",power, uid, username);
		return list;
	}

	@Override
	public List getAdminById(String id) throws Exception {
		List<User> list = (List<User>) hibernateTemplate.find("from User where uid=?",id);
		return list;
	}

	@Override
	public void updateAdmin(String[] str) throws Exception {
		List<User> user = (List<User>) hibernateTemplate.find("from User where id=?", str[0]);
		if(user != null){
			User userInfo = user.get(0);
			userInfo.setUsername(str[1]);
			userInfo.setPassword(str[2]);
			userInfo.setEmail(str[3]);
			userInfo.setPhone(str[4]);
			userInfo.setPower(str[5]);
			hibernateTemplate.update(userInfo);
		}
	}
	
	@Override
	public List getAuthorityById(String id) throws Exception {
		List<Authority> list = (List<Authority>) hibernateTemplate.find("from Authority where id=?",id);
		return list;
	}
		

	@Override
	public void delAdmin(String id) throws Exception {
		//List<User> user = (List<User>) hibernateTemplate.find("from User where id=?",id);
		User userInfo = hibernateTemplate.load(User.class, id);
		Authority authorityInfo = hibernateTemplate.load(Authority.class, id);
		if(userInfo != null){
			hibernateTemplate.delete(userInfo);
			if(authorityInfo != null){
				hibernateTemplate.delete(authorityInfo);
			}
		}
	}

	@Override
	public void updateAuthority(String[] str, String[] info) throws Exception {
		String id = str[0];
		Authority authorityInfo = hibernateTemplate.load(Authority.class, id);
		if(authorityInfo != null){
			authorityInfo.setMain(info[0]);
			authorityInfo.setSystem(info[1]);
			authorityInfo.setEmployee(info[2]);
			authorityInfo.setMenu(info[3]);
			authorityInfo.setRoom(info[4]);
			authorityInfo.setMember(info[5]);
			authorityInfo.setWarehouse(info[6]);
			authorityInfo.setFinance(info[7]);
			authorityInfo.setHotel(info[8]);
			hibernateTemplate.update(authorityInfo);
		}
	}

	@Override
	public void addAdmin(User user,Authority authority) throws Exception {
		hibernateTemplate.save(user);
		hibernateTemplate.save(authority);
	}

	@Override
	public List getPendingList() throws Exception {
		List<PendingEvent> list = (List<PendingEvent>) hibernateTemplate.find("from PendingEvent");
		return list;
	}

	@Override
	public List getPendingByInput(String type, String state, String title) throws Exception {
		String sql = "from PendingEvent where id != ''";
		List str = new ArrayList();
		if(!type.equals("")){
			sql += "and type like ?";
			str.add("%" + type + "%");
		}
		if(!state.equals("") && !state.equals("-1")){
			sql += "and state = ?";
			str.add(state);
		}
		if(!title.equals("")){
			sql += "and title like ?";
			str.add("%" +title +"%");
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<PendingEvent> list = (List<PendingEvent>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public void delPending(String id) throws Exception {
		PendingEvent pendingEvent = hibernateTemplate.load(PendingEvent.class, id);
		if(pendingEvent != null){
			hibernateTemplate.delete(pendingEvent);
		}
	}

	@Override
	public List getPendingById(String id) throws Exception {
		List<PendingEvent> list = (List<PendingEvent>) hibernateTemplate.find("from PendingEvent where id=?", id);
		return list;
	}

	@Override
	public void updateOverTime(String id) throws Exception {
		PendingEvent pendingEvent = hibernateTemplate.load(PendingEvent.class, id);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(date);
		pendingEvent.setOverTime(d);
		hibernateTemplate.update(pendingEvent);
	}

	@Override
	public void updateState(String id) throws Exception {
		PendingEvent pendingEvent = hibernateTemplate.load(PendingEvent.class, id);
		pendingEvent.setState("1");
		hibernateTemplate.update(pendingEvent);
	}

	@Override
	public List getWarningList() throws Exception {
		List<WarningInfo> list = (List<WarningInfo>) hibernateTemplate.find("from WarningInfo");
		return list;
	}

	@Override
	public List getWarningByInput(String type, String level) throws Exception {
		String sql = "from WarningInfo where id != ''";
		List str = new ArrayList();
		if(!type.equals("")){
			sql += "and type like ?";
			str.add("%" + type + "%");
		}
		if(!level.equals("") && !level.equals("-1")){
			sql += "and level = ?";
			str.add(level);
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<WarningInfo> list = (List<WarningInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public void delWarning(String id) throws Exception {
		WarningInfo warningInfo = hibernateTemplate.load(WarningInfo.class, id);
		if(warningInfo != null){
			hibernateTemplate.delete(warningInfo);
		}
	}

	@Override
	public List getWarningById(String id) throws Exception {
		List<WarningInfo> list = (List<WarningInfo>) hibernateTemplate.find("from WarningInfo where id=?", id);
		return list;
	}

	@Override
	public void updateLevel(String id) throws Exception {
		WarningInfo warningInfo = hibernateTemplate.load(WarningInfo.class, id);
		warningInfo.setLevel("0");
		hibernateTemplate.update(warningInfo);
		
	}
	
	@Override
	public List getMailList() throws Exception {
		List<MailInfo> list = (List<MailInfo>) hibernateTemplate.find("from MailInfo");
		return list;
	}

	@Override
	public List getMailByInput(String sendName, String title) throws Exception {
		String sql = "from MailInfo where id != ''";
		List str = new ArrayList();
		if(!sendName.equals("")){
			sql += "and sendName like ?";
			str.add("%" + sendName + "%");
		}
		if(!title.equals("")){
			sql += "and title like ?";
			str.add("%" + title + "%");
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<MailInfo> list = (List<MailInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public void delMail(String id) throws Exception {
		MailInfo mailInfo = hibernateTemplate.load(MailInfo.class, id);
		if(mailInfo != null){
			hibernateTemplate.delete(mailInfo);
		}
	}

	@Override
	public List getMailById(String id) throws Exception {
		List<MailInfo> list = (List<MailInfo>) hibernateTemplate.find("from MailInfo where id=?", id);
		return list;
	}

	@Override
	public List getPartnerList() throws Exception {
		List<Partner> list = (List<Partner>) hibernateTemplate.find("from Partner");
		return list;
	}

	@Override
	public void delPartnerInfo(String id) throws Exception {
		Partner partner = hibernateTemplate.load(Partner.class, id);
		if(partner != null){
			hibernateTemplate.delete(partner);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getPartnerById(String id) throws Exception {
		List<Partner> list = (List<Partner>) hibernateTemplate.find("from Partner where id=?", id);
		return list;
	}

	@Override
	public void updatePartnerInfo(String[] str) throws Exception {
		String id = str[0];
		Partner partner = hibernateTemplate.load(Partner.class, id);
		partner.setPartnerName(str[1]);
		partner.setMoney(str[2]);
		partner.setType(str[3]);
		partner.setCooperationTime(str[4]);
		partner.setStartTime(str[5]);
		hibernateTemplate.update(partner);
	}

	@Override
	public void addPartnerInfo(String[] str) throws Exception {
		Partner partner = new Partner();
		partner.setId(str[0]);
		partner.setPartnerName(str[1]);
		partner.setMoney(str[2]);
		partner.setType(str[3]);
		partner.setCooperationTime(str[4]);
		partner.setStartTime(str[5]);
		hibernateTemplate.save(partner);
	}

	@Override
	public List getInformList() throws Exception {
		List<InformInfo> list = (List<InformInfo>) hibernateTemplate.find("from InformInfo");
		return list;
	}

	@Override
	public List getInformByInput(String title, String type) throws Exception {
		String sql = "from InformInfo where id != ''";
		List str = new ArrayList();
		if(!title.equals("")){
			sql += "and title like ?";
			str.add("%" + title + "%");
		}
		if(!type.equals("")){
			sql += "and type like ?";
			str.add(type);
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<InformInfo> list = (List<InformInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public void delInformInfo(String id) throws Exception {
		InformInfo informInfo = hibernateTemplate.load(InformInfo.class, id);
		if(informInfo != null){
			hibernateTemplate.delete(informInfo);
		}
	}

	@Override
	public List getWinnersList() throws Exception {
		List<WinnersInfo> list = (List<WinnersInfo>) hibernateTemplate.find("from WinnersInfo");
		return list;
		
	}

	@Override
	public void adduploadFile(String id, String fileName, String uploadName, String showName, String fileType, String day) throws Exception {
		DownloadFile downloadFile = new DownloadFile();
		downloadFile.setId(id);
		downloadFile.setFileName(fileName);
		downloadFile.setUploadName(uploadName);
		downloadFile.setShowName(showName);
		downloadFile.setFileType(fileType);
		downloadFile.setCreateTime(day);
		hibernateTemplate.save(downloadFile);
	}

	@Override
	public List getFileList(String type) throws Exception {
		List<DownloadFile> list = (List<DownloadFile>) hibernateTemplate.find("from DownloadFile where fileType=?", type);
		return list;
	}

	@Override
	public List getFileByshowName(String type, String showName) throws Exception {
		String sql = "from DownloadFile where id != '' and fileType=? ";
		List str = new ArrayList();
		str.add(type);
		if(!showName.equals("")){
			sql += "and showName like ?";
			str.add("%" + showName + "%");
		}
		String[] strings = new String[str.size()];
		for(int i = 0; i < str.size(); i++){
			strings[i] = (String) str.get(i);
		}
		List<DownloadFile> list = (List<DownloadFile>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public void updateFile(String id, String showName) throws Exception {
		DownloadFile downloadFile = hibernateTemplate.load(DownloadFile.class, id);
		if(downloadFile != null){
			downloadFile.setShowName(showName);
			hibernateTemplate.update(downloadFile);
		}
	}

	@Override
	public void delFile(String id) throws Exception {
		DownloadFile downloadFile = hibernateTemplate.load(DownloadFile.class, id);
		if(downloadFile != null){
			String uploadName = downloadFile.getUploadName();
			String path = "F:\\java\\work\\webapps\\RestaurantMain\\wenjian\\" + uploadName;
			File file =new File(path);
			file.delete();
			hibernateTemplate.delete(downloadFile);
		}
	}

}
