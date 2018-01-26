package cn.xy.service;

import java.util.List;

import cn.xy.bean.Authority;

public interface AuthorityService {

	List<Authority> getAuthoritybyUsername(String username) throws Exception;
}
