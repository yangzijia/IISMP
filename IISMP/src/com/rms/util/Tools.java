/**
 * 转换html界面传来的特殊符号的方法
 */
package com.rms.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * @author yangzijia
 * @date 2017-04-26
 */
public class Tools {

	public static  String Change(String str) throws IOException{
		str = str.replace("&", "amp;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
	public static String toChinese(String str) throws UnsupportedEncodingException{
		str = new String(str.getBytes("ISO-8859-1"),"UTF-8");
		return str;
	}
}
