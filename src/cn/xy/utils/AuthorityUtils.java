package cn.xy.utils;

import java.util.ArrayList;
import java.util.List;

import cn.xy.bean.Authority;

public class AuthorityUtils {

	public List<String> getAuthorityJSP(Authority obj){
		List<String> list = new ArrayList<String>();
		if(obj.getMain().equals("1")){
			list.add("main.jsp");
		}
		if(obj.getSystem().equals("1")){
			list.add("system.jsp");
		}
		if(obj.getEmployee().equals("1")){
			list.add("employee.jsp");
		}
		if(obj.getMenu().equals("1")){
			list.add("menu.jsp");
		}
		if(obj.getRoom().equals("1")){
			list.add("room.jsp");
		}
		if(obj.getMember().equals("1")){
			list.add("member.jsp");
		}
		if(obj.getWarehouse().equals("1")){
			list.add("warehouse.jsp");
		}
		if(obj.getFinance().equals("1")){
			list.add("finance.jsp");
		}
		if(obj.getHotel().equals("1")){
			list.add("hotel.jsp");
		}
		
		return list;
	}
}
