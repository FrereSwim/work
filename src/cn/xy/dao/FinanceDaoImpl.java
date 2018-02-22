package cn.xy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.ExpenditureInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.TotalInfo;
import cn.xy.financeBean.IncomeInfo;
import cn.xy.memberBean.MemberInfo;

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

	@Override
	public List getIncomeInfo() throws Exception {
		List<IncomeInfo> list = (List<IncomeInfo>) hibernateTemplate.find("from IncomeInfo");
		return list;
	}

	@Override
	public List getIncomeByInput(String[] str) throws Exception {
		String sql = "from IncomeInfo where id != ' ' ";
		List arr = new ArrayList();
		if(!str[0].equals("")){
			sql += "and year = ?";
			arr.add(str[0]);
		}
		if(!str[1].equals("")){
			sql += "and type = ?";
			arr.add(str[1]);
		}
		String[] strings = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++){
			strings[i] = (String) arr.get(i);
		}
		List<IncomeInfo> list = (List<IncomeInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}

	@Override
	public List getIncomeById(String id) throws Exception {
		List<IncomeInfo> list = (List<IncomeInfo>) hibernateTemplate.find("from IncomeInfo where id=?", id);
		return list;
	}

	@Override
	public void updateIncome(String[] str) throws Exception {
		List<IncomeInfo> list = (List<IncomeInfo>) hibernateTemplate.find("from IncomeInfo where id=?", str[0]);
		IncomeInfo incomeInfo1 = list.get(0);
		//IncomeInfo incomeInfo = hibernateTemplate.load(IncomeInfo.class, str[0]);
		hibernateTemplate.delete(incomeInfo1);
		IncomeInfo incomeInfo = new IncomeInfo();
		incomeInfo.setId(str[0]);
		incomeInfo.setYear(str[1]);
		incomeInfo.setType(str[2]);
		incomeInfo.setJan(str[3]);
		incomeInfo.setFeb(str[4]);
		incomeInfo.setMar(str[5]);
		incomeInfo.setApr(str[6]);
		incomeInfo.setMay(str[7]);
		incomeInfo.setJun(str[8]);
		incomeInfo.setJul(str[9]);
		incomeInfo.setAug(str[10]);
		incomeInfo.setSept(str[11]);
		incomeInfo.setOct(str[12]);
		incomeInfo.setNov(str[13]);
		incomeInfo.setDec(str[14]);
		hibernateTemplate.save(incomeInfo);
	}

	@Override
	public void delIncome(String id) throws Exception {
		IncomeInfo incomeInfo = hibernateTemplate.load(IncomeInfo.class, id);
		hibernateTemplate.delete(incomeInfo);
	}

	@Override
	public void addIncome(String id, String[] str) throws Exception {
		IncomeInfo incomeInfo = new IncomeInfo();
		incomeInfo.setId(id);
		incomeInfo.setYear(str[0]);
		incomeInfo.setType(str[1]);
		incomeInfo.setJan(str[2]);
		incomeInfo.setFeb(str[3]);
		incomeInfo.setMar(str[4]);
		incomeInfo.setApr(str[5]);
		incomeInfo.setMay(str[6]);
		incomeInfo.setJun(str[7]);
		incomeInfo.setJul(str[8]);
		incomeInfo.setAug(str[9]);
		incomeInfo.setSept(str[10]);
		incomeInfo.setOct(str[11]);
		incomeInfo.setNov(str[12]);
		incomeInfo.setDec(str[13]);
		hibernateTemplate.save(incomeInfo);
	}
			
			

}
