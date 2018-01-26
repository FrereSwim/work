package cn.xy.service;

import java.util.List;

import cn.xy.bean.Authority;
import cn.xy.dao.AuthorityDao;

public class AuthorityServiceImpl implements AuthorityService {
	
	//注入dao对象
		private AuthorityDao authorityDao;
		public void setAuthorityDao(AuthorityDao authorityDao) {
			this.authorityDao = authorityDao;
		}

	@Override
	public List<Authority> getAuthoritybyUsername(String username) throws Exception {
		return authorityDao.getAuthoritybyUsername(username);
	}

}
