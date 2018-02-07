package cn.xy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.bean.Authority;
import cn.xy.bean.MailInfo;
import cn.xy.bean.Partner;
import cn.xy.bean.PendingEvent;
import cn.xy.bean.User;
import cn.xy.bean.WarningInfo;
import cn.xy.service.SystemService;
import cn.xy.utils.ExportExcel;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.JSONResult;
import cn.xy.utils.ModulePrefixConstant;

public class SystemAction extends ActionSupport {
	
	private String str[];
	private String info[];
	public String[] getStr() {
		return str;
	}
	public void setStr(String[] str) {
		this.str = str;
	}
	public String[] getInfo() {
		return info;
	}
	public void setInfo(String[] info) {
		this.info = info;
	}
	
	private SystemService systemService;
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	//查询普通/超级管理员列表
		public void getAdminList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String power = str[0];
			if(power.equals("admin")){
				List adminList =  systemService.getAdminList(power);
				jSONResult.jsonResult("adminList", adminList);
			}
			if(power.equals("super")){
				List adminList =  systemService.getAdminList(power);
				jSONResult.jsonResult("adminList", adminList);
			}
			
		}
		//通过ID或者用户名查询对应管理员信息
		public String getAdminByIdOrName() throws Exception{
			JSONResult jSONResult = new JSONResult();
			if(str.length == 1){
				String power = str[0];
				List admin =  systemService.getAdminList(power);
				jSONResult.jsonResult("admin", admin);
			}else{
				String power = str[0];
				String ID = str[1];
				String username = str[2];
				List admin = systemService.getAdminListByIdAndName(power, ID, username);
				if(admin.isEmpty()){
					jSONResult.jsonResult("admin", "0");
				}else{
					jSONResult.jsonResult("admin", admin);
				}
			}
			return SUCCESS;
		}
		
		public void getAdminById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List admin =  systemService.getAdminById(id);
			jSONResult.jsonResult("admin", admin);
		}
		
		public void updateAdminInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			systemService.updateAdmin(str);
			jSONResult.jsonResult("result", "true");
		}
		
		public void delAdminInfo()  throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delAdmin(id);
			jSONResult.jsonResult("result", "true");
		}
		
		public void getAuthorityById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List list = systemService.getAuthorityById(id);
			Authority authorityInfo = (Authority) list.get(0);
			jSONResult.jsonResult("result", authorityInfo);
		}
		
		
		
		public void updateAuthority() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			String username = str[1];
			systemService.updateAuthority(str, info);
			jSONResult.jsonResult("result", "1");
		}
		
		public void addAdmin() throws Exception{
			JSONResult jSONResult = new JSONResult();
			systemService.addAdmin(str,info);
			jSONResult.jsonResult("result", "1");
		}
		
		//待办事件
		public void getPendingList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getPendingList();
			jSONResult.jsonResult("pendingList", list);
		}
		
		public void getPendingByInput() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String type = str[0];
			String state = str[1];
			String title = str[2];
			List list = systemService.getPendingByInput(type, state, title);
			if(list.isEmpty()){
				jSONResult.jsonResult("pendingList", "0");
			}else{
				jSONResult.jsonResult("pendingList", list);
			}
		}
		
		public void delPendingInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delPending(id);
			jSONResult.jsonResult("result", "true");
		}
		
		public void getPendingById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List list = systemService.getPendingById(id);
			PendingEvent PendingEvent = (PendingEvent) list.get(0);
			jSONResult.jsonResult("pending", PendingEvent);
		} 
		
		public void updateOverTime() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.updateOverTime(id);
			jSONResult.jsonResult("result", "true");
		} 
		
		public void updateState() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.updateState(id);
			jSONResult.jsonResult("result", "true");
		} 
		
		//预警事件
		public void getWarningList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getWarningList();
			jSONResult.jsonResult("warningList", list);
		}
		
		public void getWarningByInput() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String type = str[0];
			String level = str[1];
			List list = systemService.getWarningByInput(type, level);
			if(list.isEmpty()){
				jSONResult.jsonResult("warningList", "0");
			}else{
				jSONResult.jsonResult("warningList", list);
			}
		}
		
		public void delWarningInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delWarning(id);
			jSONResult.jsonResult("result", "true");
		}
		
		public void getWarningById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List list = systemService.getWarningById(id);
			WarningInfo warningInfo = (WarningInfo) list.get(0);
			jSONResult.jsonResult("warning", warningInfo);
		}
		
		//邮件事件
		public void getMailList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getMailList();
			jSONResult.jsonResult("mailList", list);
		}
		
		public void getMailByInput() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String sendName = str[0];
			String title = str[1];
			List list = systemService.getMailByInput(sendName, title);
			if(list.isEmpty()){
				jSONResult.jsonResult("mailList", "0");
			}else{
				jSONResult.jsonResult("mailList", list);
			}
		}
		
		public void delMailInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delMail(id);
			jSONResult.jsonResult("result", "true");
		}
		
		public void getMailById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List list = systemService.getMailById(id);
			MailInfo mailInfo = (MailInfo) list.get(0);
			jSONResult.jsonResult("mail", mailInfo);
		}

		public void updateLevel() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.updateLevel(id);
			jSONResult.jsonResult("result", "true");
		}
		
		//合作商
		public void getPartnerList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getPartnerList();
			jSONResult.jsonResult("partnerList", list);
		}
		public void delPartnerInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delPartnerInfo(id);
			jSONResult.jsonResult("result", "true");
		}

		public void getPartnerById() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			List<Partner> list = (List<Partner>)systemService.getPartnerById(id);
			jSONResult.jsonResult("partner", list);
		}
		
		public void updatePartnerInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			systemService.updatePartnerInfo(str);
			jSONResult.jsonResult("result", "true");
		}
		
		public void addPartnerInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			systemService.addPartnerInfo(str);
			jSONResult.jsonResult("result", "true");
		}
		
		//通知事件
		public void getInformList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getInformList();
			jSONResult.jsonResult("informList", list);
		}
		
		public void getInformByInput() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String title = str[0];
			String type = str[1];
			List list = systemService.getInformByInput(title, type);
			if(list.isEmpty()){
				jSONResult.jsonResult("informList", "0");
			}else{
				jSONResult.jsonResult("informList", list);
			}
		}
		
		public void delInformInfo() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delInformInfo(id);
			jSONResult.jsonResult("result", "true");
		}
		
		//获奖事件
		public void getWinnersList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			List list = systemService.getWinnersList();
			jSONResult.jsonResult("winnersList", list);
		}
		
		
		public void exportAdmin() throws Exception{
			List<User> admin =  systemService.getAdminList("admin");
			List beanList = new ArrayList();
			for(int i = 0; i < admin.size(); i++){
				List bean = new ArrayList();
				bean.add(admin.get(i).getUid());
				bean.add(admin.get(i).getUsername());
				bean.add(admin.get(i).getPassword());
				bean.add(admin.get(i).getPhone());
				bean.add(admin.get(i).getEmail());
				beanList.add(bean);
			}
			List titleList = new ArrayList();
			titleList.add("编码");
			titleList.add("用户名");
			titleList.add("密码");
			titleList.add("手机");
			titleList.add("邮箱");
			ExportExcel exportExcel = new ExportExcel();
			exportExcel.export("管理员账号信息表", titleList, beanList);
		}
		
		//附件上传模块
		private File file;
	    private String fileFileName;
	    private String fileContentType;
	    private String showName;
		public File getFile() {
			return file;
		}
		public void setFile(File file) {
			this.file = file;
		}
		public String getFileFileName() {
			return fileFileName;
		}
		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}
		public String getFileContentType() {
			return fileContentType;
		}
		public void setFileContentType(String fileContentType) {
			this.fileContentType = fileContentType;
		}
		public String getShowName() {
			return showName;
		}
		public void setShowName(String showName) {
			this.showName = showName;
		}
		public String addFile() throws Exception{
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String day = date.format(new Date());
		    //String root = "F:\\java\\work\\webapps\\RestaurantMain\\wenjian";
		    String root = "F:\\JAVA\\space\\work\\WebContent\\wenjian";
	        InputStream is = new FileInputStream(file);
	        String[] names = fileFileName.split("\\.");
	        String fileType = names[1];
	        long currentTime = System.currentTimeMillis();
	        String uploadName = currentTime + "." +fileType;
	        OutputStream os = new FileOutputStream(new File(root, uploadName));
	        byte[] buffer = new byte[500];
	        int length = 0;
	        while(-1 != (length = is.read(buffer, 0, buffer.length))){
	            os.write(buffer);
	        }
	        os.close();
	        is.close();
	        String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.FILE_ID_PREFIX,8);
	        HttpServletRequest request = ServletActionContext.getRequest(); 
		    String showName = request.getParameter("showName");
		    String type = request.getParameter("fileType");
	        systemService.adduploadFile(id, fileFileName, uploadName, showName, type, day);
	        if(type.equals("0")){
	        	return SUCCESS;
	        }else{
	        	return NONE;
	        }
	        
		} 
		
		public void getFileList() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String type = str[0];
			List list = systemService.getFileList(type);
			jSONResult.jsonResult("fileList", list);
		}
		
		public void getFileByshowName() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String type = str[0];
			String showName = str[1];
			List list = systemService.getFileByshowName(type, showName);
			if(list.isEmpty()){
				jSONResult.jsonResult("fileList", "0");
			}else{
				jSONResult.jsonResult("fileList", list);
			}
		}
		
		public void updateFile() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			String showName = str[1];
			systemService.updateFile(id, showName);
			jSONResult.jsonResult("result", "true");
		}
		
		public void delFile() throws Exception{
			JSONResult jSONResult = new JSONResult();
			String id = str[0];
			systemService.delFile(id);
			jSONResult.jsonResult("result", "true");
		}
	    

}
