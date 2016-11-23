/*
 * 
 */
package com.rxp.apm.validator;

public interface Validator<T> {
	
	ValidatorOutput validateRequest(T t) throws Exception;

}
