package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.ExpenditureInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.TotalInfo;
import cn.xy.service.FinanceService;
import cn.xy.utils.JSONResult;

public class FinanceAction extends ActionSupport {
	
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

}
