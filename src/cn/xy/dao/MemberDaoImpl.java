package cn.xy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.memberBean.MemActInfo;
import cn.xy.memberBean.MemberInfo;

public class MemberDaoImpl implements MemberDao {
	
	//得到hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		
		@Override
		public List getMemberList() throws Exception {
			List<MemberInfo> list =(List<MemberInfo>)hibernateTemplate.find("from MemberInfo");
			return list;
		}
		@Override
		public List getMemberByInput(String[] str) throws Exception {
			String sql = "from MemberInfo where id != ' ' ";
			List arr = new ArrayList();
			if(!str[0].equals("")){
				sql += "and id = ?";
				arr.add(str[0]);
			}
			if(!str[1].equals("")){
				sql += "and mPhone = ?";
				arr.add(str[1]);
			}
			if(!str[2].equals("")){
				sql += "and mType = ?";
				arr.add(str[2]);
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<MemberInfo> list = (List<MemberInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}
		@Override
		public List getMemberById(String id) throws Exception {
			List<MemberInfo> list = (List<MemberInfo>) hibernateTemplate.find("from MemberInfo where id=?", id);
			return list;
		}
		@Override
		public void updateMember(String[] str) throws Exception {
			MemberInfo memberInfo = hibernateTemplate.load(MemberInfo.class, str[0]);
			memberInfo.setmName(str[1]);
			memberInfo.setmPhone(str[2]);
			memberInfo.setmCare(str[3]);
			memberInfo.setmBirth(str[4]);
			memberInfo.setmType(str[5]);
			hibernateTemplate.update(memberInfo);
		}
		@Override
		public void delMember(String id) throws Exception {
			MemberInfo memberInfo = hibernateTemplate.load(MemberInfo.class, id);
			if(memberInfo != null) {
				hibernateTemplate.delete(memberInfo);
			}
		}
		@Override
		public void addMember(String id, String[] str) throws Exception {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setId(id);
			memberInfo.setmName(str[0]);
			memberInfo.setmPhone(str[1]);
			memberInfo.setmCare(str[2]);
			memberInfo.setmBirth(str[3]);
			memberInfo.setmType(str[4]);
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String createTime = dateFormater.format(date);
			memberInfo.setCreateTime(createTime);
			hibernateTemplate.save(memberInfo);
		}
		
		@Override
		public List getMemActList() throws Exception {
			List<MemActInfo> list =(List<MemActInfo>)hibernateTemplate.find("from MemActInfo");
			return list;
		}
		@Override
		public List getMemActByInput(String[] str) throws Exception {
			String sql = "from MemActInfo where id != ' ' ";
			List arr = new ArrayList();
			if(!str[0].equals("")){
				sql += "and aName like ?";
				arr.add("%" + str[0] + "%");
			}
			if(!str[1].equals("")){
				sql += "and aType = ?";
				arr.add(str[1]);
			}
			String[] strings = new String[arr.size()];
			for(int i = 0; i < arr.size(); i++){
				strings[i] = (String) arr.get(i);
			}
			List<MemActInfo> list = (List<MemActInfo>) hibernateTemplate.find(sql,strings);
			return list;
		}
		@Override
		public List getMemActById(String id) throws Exception {
			List<MemActInfo> list = (List<MemActInfo>) hibernateTemplate.find("from MemActInfo where id=?", id);
			return list;
		}
		@Override
		public void updateMemAct(String[] str) throws Exception {
			MemActInfo memActInfo = hibernateTemplate.load(MemActInfo.class, str[0]);
			memActInfo.setaName(str[1]);
			memActInfo.setaInfo(str[2]);
			memActInfo.setaType(str[3]);
			memActInfo.setaPersonnel(str[4]);
			memActInfo.setaCondition(str[5]);
			memActInfo.setaContent(str[6]);
			hibernateTemplate.update(memActInfo);
		}
		@Override
		public void delMemAct(String id) throws Exception {
			MemActInfo memActInfo = hibernateTemplate.load(MemActInfo.class, id);
			if(memActInfo != null) {
				hibernateTemplate.delete(memActInfo);
			}
		}
		@Override
		public void addMemAct(String id, String[] str) throws Exception {
			MemActInfo memActInfo = new MemActInfo();
			memActInfo.setId(id);
			memActInfo.setaName(str[0]);
			memActInfo.setaInfo(str[1]);
			memActInfo.setaType(str[2]);
			memActInfo.setaPersonnel(str[3]);
			memActInfo.setaCondition(str[4]);
			memActInfo.setaContent(str[5]);
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String createTime = dateFormater.format(date);
			memActInfo.setCreateTime(createTime);
			hibernateTemplate.save(memActInfo);
		}
			

}
