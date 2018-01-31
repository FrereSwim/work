package cn.xy.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cn.xy.menuBean.CarteInfo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelUntil {

	public List readExcel(String filePath) throws IOException, BiffException{
		List list = new ArrayList();
		CarteInfo carte = new CarteInfo();
		InputStream stream = new FileInputStream(filePath); 
		Workbook rwb = Workbook.getWorkbook(stream);
		Sheet sheet = rwb.getSheet(0);
		for(int i= 0; i < sheet.getRows(); i++){
			String[] str = new String[sheet.getColumns()];
			Cell cell = null;
			for(int j = 0; j < sheet.getColumns(); j++){
				cell = sheet.getCell(j,i);
				str[j] = cell.getContents();
				
			}
			carte.setId("1");
			carte.setDishName(str[0]);
			carte.setEnglishName(str[1]);
			carte.setType(str[2]);
			carte.setPrice(str[3]);
			carte.setLevel(str[4]);
			carte.setOrigin(str[5]);
			list.add(carte);
		}
		stream.close();
		return list;
	}
	
	public static void main(String[] args) {
		ReadExcelUntil readExcelUntil = new ReadExcelUntil();
		String filePath = "G:/eclipse/project/RestaurantMain/WebContent/wenjian/菜单模板.xls";
		try {
			List list = readExcelUntil.readExcel(filePath);
			CarteInfo carteInfo = (CarteInfo) list.get(0);
			System.out.println(carteInfo.getDishName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
