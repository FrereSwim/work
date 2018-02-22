package cn.xy.dao;

import java.util.List;

public interface WarehouseDao {

	List getGoodsInfo() throws Exception;
	
	List getGoodsByInput(String[] str) throws Exception;

	List getGoodsById(String id) throws Exception;

	void updateGoods(String[] str) throws Exception;

	void delGoods(String id) throws Exception;

	void addGoods(String id, String[] str) throws Exception;
}
