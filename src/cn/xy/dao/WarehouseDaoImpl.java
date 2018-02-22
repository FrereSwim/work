package cn.xy.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.xy.warehouseBean.GoodsInfo;

public class WarehouseDaoImpl implements WarehouseDao {
	
	//得到hibernateTemplate对象
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public List getGoodsInfo() throws Exception {
		List list = hibernateTemplate.find("from GoodsInfo");
		return list;
	}
	@Override
	public List getGoodsByInput(String[] str) throws Exception {
		String sql = "from GoodsInfo where id != ' ' ";
		List arr = new ArrayList();
		if(!str[0].equals("")){
			sql += "and goodsName like ?";
			arr.add("%" + str[0] + "%");
		}
		if(!str[1].equals("")){
			sql += "and type like ?";
			arr.add("%" + str[1] + "%");
		}
		String[] strings = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++){
			strings[i] = (String) arr.get(i);
		}
		List<GoodsInfo> list = (List<GoodsInfo>) hibernateTemplate.find(sql,strings);
		return list;
	}
	@Override
	public List getGoodsById(String id) throws Exception {
		//GoodsInfo GoodsInfo = hibernateTemplate.load(GoodsInfo.class, id);
		List list = hibernateTemplate.find("from GoodsInfo where id =?", id);
		return list;
	}
	@Override
	public void updateGoods(String[] str) throws Exception {
		GoodsInfo goodsInfo = hibernateTemplate.load(GoodsInfo.class, str[0]);
		goodsInfo.setGoodsName(str[1]);
		goodsInfo.setType(str[2]);
		goodsInfo.setNum(str[3]);
		goodsInfo.setUnit(str[4]);
		goodsInfo.setUnitPrice(str[5]);
		goodsInfo.setWarden(str[6]);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createTime = dateFormater.format(date);
		goodsInfo.setCreateTime(createTime);
		hibernateTemplate.update(goodsInfo);
	}
	@Override
	public void delGoods(String id) throws Exception {
		GoodsInfo GoodsInfo = hibernateTemplate.load(GoodsInfo.class, id);
		hibernateTemplate.delete(GoodsInfo);
	}
	@Override
	public void addGoods(String id, String[] str) throws Exception {
		GoodsInfo goodsInfo = new GoodsInfo();
		goodsInfo.setId(id);
		goodsInfo.setGoodsName(str[0]);
		goodsInfo.setType(str[1]);
		goodsInfo.setNum(str[2]);
		goodsInfo.setUnit(str[3]);
		goodsInfo.setUnitPrice(str[4]);
		goodsInfo.setWarden(str[5]);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createTime = dateFormater.format(date);
		goodsInfo.setCreateTime(createTime);
		hibernateTemplate.save(goodsInfo);
	}
	
	
	
}
