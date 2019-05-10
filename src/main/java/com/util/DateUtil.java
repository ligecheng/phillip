package com.util;
/**
 * 
 * @author: his
 * @{data}@{time}
 * @description: Date��Stirng֮���ת��
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat[] sdf = new SimpleDateFormat[3];

	static {
		sdf[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdf[1] = new SimpleDateFormat("yyyy/MM/dd");
		sdf[2] = new SimpleDateFormat("yyyy*MM*dd");

	}

	/**
	 * 
	 * @author: his
	 * @description ��String���͵�����ת����Date����
	 * @param date
	 * @return 2019��1��30������3:55:37
	 */
	public static Date StringToDate(String date) {
		Date date1 = null;
		for (int i = 0; i < sdf.length; i++) {
			try {
				date1 = sdf[i].parse(date);
				break;
			} catch (ParseException e) {
				continue;
			}
		}
		return date1;

	}

	/**
	 * @author: his
	 * @description ��Date���͵�ʱ��ת����String����
	 * @param date
	 * @return 2019��1��30������3:57:07
	 */
	public static String DateToString(Date date) {

		return sdf[0].format(date);

	}

	/**
	 * 
	 * @autor:his description: ��ȡ��ǰʱ��
	 * @return: 2019��2��22������9:19:40
	 *
	 */
	public static Date currentDate() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return DateUtil.StringToDate(df.format(new Date()));
	}

	/**
	 * 
	 * @autor:his
	 * description: �õ���ǰ��ȷʱ��
	 * @return:
	 * 2019��2��24������10:26:41
	 *
	 */
	public static String currentDateMi() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return df.format(new Date());
	}
	
	public static String getYear(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		
		return df.format(date);
	}

}
