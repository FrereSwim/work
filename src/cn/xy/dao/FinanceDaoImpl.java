package cn.xy.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.ExpenditureInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.TotalInfo;

public class FinanceDaoImpl implements FinanceDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List getPartnerInfo() throws Exception {
		List<Partner> list = (List<Partner>) hibernateTemplate.find("from Partner");
		return list;
	}

	@Override
	public List getTotalInfo() throws Exception {
		List<TotalInfo> list = (List<TotalInfo>) hibernateTemplate.find("from TotalInfo");
		return list;
	}

	@Override
	public List getExpenditureInfo() throws Exception {
		List<ExpenditureInfo> list = (List<ExpenditureInfo>) hibernateTemplate.find("from ExpenditureInfo");
		return list;
	}
			
			

}
