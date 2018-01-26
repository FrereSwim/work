package cn.xy.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.service.WarehouseService;

public class WarehouseAction extends ActionSupport {
	
	private WarehouseService warehouseService;
	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
	

}
