package cn.xy.service;

import java.util.List;

public interface SystemService {
	List getAdminList(String power) throws Exception;
	List getAdminList() throws Exception;
	List getAdminListByIdAndName(String power, String uid, String username) throws Exception;
	List getAdminList(String power, String uid, String username) throws Exception;
	List getAdminById(String id) throws Exception;
	void updateAdmin(String[] str) throws Exception;
	void delAdmin(String id) throws Exception;
	List getAuthorityById(String id) throws Exception;
	void updateAuthority(String[] str, String[] info) throws Exception;
	void addAdmin(String[] str,String[] info) throws Exception;
	List getPendingList() throws Exception;
	List getPendingByInput(String type, String  state, String title ) throws Exception;
	void delPending(String id) throws Exception;
	List getPendingById(String id) throws Exception;
	void updateOverTime(String id) throws Exception;
	void updateState(String id) throws Exception;
	List getWarningList() throws Exception;
	List getWarningByInput(String type, String level) throws Exception;
	void delWarning(String id) throws Exception;
	List getWarningById(String id) throws Exception;
	void updateLevel(String id) throws Exception;
	List getMailList() throws Exception;
	List getMailByInput(String sendName, String title) throws Exception;
	void delMail(String id) throws Exception;
	List getMailById(String id) throws Exception;
	List getPartnerList() throws Exception;
	void delPartnerInfo(String id) throws Exception;
	List getPartnerById(String id) throws Exception;
	void updatePartnerInfo(String[] str) throws Exception;
	void addPartnerInfo(String[] str) throws Exception;
	List getInformList() throws Exception;
	List getInformByInput(String title, String type) throws Exception;
	void delInformInfo(String id) throws Exception;
	List getWinnersList() throws Exception;
	void adduploadFile(String id, String fileName, String uploadName, String showName, String fileType, String day) throws Exception;
	List getFileList(String type) throws Exception;
	List getFileByshowName(String type, String showName) throws Exception;
	void updateFile(String id, String showName) throws Exception;
	void delFile(String id)  throws Exception;
}
