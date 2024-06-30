package util;

import com.mysql.cj.util.StringUtils;

public class CheckWord {

	public static void main(String[] args) {
		//test idNumber
		boolean a = CheckWord.isNumber("111");
		System.out.println(a);

	}
	
	public static Boolean noContainChinese(String text){
		int byteText = text.getBytes().length;
		if(byteText==text.length() && !StringUtils.isEmptyOrWhitespaceOnly(text) && !text.contains(" ")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean phoneIsNumber(String text){
		for(int i = 0; i<text.length();) {
			int charText = text.charAt(i);
			if(charText>=48 && charText<=57) {
				i++;
			}else {
				return false;
			}
		}
		if(text.length()==10 && !StringUtils.isEmptyOrWhitespaceOnly(text)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean checkPassword(String text1,String text2){
		if(text1.equals(text2)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean checkPhone(String text1,String text2){
		if(text1.equals(text2)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Boolean isNumber(String text){
		boolean result = true;
		char[] c = text.toCharArray();
		for(char a : c) {
			if(!(a>='0' && a<='9')) {
				result = false;
			}
		}
		return result;
	}

}
