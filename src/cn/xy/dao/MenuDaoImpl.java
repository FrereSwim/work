package cn.xy.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.employeeBean.EmployeeInfo;
import cn.xy.menuBean.CarteInfo;

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
		
	}
			
			

}
