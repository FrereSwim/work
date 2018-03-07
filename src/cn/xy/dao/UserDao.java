package cn.xy.dao;

import java.util.List;

import cn.xy.bean.User;

public interface UserDao {

	void add() throws Exception;
	List<User> checkLogin(String username) throws Exception;
	User checkEmail(String email) throws Exception;
	boolean updatePassword(String username, String newPassword) throws Exception;
	
}
