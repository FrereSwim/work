package cn.xy.dao;

import java.util.List;

public interface FinanceDao {

	List getPartnerInfo() throws Exception;
	List getTotalInfo() throws Exception;
	List getExpenditureInfo() throws Exception;
	
	List getIncomeInfo() throws Exception;
	
	List getIncomeByInput(String[] str) throws Exception;
	List getIncomeById(String id) throws Exception;
	void updateIncome(String[] str) throws Exception;
	void delIncome(String id) throws Exception;
	void addIncome(String id, String[] str) throws Exception;
	
	List getRoomBillByYear(String roomType, String year) throws Exception;
}
