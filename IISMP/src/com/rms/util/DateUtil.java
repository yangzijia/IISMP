package com.rms.util;

import java.text.*;
import java.util.*;

/**
 *方法说明:
 *@author:lishun
 *@date:2012-8-4
 */
public class DateUtil {
	

	/**
	 * 获取12小时制当前日期字符串
	 * @return
	 */
	public static String getStrDate_12(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  currentTime = new Date();
		String strDate = formatter.format(currentTime);
		return strDate;
	}
	
	/**
	 * 获取24小时制当前日期字符串
	 * @return
	 */
	public static String getStrDate_24(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  currentTime = new Date();
		String strDate = formatter.format(currentTime);
		return strDate;
	}
	
	/**
	 * 获取当前日期字符串yyyy-MM
	 * @return
	 */
	public static String getStrDateyyyy_MM(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		Date  currentTime = new Date();
		String strDate = formatter.format(currentTime);
		return strDate;
	}
	
	/**
	 * 获取格式化当前时间、毫秒字符串
	 * @return
	 */
	public static String getStrDateS(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		Date currentTime = new Date();
		String strDate = formatter.format(currentTime);
		return strDate;
	}
	
	/**
	 * 转换日期为字符串格式<p>
	 * @param Date
	 * @return
	 */
	public static String DateToStr(java.util.Date Date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = formatter.format(Date);
		return strDate;
	}
	
	/**
	 * 转换日期为格式化字符串
	 * @param Date
	 * @param format
	 * @return
	 */
	public static String DateToFormatStr(java.util.Date Date,String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate = formatter.format(Date);
		return strDate;
	}
	
	/**
	 * 获取当前日期 格式为MM月dd日
	 * @return strDate
	 */
	public static String getNowDateyueri(){
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
		Date date = new Date();
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * 获取当前日期 格式为yyyy年MM月
	 * @return strDate
	 */
	public static String getNowDatenianyue(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月");
		Date date = new Date();
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * 获取当前日期 格式为 yyyy-MM-dd
	 * @return strDate
	 */
	public static String getNowStrDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * 获取当间时间字符串   yyyyMMddHHmmss
	 * @return
	 */
	public static String getLongDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * 获取当间时间字符串   yyyyMMddHHmmssSS
	 * @return
	 */
	public static String getLongDateS(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSS");
		Date date = new Date();
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * 比较二个日期
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean Compare_Date(java.util.Date date1,java.util.Date date2){
		return date1.equals(date2);
	} 
	
	/**
	 * 将字符串类型的时间转化为Date型
	 * @param strDate
	 * @param formatDate
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date str2Date(String strDate,String formatDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate); 
		return sdf.parse(strDate);
	}
	
	/**
	 * 将字符串类型的时间转化为Date型，并将在此时间上进行增加或减少相应天
	 * @param strDate
	 * @param formatDate
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date otherDate(String strDate,String formatDate,int num) throws ParseException{
		Calendar c = new GregorianCalendar();
		
		Date date = str2Date(strDate,formatDate);
		
		c.setTime(date);
		
		c.add(Calendar.DATE,num);
		
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		
		return str2Date(sdf.format(c.getTime()),formatDate);
	}
	
	 /**
	  * 获取现在时间
	  * 
	  * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	  */
	 public static Date getNowDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	 }

	 /**
	  * 获取现在时间
	  * 
	  * @return返回短时间格式 yyyy-MM-dd
	  */
	 public static Date getNowDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	 }

	 /**
	  * 获取现在时间
	  * 
	  * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	  */
	 public static String getStringDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }

	 /**
	  * 获取现在时间
	  * 
	  * @return 返回短时间字符串格式yyyy-MM-dd
	  */
	 public static String getStringDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 获取时间 小时:分  HH:mm
	  * @return
	  */
	 public static String getTimeHHmm(){
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		 Date currentTime = new Date();
		 String dateString = formatter.format(currentTime);
		 return dateString;
	 }

