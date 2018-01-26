package cn.xy.service;

import java.util.List;

import cn.xy.dao.FinanceDao;

public class FinanceServiceImpl implements FinanceService {
	
	private FinanceDao financeDao;
	public void setFinanceDao(FinanceDao financeDao) {
		this.financeDao = financeDao;
	}
	@Override
	public List getPartnerInfo() throws Exception {
		return financeDao.getPartnerInfo();
	}
	@Override
	public List getTotalInfo() throws Exception {
		return financeDao.getTotalInfo();
	}
	@Override
	public List getExpenditureInfo() throws Exception {
		return financeDao.getExpenditureInfo();
	}
	
	

}
