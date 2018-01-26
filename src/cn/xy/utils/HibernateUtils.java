package cn.xy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//避免每次都创建SessionFactory，耗费资源，使用静态代码块，在类加载时执行，只执行一次
public class HibernateUtils {
	static Configuration cgf = null;
	static SessionFactory sessionFactory = null;
	static{
		cgf = new Configuration();
		cgf.configure();
		sessionFactory = cgf.buildSessionFactory();	
	}
	
	public static Session getSessionObject(){
		return sessionFactory.getCurrentSession();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void main(String[] args) {
		
	}
}
