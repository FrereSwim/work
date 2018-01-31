package cn.xy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.xy.dao.MenuDao;
import cn.xy.menuBean.CarteInfo;
import cn.xy.menuBean.TemporaryDishInfo;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	@Override
	public void addDishList(List list) throws Exception {
		int len = list.size();
		for(int i = 0; i < len; i++){
			String[] str = new String[len];
			CarteInfo carteInfo = (CarteInfo) list.get(i);
		    str[0] = carteInfo.getDishName();
		    str[1] = carteInfo.getEnglishName();
		    str[2] = carteInfo.getType();
		    str[3] = carteInfo.getPrice();
		    str[4] = carteInfo.getLevel();
		    str[5] = carteInfo.getOrigin();
			String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHINFO_ID_PREFIX,8);
			menuDao.addDish(id, str);
		}
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
	@Override
	public void checkoutBill(String tableNum) throws Exception {
		List list = menuDao.getdishBill(tableNum);
		int len = list.size();
		double prices = 0.0;
		TemporaryDishInfo temporaryDishInfo;
		for(int i = 0; i < len; i++) {
			temporaryDishInfo = (TemporaryDishInfo) list.get(i);
			String price = temporaryDishInfo.getPrice();
			double p = Double.parseDouble(price);
			prices += p;
		}
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(date);
        String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHBILL_ID_PREFIX,8);
		menuDao.addBill(id, tableNum, prices+"", createTime);
		menuDao.deldishBill(tableNum);
		menuDao.updateTableState(tableNum, "0");
	}
	@Override
	public void revokeBill(String tableNum) throws Exception {
		menuDao.deldishBill(tableNum);
		menuDao.updateTableState(tableNum, "0");
	}
	@Override
	public List getDishList() throws Exception {
		return menuDao.getDishList();
	}
	@Override
	public List getDishListByInput(String[] str) throws Exception {
		return menuDao.getDishListByInput(str);
	}
	@Override
	public List getDishById(String id) throws Exception {
		return menuDao.getDishById(id);
	}
	@Override
	public void updateDishInfo(String[] str) throws Exception {
		menuDao.updateDishInfo(str);
	}
	@Override
	public void delDishInfo(String id) throws Exception {
		menuDao.delDishInfo(id);
	}
	@Override
	public void addDishInfo(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHINFO_ID_PREFIX,8);
		menuDao.addDishInfo(id, str);
	}
	
	

}
