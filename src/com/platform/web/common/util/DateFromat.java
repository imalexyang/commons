package com.platform.web.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理类
 * 
 * @author 闫强
 * 
 */
public class DateFromat
{

	/**
	 * 将String类型转换成date类型
	 * @param old_date
	 * @param paten
	 * @return
	 */
	public static Date formatDate(String old_date, String paten)
	{
		Date date = null;
		if (old_date == null || "".equals(old_date))
			return null;
		SimpleDateFormat tempDate = new SimpleDateFormat(paten);
		try
		{
			date = tempDate.parse(old_date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;

	}
	/**
	 * 格式化日期，将日期类型转换成string型
	 * @param old_date
	 * @param paten
	 * @return
	 */
	public static String formatDate(Date old_date, String paten)
	{
		String date = null;
		if (old_date == null)
			return null;
		SimpleDateFormat tempDate = new SimpleDateFormat(paten);
		try
		{
			date = tempDate.format(old_date);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return date;
	}
	
	/** 
     * 得到两个日期之间相差的天数 
     * 
     * @param newDate 大的日期 
     * @param oldDate 小的日期 
     * @return newDate-oldDate相差的天数 
     */  
    public static int daysBetweenDates(Date newDate, Date oldDate)  
    {  
        int days = 0;  
        Calendar calo = Calendar.getInstance();  
        Calendar caln = Calendar.getInstance();  
        calo.setTime(oldDate);  
        caln.setTime(newDate);  
        int oday = calo.get(Calendar.DAY_OF_YEAR);  
        int nyear = caln.get(Calendar.YEAR);  
        int oyear = calo.get(Calendar.YEAR);  
        while (nyear > oyear)  
        {  
            calo.set(Calendar.MONTH, 11);  
            calo.set(Calendar.DATE, 31);  
            days = days + calo.get(Calendar.DAY_OF_YEAR);  
            oyear = oyear + 1;  
            calo.set(Calendar.YEAR, oyear);  
        }  
        int nday = caln.get(Calendar.DAY_OF_YEAR);  
        days = days + nday - oday;  
  
        return days;  
    }  
}
