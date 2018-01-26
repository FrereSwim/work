package cn.xy.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.Authority;

public class AuthorityDaoImpl implements AuthorityDao{
	
	//得到hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

	@Override
	public List<Authority> getAuthoritybyUsername(String username) throws Exception {
		List<Authority> list = (List<Authority>) hibernateTemplate.find("from Authority where username=?", username);
		return list;
	}
	
}
