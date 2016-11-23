/*
 * 
 */
package com.rxp.apm.validator.constants;

/**
 * The Enum ValidationConstants.
 * @author ssing69
 */
public enum ValidationConstants {
	TRUE("true"),
	INTEGER("INTEGER"),
	STRING("STRING"),
	DECIMAL("DECIMAL"),
	DATE("DATE"),
	VALIDATION_FAILURE_CODE("04"),
	VALIDATION_SUCCESS_CODE("00")	;

	private String value = "";

	private ValidationConstants(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
	
}
