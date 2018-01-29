package cn.xy.service;

import java.util.List;

public interface EmployeeService {

	List getEmployeeList(String eType) throws Exception;
	List getEmployeeByInput(String[] str) throws Exception;
	List getEmployeeById(String id) throws Exception;
	void updateEmployee(String[] str) throws Exception;
	void delEmployee(String id) throws Exception;
	void addEmployee(String[] str) throws Exception;
	List getDepartmentList() throws Exception;
	List getDepartmentByInput(String[] str) throws Exception;
	List getDepartmentById(String id) throws Exception;
	void updateDepartment(String[] str) throws Exception;
	void delDepartment(String id) throws Exception;
	void addDepartment(String[] str) throws Exception;
	void getInfo() throws Exception;
	void regBusinessTrip(String[] dateArr) throws Exception;
	void regLeave(String[] dateArr) throws Exception;
	
	List getBusinessTripList() throws Exception;
	List getBusinessTripByInput(String[] str) throws Exception;
	void approvalBusinessTrip(String id) throws Exception;
	void cancelRegBT(String id) throws Exception;
	void delBT(String id) throws Exception;
	List getLeaveList() throws Exception;
	List getLeaveByInput(String[] str) throws Exception;
	void approvalLeave(String id) throws Exception;
	void cancelRegLeave(String id) throws Exception;
	void delLeave(String id) throws Exception;
	
	List getEmployeeList2(String eStage) throws Exception;
	List getEmployeeByInput2(String[] str) throws Exception;
	
	List getRemindList(String eStage) throws Exception;  
	List getRemindBirthDateList() throws Exception;
}
