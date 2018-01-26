package cn.xy.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.xy.bean.User;
import cn.xy.dao.UserDao;

@Transactional
public class UserServiceImpl implements UserService{

	//注入dao对象
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add() throws Exception{
		System.out.println("service...");
		userDao.add();
	}
	@Override
	public  List<User> checkLogin(String username, String password) throws Exception{
		List<User> userList = userDao.checkLogin(username,password);
		return userList;
	}
	@Override
	public boolean checkEmail(String username, String email) throws Exception {
		User user =  userDao.checkEmail(email);
		if(user != null && !user.getUid().equals("0")){
			if(user.getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean updatePassword(String username, String newPassword) throws Exception {
		return userDao.updatePassword(username, newPassword);
	}
	
}
