package cn.xy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.menuBean.CarteInfo;
import cn.xy.service.MenuService;
import cn.xy.utils.JSONResult;
import cn.xy.utils.ReadExcelUntil;

public class MenuAction extends ActionSupport {
	
	private MenuService menuService;
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	private String[] str;
    private File file;
    private String fileFileName;
    public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}

	public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }
    
    public String fileImport() throws Exception{
    	String root = "F:\\java\\work\\webapps\\RestaurantMain\\数据导入";
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(new File(root, fileFileName));
        System.out.println("fileFileName: " + fileFileName);
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getPath());
        byte[] buffer = new byte[500];
        int length = 0;
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();
        ReadExcelUntil readExcelUntil = new ReadExcelUntil();
		String filePath = root + "/" + fileFileName;
		
		List list = readExcelUntil.readExcel(filePath);
		CarteInfo carteInfo = (CarteInfo) list.get(0);
		HttpServletRequest request = ServletActionContext.getRequest(); 
	    String username = request.getParameter("username");
        return SUCCESS;
    }
    
    public void getMenuByEid() throws Exception{
    	JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List menuList = menuService.getMenuByEid(id);
		if(menuList.isEmpty()){
			jSONResult.jsonResult("menuList", "0");
		}else{
			jSONResult.jsonResult("menuList", menuList);
		}
    }
    
    public void addDish() throws Exception{
    	JSONResult jSONResult = new JSONResult();
    	menuService.addDish(str);
    	jSONResult.jsonResult("result", true);
    }
    
    public void getTemporarydish() throws Exception{
    	JSONResult jSONResult = new JSONResult();
    	String tableNum = str[0];
    	List dishList = menuService.getTemporarydish(tableNum);
    	jSONResult.jsonResult("dishList", dishList);
    }
    
    public void delDish() throws Exception{
    	JSONResult jSONResult = new JSONResult();
    	menuService.delDish(str);
    	jSONResult.jsonResult("result", true);
    }
    
    public void getTableNumByTableType() throws Exception{
    	JSONResult jSONResult = new JSONResult();
    	String tableType = str[0];
    	String state = str[1];
    	List list = menuService.getTableNumByTableType(tableType, state);
    	jSONResult.jsonResult("list", list);
    }
    
    public void updateTableState() throws Exception{
    	JSONResult jSONResult = new JSONResult();
    	String tableNum = str[0];
    	String state = str[1];
    	menuService.updateTableState(tableNum, state);
    	jSONResult.jsonResult("result", true);
    }
    
}
	
