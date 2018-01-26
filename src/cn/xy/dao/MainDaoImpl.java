package cn.xy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.DownloadFile;
import cn.xy.bean.InformInfo;
import cn.xy.bean.MailInfo;
import cn.xy.bean.PendingEvent;
import cn.xy.bean.WarningInfo;
import cn.xy.bean.WinnersInfo;

public class MainDaoImpl implements MainDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List getbacklog() throws Exception {
		List<PendingEvent> list = (List<PendingEvent>) hibernateTemplate.find("from PendingEvent");
		return list;
	}

	@Override
	public List getWarningInfo() throws Exception {
		List<WarningInfo> list = (List<WarningInfo>) hibernateTemplate.find("from WarningInfo");
		return list;
	}

	@Override
	public List getMailInfo() throws Exception {
		List<MailInfo> list = (List<MailInfo>) hibernateTemplate.find("from MailInfo");
		return list;
	}

	@Override
	public List getDownloadFile() throws Exception {
		List<DownloadFile> list1 = (List<DownloadFile>) hibernateTemplate.find("from DownloadFile where fileType=?", "0");
		List<DownloadFile> list2 = (List<DownloadFile>) hibernateTemplate.find("from DownloadFile where fileType=?", "1");
		List list = new ArrayList();
		list.add(list1);
		list.add(list2);
		return list;
	}

	@Override
	public List getInformInfo() throws Exception {
		List<InformInfo> list = (List<InformInfo>) hibernateTemplate.find("from InformInfo");
		return list;
	}
	
	@Override
	public List getWinnersInfo() throws Exception {
		List<WinnersInfo> list = (List<WinnersInfo>) hibernateTemplate.find("from WinnersInfo");
		return list;
	}
			

}
