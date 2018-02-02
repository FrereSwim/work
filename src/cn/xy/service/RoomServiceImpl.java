package cn.xy.service;

import java.util.List;

import cn.xy.dao.RoomDao;
import cn.xy.roomBean.RoomBillInfo;

public class RoomServiceImpl implements RoomService {
	
	private RoomDao roomDao;
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	@Override
	public List getRoomList()  throws Exception {
		return roomDao.getRoomList();
	}
	
	@Override
	public List getRoomListByInput(String[] str)  throws Exception {
		return roomDao.getRoomListByInput(str);
	}
	
	@Override
	public void addRoomBill(String[] str) throws Exception {
		roomDao.addRoomBill(str);
	}
	
	@Override
	public void updateRoomBillState(String[] str) throws Exception {
		roomDao.updateRoomBillState(str);
	}
	
	@Override
	public void delRoomBill(String[] str) throws Exception {
		
	}
	
	@Override
	public void updateRoomInfo(String id, String state) throws Exception {
		roomDao.updateRoomInfo(id, state);
	}

	@Override
	public List getRoomBillList() throws Exception {
		return roomDao.getRoomBillList();
	}

	@Override
	public List getRoomBillByInput(String[] str) throws Exception {
		return roomDao.getRoomBillByInput(str);
	}

	@Override
	public RoomBillInfo getRoomBillInfoById(String id) throws Exception {
		return roomDao.getRoomBillInfoById(id);
	}
	
	

}
