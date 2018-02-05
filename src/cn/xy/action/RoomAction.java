package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.roomBean.RoomBillInfo;
import cn.xy.service.RoomService;
import cn.xy.utils.JSONResult;

public class RoomAction extends ActionSupport {
	
	private String[] str;
	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}

	private RoomService roomService;
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	

	public void getRoomList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List list = roomService.getRoomList();
		jSONResult.jsonResult("roomList", list);
	}
	
	public void getRoomListByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List list = roomService.getRoomListByInput(str);
		jSONResult.jsonResult("roomList", list);
	}
	
	public void addRoomBill() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[8];
		String state = str[9];
		roomService.updateRoomInfo(id, state);
		roomService.addRoomBill(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void updateRoomBillState() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[3];
		String state = str[4];
		roomService.updateRoomInfo(id, state);
		roomService.updateRoomBillState(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void delRoomBill() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[3];
		String state = str[4];
		roomService.updateRoomInfo(id, state);
		roomService.updateRoomBillState(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void updateRoomInfo() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		String state = str[1];
		roomService.updateRoomInfo(id, state);
		jSONResult.jsonResult("result", true);
	}
	
	public void getRoomBillList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List roomBillList = roomService.getRoomBillList();
		jSONResult.jsonResult("roomBillList", roomBillList);
	}
	
	public void getRoomBillByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List roomBillList = roomService.getRoomBillByInput(str);
		jSONResult.jsonResult("roomBillList", roomBillList);
	}
	
	public void getRoomBillInfoById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		RoomBillInfo roomBillInfo = roomService.getRoomBillInfoById(id);
		jSONResult.jsonResult("roomBillInfo", roomBillInfo);
	}
	
	public void getRoomBillInfoByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String[] arr = roomService.getBillInfoByInput(str);
		jSONResult.jsonResult("billInfoArr", arr);
	}
	
	public void getRoomBillInfoByInput2() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String[] arr = roomService.getBillInfoByInput2(str);
		jSONResult.jsonResult("billInfoArr", arr);
	}

}
