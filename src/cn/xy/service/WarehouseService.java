package cn.xy.service;

import java.util.List;

public interface WarehouseService {

	List getGoodsInfo() throws Exception;
	
	List getGoodsByInput(String[] str) throws Exception;

	List getGoodsById(String id) throws Exception;

	void updateGoods(String[] str) throws Exception;

	void delGoods(String id) throws Exception;

	void addGoods(String[] str) throws Exception;



}
