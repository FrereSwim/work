package cn.xy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class IDMD5BuilderUtil {
	
	private static final String PATTERN_ONLY_DATE = "yyyy-MM-dd";
	private static final String PATTERN_ONLY_TIME = "HH:mm:ss";
	private static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";
	private static final HashMap<String, SimpleDateFormat> FORMATS = new HashMap<String, SimpleDateFormat>();
	static {
		FORMATS.put(PATTERN_ONLY_DATE, new SimpleDateFormat(PATTERN_ONLY_DATE));
		FORMATS.put(PATTERN_ONLY_TIME, new SimpleDateFormat(PATTERN_ONLY_TIME));
		FORMATS.put(PATTERN_DATETIME, new SimpleDateFormat(PATTERN_DATETIME));
	}

	public static String  builder(String prefix , int length){
		  return  prefix  + dateToString(new Date() , "yyyyMMddHHmmss") + generateString(length);
	}
	
	/**
	 *  随机生成N位数字字符串
	 * @param length  位数
	 * @return
	 */
	public static String  generateString(int length){
			StringBuffer sb = new StringBuffer();  
	        Random random = new Random();  
	        for (int i = 0; i < length; i++) {  
	            sb.append(random.nextInt(10));  
	        }  
	        return sb.toString();  
	}
	
	/**
	 * 日期对象转字符串，用户指定格式化对象
	 * 
	 * @param date
	 *            日期对象
	 * @param dateFormat
	 *            格式化对象
	 * @return
	 */
	public static String dateToString(Date date, SimpleDateFormat dateFormat) {
		if (date == null) {
			throw new IllegalArgumentException("date can't be null");
		}
		return dateFormat.format(date);
	}
	
	/**
	 * 日期对象转字符串，用户指定格式
	 * 
	 * @param date
	 *            日期对象
	 * @param pattern
	 *            格式化
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		return dateToString(date, getSimpleDateFormat(pattern));
	}
	
	/**
	 * 根据格式获取格式化对象
	 * 
	 * @param pattern
	 * @return
	 */
	private static SimpleDateFormat getSimpleDateFormat(String pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("pattern can't be null");
		}
		SimpleDateFormat dateFormat = FORMATS.get(pattern);
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat(pattern);
			FORMATS.put(pattern, dateFormat);
		}
		return dateFormat;
	}
}
