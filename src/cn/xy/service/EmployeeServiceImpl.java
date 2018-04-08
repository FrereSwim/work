package cn.xy.service;

import java.util.List;

import cn.xy.dao.EmployeeDao;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List getEmployeeList(String eType) throws Exception {
		return employeeDao.getEmployeeList(eType);
	}
	@Override
	public List getEmployeeByInput(String[] str) throws Exception {
		return employeeDao.getEmployeeByInput(str);
	}
	@Override
	public List getEmployeeById(String id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}
	@Override
	public void updateEmployee(String[] str) throws Exception {
		employeeDao.updateEmployee(str);
	}
	@Override
	public void delEmployee(String id) throws Exception {
		employeeDao.delEmployee(id);
	}
	@Override
	public void addEmployee(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.EMPLOYEE_ID_PREFIX,8);
		employeeDao.addEmployee(id, str);
	}

	@Override
	public List getDepartmentList() throws Exception {
		return employeeDao.getDepartmentList();
	}

	@Override
	public List getDepartmentByInput(String[] str) throws Exception {
		return employeeDao.getDepartmentByInput(str);
	}

	@Override
	public List getDepartmentById(String id) throws Exception {
		return employeeDao.getDepartmentById(id);
	}

	@Override
	public void updateDepartment(String[] str) throws Exception {
		employeeDao.updateDepartment(str);
	}

	@Override
	public void delDepartment(String id) throws Exception {
		employeeDao.delDepartment(id);
	}

	@Override
	public void addDepartment(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.DEPARTMENT_ID_PREFIX,8);
		employeeDao.addDepartment(id, str);	
	}
	
	public void getInfo() throws Exception{
		employeeDao.getInfo();
	}

	@Override
	public void regBusinessTrip(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.BUSINESSTRIP_ID_PREFIX,8);
		employeeDao.addBusinessTrip(id, str);
	}
	
	@Override
	public void regLeave(String[] str) throws Exception {
		String id = IDMD5BuilderUtil.builder(ModulePrefixConstant.LEAVE_ID_PREFIX,8);
		employeeDao.addLeave(id, str);
	}

	@Override
	public List getBusinessTripList() throws Exception {
		return employeeDao.getBusinessTripList();
	}

	@Override
	public List getBusinessTripByInput(String[] str) throws Exception {
		return employeeDao.getBusinessTripByInput(str);
	}

	@Override
	public void approvalBusinessTrip(String id) throws Exception {
		employeeDao.updateBusinessTrip(id);
	}

	@Override
	public void cancelRegBT(String id) throws Exception {
		employeeDao.updateCancelRegBT(id);
	}

	@Override
	public void delBT(String id) throws Exception {
		employeeDao.delBT(id);
	}

	@Override
	public List getLeaveList() throws Exception {
		return employeeDao.getLeaveList();
	}

	@Override
	public List getLeaveByInput(String[] str) throws Exception {
		return employeeDao.getLeaveByInput(str);
	}

	@Override
	public void approvalLeave(String id) throws Exception {
		employeeDao.updateLeave(id);
	}

	@Override
	public void cancelRegLeave(String id) throws Exception {
		employeeDao.updateCancelRegLeave(id);
	}

	@Override
	public void delLeave(String id) throws Exception {
		employeeDao.delLeave(id);
	}
	
	@Override
	public List getEmployeeList2(String eStage) throws Exception {
		return employeeDao.getEmployeeList2(eStage);
	}
	@Override
	public List getEmployeeByInput2(String[] str) throws Exception {
		return employeeDao.getEmployeeByInput2(str);
	}
	
	@Override
	public List getRemindList(String eStage) throws Exception {
		return employeeDao.getRemindList(eStage);
	}

	@Override
	public List getRemindBirthDateList() throws Exception {
		return employeeDao.getRemindBirthDateList();
	}

	@Override
	public List getAttendanceList() throws Exception {
		return employeeDao.getAttendanceList();
	}

	@Override
	public List getAttendanceByInput(String[] str) throws Exception {
		return employeeDao.getAttendanceByInput(str);
	}

}
