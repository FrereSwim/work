package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.memberBean.MemActInfo;
import cn.xy.service.WarehouseService;
import cn.xy.utils.JSONResult;
import cn.xy.warehouseBean.GoodsInfo;

public class WarehouseAction extends ActionSupport {
	
	private String[] str;
	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}
	
	private WarehouseService warehouseService;
	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	//会员活动管理
	public void getGoodsInfo() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List goodsList = warehouseService.getGoodsInfo();
		jSONResult.jsonResult("goodsList", goodsList);
	} 
	
	public void getGoodsByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List goodsList = warehouseService.getGoodsByInput(str);
		jSONResult.jsonResult("goodsList", goodsList);
	} 
	
	public void getGoodsById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = warehouseService.getGoodsById(id);
		GoodsInfo goods = (GoodsInfo) list.get(0);
		jSONResult.jsonResult("goods", goods);
	} 
	
	public void updateGoods() throws Exception{
		JSONResult jSONResult = new JSONResult();
		warehouseService.updateGoods(str);
		jSONResult.jsonResult("result", true);
	} 
	
	public void delGoods() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		warehouseService.delGoods(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addGoods() throws Exception{
		JSONResult jSONResult = new JSONResult();
		warehouseService.addGoods(str);
		jSONResult.jsonResult("result", true);
	}
	

}
