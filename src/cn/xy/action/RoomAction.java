package cn.xy.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.service.RoomService;

public class RoomAction extends ActionSupport {
	
	private RoomService roomService;
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	
	

}
