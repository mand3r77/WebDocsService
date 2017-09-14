package com.uscs.common.config.utils.string;

import java.util.Calendar;

public class StringUtils {
	
	Calendar calendar = Calendar.getInstance();
	
	
	public Boolean containsSpecial(String s1){
		Boolean containsSpecial = false;
		String s2 = s1.replaceAll("[^a-zA-Z0-9.]", "");
		
			if (s2.equalsIgnoreCase(s1)){
					return containsSpecial = true;
			}
			return containsSpecial;
	}
	
	public Boolean isNumbers(String s1){
		
		Boolean isNumeric = false;
		
		String s2 = s1.replaceAll("[^0-9]", "");
			if (s2.equalsIgnoreCase(s1)){
				return isNumeric = true;
			}
		return isNumeric;
	}

	public String stripSpecial(String s1){
		String s2 = s1.replaceAll("[^a-zA-Z0-9.]", "");
		return s2;
	}
	
	
}