	 /**
	  * 获取时间 小时:分;秒 HH:mm:ss
	  * 
	  * @return
	  */
	 public static String getTimeShort() {
	  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	  Date currentTime = new Date();
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }

	 /**
	  * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	  * 
	  * @param strDate
	  * @return
	  */
	 public static Date strToDateLong(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	 }

	 /**
	  * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	  * 
	  * @param dateDate
	  * @return
	  */
	 public static String dateToStrLong(java.util.Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	 }

	 /**
	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  * 
	  * @param dateDate
	  * @param k
	  * @return
	  */
	 public static String dateToStr(java.util.Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	 }

	 /**
	  * 将短时间格式字符串转换为时间 yyyy-MM-dd 
	  * 
	  * @param strDate
	  * @return
	  */
	 public static Date strToDate(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	 }

	 /**
	  * 得到现在时间
	  * 
	  * @return
	  */
	 public static Date getNow() {
	  Date currentTime = new Date();
	  return currentTime;
	 }

	 /**
	  * 提取一个月中的最后一天
	  * 
	  * @param day
	  * @return
	  */
	 public static Date getLastDate(long day) {
	  Date date = new Date();
	  long date_3_hm = date.getTime() - 3600000 * 34 * day;
	  Date date_3_hm_date = new Date(date_3_hm);
	  return date_3_hm_date;
	 }
	 
