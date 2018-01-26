package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.InformInfo;
import cn.xy.bean.MailInfo;
import cn.xy.bean.PendingEvent;
import cn.xy.bean.WarningInfo;
import cn.xy.bean.WinnersInfo;
import cn.xy.service.MainService;
import cn.xy.utils.JSONResult;

public class MainAction extends ActionSupport {
	
	private MainService mainService;
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	public void getPendingEvent() throws Exception{
		List<PendingEvent> list = mainService.getbacklog();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("pendinglist", list);
	}
	
	public void getWarningInfo() throws Exception{
		List<WarningInfo> list = mainService.getWarningInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("warninglist", list);
	}
	
	public void getMailInfo() throws Exception{
		List<MailInfo> list = mainService.getMailInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("maillist", list);
	}
	
	public void downloadFile() throws Exception{
		List list = mainService.getDownloadFile();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("downloadFile", list);
	}
	
	public void getInformInfo() throws Exception{
		List<InformInfo> list = mainService.getInformInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("informList", list);
	}
	
	public void getWinnersInfo() throws Exception{
		List<WinnersInfo> list = mainService.getWinnersInfo();
		JSONResult jSONResult = new JSONResult();
		jSONResult.jsonResult("winnersList", list);
	}

}
