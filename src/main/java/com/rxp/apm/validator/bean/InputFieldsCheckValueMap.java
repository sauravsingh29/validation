/*
 * 
 */
package com.rxp.apm.validator.bean;

import java.util.Map;

/**
 * The Class InputFieldsCheckValueMap.
 */
public class InputFieldsCheckValueMap {
	
	/** The input fields check map. */
	private Map<String, InputValueCheck> inputFieldsCheckMap;


	/**
	 * Gets the input fields check map.
	 *
	 * @return the inputFieldsCheckMap
	 */
	public Map<String, InputValueCheck> getInputFieldsCheckMap() {
		return inputFieldsCheckMap;
	}


	/**
	 * Sets the input fields check map.
	 *
	 * @param inputFieldsCheckMap the inputFieldsCheckMap to set
	 */
	public void setInputFieldsCheckMap(Map<String, InputValueCheck> inputFieldsCheckMap) {
		this.inputFieldsCheckMap = inputFieldsCheckMap;
	}


	/**
	 * Gets the common edit check obj.
	 *
	 * @param key the key
	 * @return the common edit check obj
	 */
	public InputValueCheck getCommonEditCheckObj(String key) {
		return getInputFieldsCheckMap().get(key);
	}

}
