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
	
	

}
