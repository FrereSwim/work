package cn.xy.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.bean.User;

public class UserDaoImpl implements UserDao {

	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void add() throws Exception{
		//原来的方法
//		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
//		hibernateTemplate.save(entity);
		
//		User user = new User();
//		user.setUsername("小白");
//		user.setAddress("广东");
//		//调用sava方法实现封装
//		hibernateTemplate.save(user);
		
		//1查询   get方法，根据id查询
//		User user = hibernateTemplate.get(User.class, 2);
//		System.out.println(user.getUsername() +  ":" + user.getAddress());
		
		//2 find方法查询所有记录
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		for(User user : list){
			System.out.println(user);
		}
		
		//3 find方法条件查询
		List<User> list1 =  (List<User>) hibernateTemplate.find("from User where username=?", "小白");
		for(User user : list1){
			System.out.println(user);
		}
	}

	@Override
	public List<User> checkLogin(String username, String password) throws Exception {
		List<User> userList = (List<User>) hibernateTemplate.find("from User where username=? and password=?", username,password);
		return userList;
	}

	@Override
	public User checkEmail(String email) throws Exception {
		List<User> user = (List<User>) hibernateTemplate.find("from User where email=?", email);
		if(user.size() != 0){
			return user.get(0);
		}else{
			User user_1 = new User();
			user_1.setUid("0");
			return user_1;
		}
		
	}

	@Override
	public boolean updatePassword(String username, String newPassword) throws Exception {
		List<User> user = (List<User>) hibernateTemplate.find("from User where username=?", username);
		if(user != null){
			User userInfo = user.get(0);
			userInfo.setPassword(newPassword);
			hibernateTemplate.update(userInfo);
			return true;
		}
		return false;
	}

	
}
