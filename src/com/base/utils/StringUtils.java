package com.base.utils;

/**
 * Created by kai.wang on 12/3/13.
 */
public class StringUtils {
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 删除中括号
	 * @param str
	 * @return
	 */
	public static String cleanBracket(String str){
		if(isEmpty(str)){
			return str;
		}
		return str.replaceAll("\\[","").replaceAll("]","");
	}

}
