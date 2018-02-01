package cn.xy.service;

import java.util.List;

public interface MenuService {
	
	void addDishList(List list) throws Exception;
	
	List getMenuByEid(String id) throws Exception;
	void addDish(String[] str) throws Exception;
	List getTemporarydish(String tableNum) throws Exception;
	void delDish(String[] str) throws Exception;
	List getTableNumByTableType(String tableType, String state) throws Exception;
	void updateTableState(String tableNum, String state) throws Exception;
	void checkoutBill(String tableNum) throws Exception;
	void revokeBill(String tableNum) throws Exception;
	
	List getDishList() throws Exception;
	List getDishListByInput(String[] str) throws Exception;
	List getDishById(String id) throws Exception;
	void updateDishInfo(String[] str) throws Exception;
	void delDishInfo(String id) throws Exception;
	void addDishInfo(String[] str) throws Exception;
	
	List getDishBillList() throws Exception;
	List getDishBillListByInput(String[] str) throws Exception;
	
	String[] getBillInfoByInput(String[] str) throws Exception;
	String[] getBillInfoByInput2(String[] str) throws Exception;
}
