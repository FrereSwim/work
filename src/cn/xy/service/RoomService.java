package cn.xy.service;

import java.util.List;

import cn.xy.roomBean.RoomBillInfo;

public interface RoomService {
	
	List getRoomList() throws Exception;
	List getRoomListByInput(String[] str) throws Exception;

	void addRoomBill(String[] str) throws Exception;
	void updateRoomBillState(String[] str) throws Exception;
	void delRoomBill(String[] str) throws Exception;
	void updateRoomInfo(String id, String state) throws Exception;
	
	List getRoomBillList() throws Exception;
	List getRoomBillByInput(String[] str) throws Exception;
	
	RoomBillInfo getRoomBillInfoById(String id) throws Exception;
}
