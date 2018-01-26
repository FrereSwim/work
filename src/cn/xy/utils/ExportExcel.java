package cn.xy.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import cn.xy.bean.User;

public class ExportExcel {
	
	public void export(String filename, List titleList, List beanList) throws Exception{
		  // 1.创建一个workbook，对应一个Excel文件
	      HSSFWorkbook wb = new HSSFWorkbook();
	      // 2.在workbook中添加一个sheet，对应Excel中的一个sheet
	      HSSFSheet sheet = wb.createSheet(filename);
	      // 3.在sheet中添加表头第0行，老版本poi对excel行数列数有限制short
	      HSSFRow row = sheet.createRow((int) 0);
	      // 4.创建单元格，设置值表头，设置表头居中
	      HSSFCellStyle style = wb.createCellStyle();
	      // 居中格式
	      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	 
	      // 设置表头
	      HSSFCell cell;
	      for(int a = 0; a < titleList.size(); a++){
	    	  cell = row.createCell(a);
		      cell.setCellValue((String)titleList.get(a));
		      cell.setCellStyle(style);
	      }
	      
	      for (int b = 0; b < beanList.size(); b++) {
	          row = sheet.createRow((int) b + 1);
	          List bean = (List) beanList.get(b);
	          // 创建单元格，设置值
	          for(int c = 0; c < bean.size(); c++){
	        	  row.createCell(c).setCellValue((String)bean.get(c));
	          }
	        }
	      String fileName = filename;
	      ByteArrayOutputStream os = new ByteArrayOutputStream();
	      wb.write(os);
	      byte[] content = os.toByteArray();
	      InputStream is = new ByteArrayInputStream(content);
	      // 设置response参数，可以打开下载页面
	      HttpServletResponse res = ServletActionContext.getResponse();
	      res.reset();
	      res.setContentType("application/vnd.ms-excel;charset=utf-8");
	      res.setHeader("Content-Disposition", "attachment;filename="
	          + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
	      ServletOutputStream out = res.getOutputStream();
	      BufferedInputStream bis = null;
	      BufferedOutputStream bos = null;
	 
	      try {
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(out);
	        byte[] buff = new byte[2048];
	        int bytesRead;
	        // Simple read/write loop.
	        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	          bos.write(buff, 0, bytesRead);
	        }
	      } catch (Exception e) {
	        // TODO: handle exception
	        e.printStackTrace();
	      } finally {
	        if (bis != null)
	          bis.close();
	        if (bos != null)
	          bos.close();
	      }
	}

}
