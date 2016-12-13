/**
 * 
 */
package com.rxp.apm.validator;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.rxp.apm.helper.MessageHelper;
import com.rxp.apm.utils.CommonUtils;
import com.rxp.apm.utils.ValidatorUtil;
import com.rxp.apm.validator.bean.InputFieldsCheckDetails;
import com.rxp.apm.validator.bean.InputValueCheck;
import com.rxp.apm.validator.constants.ValidationConstants;

@Component
@Lazy
public class RequestValidator<T> implements Validator<T> {
	
	@Autowired
	MessageHelper helper;
	
	@Autowired
	@Qualifier("inputFieldsCheckDetails")
	@Lazy
	private InputFieldsCheckDetails inputFieldsCheckDetails;

	@Override
	public ValidatorOutput validateRequest(T t) throws Exception {
		Set<String> errorMessages = new LinkedHashSet<String>();
		Class<?> clazz = t != null ? t.getClass() : null;
		List<String> fieldsName = CommonUtils.getFieldsName(clazz);
		List<Method> getters = CommonUtils.findGetters(t.getClass());
		for (String fieldName : fieldsName) {
			for (Method method : getters) {
				if (StringUtils.upperCase(method.getName()).endsWith(StringUtils.upperCase(fieldName))) {
					Object value = method.invoke(t, (Object[]) null);
					validateCommonFields( value, fieldName, errorMessages);
				}
			}
		}
		String respCode = ValidationConstants.VALIDATION_SUCCESS_CODE.toString();
		String respMessage = helper.getMessage("validation.success.message", null);
		
		if (!CollectionUtils.isEmpty(errorMessages)) {
			respCode = ValidationConstants.VALIDATION_FAILURE_CODE.toString();
			respMessage = helper.getMessage("validation.failure.message", null);
		}
		return CommonUtils.buildResponse(t, ValidatorOutput.class, respCode, respMessage, errorMessages);
	}
	
	private void validateCommonFields(Object value, String fieldName, Set<String> errorMessages) throws Exception {
		validateFields(value, inputFieldsCheckDetails.getCommonEditCheckObj(fieldName), fieldName, errorMessages);
	}

	public void validateFields(Object value, InputValueCheck fieldBean, String delimeter, Set<String> errorMessages)
		      throws Exception {
			if (fieldBean == null) {
				throw new Exception(
				   "One or more fieldBean is not configured in Request configuration file.");
			} else {
				String fieldName = fieldBean.getFieldName();
				String disPattern = fieldBean.getDispPattern();
				String dateFormat = fieldBean.getDateFormatPattern();
				String regexPattern = fieldBean.getRegexPattern();
				Integer minDataLength = fieldBean.getMinDataLength();
				Integer maxDataLength = fieldBean.getMaxDataLength();

				if (ValidationConstants.TRUE.toString().equalsIgnoreCase(fieldBean.getRequired())) {
					ValidatorUtil.isRequired(value, errorMessages, fieldName, helper.getMessage("is.required", null));
				}

				ValidationConstants vc = ValidationConstants.valueOf(fieldBean.getDataType().toUpperCase());
				if (vc != null) {
					switch (vc) {
						case INTEGER:
							ValidatorUtil.isNumeric(value, errorMessages, fieldName, helper.getMessage("is.numeric", null));
							if (null != maxDataLength) {
								ValidatorUtil.isValidLength(value, errorMessages, fieldName, maxDataLength, minDataLength, helper.getMessage("is.invalid.length", null));
							}
							break;

						case STRING:
							if (null != maxDataLength) {
								ValidatorUtil.isValidLength(value, errorMessages, fieldName, maxDataLength, minDataLength, helper.getMessage("is.invalid.length", null));
							}
							if (null != regexPattern) {
								ValidatorUtil.isValidRegexPattern(value, errorMessages, fieldName, regexPattern, helper.getMessage("is.invalid.format", null));
							}
							break;

						case DECIMAL:
							if (null != regexPattern) {
								ValidatorUtil.isDecimal(value, errorMessages, fieldName, regexPattern, disPattern, helper.getMessage("is.invalid.format", null));
							}
							break;
						case DATE:
							if (StringUtils.isNotBlank(dateFormat)) {
								ValidatorUtil.isValidDateTimeFormat(value, errorMessages, fieldName, dateFormat, helper.getMessage("is.invalid.format", null));
							}
							break;
					default:
						break;
					}
				}

				Set<String> validValueSet = fieldBean.getValidValuesSet(delimeter);
				if (!CollectionUtils.isEmpty(validValueSet)) {
					ValidatorUtil.isValidValue(value, errorMessages, fieldName, validValueSet, fieldBean.getDefaultValue(), fieldBean.showValidValues(), helper.getMessage("is.valid.value.no.set.display", null));
				}

			}
		}
	
	
}
