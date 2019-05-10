package com.util;

/**
 * 
 * @author: his
 * @{data}@{time}
 * @description: �ж��ַ����Ƿ�Ϊ��
 */
public class StringUtils {

	/**
	 * @author: his
	 * @description �ж��ַ����Ƿ�Ϊ��
	 * @param s
	 * @return true--�ַ���Ϊ�� ,false--�ַ�����Ϊ��
	 * 2019��1��31������11:26:05
	 */
	public static boolean isNullOrEmpty(String s) {
		if (s == null || s.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
