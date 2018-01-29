package cn.xy.dao;

import java.util.List;

public interface MenuDao {

	List getMenuByEid(String id) throws Exception;
	void addDish(String id, String[] str) throws Exception;
	List getTemporarydish(String tableNum) throws Exception;
	void delDish(String[] str) throws Exception;
}
