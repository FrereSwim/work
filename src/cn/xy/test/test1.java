package cn.xy.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test1 {

	public static void main(String args[]){
        
        display("2008-08-08", "2008-09-11");
         
    }
     
    public static void display(String dateFirst, String dateSecond){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(dateFirst.equals(dateSecond)){
        	System.out.println(dateFirst);
        }else{
	        try{
	            Date dateOne = dateFormat.parse(dateFirst);
	            Date dateTwo = dateFormat.parse(dateSecond);
	             
	            Calendar calendar = Calendar.getInstance();
	             
	            calendar.setTime(dateOne);
	             
	            while(calendar.getTime().before(dateTwo)){               
	                System.out.println(dateFormat.format(calendar.getTime()));
	                 
	                calendar.add(Calendar.DAY_OF_MONTH, 1);               
	            }
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
        }
         
    }
}
