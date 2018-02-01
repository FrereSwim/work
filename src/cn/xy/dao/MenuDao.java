package cn.xy.dao;

import java.util.List;

public interface MenuDao {

	List getMenuByEid(String id) throws Exception;
	void addDish(String id, String[] str) throws Exception;
	List getTemporarydish(String tableNum) throws Exception;
	void delDish(String[] str) throws Exception;
	List getTableNumByTableType(String tableType, String state) throws Exception;
	List getdishBill(String tableNum) throws Exception;
	void addBill(String id, String tableNum, String price, String createTime) throws Exception;
	void updateTableState(String tableNum, String state) throws Exception;
	void deldishBill(String tableNum) throws Exception;
	
	List getDishList() throws Exception;
	List getDishListByInput(String[] str) throws Exception;
	List getDishById(String id) throws Exception;
	void updateDishInfo(String[] str) throws Exception;
	void delDishInfo(String id) throws Exception;
	void addDishInfo(String id, String[] str) throws Exception;
	
	List getDishBillList() throws Exception;
	List getDishBillListByInput(String[] str) throws Exception;
	
	//List getBillInfoByInput(String[] str) throws Exception;
	List getBillInfoByInput2(String[] str) throws Exception;
}
