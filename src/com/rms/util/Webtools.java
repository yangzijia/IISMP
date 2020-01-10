/**
 * 
 */
package com.rms.util;

import java.io.IOException;


/**
 * @author dong
 *2017-4-26
 * 
 */

public class Webtools {
	

	/*public static  String Change(String str) throws IOException{
	
		String str1=StringEscapeUtils.escapeHtml(str);
		return str1;
		
		
	}*/
	public static  String Change(String str) throws IOException{
		str = str.replace("&", "amp;");
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		return str;
	}
}
