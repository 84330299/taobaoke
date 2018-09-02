package com.igogogo.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils {

	public static final String SUCCESS_MSG = "SUCCESS";
	public static final String FAIL_MSG = "FAIL";
	public static final Integer SUCCESS_CODE = 200;
	public static final Integer FAIL_CODE = 900;

	/**
	 * MD5
	 * 
	 * @param word
	 *            需要加密的字符串
	 * 
	 */
	public static String md5(String word) {
		String md5Hex = DigestUtils.md5Hex(word);
		return md5Hex;
	}

	/**
	 * 截取字符串str中指定字符 strStart、strEnd之间的字符串
	 * 
	 * @param string
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String subString(String str, String strStart, String strEnd) {
		/* 找出指定的2个字符在 该字符串里面的 位置 */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);
		/* 开始截取 */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;
	}

	/**
	 * @param 通过ME获取连接部分
	 *            https://uland.taobao.com/coupon/edetail 该URL中 ?e=后面的内容
	 *            &traceId 之前的内容
	 */
	public static String meargs(String me) {
		String str = me.substring(me.indexOf("=") + 1);
		// Pattern p = Pattern.compile("e=(.*)&traceId");
		// Matcher m = p.matcher(me);
		// while (m.find()) {
		// return m.group(1);
		// }
		return str;
	}
}
