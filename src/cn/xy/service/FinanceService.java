package cn.xy.service;

import java.util.List;

public interface FinanceService {
	
	List getPartnerInfo() throws Exception;
	List getTotalInfo() throws Exception;
	List getExpenditureInfo() throws Exception;

}
