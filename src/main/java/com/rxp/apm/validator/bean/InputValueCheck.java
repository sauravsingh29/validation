/**
 * 
 */
package com.rxp.apm.validator.bean;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.rxp.apm.validator.constants.ValidationConstants;

/**
 * The Class InputValueCheck.
 */
public class InputValueCheck {
	
	private String fieldName;
	
	private String dataType;
	
	private Integer minDataLength;
	
	private Integer maxDataLength;
	
	private String dateFormatPattern;
	
	private String required;
	
	private String defaultValue;
	
	private String validValues;
	
	private String showValidValues;

	private String rangeStart;
	
	private String rangeEnd;
	
	private String dispPattern;
	
	private String regexPattern;
	
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getDataType() {
		return dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public Integer getMinDataLength() {
		return minDataLength;
	}
	
	public void setMinDataLength(Integer minDataLength) {
		this.minDataLength = minDataLength;
	}
	
	public Integer getMaxDataLength() {
		return maxDataLength;
	}
	
	public void setMaxDataLength(Integer maxDataLength) {
		this.maxDataLength = maxDataLength;
	}
	
	public String getRequired() {
		return required;
	}
	
	public void setRequired(String required) {
		this.required = required;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getValidValues() {
		return validValues;
	}
	
	public void setValidValues(String validValues) {
		this.validValues = validValues;
	}
	
	public String getShowValidValues() {
		return showValidValues;
	}
	
	public void setShowValidValues(String showValidValues) {
		this.showValidValues = showValidValues;
	}
	
	public String getRangeStart() {
		return rangeStart;
	}
	
	public void setRangeStart(String rangeStart) {
		this.rangeStart = rangeStart;
	}
	
	public String getRangeEnd() {
		return rangeEnd;
	}
	
	public void setRangeEnd(String rangeEnd) {
		this.rangeEnd = rangeEnd;
	}
	
	public String getDispPattern() {
		return dispPattern;
	}

	public void setDispPattern(String dispPattern) {
		this.dispPattern = dispPattern;
	}
	
	public Set<String> getValidValuesSet(String delimeter) {
		Set<String> validValuesSet = new LinkedHashSet<String>();
		if (StringUtils.isNotBlank(validValues)) {
			StringTokenizer tokenizer = new StringTokenizer(validValues, delimeter);
			while (tokenizer.hasMoreElements()) {
				validValuesSet.add((String) tokenizer.nextElement());
			}
		}
		return validValuesSet;
	}

	public boolean showValidValues() {
		return (showValidValues == null || ValidationConstants.TRUE.toString().equalsIgnoreCase(showValidValues));
	}

	public String getDateFormatPattern() {
		return dateFormatPattern;
	}

	public void setDateFormatPattern(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
	}

	public String getRegexPattern() {
		return regexPattern;
	}

	public void setRegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("fieldName", fieldName);
		builder.append("dataType", dataType);
		builder.append("minDataLength", minDataLength);
		builder.append("maxDataLength", maxDataLength);
		builder.append("dateFormatPattern", dateFormatPattern);
		builder.append("required", required);
		builder.append("defaultValue", defaultValue);
		builder.append("validValues", validValues);
		builder.append("showValidValues", showValidValues);
		builder.append("rangeStart", rangeStart);
		builder.append("rangeEnd", rangeEnd);
		builder.append("dispPattern", dispPattern);
		builder.append("regexPattern", regexPattern);
		return builder.toString();
	}
	
}
