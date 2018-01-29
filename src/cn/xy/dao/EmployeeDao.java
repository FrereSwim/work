package cn.xy.dao;

import java.util.List;

public interface EmployeeDao {

	List getEmployeeList(String eType) throws Exception;
	List getEmployeeByInput(String[] str) throws Exception;
	List getEmployeeById(String id) throws Exception;
	void updateEmployee(String[] str) throws Exception;
	void delEmployee(String id) throws Exception;
	void addEmployee(String id,String[] str) throws Exception;
	List getDepartmentList() throws Exception;
	List getDepartmentByInput(String[] str) throws Exception;
	List getDepartmentById(String id) throws Exception;
	void updateDepartment(String[] str) throws Exception;
	void delDepartment(String id) throws Exception;
	void addDepartment(String id,String[] str) throws Exception;
	void getInfo() throws Exception;
	void addBusinessTrip(String id, String[] str) throws Exception;
	void addLeave(String id, String[] str) throws Exception;
	
	List getBusinessTripList() throws Exception;
	List getBusinessTripByInput(String[] str) throws Exception;
	void updateBusinessTrip(String id) throws Exception;
	void updateCancelRegBT(String id) throws Exception;
	void delBT(String id) throws Exception;
	List getLeaveList() throws Exception;
	List getLeaveByInput(String[] str) throws Exception;
	void updateLeave(String id) throws Exception;
	void updateCancelRegLeave(String id) throws Exception;
	void delLeave(String id) throws Exception;
	
	List getEmployeeList2(String eStage) throws Exception;
	List getEmployeeByInput2(String[] str) throws Exception;
	
	List getRemindList(String eStage) throws Exception;  
	List getRemindBirthDateList() throws Exception;
}
