package cn.xy.service;

import java.util.ArrayList;
import java.util.List;

import cn.xy.dao.FinanceDao;
import cn.xy.financeBean.IncomeInfo;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

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
	
	@Override
	public List getIncomeInfo() throws Exception {
		return financeDao.getIncomeInfo();
	}
	
	@Override
	public List getIncomeInfoByYear(String year) throws Exception {
		List incomeInfoLsit =  financeDao.getIncomeInfo();
		List list = new ArrayList();
		for(int i = 0; i < incomeInfoLsit.size(); i++) {
			IncomeInfo  IncomeInfo = (cn.xy.financeBean.IncomeInfo) incomeInfoLsit.get(i);
			if(IncomeInfo.getYear().equals(year)) {
				list.add(IncomeInfo);
			}
		}
		return list;
	}
	@Override
	public List getIncomeByInput(String[] str) throws Exception {
		return financeDao.getIncomeByInput(str);
	}
	@Override
	public List getIncomeById(String id) throws Exception {
		return financeDao.getIncomeById(id);
	}
	@Override
	public void updateIncome(String[] str) throws Exception {
		financeDao.updateIncome(str);
	}
	@Override
	public void delIncome(String id) throws Exception {
		financeDao.delIncome(id);
	}
	@Override
	public void addIncome(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.INCOME_ID_PREFIX,1);
		financeDao.addIncome(id, str);
	}
	
	

}
