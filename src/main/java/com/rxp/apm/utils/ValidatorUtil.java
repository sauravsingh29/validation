/*
 * 
 */
package com.rxp.apm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;



/**
 * The Class ValidatorUtil.
 */
public final class ValidatorUtil {
	
	/**
	 * Instantiates a new validator util.
	 */
	private ValidatorUtil() {}

	/**
	 * This is check whether object is required in request.
	 *
	 * @param reqValue the req value
	 * @param errorMessage the error message
	 * @param fieldName the field name
	 */
	public static void isRequired(Object reqValue, Set<String> errorMessage, String fieldName, String format) {
		if (reqValue == null || StringUtils.isBlank(reqValue.toString())
		      || (reqValue instanceof Integer && (Integer) reqValue == 0)) {
			errorMessage.add(String.format(format, fieldName.toUpperCase()));
		}
	}

	@SuppressWarnings("static-access")
	public static void isDecimal(Object reqValue, Set<String> errorMessage, String fieldName, String formatPattern, String disPattern, String format) {
		if (StringUtils.isNotBlank(disPattern)) {
			if (reqValue != null && StringUtils.isNotBlank(reqValue.toString())
			      && !Pattern.compile(formatPattern).matches(formatPattern, reqValue.toString())) {
				errorMessage.add(String.format(format, fieldName.toUpperCase(), disPattern));
			}
		} else if (reqValue != null && StringUtils.isNotBlank(reqValue.toString())
		      && !Pattern.compile(formatPattern).matches(formatPattern, reqValue.toString())) {
			errorMessage.add(String.format(format, fieldName.toUpperCase()));
		}
	}
	
	@SuppressWarnings("static-access")
	public static void isValidRange(Object reqValue, Set<String> errorMessage, String fieldName, String formatPattern,
	      String start, String end, String format) {
		if (reqValue != null && StringUtils.isNotBlank(reqValue.toString()) && !Pattern.compile(formatPattern).matches(formatPattern, reqValue.toString())) {
			errorMessage.add(String.format(format, fieldName.toUpperCase(), start, end));
		}
	}
	
	@SuppressWarnings("static-access")
	public static void isValidRegexPattern(Object reqValue, Set<String> errorMessage, String fieldName, String formatPattern, String format) {
		if (reqValue != null && StringUtils.isNotBlank(reqValue.toString()) && !Pattern.compile(formatPattern).matches(formatPattern, reqValue.toString())) {
			errorMessage.add(String.format(format, fieldName.toUpperCase()));
		}
	}

	public static void isNumeric(Object reqValue, Set<String> errorMessage, String fieldName, String format) {
		if (reqValue != null
		      && StringUtils.isNotBlank(reqValue.toString())
		      && (!StringUtils.isNumeric(reqValue.toString()) || (reqValue instanceof Integer && (Integer) reqValue == 0))) {
			errorMessage.add(String.format(format, fieldName.toUpperCase()));
		}
	}

	public static void isValidLength(Object reqValue, Set<String> errorMessage, String fieldName, Integer maxLength,
	      Integer minLength, String format) {
		if (reqValue != null && StringUtils.isNotBlank(reqValue.toString())) {
			if (null != maxLength && null != minLength) {
				if ((minLength.equals(maxLength)) && (StringUtils.length(reqValue.toString()) != maxLength)) {
					errorMessage.add(String.format(format,fieldName.toUpperCase(), maxLength));
				}
			} else if (null == minLength && null != maxLength && (StringUtils.length(reqValue.toString()) > maxLength)) {
				errorMessage.add(String.format(format, fieldName.toUpperCase(), maxLength));
			}
		}
	}

	/**
	 * Object value is in proper format or not.
	 *
	 * @param reqValue the req value
	 * @param errorMessage the error message
	 * @param fieldName the field name
	 * @param formatPattern the format pattern
	 */
	public static void isValidDateTimeFormat(Object reqValue, Set<String> errorMessage, String fieldName,
	      String formatPattern, String format) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(formatPattern);
		if (reqValue != null && StringUtils.isNotEmpty(reqValue.toString())) {
			dateTimeFormat.setLenient(false);
			try {
				dateTimeFormat.parse(reqValue.toString());
			} catch (ParseException e) {
				errorMessage.add(String.format(format, fieldName.toUpperCase(), formatPattern));
			}
		}
	}

	public static void isValidValue(Object reqValue, Set<String> errorMessage, String fieldName, Set<String> validSet,
			String defaultVal, boolean showValidSetValues, String format) {
		if (reqValue != null && StringUtils.isNotEmpty(reqValue.toString())) {
			Object value = String.valueOf(reqValue);
			if (StringUtils.isBlank(defaultVal) && !validSet.contains(value.toString())) {
				if (showValidSetValues) {
					errorMessage.add(String.format(format, fieldName.toUpperCase(), value.toString(), validSet.toString()));
				} else {
					errorMessage.add(String.format(format, fieldName.toUpperCase(), value.toString()));
				}
			}
		}
	}
}
