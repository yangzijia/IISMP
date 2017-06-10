package com.rms.util;

import java.text.DecimalFormat;

public class PmnUtils {
	
	public static String pmn(double num){
		
		DecimalFormat dt=(DecimalFormat) DecimalFormat.getInstance(); //获得格式化类对象
		dt.applyPattern("0.0");
		
		return dt.format(num);
	}
	public static void main(String[] args){
		System.out.println("dsfkljsldflj==="+pmn(125466.09556123));
	}

}
