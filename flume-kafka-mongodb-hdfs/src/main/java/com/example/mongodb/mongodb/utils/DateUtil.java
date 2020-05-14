package com.ledong.platform.app.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil {
	public final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	public final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

	public final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

	public final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public final static SimpleDateFormat sdfWeek = new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");

	public final static SimpleDateFormat sdfOnlyDay = new SimpleDateFormat("dd");

	public final static SimpleDateFormat sdfOnlyMonth = new SimpleDateFormat("MM");

	public static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	public final static SimpleDateFormat sdfOnlyHour = new SimpleDateFormat("HH");

	public final static SimpleDateFormat sdfOnlyMin = new SimpleDateFormat("mm");

	public final static SimpleDateFormat sdfOnlyScounds = new SimpleDateFormat("ss");

	public final static SimpleDateFormat sdfYMDHM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static List<String> getBetweenDate(String firstDay, String secondDay) throws ParseException {
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();

		startDay.setTime(FORMATTER.parse(firstDay));
		endDay.setTime(FORMATTER.parse(secondDay));

		List<String> dateList = printDay(startDay, endDay);
		return dateList;
	}

	/**
	 * 
	 * @Title: getBetweenListDate  
	 * @Description: 获得日期间隔列表
	 * @param @param firstDay
	 * @param @param secondDay
	 * @param @return
	 * @param @throws ParseException      
	 * @return List<String>       
	 * @throws
	 */
	public static List<Date> getBetweenListDate(Date firstDay, Date secondDay) throws ParseException {
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();

		startDay.setTime(firstDay);
		endDay.setTime(secondDay);

		List<Date> dateList = printDayResultDates(startDay, endDay);
		return dateList;
	}

	/**
	 * 
	 * @Title: printDay  
	 * @Description: 返回的是日期集合
	 * @param @param startDay
	 * @param @param endDay
	 * @param @return      
	 * @return List<String>       
	 * @throws
	 */
	private static List<Date> printDayResultDates(Calendar startDay, Calendar endDay) {
		List<Date> dateList = new ArrayList<Date>();
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) >= 0) {
			return dateList;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				break;
			}
			// 打印日期
			dateList.add(currentPrintDay.getTime());
			/* System.out.println(currentPrintDay.getTime()); */
		}
		return dateList;
	}

	private static List<String> printDay(Calendar startDay, Calendar endDay) {
		List<String> dateList = new ArrayList<String>();
		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) >= 0) {
			return dateList;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		while (true) {
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				break;
			}
			// 打印日期
			dateList.add(FORMATTER.format(currentPrintDay.getTime()));
			/* System.out.println(FORMATTER.format(currentPrintDay.getTime())); */
		}
		return dateList;
	}

	public static boolean isWeekDay(Date date) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// String bDate = "2011-12-31";
		String bdate = formatter.format(date);
		Date bDate = formatter.parse(bdate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(bDate);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			System.out.println("yes");
			return true;
		} else {
			System.out.print("no");
			return false;
		}
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
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss 
	 */
	public static Date getDate(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getStringToDate(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return sdfDay.format(new Date());
	}

	public static String getDay(Date date) {
		return sdfDay.format(date);
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return sdfTime.format(new Date());
	}

	public static String getTime(Date date) {
		return sdfTime.format(date);
	}

	/**
	 * @Title: compareDate
	 * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 
	 * @Title: getAfterDate  
	 * @Description: 得到n天之后的日期 返回的是date
	 * @param @param days
	 * @param @return      
	 * @return Date       
	 * @throws
	 */
	public static Date getAfterDate(String days) {
		int daysInt = Integer.parseInt(days);
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();
		return date;
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 根据当前日期获取前N个月的日期
	 * 
	 * @return
	 */
	public static String getDate(int month) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// yyyy-MM-dd
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, month);// 对月份进行计算,减去12个月
		Date date = cal.getTime();
		return df.format(date);

	}


	public static Map<Date, String> getDateWeekMap(List<Date> dateList, Date cDate) {
		Map<Date, String> map = new HashMap<Date, String>();
		String[] wArr = { "周六", "周日", "周一", "周二", "周三", "周四", "周五" };
		for (Date date : dateList) {
			if (cDate == date) {
				map.put(date, "今天");
				continue;
			}
			if (getAfterDate("1") == date) {
				map.put(date, "明天");
				continue;
			}
			Format f = new SimpleDateFormat(" E");
			String e = f.format(date);
			Integer index = Integer.parseInt(e);
			map.put(date, wArr[index - 1]);
		}
		return map;
	}

	/**
	 * 
	 * @Title: getDayWithWeek  
	 * @Description: 2016-08-11 17:02 星期四格式获取
	 * @param @param date
	 * @param @return      
	 * @return String       
	 * @throws
	 */
	public static String getDayWithOnlyWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		return sdf.format(date);
		// System.out.println(format);
	}

	/**
	 * 
	 * @Title: getHHMM  
	 * @Description: 获取2016-08-15 16:18 星期一格式string
	 * @param @param date
	 * @param @return      
	 * @return String       
	 * @throws
	 */
	public static String getYYYYHHMMEEE(Date date) {
		return sdfWeek.format(date);
	}

	/**
	 * 
	 * @Title: getX年X月X日  
	 * @Description: 获取X年X月X日
	 * @param @param date
	 * @param @return      
	 * @return String       
	 * @throws
	 */
	public static String getX年X月X日(Date date) {
		String year = sdfYear.format(date);
		String month = sdfOnlyMonth.format(date);
		String day = sdfOnlyDay.format(date);
		return year + "年" + month + "月" + day + "日";
	}

	/**
	 * 获取指定时间
	 * @param date
	 * @return
	 */
	public static String getStringDate(Date date) {
		String year = sdfYear.format(date);
		String month = sdfOnlyMonth.format(date);
		String day = sdfOnlyDay.format(date);
		String hour = sdfOnlyHour.format(date);
		String min = sdfOnlyMin.format(date);
		String scounds = sdfOnlyScounds.format(date);
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}

	/**
	 * 获取指定时间后30秒的时间
	 * @param date
	 * @return
	 */
	public static String getAfterStringDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 30);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = sdfOnlyHour.format(newDate);
		String min = sdfOnlyMin.format(newDate);
		String scounds = sdfOnlyScounds.format(newDate);
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}
	
	public static String getAfterStringTestDate(Date date,int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, i);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = sdfOnlyHour.format(newDate);
		String min = sdfOnlyMin.format(newDate);
		String scounds = sdfOnlyScounds.format(newDate);
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}
	
	public static String getRedPackageSetDate(Date date,int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR,i);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = "12";
		String min = "00";
		String scounds = "00";
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}
	
	public static String getRedPackageSetDate1(Date date,int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR,i+1);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = "00";
		String min = "00";
		String scounds = "00";
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}
	
	public static String getAfterStringDate1(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 10);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = sdfOnlyHour.format(newDate);
		String min = sdfOnlyMin.format(newDate);
		String scounds = sdfOnlyScounds.format(newDate);
		return scounds + " " + min + " " + hour + " " + day + " " + month + " ? " + year;
	}

	public static String getAfterStringDate2(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, 30);
		Date newDate = calendar.getTime();
		String year = sdfYear.format(newDate);
		String month = sdfOnlyMonth.format(newDate);
		String day = sdfOnlyDay.format(newDate);
		String hour = sdfOnlyHour.format(newDate);
		String min = sdfOnlyMin.format(newDate);
		String scounds = sdfOnlyScounds.format(newDate);
		return scounds + " " + min + " " + hour + " " + day + " " + month
				+ " ? " + year;
	}

	public static String getChineseMonth(Date date) {
		String month = sdfOnlyMonth.format(date);
		String day = sdfOnlyDay.format(date);
		long mothLong = Long.parseLong(month);
		long dayLong = Long.parseLong(day);
		return mothLong + "月" + dayLong;
	}
	/**
	 * 
	 * @Title: getYYYYMMddHHMM  
	 * @Description: 获取yyyy-MM-dd HH:mm
	 * @param @param date
	 * @param @return      
	 * @return String       
	 * @throws
	 */
	public static String getYYYYMMddHHMM(Date date) {
		return sdfYMDHM.format(date);
	}

	public static Long getCheerVideoKeyExpTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(dateFormat.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date newDate = calendar.getTime();
		System.out.println(dateFormat.format(newDate));
		long timeStamp = calendar.getTimeInMillis();
		return timeStamp;
	}

	public static void main(String[] args) {

//		getCheerVideoKeyExpTime();
		SimpleDateFormat  dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		try {
			List<Date> betweenListDate = getBetweenListDate(dateFormat.parse("2017-09-05 12:15:30"),new Date());
		for (Date date : betweenListDate) {
			System.out.println(date);
		}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断第二天是否是月初
	 * 
	 * @return
	 */
	public static boolean nextDate() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,+1);
		int i = cal.get(Calendar.DAY_OF_MONTH);
		if (i == 2) { 
            return true; 
        } 
        return false; 
	}

	public static Map<String, Object> getDateC(Date endDate, Date beginDate) {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long between = 0;
		String str2 = dfs.format(beginDate);
		String str1 = dfs.format(endDate);
		try {
			java.util.Date begin = dfs.parse(str2);
			java.util.Date end = dfs.parse(str1);
			between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		long day = between / (24 * 60 * 60 * 1000);
		long hour = (between / (60 * 60 * 1000) - day * 24);
		long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
//		long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		Map<String, Object> map = new HashMap<String, Object>();
		DecimalFormat df = new DecimalFormat("0.0");
		//当天数小时数为零且分钟数不为负数时，将分钟以小时的小数形式表示
			if(day==0&&hour==0&&min>0&&min<60){
				Double hour1 = (Double) ((hour*60+min)/ 60.0);
			 	map.put("hour", df.format(hour1));
			}else{
				map.put("hour", hour);
			}
			
		map.put("day", day);
		
		return map;
	}
	
}
