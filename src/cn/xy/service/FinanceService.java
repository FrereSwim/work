package cn.xy.service;

import java.util.List;

public interface FinanceService {
	
	List getPartnerInfo() throws Exception;
	List getTotalInfo() throws Exception;
	List getExpenditureInfo() throws Exception;

	List getIncomeInfo() throws Exception;
	List getIncomeInfoByYear(String year) throws Exception;
	
	List getIncomeByInput(String[] str) throws Exception;
	List getIncomeById(String id) throws Exception;
	void updateIncome(String[] str) throws Exception;
	void delIncome(String id) throws Exception;
	void addIncome(String[] str) throws Exception;
	
	List getRoomBillByYear(String year) throws Exception;
	
}
