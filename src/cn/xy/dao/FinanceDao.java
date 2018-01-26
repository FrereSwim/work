package cn.xy.dao;

import java.util.List;

public interface FinanceDao {

	List getPartnerInfo() throws Exception;
	List getTotalInfo() throws Exception;
	List getExpenditureInfo() throws Exception;
}
