package cn.xy.service;

import java.util.List;

import cn.xy.dao.WarehouseDao;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class WarehouseServiceImpl implements WarehouseService {
	
	private WarehouseDao warehouseDao;
	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}
	@Override
	public List getGoodsInfo() throws Exception {
		return warehouseDao.getGoodsInfo();
	}
	@Override
	public List getGoodsByInput(String[] str) throws Exception {
		return warehouseDao.getGoodsByInput(str);
	}
	@Override
	public List getGoodsById(String id) throws Exception {
		return warehouseDao.getGoodsById(id);
	}
	@Override
	public void updateGoods(String[] str) throws Exception {
		warehouseDao.updateGoods(str);		
	}
	@Override
	public void delGoods(String id) throws Exception {
		warehouseDao.delGoods(id);
	}
	@Override
	public void addGoods(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.WAREHOUSE_ID_PREFIX,8);
		warehouseDao.addGoods(id, str);		
	}
	
	

}
