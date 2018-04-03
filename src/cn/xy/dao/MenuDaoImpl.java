package cn.xy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.employeeBean.DepartmentInfo;
import cn.xy.employeeBean.EmployeeInfo;
import cn.xy.menuBean.CarteInfo;
import cn.xy.menuBean.DishBillInfo;
import cn.xy.menuBean.TableInfo;
import cn.xy.menuBean.TemporaryDishInfo;

public class MenuDaoImpl implements MenuDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Override
	public List getMenuByEid(String id) throws Exception {
		List<CarteInfo> list = (List<CarteInfo>) hibernateTemplate.find("from CarteInfo where id=?",id);
		return list;
	}

	@Override
	public void addDish(String id, String[] str) throws Exception {
		TemporaryDishInfo temporaryDishInfo = new TemporaryDishInfo();
		temporaryDishInfo.setId(id);
		temporaryDishInfo.setTableNum(str[0]);
		temporaryDishInfo.setDishID(str[1]);
		temporaryDishInfo.setPrice(str[2]);
		hibernateTemplate.save(temporaryDishInfo);
	}


	@Override
	public List getTemporarydish(String tableNum) throws Exception {
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where tableNum=?", tableNum);
		return list;
	}


	@Override
	public void delDish(String[] str) throws Exception {
		String id = str[0];
		String tableNum = str[1];
		String dishID = str[2];
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where id=? and tableNum=? and dishID=?", id, tableNum, dishID);
		TemporaryDishInfo temporaryDishInfo = list.get(0);
		if(temporaryDishInfo != null){
			hibernateTemplate.delete(temporaryDishInfo);
		}
	}

	@Override
	public List getTableNumByTableType(String tableType, String state) throws Exception {
		List<TableInfo> list = (List<TableInfo>) hibernateTemplate.find("from TableInfo where mapping=? and state=?", tableType, state);
		return list;
	}
	
	@Override
	public List getTableNum(String state) throws Exception {
		List<TableInfo> list = (List<TableInfo>) hibernateTemplate.find("from TableInfo where state=?", state);
		return list;
	}


	@Override
	public void updateTableState(String tableNum, String state) throws Exception {
		List<TableInfo> list = (List<TableInfo>) hibernateTemplate.find("from TableInfo where tableNum=?", tableNum);
		TableInfo tableInfo = list.get(0);
		tableInfo.setState(state);
		hibernateTemplate.update(tableInfo);
	}


	@Override
	public List getdishBill(String tableNum) throws Exception {
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where tableNum=?", tableNum);
		return list;
	}
	
	@Override
	public void addBill(String id, String[] str) throws Exception {
		Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(date);
        String tableNum = str[0];
        String money = str[1];
		String actId = str[2];
		String actName = str[3];
		String mid = str[4];
		DishBillInfo dishBillInfo = new DishBillInfo();
		dishBillInfo.setId(id);
		dishBillInfo.setTableNum(tableNum);
		dishBillInfo.setPrice(money);
		dishBillInfo.setCreateTime(createTime);
		dishBillInfo.setActId(actId);
		dishBillInfo.setActName(actName);
		dishBillInfo.setMid(mid);
		hibernateTemplate.save(dishBillInfo);
	}

	@Override
	public void deldishBill(String tableNum) throws Exception {
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where tableNum=?", tableNum);
		int len = list.size();
		TemporaryDishInfo temporaryDishInfo;
		for(int i = 0; i < len; i++) {
			temporaryDishInfo = list.get(i);
			hibernateTemplate.delete(temporaryDishInfo);
		}
	}


	@Override
	public List getDishList() throws Exception {
		List<CarteInfo> list = (List<CarteInfo>) hibernateTemplate.find("from CarteInfo order by num DESC");
		return list;
	}


	@Override
	public List getDishListByInput(String[] str) throws Exception {
		String sql = "from CarteInfo where id != ' ' ";
		List arr = new ArrayList();
		if(!str[0].equals("")){
			sql += "and dishName like ?";
			arr.add("%" + str[0] + "%");
		}
		if(!str[1].equals("")){
			sql += "and type = ?";
			arr.add(str[1]);
		}
		if(!str[2].equals("")){
			sql += "and level = ?";
			arr.add(str[2]);
		}
		String[] strings = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++){
			strings[i] = (String) arr.get(i);
		}
		List<CarteInfo> list = (List<CarteInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}


	@Override
	public List getDishById(String id) throws Exception {
		List<CarteInfo> list = (List<CarteInfo>) hibernateTemplate.find("from CarteInfo where id=?", id);
		return list;
	}


	@Override
	public void updateDishInfo(String[] str) throws Exception {
		CarteInfo carteInfo = hibernateTemplate.load(CarteInfo.class, str[0]);
		if(carteInfo != null) {
			carteInfo.setDishName(str[1]);
			carteInfo.setEnglishName(str[2]);
			carteInfo.setType(str[3]);
			carteInfo.setPrice(str[4]);
			carteInfo.setLevel(str[5]);
			carteInfo.setOrigin(str[6]);
			hibernateTemplate.update(carteInfo);
		}
	}


	@Override
	public void delDishInfo(String id) throws Exception {
		CarteInfo carteInfo = hibernateTemplate.load(CarteInfo.class, id);
		hibernateTemplate.delete(carteInfo);
	}


	@Override
	public void addDishInfo(String id, String[] str, int num) throws Exception {
		CarteInfo carteInfo = new CarteInfo();
		carteInfo.setId(id);
		carteInfo.setDishName(str[0]);
		carteInfo.setEnglishName(str[1]);
		carteInfo.setType(str[2]);
		carteInfo.setPrice(str[3]);
		carteInfo.setLevel(str[4]);
		carteInfo.setOrigin(str[5]);
		carteInfo.setNum(num + 1);
		hibernateTemplate.save(carteInfo);
	}

	@Override
	public List getDishBillList() throws Exception {
		List<DishBillInfo> list = (List<DishBillInfo>) hibernateTemplate.find("from DishBillInfo ORDER BY createTime DESC");
		return list;
	}

	@Override
	public List getDishBillListByInput(String[] str) throws Exception {
		String startTime = str[0];
		String endTime = str[1];
		List<DishBillInfo> list = (List<DishBillInfo>) hibernateTemplate.find("from DishBillInfo where createTime >= ? and createTime <= ? ORDER BY createTime DESC", startTime, endTime);
		return list;
	}

	@Override
	public List getBillInfoByInput2(String[] str) throws Exception {
		String time = str[0];
		List<DishBillInfo> list = (List<DishBillInfo>) hibernateTemplate.find("from DishBillInfo where createTime like ?", time + "%");
		return list;
	}


	@Override
	public List getdishInfo(String tableNum) throws Exception {
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where tableNum=? group by dishID", tableNum);
		return list;
	}


	@Override
	public int getDishCount(String dishID) throws Exception {
		List<TemporaryDishInfo> list = (List<TemporaryDishInfo>) hibernateTemplate.find("from TemporaryDishInfo where dishID=?", dishID);
		int count = list.size();
		return count;
	}
	
			

}
