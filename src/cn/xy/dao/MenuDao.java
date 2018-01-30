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
}
