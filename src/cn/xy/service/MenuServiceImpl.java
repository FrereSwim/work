package cn.xy.service;

import java.util.List;

import cn.xy.dao.MenuDao;
import cn.xy.menuBean.CarteInfo;
import cn.xy.menuBean.DishBillInfo;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.MenuDishID;
import cn.xy.utils.ModulePrefixConstant;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	@Override
	public void addDishList(List list) throws Exception {
		int len = list.size();
		for(int i = 1; i < len; i++){
			CarteInfo carteInfo = (CarteInfo) list.get(i);
			String[] str = new String[6];
		    str[0] = carteInfo.getDishName();
		    str[1] = carteInfo.getEnglishName();
		    str[2] = carteInfo.getType();
		    str[3] = carteInfo.getPrice();
		    str[4] = carteInfo.getLevel();
		    str[5] = carteInfo.getOrigin();
			//String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHINFO_ID_PREFIX,8);
		    List list1 = menuDao.getDishList();
			CarteInfo carteInfo1 = (CarteInfo) list1.get(0);
		    int num = carteInfo1.getNum();
			MenuDishID menuDishID = new MenuDishID();
			String id =menuDishID.getDishID(num);
			menuDao.addDishInfo(id, str, num);
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
	public void checkoutBill(String[] str) throws Exception {
		String tableNum = str[0];
		/*String actId = str[1];
		String actName = str[2];
		String mid = str[3];
		List list = menuDao.getdishBill(tableNum);
		int len = list.size();
		double prices = 0.0;
		TemporaryDishInfo temporaryDishInfo;
		for(int i = 0; i < len; i++) {
			temporaryDishInfo = (TemporaryDishInfo) list.get(i);
			String price = temporaryDishInfo.getPrice();
			double p = Double.parseDouble(price);
			prices += p;
		}*/
        String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHBILL_ID_PREFIX,8);
		menuDao.addBill(id, str);
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
		//String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DISHINFO_ID_PREFIX,8);
		List list = menuDao.getDishList();
		CarteInfo carteInfo = (CarteInfo) list.get(0);
		int num = carteInfo.getNum();
		MenuDishID menuDishID = new MenuDishID();
		String id =menuDishID.getDishID(num);
		menuDao.addDishInfo(id, str, num);
	}

	@Override
	public List getDishBillList() throws Exception {
		return menuDao.getDishBillList();
	}
	
	@Override
	public List getDishBillListByTableNum(String tableNum) throws Exception {
		List list = menuDao.getdishBill(tableNum);
		return list;
	}

	@Override
	public List getDishBillListByInput(String[] str) throws Exception {
		return menuDao.getDishBillListByInput(str);
	}

	@Override
	public String[] getBillInfoByInput(String[] str) throws Exception {
		List list = menuDao.getDishBillListByInput(str);
		String[] arr = new String[2];
		int len = list.size();
		double count = 0.0;
		for(int i = 0; i < len; i++){
			DishBillInfo dishBillInfo = (DishBillInfo) list.get(i);
			String price = dishBillInfo.getPrice();
			count += Double.parseDouble(price);
		}
		arr[0] = len + "";
		arr[1] = count + "";
		return arr;
	}

	@Override
	public String[] getBillInfoByInput2(String[] str) throws Exception {
		List list = menuDao.getBillInfoByInput2(str);
		String[] arr = new String[2];
		int len = list.size();
		double count = 0.0;
		for(int i = 0; i < len; i++){
			DishBillInfo dishBillInfo = (DishBillInfo) list.get(i);
			String price = dishBillInfo.getPrice();
			count += Double.parseDouble(price);
		}
		arr[0] = len + "";
		arr[1] = count + "";
		return arr;
	}
	
	

}
