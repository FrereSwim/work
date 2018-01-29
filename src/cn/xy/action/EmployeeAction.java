package cn.xy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.xy.employeeBean.BusinessTripInfo;
import cn.xy.employeeBean.DepartmentInfo;
import cn.xy.employeeBean.EmployeeInfo;
import cn.xy.service.EmployeeService;
import cn.xy.utils.JSONResult;

public class EmployeeAction extends ActionSupport {
	
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private String[] str;
	private String[] dateArr;
	public String[] getStr() {
		return str;
	}
	public void setStr(String[] str) {
		this.str = str;
	}
	public String[] getDateArr() {
		return dateArr;
	}
	public void setDateArr(String[] dateArr) {
		this.dateArr = dateArr;
	}
	public void getEmployeeList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String eType = str[0];
		List employeeList = employeeService.getEmployeeList(eType);
		jSONResult.jsonResult("employeeList", employeeList);
	} 
	
	public void getEmployeeByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List employeeList = employeeService.getEmployeeByInput(str);
		jSONResult.jsonResult("employeeList", employeeList);
	} 
	
	public void getEmployeeById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = employeeService.getEmployeeById(id);
		EmployeeInfo employee = (EmployeeInfo) list.get(0);
		jSONResult.jsonResult("employee", employee);
	} 
	
	public void updateEmployee() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.updateEmployee(str);
		jSONResult.jsonResult("result", true);
	} 
	
	public void delEmployee() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.delEmployee(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addEmployee() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.addEmployee(str);
		jSONResult.jsonResult("result", true);
	} 

	public void getDepartmentList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List departmentList =  employeeService.getDepartmentList();
		jSONResult.jsonResult("departmentList", departmentList);
	}
	
	public void getDepartmentByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List departmentList = employeeService.getDepartmentByInput(str);
		jSONResult.jsonResult("departmentList", departmentList);
	} 
	
	public void getDepartmentById() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		List list = employeeService.getDepartmentById(id);
		DepartmentInfo department = (DepartmentInfo) list.get(0);
		jSONResult.jsonResult("department", department);
	} 
	
	public void updateDepartment() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.updateDepartment(str);
		jSONResult.jsonResult("result", true);
	} 
	
	public void delDepartment() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.delDepartment(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void addDepartment() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.addDepartment(str);
		jSONResult.jsonResult("result", true);
	} 
	
	//测试
	public void getInfo() throws Exception{
		employeeService.getInfo();	
	}
	
	public void regBusinessTrip() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.regBusinessTrip(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void regLeave() throws Exception{
		JSONResult jSONResult = new JSONResult();
		employeeService.regLeave(str);
		jSONResult.jsonResult("result", true);
	}
	
	public void getBusinessTripList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List businessTripList = employeeService.getBusinessTripList();
		jSONResult.jsonResult("businessTripList", businessTripList);
	}
	public void getBusinessTripByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List businessTripList = employeeService.getBusinessTripByInput(str);
		jSONResult.jsonResult("businessTripList", businessTripList);
	}
	public void approvalBusinessTrip() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.approvalBusinessTrip(id);
		jSONResult.jsonResult("result", true);
	}
	public void cancelRegBT() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.cancelRegBT(id);
		jSONResult.jsonResult("result", true);
	}
	public void delBT() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.delBT(id);
		jSONResult.jsonResult("result", true);
	}
	
	public void getLeaveList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List leaveList = employeeService.getLeaveList();
		jSONResult.jsonResult("leaveList", leaveList);
	}
	public void getLeaveByInput() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List leaveList = employeeService.getLeaveByInput(str);
		jSONResult.jsonResult("leaveList", leaveList);
	}
	public void approvalLeave() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.approvalLeave(id);
		jSONResult.jsonResult("result", true);
	}
	public void cancelRegLeave() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.cancelRegLeave(id);
		jSONResult.jsonResult("result", true);
	}
	public void delLeave() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String id = str[0];
		employeeService.delLeave(id);
		jSONResult.jsonResult("result", true);
	}
	
	//合同登记
	public void getEmployeeList2() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String eStage = str[0];
		List employeeList = employeeService.getEmployeeList2(eStage);
		jSONResult.jsonResult("employeeList", employeeList);
	} 
	
	public void getEmployeeByInput2() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List employeeList = employeeService.getEmployeeByInput2(str);
		jSONResult.jsonResult("employeeList", employeeList);
	}
	
	//提醒列表
	public void getRemindList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		String eStage = str[0];
		List employeeList = employeeService.getRemindList(eStage);
		jSONResult.jsonResult("employeeList", employeeList);
	}
	public void getRemindBirthDateList() throws Exception{
		JSONResult jSONResult = new JSONResult();
		List employeeList = employeeService.getRemindBirthDateList();
		jSONResult.jsonResult("employeeList", employeeList);
	}
	
	  
	
}
