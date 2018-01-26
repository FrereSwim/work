package cn.xy.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class MemberDaoImpl implements MemberDao {
	
	//得到hibernateTemplate对象
			private HibernateTemplate hibernateTemplate;
			public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
			}
			
			

}
