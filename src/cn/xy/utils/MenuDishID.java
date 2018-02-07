package cn.xy.utils;

public class MenuDishID {

	public String getDishID(int num) {
		String id = "";
		if(num >= 10) {
			if(num >= 100) {
				id = num + 1 + "";
			}else {
				if(num == 99) {
					id = num + 1 + "";
				}else {
					id = "0" + (num + 1);
				}
			}
		}else {
			if(num == 9) {
				id = "0" + (num + 1);
			}else {
				id = "00" + (num + 1);
			}
		}
		return id;
	}
}
