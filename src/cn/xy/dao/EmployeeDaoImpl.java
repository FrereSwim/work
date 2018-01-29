package cn.xy.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.employeeBean.AttendanceInfo;
import cn.xy.employeeBean.BusinessTripInfo;
import cn.xy.employeeBean.DepartmentInfo;
import cn.xy.employeeBean.EmployeeInfo;
import cn.xy.employeeBean.LeaveInfo;
import cn.xy.utils.CalculationdDate;
import cn.xy.utils.IDMD5BuilderUtil;
import cn.xy.utils.ModulePrefixConstant;

public class EmployeeDaoImpl implements EmployeeDao {

	//得到hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		@Override
		public List getEmployeeList(String eType) throws Exception {
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find("from EmployeeInfo where eType=?", eType);
			return list;
		}
		@Override
		public List getEmployeeByInput(String[] str) throws Exception {
			String sql = "from EmployeeInfo where eType=? ";
			List arr = new ArrayList();
			arr.add(str[4]);
			if(!str[0].equals("")){
				sql += "and eid like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and eName like ?";
				arr.add("%" + str[1] + "%");
			}
			if(!str[2].equals("")){
				sql += "and eDepar like ?";
				arr.add("%" + str[2] + "%");
			}
			if(!str[3].equals("")){
				sql += "and ePost like ?";
				arr.add("%" + str[3] + "%");
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}
		@Override
		public List getEmployeeById(String id) throws Exception {
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find("from EmployeeInfo where id=?",id);
			return list;
		}
		@Override
		public void updateEmployee(String[] str) throws Exception {
			EmployeeInfo employeeInfo = hibernateTemplate.load(EmployeeInfo.class, str[0]);
			if(employeeInfo != null){
				employeeInfo.setEid(str[1]);
				employeeInfo.seteName(str[2]);
				employeeInfo.seteSex(str[3]);
				employeeInfo.seteAge(str[4]);
				employeeInfo.seteDepar(str[5]);
				employeeInfo.setePost(str[6]);
				employeeInfo.seteType(str[7]);
				employeeInfo.seteEntryTime(str[8]);
				employeeInfo.seteStage(str[9]);
				employeeInfo.seteExpiryTime(str[10]);
				hibernateTemplate.update(employeeInfo);
			}
		}
		@Override
		public void delEmployee(String id) throws Exception {
			EmployeeInfo employeeInfo = hibernateTemplate.load(EmployeeInfo.class, id);
			if(employeeInfo != null){
				hibernateTemplate.delete(employeeInfo);
			}
		}
		@Override
		public void addEmployee(String id, String[] str) throws Exception {
			EmployeeInfo employeeInfo = new EmployeeInfo();
			employeeInfo.setId(id);
			employeeInfo.setEid(str[0]);
			employeeInfo.seteName(str[1]);
			employeeInfo.seteSex(str[2]);
			employeeInfo.seteAge(str[3]);
			employeeInfo.seteDepar(str[4]);
			employeeInfo.setePost(str[5]);
			employeeInfo.seteType(str[6]);
			employeeInfo.seteEntryTime(str[7]);
			employeeInfo.seteStage(str[8]);
			employeeInfo.seteExpiryTime(str[9]);
			hibernateTemplate.save(employeeInfo);
		}

		@Override
		public List getDepartmentList() throws Exception {
			List<DepartmentInfo> list = (List<DepartmentInfo>) hibernateTemplate.find("from DepartmentInfo ORDER BY dMapping ASC"); 
			return list;
		}

		@Override
		public List getDepartmentByInput(String[] str) throws Exception {
			String sql = "from DepartmentInfo where id != ' ' ";
			List arr = new ArrayList();
			if(!str[0].equals("")){
				sql += "and dName like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and dHead like ?";
				arr.add("%" + str[1] + "%");
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<DepartmentInfo> list = (List<DepartmentInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}

		@Override
		public List getDepartmentById(String id) throws Exception {
			List<DepartmentInfo> list = (List<DepartmentInfo>) hibernateTemplate.find("from DepartmentInfo where id=?",id);
			return list;
		}

		@Override
		public void updateDepartment(String[] str) throws Exception {
			DepartmentInfo departmentInfo = hibernateTemplate.load(DepartmentInfo.class, str[0]);
			if(departmentInfo != null){
				departmentInfo.setdName(str[0]);
				departmentInfo.setdHead(str[1]);
				departmentInfo.setdInfo(str[3]);
				//departmentInfo.setdMapping(str[4]);
				hibernateTemplate.update(departmentInfo);
			}
			
		}

		@Override
		public void delDepartment(String id) throws Exception {
			DepartmentInfo departmentInfo = hibernateTemplate.load(DepartmentInfo.class, id);
			if(departmentInfo != null){
				hibernateTemplate.delete(departmentInfo);
			}
			
		}

		@Override
		public void addDepartment(String id, String[] str) throws Exception {
			DepartmentInfo departmentInfo = new DepartmentInfo();
			departmentInfo.setId(id);
			departmentInfo.setdName(str[0]);
			departmentInfo.setdHead(str[1]);
			departmentInfo.setdInfo(str[2]);
			departmentInfo.setdMapping(str[3]);
			hibernateTemplate.save(departmentInfo);
			
		}
		
		public void getInfo() throws Exception {
			Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
			StringBuffer sql = new StringBuffer("select e.eName, e.id, d.dName from EmployeeInfo as e ,DepartmentInfo as d where e.eDepar = d.dMapping");
			Query q = session.createQuery(sql.toString());
			List list = q.list();
			System.out.println();
		}
		
		public void addBusinessTrip(String id, String[] str)throws Exception{
			String eid = str[0];
			String eName = str[1];
			String aReason = str[2];
			String startTime = str[3];
			String endTime = str[4];
			String state = str[5];
			BusinessTripInfo businessTripInfo = new BusinessTripInfo();
			businessTripInfo.setId(id);
			businessTripInfo.setEid(eid);
			businessTripInfo.seteName(eName);
			businessTripInfo.setaReason(aReason);
			businessTripInfo.setStartTime(startTime);
			businessTripInfo.setEndTime(endTime);
			businessTripInfo.setState(state);
			hibernateTemplate.save(businessTripInfo);
			
		}
		
		public void addLeave(String id, String[] str)throws Exception{
			String eid = str[0];
			String eName = str[1];
			String aReason = str[2];
			String startTime = str[3];
			String endTime = str[4];
			String state = str[5];
			LeaveInfo leaveInfo = new LeaveInfo();
			leaveInfo.setId(id);
			leaveInfo.setEid(eid);
			leaveInfo.seteName(eName);
			leaveInfo.setaReason(aReason);
			leaveInfo.setStartTime(startTime);
			leaveInfo.setEndTime(endTime);
			leaveInfo.setState(state);
			hibernateTemplate.save(leaveInfo);
			
		}

		@Override
		public List getBusinessTripList() throws Exception {
			List<BusinessTripInfo> list = (List<BusinessTripInfo>) hibernateTemplate.find("from BusinessTripInfo");
			return list;
		}

		@Override
		public List getBusinessTripByInput(String[] str) throws Exception {
			String sql = "from BusinessTripInfo where id != ' ' ";
			List arr = new ArrayList();
			if(!str[0].equals("")){
				sql += "and eid like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and eName like ?";
				arr.add("%" + str[1] + "%");
			}
			if(!str[2].equals("")){
				sql += "and state like ?";
				arr.add("%" + str[2] + "%");
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<BusinessTripInfo> list = (List<BusinessTripInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}

		@Override
		public void updateBusinessTrip(String id) throws Exception {
			BusinessTripInfo businessTripInfo = hibernateTemplate.load(BusinessTripInfo.class, id);
			List dateArr = new ArrayList();
			String dateFirst = businessTripInfo.getStartTime();
			String dateSecond = businessTripInfo.getEndTime();
			String eid = businessTripInfo.getEid();
			String eName = businessTripInfo.geteName();
			CalculationdDate calculationdDate = new CalculationdDate();
			dateArr = calculationdDate.Calculation(dateFirst, dateSecond);
	        int len = dateArr.size();
	        for(int i = 0; i < len; i++){
	        	String date = (String) dateArr.get(i);
	        	List list =  (List<AttendanceInfo>) hibernateTemplate.find("from AttendanceInfo where eid=? and date=?",eid, date);
	        	if(list == null || list.isEmpty() ){
	        		AttendanceInfo attendanceInfo = new AttendanceInfo();
	        		String aid = IDMD5BuilderUtil.builder(ModulePrefixConstant.ATTENDANCE_ID_PREFIX,8);
	        		attendanceInfo.setId(aid);
	        		attendanceInfo.setDate(date);
	        		attendanceInfo.setEid(eid);
	        		attendanceInfo.seteName(eName);
	        		attendanceInfo.setState("出差");
	        		hibernateTemplate.save(attendanceInfo);
	        	}else{
	        		AttendanceInfo attendanceInfo = (AttendanceInfo) list.get(0);
		        	attendanceInfo.setState("出差");
		        	hibernateTemplate.update(attendanceInfo);
	        	}
	        }
			businessTripInfo.setState("1");
			hibernateTemplate.update(businessTripInfo);
		}

		@Override
		public void updateCancelRegBT(String id) throws Exception {
			BusinessTripInfo businessTripInfo = hibernateTemplate.load(BusinessTripInfo.class, id);
			List dateArr = new ArrayList();
			String dateFirst = businessTripInfo.getStartTime();
			String dateSecond = businessTripInfo.getEndTime();
			String eid = businessTripInfo.getEid();
			String eName = businessTripInfo.geteName();
			CalculationdDate calculationdDate = new CalculationdDate();
			dateArr = calculationdDate.Calculation(dateFirst, dateSecond);
	        int len = dateArr.size();
	        for(int i = 0; i < len; i++){
	        	String date = (String) dateArr.get(i);
	        	List list =  (List<AttendanceInfo>) hibernateTemplate.find("from AttendanceInfo where eid=? and date=?",eid, date);
	        	if(list == null || list.isEmpty()){
	        		AttendanceInfo attendanceInfo = new AttendanceInfo();
	        		String aid = IDMD5BuilderUtil.builder(ModulePrefixConstant.ATTENDANCE_ID_PREFIX,8);
	        		attendanceInfo.setId(aid);
	        		attendanceInfo.setDate(date);
	        		attendanceInfo.setEid(eid);
	        		attendanceInfo.seteName(eName);
	        		attendanceInfo.setState("");
	        		hibernateTemplate.save(attendanceInfo);
	        	}else{
	        		AttendanceInfo attendanceInfo = (AttendanceInfo) list.get(0);
		        	attendanceInfo.setState("");
		        	hibernateTemplate.update(attendanceInfo);
	        	}
	        }
			businessTripInfo.setState("0");
			hibernateTemplate.update(businessTripInfo);
		}

		@Override
		public void delBT(String id) throws Exception {
			BusinessTripInfo businessTripInfo = hibernateTemplate.load(BusinessTripInfo.class, id);
			hibernateTemplate.delete(businessTripInfo);
		}

		@Override
		public List getLeaveList() throws Exception {
			List<LeaveInfo> list = (List<LeaveInfo>) hibernateTemplate.find("from LeaveInfo");
			return list;
		}

		@Override
		public List getLeaveByInput(String[] str) throws Exception {
			String sql = "from LeaveInfo where id != ' ' ";
			List arr = new ArrayList();
			if(!str[0].equals("")){
				sql += "and eid like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and eName like ?";
				arr.add("%" + str[1] + "%");
			}
			if(!str[2].equals("")){
				sql += "and state like ?";
				arr.add("%" + str[2] + "%");
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<LeaveInfo> list = (List<LeaveInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}

		@Override
		public void updateLeave(String id) throws Exception {
			LeaveInfo leaveInfo = hibernateTemplate.load(LeaveInfo.class, id);
			List dateArr = new ArrayList();
			String dateFirst = leaveInfo.getStartTime();
			String dateSecond = leaveInfo.getEndTime();
			String eid = leaveInfo.getEid();
			String eName = leaveInfo.geteName();
			CalculationdDate calculationdDate = new CalculationdDate();
			dateArr = calculationdDate.Calculation(dateFirst, dateSecond);
	        int len = dateArr.size();
	        for(int i = 0; i < len; i++){
	        	String date = (String) dateArr.get(i);
	        	List list =  (List<AttendanceInfo>) hibernateTemplate.find("from AttendanceInfo where eid=? and date=?",eid, date);
	        	if(list == null || list.isEmpty()){
	        		AttendanceInfo attendanceInfo = new AttendanceInfo();
	        		String aid = IDMD5BuilderUtil.builder(ModulePrefixConstant.ATTENDANCE_ID_PREFIX,8);
	        		attendanceInfo.setId(aid);
	        		attendanceInfo.setDate(date);
	        		attendanceInfo.setEid(eid);
	        		attendanceInfo.seteName(eName);
	        		attendanceInfo.setState("请假");
	        		hibernateTemplate.save(attendanceInfo);
	        	}else{
	        		AttendanceInfo attendanceInfo = (AttendanceInfo) list.get(0);
		        	attendanceInfo.setState("请假");
		        	hibernateTemplate.update(attendanceInfo);
	        	}
	        }
	        leaveInfo.setState("1");
			hibernateTemplate.update(leaveInfo);
			
		}

		@Override
		public void updateCancelRegLeave(String id) throws Exception {
			LeaveInfo leaveInfo = hibernateTemplate.load(LeaveInfo.class, id);
			List dateArr = new ArrayList();
			String dateFirst = leaveInfo.getStartTime();
			String dateSecond = leaveInfo.getEndTime();
			String eid = leaveInfo.getEid();
			String eName = leaveInfo.geteName();
			CalculationdDate calculationdDate = new CalculationdDate();
			dateArr = calculationdDate.Calculation(dateFirst, dateSecond);
	        int len = dateArr.size();
	        for(int i = 0; i < len; i++){
	        	String date = (String) dateArr.get(i);
	        	List list =  (List<AttendanceInfo>) hibernateTemplate.find("from AttendanceInfo where eid=? and date=?",eid, date);
	        	if(list == null || list.isEmpty()){
	        		AttendanceInfo attendanceInfo = new AttendanceInfo();
	        		String aid = IDMD5BuilderUtil.builder(ModulePrefixConstant.ATTENDANCE_ID_PREFIX,8);
	        		attendanceInfo.setId(aid);
	        		attendanceInfo.setDate(date);
	        		attendanceInfo.setEid(eid);
	        		attendanceInfo.seteName(eName);
	        		attendanceInfo.setState("");
	        		hibernateTemplate.save(attendanceInfo);
	        	}else{
	        		AttendanceInfo attendanceInfo = (AttendanceInfo) list.get(0);
		        	attendanceInfo.setState("");
		        	hibernateTemplate.update(attendanceInfo);
	        	}
	        }
	        leaveInfo.setState("0");
			hibernateTemplate.update(leaveInfo);
						
		}

		@Override
		public void delLeave(String id) throws Exception {
			LeaveInfo leaveInfo = hibernateTemplate.load(LeaveInfo.class, id);
			hibernateTemplate.delete(leaveInfo);			
		}
		
		private void updateAttState() throws Exception{
			List list =  (List<AttendanceInfo>) hibernateTemplate.find("from AttendanceInfo");
			int len = list.size();
			for(int i = 0; i < len; i++){
				AttendanceInfo attendanceInfo = (AttendanceInfo) list.get(i);
				//String id = attendanceInfo.getId();
				String amState = attendanceInfo.getAmState();
				String pmState = attendanceInfo.getPmState();
				String state = attendanceInfo.getState();
				if(!state.isEmpty()){
					if(amState.equals("0") && pmState.equals("0")){
						attendanceInfo.setState("缺勤");
					}
					if(amState.equals("0") && pmState.equals("1")){
						attendanceInfo.setState("迟到");
					}
					if(amState.equals("1") && pmState.equals("0")){
						attendanceInfo.setState("早退");
					}
					if(amState.equals("1") && pmState.equals("1")){
						attendanceInfo.setState("正常");
					}
					hibernateTemplate.delete(attendanceInfo);
				}
			}
		}
		
		public List getEmployeeList2(String eStage) throws Exception {
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find("from EmployeeInfo where eStage=?", eStage);
			return list;
		}
		
		public List getEmployeeByInput2(String[] str) throws Exception {
			String sql = "from EmployeeInfo where eStage=? ";
			List arr = new ArrayList();
			arr.add(str[4]);
			if(!str[0].equals("")){
				sql += "and eid like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and eName like ?";
				arr.add("%" + str[1] + "%");
			}
			if(!str[2].equals("")){
				sql += "and eDepar like ?";
				arr.add("%" + str[2] + "%");
			}
			if(!str[3].equals("")){
				sql += "and ePost like ?";
				arr.add("%" + str[3] + "%");
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}
		
		public List getRemindList(String eStage) throws Exception {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
		    calendar.setTime(date);
		    calendar.add(calendar.MONTH, 1);
		    date = calendar.getTime();
			String time = dateFormater.format(date);
			String sql = "from EmployeeInfo where eStage=? " 
					   + "and str_to_date(eExpiryTime,'%Y-%m-%d %H:%i:%s') < str_to_date(?,'%Y-%m-%d %H:%i:%s') "
					   + "and str_to_date(eExpiryTime,'%Y-%m-%d %H:%i:%s') > NOW() ORDER BY eExpiryTime ASC";
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find(sql, eStage, time);
			return list;
		}

		@Override
		public List getRemindBirthDateList() throws Exception {
			List elist  = new ArrayList();
			List<EmployeeInfo> list = (List<EmployeeInfo>) hibernateTemplate.find("from EmployeeInfo where eStage = '正式'");
			int len = list.size();
			for(int i = 0; i < len; i++){
				String birthDate = list.get(i).geteBirthDate();
				String[] arr = birthDate.split("-");
				SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String nowDate = dateFormater.format(date);
				String[] arr2 = nowDate.split("-");
				String linshiTime = arr[0] + "-" + arr2[1] + "-" + arr2[2];
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if(dateFormat.parse(birthDate).getTime() > dateFormat.parse(linshiTime).getTime()) {
					int days = (int) ((dateFormat.parse(birthDate).getTime() - dateFormat.parse(linshiTime).getTime()) / (1000*3600*24));
					if(days < 30) {
						elist.add(list.get(i));
					}
				}
			}
			return elist;
		} 
		
		
		
		
		
		
		
		
		
		
		
}
