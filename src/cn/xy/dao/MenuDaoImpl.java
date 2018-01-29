package cn.xy.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.menuBean.CarteInfo;
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
	public void updateTableState(String tableNum, String state) throws Exception {
		List<TableInfo> list = (List<TableInfo>) hibernateTemplate.find("from TableInfo where tableNum=?", tableNum);
		TableInfo tableInfo = list.get(0);
		tableInfo.setState(state);
		hibernateTemplate.update(tableInfo);
	}
	
	
			

}
