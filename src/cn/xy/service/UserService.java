package cn.xy.service;

import java.util.List;

import cn.xy.bean.User;

public interface UserService {
	void add() throws Exception;
	List<User> checkLogin(String username, String password) throws Exception;
	boolean checkEmail(String username, String email)  throws Exception;
	boolean updatePassword(String username, String newPassword) throws Exception;
	
}
