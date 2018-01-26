package cn.xy.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.service.HotelService;

public class HotelAction extends ActionSupport {
	
	private HotelService hotelService;
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	

}
