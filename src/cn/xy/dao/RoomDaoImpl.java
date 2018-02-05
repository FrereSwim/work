package cn.xy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.menuBean.DishBillInfo;
import cn.xy.roomBean.RoomBillInfo;
import cn.xy.roomBean.RoomInfo;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class RoomDaoImpl implements RoomDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List getRoomList() throws Exception{
		List<RoomInfo> list = (List<RoomInfo>) hibernateTemplate.find("from RoomInfo order by roomNum ASC");
		return list;
	}
	
	@Override
	public List getRoomListByInput(String[] str) throws Exception{
		String sql = "from RoomInfo where id != ' ' ";
		List arr = new ArrayList();
		if(!str[0].equals("")){
			sql += "and level like ? ";
			arr.add("%" + str[0] + "%");
		}
		if(!str[1].equals("")){
			sql += "and area like ? ";
			arr.add("%" + str[1] + "%");
		}
		if(!str[2].equals("")){
			sql += "and roomNum = ? ";
			arr.add(str[2]);
		}
		if(!str[3].equals("")){
			sql += "and state like ? ";
			arr.add("%" + str[3] + "%");
		}
		String[] strings = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++){
			strings[i] = (String) arr.get(i);
		}
		sql += " order by roomNum ASC";
		List<RoomInfo> list = (List<RoomInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}	
	
	@Override
	public void addRoomBill(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.ROOMBILL_ID_PREFIX,8);
		RoomBillInfo roomBillInfo = new RoomBillInfo();
		roomBillInfo.setId(id);
		roomBillInfo.setRoomNum(str[0]);
		roomBillInfo.setPrice(str[1]);
		roomBillInfo.setPhone(str[2]);
		roomBillInfo.setCare(str[3]);
		roomBillInfo.setStartTime(str[4]);
		roomBillInfo.setEndTime(str[5]);
		roomBillInfo.setDays(str[6]);
		roomBillInfo.setState(str[7]);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createTime = dateFormater.format(date);
		roomBillInfo.setCreateTime(createTime);
		roomBillInfo.setActId(str[10]);
		roomBillInfo.setActName(str[11]);
		roomBillInfo.setMid(str[12]);
		hibernateTemplate.save(roomBillInfo);
	}
	@Override
	public void updateRoomBillState(String[] str) throws Exception {
		String roomNum =  str[0];
		String state = str[1];
		List<RoomBillInfo> list = (List<RoomBillInfo>) hibernateTemplate.find("from RoomBillInfo where roomNum=? and state=?", roomNum, state);
		RoomBillInfo roomBillInfo = list.get(0);
		roomBillInfo.setState(str[2]);
		hibernateTemplate.update(roomBillInfo);
	}
	
	@Override
	public void updateRoomInfo(String id, String state) throws Exception {
		RoomInfo roomInfo = hibernateTemplate.load(RoomInfo.class, id);
		roomInfo.setState(state);
		hibernateTemplate.update(roomInfo);
	}

	@Override
	public List getRoomBillList() throws Exception {
		List<RoomBillInfo> list = (List<RoomBillInfo>) hibernateTemplate.find("from RoomBillInfo order by createTime DESC");
		return list;
	}

	@Override
	public List getRoomBillByInput(String[] str) throws Exception {
		String phone = str[0];
		String roomNum = str[1];
		String state = str[2];
		String startTime = str[3];
		String endTime = str[4];
		String sql = "from RoomBillInfo where id != ' ' ";
		List arr = new ArrayList();
		if(!phone.equals("")){
			sql += "and phone = ? ";
			arr.add(str[0]);
		}
		if(!roomNum.equals("")){
			sql += "and roomNum = ? ";
			arr.add(str[1]);
		}
		if(!state.equals("")){
			sql += "and state = ? ";
			arr.add(state);
		}
		if(!startTime.equals("")){
			sql += "and createTime >= ? ";
			arr.add(startTime);
		}
		if(!endTime.equals("")){
			sql += "and createTime <= ? ";
			arr.add(endTime);
		}
		String[] strings = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++){
			strings[i] = (String) arr.get(i);
		}
		sql += " ORDER BY createTime DESC";
		List<RoomBillInfo> list = (List<RoomBillInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public RoomBillInfo getRoomBillInfoById(String id) throws Exception {
		//RoomBillInfo roomBillInfo = hibernateTemplate.load(RoomBillInfo.class, id);
		List list = (List<RoomBillInfo>) hibernateTemplate.find("from RoomBillInfo where id=?", id);
		RoomBillInfo roomBillInfo = (RoomBillInfo) list.get(0);
		return roomBillInfo;
	}
	
	@Override
	public List getRoomBillListByInput(String[] str) throws Exception {
		String startTime = str[0];
		String endTime = str[1];
		List<RoomBillInfo> list = (List<RoomBillInfo>) hibernateTemplate.find("from RoomBillInfo where createTime >= ? and createTime <= ? ORDER BY createTime DESC", startTime, endTime);
		return list;
	}

	@Override
	public List getBillInfoByInput2(String[] str) throws Exception {
		String time = str[0];
		List<RoomBillInfo> list = (List<RoomBillInfo>) hibernateTemplate.find("from RoomBillInfo where createTime like ?", time + "%");
		return list;
	}
			
			

}
