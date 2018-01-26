package cn.xy.service;

import java.util.List;

import cn.xy.dao.MainDao;

public class MainServiceImpl implements MainService {
	
	private MainDao mainDao;
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	
	@Override
	public List getbacklog() throws Exception {
		return mainDao.getbacklog();
	}


	@Override
	public List getWarningInfo() throws Exception {
		return mainDao.getWarningInfo();
	}


	@Override
	public List getMailInfo() throws Exception {
		return mainDao.getMailInfo();
	}


	@Override
	public List getDownloadFile() throws Exception {
		return mainDao.getDownloadFile();
	}


	@Override
	public List getInformInfo() throws Exception {
		return mainDao.getInformInfo();
	}
	
	@Override
	public List getWinnersInfo() throws Exception {
		return mainDao.getWinnersInfo();
	}
	

}
