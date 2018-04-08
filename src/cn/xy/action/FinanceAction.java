package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.ExpenditureInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.TotalInfo;
import cn.xy.financeBean.IncomeInfo;
import cn.xy.service.FinanceService;
import cn.xy.utils.JSONResult;

public class FinanceAction extends ActionSupport {
	
	private String[] str;
	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}
	private FinanceService financeService;
	public void setFinanceService(FinanceService financeService) {
		this.financeService = financeService;
	}
	
	public void getPartnerInfo() throws Exception{
		List<Partner> list = financeService.getPartnerInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("partnerlist", list);
	}
	
	public void getchart0Info() throws Exception{
		List<TotalInfo> list = financeService.getTotalInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("Totallist", list);
	}
	
	public void getchart1Info() throws Exception{
		
	}

	public void getchart2Info() throws Exception{
		List<ExpenditureInfo> list = financeService.getExpenditureInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("Expenditurelist", list);
	}
	
	public void getIncomeInfo() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List list = financeService.getIncomeInfo();
		jSONResult.jsonResult("incomeInfo", list);
	}
	
	public void getIncomeInfoByYear() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String year = str[0];
		List list = financeService.getIncomeInfoByYear(year);
		jSONResult.jsonResult("incomeInfo", list);
	}
	
	public void getIncomeByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List list = financeService.getIncomeByInput(str);
		jSONResult.jsonResult("incomeInfo", list);
	}
	
	public void getIncomeById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = financeService.getIncomeById(id);
		if(list.size() == 0) {
			jSONResult.jsonResult("incomeInfo", "0");
		}else{
			IncomeInfo incomeInfo = (IncomeInfo) list.get(0);
			jSONResult.jsonResult("incomeInfo", incomeInfo);
		}
	}
	
	public void updateIncome() throws Exception{
		JSONResult jSONResult = new JSONResult();
		financeService.updateIncome(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void delIncome() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		financeService.delIncome(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addIncome() throws Exception{
		JSONResult jSONResult = new JSONResult();
		financeService.addIncome(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void getRoomBillByYear() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String year = str[0];
		List list = financeService.getRoomBillByYear(year);
		jSONResult.jsonResult("RoomBillCount", list);
	}
	
	public void getRoomCheckIn() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String year = str[0];
		List list = financeService.getRoomCheckIn(year);
		jSONResult.jsonResult("RoomCheckIn", list);
	}
	
	public void getDishBill() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String time = str[0];
		//time = "2018-02-05";
		List list = financeService.getDishBill(time);
		jSONResult.jsonResult("DishBill", list);
	}

}
