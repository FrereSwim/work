package cn.xy.service;

import java.util.List;

public interface MainService {
	
	List getbacklog() throws Exception;
	List getWarningInfo() throws Exception;
	List getMailInfo() throws Exception;
	List getDownloadFile() throws Exception;
	List getInformInfo() throws Exception;
	List getWinnersInfo() throws Exception;
}
