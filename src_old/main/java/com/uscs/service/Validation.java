package com.uscs.service;

import com.uscs.common.config.utils.string.StringUtils;

public class Validation {

	StringUtils stringUtils = new StringUtils();
	
	public boolean validateInputData(String data){
		boolean isNumber = false;
		boolean isValid = false;
		
		isNumber = stringUtils.isNumbers(data);
		isValid = stringUtils.containsSpecial(data);
		
		if(isNumber && isValid){
			return true;
		}
		return false;
	}
}
