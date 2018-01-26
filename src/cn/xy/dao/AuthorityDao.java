package cn.xy.dao;

import java.util.List;

import cn.xy.bean.Authority;

public interface AuthorityDao{
	List<Authority> getAuthoritybyUsername(String username) throws Exception;
}
