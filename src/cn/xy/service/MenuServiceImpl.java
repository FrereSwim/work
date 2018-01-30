package cn.xy.service;

import java.util.List;

import cn.xy.dao.MenuDao;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	@Override
	public List getMenuByEid(String id) throws Exception {
		return menuDao.getMenuByEid(id);
	}
	
	@Override
	public void addDish(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.CHOICEDISH_ID_PREFIX,8);
		menuDao.addDish(id, str);
	}
	@Override
	public List getTemporarydish(String tableNum) throws Exception {
		return menuDao.getTemporarydish(tableNum);
	}
	@Override
	public void delDish(String[] str) throws Exception {
		menuDao.delDish(str);
	}
	@Override
	public List getTableNumByTableType(String tableType, String state) throws Exception {
		return menuDao.getTableNumByTableType(tableType, state);
	}
	@Override
	public void updateTableState(String tableNum, String state) throws Exception {
		menuDao.updateTableState(tableNum, state);
	}
	

}
