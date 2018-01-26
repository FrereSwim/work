package cn.xy.dao;

import java.util.List;

public interface MainDao {
	
	List getbacklog() throws Exception;
	List getWarningInfo() throws Exception;
	List getMailInfo() throws Exception;
	List getDownloadFile() throws Exception;
	List getInformInfo() throws Exception;
	List getWinnersInfo() throws Exception;
}
