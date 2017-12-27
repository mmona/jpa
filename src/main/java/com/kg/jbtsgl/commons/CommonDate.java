package com.kg.jbtsgl.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CommonDate extends Date {
	private static final long serialVersionUID = 1L;

	public static final String TIMEZONE_DEFAULT = "US/Central";

	/**
	 * Format to yyyy-MM-dd
	 */
	public static final Integer SHORT = 1;

	/**
	 * Format to yyyy-MM-dd HH:mm:ss.S
	 */
	public static final Integer LONG = 2;

	
	
	/**
	 * Format to ddMMMyy
	 */
	public static final Integer SHORT_US = 3;
	
	/**
	 * Format to yyyyMMdd
	 */
	public static final Integer SHORT1 = 4;


	/**
	 * Format to ddMMMyy hh:mm a zzz
	 */
	public static final Integer LONG12_US = 4;

	/**
	 * Format to ddMMMyy hh:mm a zzz
	 */
	public static final Integer LONG24_US = 5;

	/**
	 * Format to HH:mm:ss
	 */
	public static final Integer TIME_US = 6;

	/**
	 * Format to yyyy-MM-dd'T'HH:mm:ss.SSSTZD e.g. 2011-10-21T12:20:53.012+03:00
	 */
	public static final Integer TIME_STANMP = 7;

	/**
	 * Format to MMMyyyydd
	 */
	public static final Integer SHORT9_US = 8;
	/**
	 * Formate to MM/dd/yy
	 * 
	 */
	public static final Integer SHORT8 = 9;
	
	/**
	 * Format to yyyy-MM-dd HH:mm:ss
	 */
	public static final Integer Normal = 10;
	
	public static final Integer DEFAULT_FORMAT = SHORT8;
	
	private Integer formatFlag;

	private String pattern;

	private boolean isNull = false;

	public static CommonDate getInstance(Date date, Integer formatFlag) {
		if (date == null) {
			return null;
		}
		return new CommonDate(date, formatFlag);
	}

	public static CommonDate getInstance(Date date) {
		if (date == null) {
			return null;
		}
		return new CommonDate(date);
	}

	public static CommonDate getInstance(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return new CommonDate(date, pattern);
	}

	public static CommonDate getInstance(Integer formatFlag) {
		return new CommonDate(formatFlag);
	}

	public static CommonDate getInstance() {
		return new CommonDate();
	}

	private CommonDate(Integer formatFlag) {
		super();
		this.setFormatFlag(formatFlag);
	}

	private CommonDate() {
		super();
		this.setFormatFlag(DEFAULT_FORMAT);
	}

	private CommonDate(Date date) {
		super();
		if (date == null) {
			this.isNull = true;
		} else {
			this.setTime(date.getTime());
		}
		this.setFormatFlag(DEFAULT_FORMAT);
	}

	private CommonDate(Date date, Integer formatFlag) {
		super();
		if (date == null) {
			this.isNull = true;
		} else {
			this.setTime(date.getTime());
		}
		if(formatFlag == null){
			this.setFormatFlag(DEFAULT_FORMAT);
		}else{
			this.setFormatFlag(formatFlag);
		}
	}

	private CommonDate(Date date, String pattern) {
		super();
		if (date == null) {
			this.isNull = true;
		} else {
			this.setTime(date.getTime());
		}
		this.setPattern(pattern);
	}

	public void setFormatFlag(Integer formatFlag) {
		this.formatFlag = formatFlag;
	}

	public Integer getFormatFlag() {
		return formatFlag;
	}

	@Override
	public String toString() {
		if (isNull) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyy");
		String formatedDate = "";
		if (this.getPattern() != null) {
			sdf = new SimpleDateFormat(this.getPattern());
		} else {
			if (formatFlag == CommonDate.SHORT_US) {
				sdf = new SimpleDateFormat("ddMMMyy", Locale.US);
				return sdf.format(this);
			} else if (formatFlag == CommonDate.SHORT1) {
				sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
			} else if (formatFlag == CommonDate.LONG24_US) {
				sdf = new SimpleDateFormat("ddMMMyy HH:mm zzz", Locale.US);
			} else if (formatFlag == CommonDate.LONG12_US) {
				sdf = new SimpleDateFormat("ddMMMyy hh:mm a zzz", Locale.US);
			} else if (formatFlag == CommonDate.TIME_US) {
				sdf = new SimpleDateFormat("HH:mm:ss", Locale.US);
			} else if (formatFlag == CommonDate.SHORT) {
				sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
				return sdf.format(this);
			} else if (formatFlag == CommonDate.LONG) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.US);
			} else if (formatFlag == CommonDate.TIME_STANMP) {
				sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",
						Locale.US);
			} else if (formatFlag == CommonDate.SHORT9_US) {
				sdf = new SimpleDateFormat("MMMyyyydd", Locale.US);
			} else if (formatFlag == CommonDate.SHORT8) {
				sdf = new SimpleDateFormat("MM/dd/yy", Locale.US);
			} else if(formatFlag == CommonDate.Normal){
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			}
			else { // Default as "ddMMMyy"
				sdf = new SimpleDateFormat("ddMMMyy", Locale.US);
				return sdf.format(this);
			}
		}
		//setTimeZone(sdf);
		formatedDate = sdf.format(this);
		if (formatFlag == CommonDate.TIME_STANMP) {
			if (formatedDate.endsWith("0000")) {
				return formatedDate.substring(0, formatedDate.length() - 5)
						+ "Z";
			} else {
				int dindex = formatedDate.length() - 2;
				return formatedDate.substring(0, dindex) + ":"
						+ formatedDate.substring(dindex);
			}
		}
		return formatedDate;
	}

	@SuppressWarnings("unused")
	private void setTimeZone(SimpleDateFormat sdf) {
		sdf.setTimeZone(TimeZone.getTimeZone(CommonDate.TIMEZONE_DEFAULT));
	}

	public static Date parseDate(String str, Integer formatFlag)
			throws ParseException {
		return CommonDate.parseDate(str, formatFlag, null);
	}

	public static Date parseDate(String str, String pattern)
			throws ParseException {
		return CommonDate.parseDate(str, null, pattern);
	}

	public static Date parseDate(String str)
			throws ParseException {
		return CommonDate.parseDate(str, null, null);
	}

	private static Date parseDate(String dateString, Integer formatFlag,
			String pattern) throws ParseException {
		if (dateString == null || "".equals(dateString)) {
			return null;
		}
		if(formatFlag == null){
			formatFlag = DEFAULT_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyy");
		if (pattern != null) {
			sdf = new SimpleDateFormat(pattern, Locale.US);
		} else {
			if (formatFlag == CommonDate.SHORT_US) {
				sdf = new SimpleDateFormat("ddMMMyy", Locale.US);
				return sdf.parse(dateString);
			} else if (formatFlag == CommonDate.SHORT1) {
				sdf = new SimpleDateFormat("yyyyMMdd", Locale.US);
			} else if (formatFlag == CommonDate.LONG24_US) {
				sdf = new SimpleDateFormat("ddMMMyy HH:mm zzz", Locale.US);
			} else if (formatFlag == CommonDate.LONG12_US) {
				sdf = new SimpleDateFormat("ddMMMyy hh:mm a zzz", Locale.US);
			} else if (formatFlag == CommonDate.TIME_US) {
				sdf = new SimpleDateFormat("HH:mm:ss", Locale.US);
			} else if (formatFlag == CommonDate.SHORT) {
				sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
				return sdf.parse(dateString);
			} else if (formatFlag == CommonDate.LONG) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.US);
			} else if (formatFlag == CommonDate.TIME_STANMP) {
				sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ",
						Locale.US);
				if (dateString.endsWith("Z")) {
					dateString = dateString.substring(0,
							dateString.length() - 1) + "+0000";
				} else {
					int tzsindex = dateString.length() - 6;
					char tzsign = dateString.charAt(tzsindex);
					if (tzsign == '+' || tzsign == '-') {
						dateString = dateString.substring(0, tzsindex)
								+ dateString.substring(tzsindex).replaceAll(
										":", "");
					}
				}
			} else if (formatFlag == CommonDate.SHORT9_US) {
				sdf = new SimpleDateFormat("MMMyyyydd", Locale.US);
			} else if (formatFlag == CommonDate.SHORT8) {
				sdf = new SimpleDateFormat("MM/dd/yy", Locale.US);
			} else if (formatFlag == CommonDate.Normal) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			} else { // Default 'ddMMMyy'
				sdf = new SimpleDateFormat("ddMMMyy", Locale.US);
				return sdf.parse(dateString);
			}
		}
		sdf.setTimeZone(TimeZone.getTimeZone(CommonDate.TIMEZONE_DEFAULT));
		Date parsedDate = sdf.parse(dateString);
		if (pattern != null) {
			return CommonDate.getInstance(parsedDate, pattern);
		}else{
			return CommonDate.getInstance(parsedDate, formatFlag);
		}
	}

	public static Date addTime(Date originalDate, int time, int timeType) {
		Calendar cal = Calendar.getInstance();
		Date tempDate = new Date(originalDate.getTime());
		cal.setTime(tempDate);
		if (timeType == Calendar.DAY_OF_MONTH || timeType == Calendar.MONTH
				|| timeType == Calendar.YEAR
				|| timeType == Calendar.HOUR_OF_DAY
				|| timeType == Calendar.MINUTE || timeType == Calendar.SECOND) {
			cal.add(timeType, time);
		} else {
			return originalDate;
		}
		if (originalDate instanceof CommonDate) {
			CommonDate oDate = (CommonDate) originalDate;
			CommonDate rDate = CommonDate.getInstance(oDate, oDate.getFormatFlag());
			rDate.setTime(cal.getTime().getTime());
			return rDate;
		} else {
			return cal.getTime();
		}
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Date)) {
			return false;
		}
		if (this.getTime() == ((Date)other).getTime()) {
			return true;
		}
		if (other.toString().equals(this.toString())) {
			return true;
		}
		return false;
	}

	public String getDateString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(Constance.MM_DD_YY);
		//setTimeZone(sdf);
		return sdf.format(date);
	}
	public String getDateString(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//setTimeZone(sdf);
		return sdf.format(date);
	}
	public int getDays(Date nowDate,Date createDate){
         Calendar nowCal = Calendar.getInstance(); 
         nowCal.setTime(nowDate); 

         Calendar createCal = Calendar.getInstance(); 
         createCal.setTime(createDate); 

         int nowYear = nowCal.get(Calendar.YEAR); 
         int createYear = createCal.get(Calendar.YEAR); 

         int days = 0; 
         Calendar can = null; 
         if(nowCal.before(createCal)){ 
             days -= nowCal.get(Calendar.DAY_OF_YEAR); 
             days += createCal.get(Calendar.DAY_OF_YEAR); 
             can = createCal; 
         }else{ 
             days -= createCal.get(Calendar.DAY_OF_YEAR); 
             days += nowCal.get(Calendar.DAY_OF_YEAR); 
             can = createCal; 

         } 
         for (int i = 0; i < Math.abs(createYear-nowYear); i++) { 
             days += can.getActualMaximum(Calendar.DAY_OF_YEAR); 
             can.add(Calendar.YEAR, 1); 

         }
         return days;
	}
	
	public static Date stringToDate(String str,String dateFormat) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date= format.parse(str);
		return date;
	}
	
	public static String dateToString(Date date, String dataFormat){
		SimpleDateFormat format = new SimpleDateFormat(dataFormat); 
		String strDate = format.format(date);
		return strDate;
	}
	
}
