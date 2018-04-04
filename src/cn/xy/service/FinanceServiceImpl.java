package cn.xy.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xy.dao.FinanceDao;
import cn.xy.financeBean.IncomeInfo;
import cn.xy.menuBean.DishBillInfo;
import cn.xy.roomBean.RoomBillInfo;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class FinanceServiceImpl implements FinanceService {
	
	private FinanceDao financeDao;
	public void setFinanceDao(FinanceDao financeDao) {
		this.financeDao = financeDao;
	}
	@Override
	public List getPartnerInfo() throws Exception {
		return financeDao.getPartnerInfo();
	}
	@Override
	public List getTotalInfo() throws Exception {
		return financeDao.getTotalInfo();
	}
	@Override
	public List getExpenditureInfo() throws Exception {
		return financeDao.getExpenditureInfo();
	}
	
	@Override
	public List getIncomeInfo() throws Exception {
		return financeDao.getIncomeInfo();
	}
	
	@Override
	public List getIncomeInfoByYear(String year) throws Exception {
		List incomeInfoLsit =  financeDao.getIncomeInfo();
		List list = new ArrayList();
		for(int i = 0; i < incomeInfoLsit.size(); i++) {
			IncomeInfo  IncomeInfo = (cn.xy.financeBean.IncomeInfo) incomeInfoLsit.get(i);
			if(IncomeInfo.getYear().equals(year)) {
				list.add(IncomeInfo);
			}
		}
		return list;
	}
	@Override
	public List getIncomeByInput(String[] str) throws Exception {
		return financeDao.getIncomeByInput(str);
	}
	@Override
	public List getIncomeById(String id) throws Exception {
		return financeDao.getIncomeById(id);
	}
	@Override
	public void updateIncome(String[] str) throws Exception {
		financeDao.updateIncome(str);
	}
	@Override
	public void delIncome(String id) throws Exception {
		financeDao.delIncome(id);
	}
	@Override
	public void addIncome(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.INCOME_ID_PREFIX,1);
		financeDao.addIncome(id, str);
	}
	@Override
	public List getRoomBillByYear(String year) throws Exception {
		List list = new ArrayList();
		for(int i = 1; i < 9; i++) {
			List RoomBillCountlist = financeDao.getRoomBillByYear(i + "", year);
			int num = RoomBillCountlist.size();
			list.add(num);
		}
		return list;
	}
	@Override
	public List getRoomCheckIn(String year) throws Exception {
		int[] list = new int[12];
		for(int i = 1; i < 13; i++) {
			String str = "";
			if(i < 10) {
				str = "0" + i;
			}else {
				str = "" + i;
			}
			String yearAndMonth = year + "-" + str;
			List RoomBilllist = financeDao.getRoomBillByYear1(yearAndMonth);
			int len = RoomBilllist.size();
			int countDay = 0;
			for(int j = 0; j < len; j++) {
				RoomBillInfo roomBillInfo = (RoomBillInfo) RoomBilllist.get(j);
				String day = roomBillInfo.getDays();
				countDay +=  Integer.parseInt(day);
			}
			list[i-1] = countDay;
		}
		
		List RoomBilllist2 = financeDao.getRoomBillByYear2();
		int len = RoomBilllist2.size();
		for(int x = 0; x < len; x++) {
			RoomBillInfo roomBillInfo2 = (RoomBillInfo) RoomBilllist2.get(x);
			String[] startTimeStr = roomBillInfo2.getStartTime().split("-");
			String[] endTimeStr = roomBillInfo2.getEndTime().split("-");
			String day = roomBillInfo2.getDays();
			for(int y = 1; y < 13; y++) {
				String str2 = "";
				if(y < 10) {
					str2 = "0" + y;
				}else {
					str2 = "" + y;
				}
				if(str2.equals(startTimeStr[1])) {
					int k = y + 1;
					if(k < 10) {
						str2 = "0" + k;
					}else {
						str2 = "" + k;
					}
					String lsTime = year + "-" + str2 + "-01";
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date date1 = format.parse(roomBillInfo2.getEndTime());
					Date date2 = format.parse(lsTime);
					int lsDay = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));//结束时间和当月第一天的距离天数
					int dangyueDay = Integer.parseInt(day) - (lsDay + 1);//开始时间距离月末距离天数
					int a = list[y-1];
					int num = a + dangyueDay;
					list[y-1] = num;
					list[y] = list[y] + lsDay + 1;
				}
			}
		}
		List arraylist = new ArrayList();
		int length = list.length;
		for(int z = 0; z < length; z++) {
			arraylist.add(list[z] / 9.6);
		}
		
		return arraylist;
	}
	@Override
	public List getDishBill(String time) throws Exception {
		List dishBillInfoList = financeDao.getDishBill(time);
		int size  = dishBillInfoList.size();
		String[] billCount = new String[24];
		int len = billCount.length;
		for(int i = 0; i < size; i++) {
			DishBillInfo dishBillInfo = (DishBillInfo) dishBillInfoList.get(i);
			String createTime = dishBillInfo.getCreateTime();
			String[] str1 = createTime.split("\\s+");
			String[] str2 = str1[1].split("\\.");
			String hour = str2[0];
			for(int j =0; j < len; j++) {
				String str = "";
				if(j < 10) {
					str = "0" + j;
				}else {
					str = "" + j;
				}
				if(str.equals(hour)) {
					billCount[j] += 1;
				}
			}
		}
		List arraylist = new ArrayList();
		int length = billCount.length;
		for(int z = 0; z < length; z++) {
			arraylist.add(billCount[z]);
		}
		return arraylist;
	}
	
	
	

}