	 /**
	  * 得到现在时间
	  * 
	  * @return 字符串 yyyyMMdd HHmmss
	  */
	 public static String getStringToday() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }

	 /**
	  * 得到现在小时
	  */
	 public static String getHour() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  String hour;
	  hour = dateString.substring(11, 13);
	  return hour;
	 }

	 /**
	  * 得到现在分钟
	  * 
	  * @return
	  */
	 public static String getTime() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  String min;
	  min = dateString.substring(14, 16);
	  return min;
	 }

	 /**
	  * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	  * 
	  * @param sformat
	  *            yyyyMMddhhmmss
	  * @return
	  */
	 public static String getUserDate(String sformat) {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat(sformat);
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 将yyyy-MM-dd转化为MM月dd日
	  */
	 public static String getmmyueddri(String str){
		 String[] kk = null;
		 kk = str.split("-");
		 String info = kk[1]+"月"+kk[2]+"日";
		 return info;
	 }
	 
	 /**
	  * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	  */
	 public static String getTwoHour(String st1, String st2) {
	  String[] kk = null;
	  String[] jj = null;
	  kk = st1.split(":");
	  jj = st2.split(":");
	  if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
	   return "0";
	  else {
	   double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
	   double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
	   if ((y - u) > 0)
	    return y - u + "";
	   else
	    return "0";
	  }
	 }
	 

	 /**
	  * 得到二个日期间的间隔天数 yyyy-MM-dd
	  */
	 public static String getTwoDay(String sj1, String sj2) {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  long day = 0;
	  try {
	   java.util.Date date = myFormatter.parse(sj1);
	   java.util.Date mydate = myFormatter.parse(sj2);
	   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  } catch (Exception e) {
	   return "";
	  }
	  return day + "";
	 }
	 
	 /**
	  * 时间前推分钟,其中JJ表示分钟.
	  */
	 public static String getNextTimehhmm(String sj1, String jj) {
	  SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	  String mydate1 = "";
	  try {
	   Date date1 = format.parse(sj1);
	   long Time = (date1.getTime() / 1000) - Integer.parseInt(jj) * 60;
	   date1.setTime(Time * 1000);
	   mydate1 = format.format(date1);
	  } catch (Exception e) {
	  }
	  return mydate1;
	 }
	 
	 /**
	  * 时间后推分钟,其中JJ表示分钟.
	  */
	 public static String getPreTimehhmm(String sj1, String jj) {
	  SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	  String mydate1 = "";
	  try {
	   Date date1 = format.parse(sj1);
	   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
	   date1.setTime(Time * 1000);
	   mydate1 = format.format(date1);
	  } catch (Exception e) {
	  }
	  return mydate1;
	 }

	 /**
	  * 时间前推或后推分钟,其中JJ表示分钟.
	  */
	 public static String getPreTime(String sj1, String jj) {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String mydate1 = "";
	  try {
	   Date date1 = format.parse(sj1);
	   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
	   date1.setTime(Time * 1000);
	   mydate1 = format.format(date1);
	  } catch (Exception e) {
	  }
	  return mydate1;
	 }

	 /**
	  * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	  */
	 public static String getNextDay(String nowdate, String delay) {
	  try{
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  String mdate = "";
	  Date d = strToDate(nowdate);
	  long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
	  d.setTime(myTime * 1000);
	  mdate = format.format(d);
	  return mdate;
	  }catch(Exception e){
	   return "";
	  }
	 }

	 /**
	  * 判断是否润年
	  * @param ddate
	  * @return
	  */
	 public static boolean isLeapYear(String ddate) {

	  /**
	   * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	   * 3.能被4整除同时能被100整除则不是闰年
	   */
	  Date d = strToDate(ddate);
	  GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	  gc.setTime(d);
	  int year = gc.get(Calendar.YEAR);
	  if ((year % 400) == 0)
	   return true;
	  else if ((year % 4) == 0) {
	   if ((year % 100) == 0)
	    return false;
	   else
	    return true;
	  } else
	   return false;
	 }

	 /**
	  * 返回美国时间格式 26 Apr 2006
	  * 
	  * @param str
	  * @return
	  */
	 public static String getEDate(String str) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(str, pos);
	  String j = strtodate.toString();
	  String[] k = j.split(" ");
	  return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	 }

	  
	 
	 /**
	  * 根据传来的yyyy年MM月返回该月的有多少天
	  */
	 public static String getMonthNum(String dat){
		 String[] k = dat.split("年");
		 String[] s = k[1].split("月");
		 String dnum = "";
		 int month = Integer.parseInt(s[0]);
		 int year = Integer.parseInt(k[0]);
		 //System.out.println(year+"-"+month);
		 switch(month){
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
			 dnum = "31";
			 break;
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 dnum = "30";
			 break;
		 case 2:
			 dnum = (isLeapYear(year)?"29":"28");
			 break;
		 }
		 return dnum;
	 }
	 
	 /**
	  * 判断该年时候是闰年
	  */
	 public static boolean isLeapYear(int year){
		 if(year % 100 == 0){
			 if(year % 400 == 0){
				 return true;
			 }
		 } else {
			 if(year % 4 == 0){
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * 获取一个月的最后一天
	  * 
	  * @param dat
	  * @return
	  */
	 public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
	  String str = dat.substring(0, 8);
	  String month = dat.substring(5, 7);
	  int mon = Integer.parseInt(month);
	  if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
	   str += "31";
	  } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
	   str += "30";
	  } else {
	   if (isLeapYear(dat)) {
	    str += "29";
	   } else {
	    str += "28";
	   }
	  }
	  return str;
	 }

	 /**
	  * 判断二个时间是否在同一个周
	  * 
	  * @param date1
	  * @param date2
	  * @return
	  */
	 public static boolean isSameWeekDates(Date date1, Date date2) {
	  Calendar cal1 = Calendar.getInstance();
	  Calendar cal2 = Calendar.getInstance();
	  cal1.setTime(date1);
	  cal2.setTime(date2);
	  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
	  if (0 == subYear) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
	   // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  }
	  return false;
	 }

	 /**
	  * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	  * 
	  * @param sdate
	  * @param num
	  * @return
	  */
	 public static String getWeek(String sdate, String num) {
	  // 再转换为时间
	  Date dd = DateUtil.strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(dd);
	  if (num.equals("1")) // 返回星期一所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	  else if (num.equals("2")) // 返回星期二所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	  else if (num.equals("3")) // 返回星期三所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
	  else if (num.equals("4")) // 返回星期四所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	  else if (num.equals("5")) // 返回星期五所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
	  else if (num.equals("6")) // 返回星期六所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	  else if (num.equals("0")) // 返回星期日所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	  return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	 }

	 /**
	  * 根据一个日期，返回是星期几的字符串
	  * 
	  * @param sdate
	  * @return
	  */
	 public static String getWeek(String sdate) {
	  // 再转换为时间
	  Date date = DateUtil.strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(date);
	  // int hour=c.get(Calendar.DAY_OF_WEEK);
	  // hour中存的就是星期几了，其范围 1~7
	  // 1=星期日 7=星期六，其他类推
	  return new SimpleDateFormat("EEEE").format(c.getTime());
	 }
	 public static String getWeekStr(String sdate){
	  String str = "";
	  str = DateUtil.getWeek(sdate);
	  if("1".equals(str)){
	   str = "星期日";
	  }else if("2".equals(str)){
	   str = "星期一";
	  }else if("3".equals(str)){
	   str = "星期二";
	  }else if("4".equals(str)){
	   str = "星期三";
	  }else if("5".equals(str)){
	   str = "星期四";
	  }else if("6".equals(str)){
	   str = "星期五";
	  }else if("7".equals(str)){
	   str = "星期六";
	  }
	  return str;
	 }

	 /**
	  * 两个时间之间的天数
	  * 
	  * @param date1
	  * @param date2
	  * @return
	  */
	 public static long getDays(String date1, String date2) {
	  if (date1 == null || date1.equals(""))
	   return 0;
	  if (date2 == null || date2.equals(""))
	   return 0;
	  // 转换为标准时间
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  java.util.Date date = null;
	  java.util.Date mydate = null;
	  try {
	   date = myFormatter.parse(date1);
	   mydate = myFormatter.parse(date2);
	  } catch (Exception e) {
	  }
	  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  return day;
	 }

	 /**
	  * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	  * 此函数返回该日历第一行星期日所在的日期
	  * 
	  * @param sdate
	  * @return
	  */
	 public static String getNowMonth(String sdate) {
	  // 取该时间所在月的一号
	  sdate = sdate.substring(0, 8) + "01";

	  // 得到这个月的1号是星期几
	  Date date = DateUtil.strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(date);
	  int u = c.get(Calendar.DAY_OF_WEEK);
	  String newday = DateUtil.getNextDay(sdate, (1 - u) + "");
	  return newday;
	 }

	 /**
	  * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	  * 
	  * @param k
	  *            表示是取几位随机数，可以自己定
	  */

	 public static String getNo(int k) {

	  return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	 }

	 /**
	  * 返回一个随机数
	  * 
	  * @param i
	  * @return
	  */
	 public static String getRandom(int i) {
	  Random jjj = new Random();
	  // int suiJiShu = jjj.nextInt(9);
	  if (i == 0)
	   return "";
	  String jj = "";
	  for (int k = 0; k < i; k++) {
	   jj = jj + jjj.nextInt(9);
	  }
	  return jj;
	 }

	 /**
	  * 
	  * @param args
	  */
	 public static boolean RightDate(String date) {

	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  if (date == null)
	   return false;
	  if (date.length() > 10) {
	   sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  } else {
	   sdf = new SimpleDateFormat("yyyy-MM-dd");
	  }
	  try {
	   sdf.parse(date);
	  } catch (ParseException pe) {
	   return false;
	  }
	  return true;
	 }
	 
	 /**
	  * 补0
	  * @param v
	  * @return
	  */
	 public static String fillzero(String v){
		 if(Integer.parseInt(v)<10){
			v="0"+v;
		 }
		 return v;
	 }
	 
	 public static String fillzeroint(int v){
		 String vv = v+"";
		 if(Integer.parseInt(vv)<10){
			vv="0"+vv;
		 }
		 return vv;
	 }
	 
	 /**
	  * 获取当前年
	  */
	 public static int getYear() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
	  String dateString = formatter.format(currentTime);
	  return Integer.parseInt(dateString);
	 }
	 
	 
	 /**
	  * 获取当月是几月
	  */
	 public static int getMonth() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("MM");
	  String dateString = formatter.format(currentTime);
	  return Integer.parseInt(dateString);
	 }
	 
	 /**
	  * 获取当月1到现在有多少天
	  */
	 public static int getMonthtoToday() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("dd");
	  String dateString = formatter.format(currentTime);
	  return Integer.parseInt(dateString);
	 }
	 
	 /**
	  * 根据传来的 yyyy年MM月 判断该月有几个星期几
	  * @param String yyyy年MM月
	  * @param String weekname
	  * @return int num
	 * @throws ParseException 
	  */
	 public static int getweeknum(String dat,String weekname,int monthNum) throws ParseException{
		 int num = 0;
		 String[] k = dat.split("年");
		 String[] s = k[1].split("月");
		 //获取当月de第几号
		// int monthNum = getMonthtoToday();
System.out.println(monthNum);
		 for(int i = 1;i<monthNum;i++){
			 String nianyueri = k[0]+"-"+fillzero(s[0])+"-"+fillzero(i+"");
			 String week = getWeekDay(nianyueri);
			 if(weekname.equals(week)){
				 num++;
			 }
		 }
		 return num;
	 }
	 
	 
	 /**
	  * 计算time1到time2 有几个星期“” weekname
	  * @return
	  */
	public static int getTowNumweeknum(String time1,String time2,String weekname){
		int num = 0;
		try {
			String[] tm1 = time1.split("-");
			String[] tm2 = time2.split("-");
			
			String[] mon1 = getEndDateOfMonth(time1).split("-");
			
			if(getDays(time2,time1)>0){
				if(getDays(time2, getEndDateOfMonth(time1))>0){
					//time2>time1 的月底
					for(int i=Integer.parseInt(tm1[2]);i<=Integer.parseInt(mon1[2]);i++){
						String nianyueri = tm1[0]+"-"+fillzero(tm1[1])+"-"+fillzeroint(i);
						System.out.println("1="+nianyueri);
						String week = getWeekDay(nianyueri);
						if(weekname.equals(week)){
							num++;
						}
					}
					for(int i=1;i<=Integer.parseInt(tm2[2]);i++){
						String nianyueri = tm2[0]+"-"+fillzero(tm2[1])+"-"+fillzeroint(i);
						System.out.println("2="+nianyueri);
						String week = getWeekDay(nianyueri);
						if(weekname.equals(week)){
							num++;
						}
					}
				}else{
					//time2<time1 的月底
					for(int i=Integer.parseInt(tm1[2]);i<=Integer.parseInt(tm2[2]);i++){
						String nianyueri = tm1[0]+"-"+fillzero(tm1[1])+"-"+fillzeroint(i);
						System.out.println("3="+nianyueri);
						String week = getWeekDay(nianyueri);
						if(weekname.equals(week)){
							num++;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	 
	/**
	  * 获取某一天是一周中的星期几
	  * 
	  * @param strDate 1900-01-01
	  * @return
	  * @throws ParseException
	  */
	 public static String getWeekDay(String strDate) throws ParseException {
	  String nReturn = "";
	  Calendar cDay = Calendar.getInstance(); // 实例化一个Calendar对象
	  cDay.clear(); // 清空Calendar
	  cDay.set(Integer.parseInt(strDate.substring(0, 4)), Integer
	    .parseInt(strDate.substring(5, 7)) - 1, Integer
	    .parseInt(strDate.substring(8, 10))); // 设置这个日期的内容
	  switch (cDay.get(Calendar.DAY_OF_WEEK)) {
	  case 1:
	   nReturn = "星期日"; // 周日
	   break;
	  case 2:
	   nReturn = "星期一"; // 周一
	   break;
	  case 3:
	   nReturn = "星期二"; // 周二
	   break;
	  case 4:
	   nReturn = "星期三"; // 周三
	   break;
	  case 5:
	   nReturn = "星期四"; // 周四
	   break;
	  case 6:
	   nReturn = "星期五"; // 周五
	   break;
	  case 7:
	   nReturn = "星期六"; // 周六
	   break;
	  default:
	   nReturn = null;
	   break;
	  }
	  return nReturn;
	 }
}