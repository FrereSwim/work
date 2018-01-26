package cn.xy.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalculationdDate {

	public List Calculation(String fistTime, String secondTime){
		List dateArr = new ArrayList();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(fistTime.equals(secondTime)){
        	dateArr.add(fistTime);
        }else{
	        try{
	            Date dateOne = dateFormat.parse(fistTime);
	            Date dateTwo = dateFormat.parse(secondTime);
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(dateOne);
	            while(calendar.getTime().before(dateTwo)){               
	                //System.out.println(dateFormat.format(calendar.getTime()));
	            	dateArr.add(dateFormat.format(calendar.getTime()));
	                calendar.add(Calendar.DAY_OF_MONTH, 1);               
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
        }
        dateArr.add(secondTime);
		return dateArr;
	} 
}
