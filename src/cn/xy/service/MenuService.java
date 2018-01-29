package cn.xy.service;

import java.util.List;

public interface MenuService {
	
	List getMenuByEid(String id) throws Exception;
	void addDish(String[] str) throws Exception;
	List getTemporarydish(String tableNum) throws Exception;
	void delDish(String[] str) throws Exception;

}
